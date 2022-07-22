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
        doSetStoreNames();
        parseAll();
    }

    public T getComponent() {
        return component;
    }

    private void doSetStoreNames() {
        StoreName storeName = applicationContext.getBean(StoreName.class);
        String displayName = storeName.getDisplay();
        String nameLower = storeName.getLower();
        component.setStoreName(displayName);
        component.setStoreNameLower(nameLower);
    }

    private void parseAll() {
        parsePrice();
        parseTitleElement();
        parseImageUrl();
        parseProperties();
    }

    private void parsePrice() {
        String price = element.attr("data-price")
                .replace(" ", "");
        component.setPrice(Integer.parseInt(price));
    }

    private void parseTitleElement() {
        saveTitleElement();
        parseUrl();
        parseDisplayTitle();
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
        component.setDisplayTitleLower(displayTitle.toLowerCase(Locale.ROOT));
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