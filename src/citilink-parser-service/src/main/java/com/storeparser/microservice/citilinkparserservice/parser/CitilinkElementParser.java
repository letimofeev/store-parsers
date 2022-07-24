package com.storeparser.microservice.citilinkparserservice.parser;

import com.storeparser.microservice.citilinkparserservice.config.CitilinkUrls;
import com.storeparser.microservice.citilinkparserservice.entity.ComputerComponent;
import com.storeparser.microservice.citilinkparserservice.config.StoreName;
import com.storeparser.microservice.citilinkparserservice.parser.properties.ComputerComponentProperties;
import com.storeparser.microservice.citilinkparserservice.config.SpringApplicationContext;
import org.jsoup.nodes.Element;
import org.springframework.context.ApplicationContext;
import org.springframework.lang.NonNull;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CitilinkElementParser<T extends ComputerComponent> {

    protected Element element;
    protected T component;
    protected Map<String, String> properties;

    private Element titleElement;
    private final ApplicationContext applicationContext;

    public CitilinkElementParser(Element element, @NonNull Class<T> requiredType) {
        this.element = element;
        try {
            this.component = requiredType.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException
                | InvocationTargetException | NoSuchMethodException e) {
            throw new IllegalArgumentException(String.format(
                    "Exception during creating component with type = %s; " +
                    "nested exception: %s", requiredType.getSimpleName(), e.getMessage()));
        }
        this.applicationContext = SpringApplicationContext.getApplicationContext();
        properties = new HashMap<>();
        doSetStoreName();
        parseAll();
    }

    public T getComponent() {
        return component;
    }

    private void doSetStoreName() {
        StoreName storeName = applicationContext.getBean(StoreName.class);
        String displayName = storeName.getDisplayName();
        component.setStoreDisplayName(displayName);
    }

    private void parseAll() {
        parsePrice();
        parseStock();
        parseTitleElement();
        parseImageUrl();
        parsVendorName();
        parseProperties();
    }

    private void parsePrice() {
        String price = element.attr("data-price")
                .replace(" ", "");
        component.setPrice(Integer.parseInt(price));
    }

    private void parseStock() {
        boolean isStock = element.selectFirst("div.ProductCardHorizontal__not-available-block") == null;
        component.setStock(isStock);
    }

    private void parseTitleElement() {
        saveTitleElement();
        parseUrl();
        parseDisplayTitle();
        parseSerialIdentifier();
        parseModel();
    }

    private void saveTitleElement() {
        titleElement = element.selectFirst("a.ProductCardHorizontal__title");
    }

    private void parseUrl() {
        String urlPrefix = applicationContext.getBean(CitilinkUrls.class).getHome();
        String url = urlPrefix + titleElement.attr("href");
        component.setUrl(url);
    }

    private void parseDisplayTitle() {
        String displayTitle = titleElement.text();
        component.setDisplayTitle(displayTitle);
    }

    private void parseSerialIdentifier() {
        String titleAttr = titleElement.attr("title");
        String idRegex = "\\[(.*?)]";
        Pattern pattern = Pattern.compile(idRegex);
        Matcher matcher = pattern.matcher(titleAttr);
        if (matcher.find()) {
            String serialNumber = matcher.group(1)
                    .replace(" bulk", "");
            component.setSerialIdentifier(serialNumber);
        }
    }

    private void parseModel() {
        String title = component.getDisplayTitle();
        String model = title.split(", ")[1]
                .replace(" bulk", "")
                .toLowerCase(Locale.ROOT);
        component.setModel(model);
    }

    private void parseImageUrl() {
        Element imageElement = element.selectFirst("div.ProductCardHorizontal__image-block");
        if (imageElement == null) {
            return;
        }
        String imageUrl = imageElement.select("img")
                .attr("src");
        component.setImageUrl(imageUrl);
    }

    private void parsVendorName() {
        String title = component.getDisplayTitle();
        String brand = title.split(" ")[1];
        component.setVendorName(brand);
    }

    private void parseProperties() {
        saveProperties();
        ComputerComponentProperties.doSetProperties(component, properties);
    }

    private void saveProperties() {
        Element propertiesElement = element.selectFirst("ul.ProductCardHorizontal__properties");
        if (propertiesElement == null) {
            return;
        }
        for (Element property : propertiesElement.children()) {
            String key = property.select("span.ProductCardHorizontal__properties_name").text();
            String value = property.select("span.ProductCardHorizontal__properties_value").text();
            properties.put(key, value);
        }
    }
}