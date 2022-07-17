package com.storeparsers.microservices.citilinkparserservice.parser;

import com.storeparsers.microservices.citilinkparserservice.config.CitilinkUrls;
import com.storeparsers.microservices.citilinkparserservice.config.SpringApplicationContext;
import com.storeparsers.microservices.citilinkparserservice.entity.ComputerComponent;
import com.storeparsers.microservices.citilinkparserservice.parser.properties.ComputerComponentProperties;
import org.jsoup.nodes.Element;
import org.springframework.context.ApplicationContext;
import org.springframework.lang.NonNull;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class CitilinkElementParser<E extends ComputerComponent> {

    protected Element element;
    protected E component;
    protected Map<String, String> properties;

    private Element titleElement;
    private final ApplicationContext applicationContext;

    public CitilinkElementParser(Element element, @NonNull Class<E> requiredType) {
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
        parseAll();
    }

    public E getComponent() {
        return component;
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
        String urlPrefix = applicationContext.getBean(CitilinkUrls.class).getHomeUrl();
        String url = urlPrefix + titleElement.attr("href");
        component.setUrl(url);
    }

    private void parseDisplayTitle() {
        String displayTitle = titleElement.text();
        component.setDisplayTitle(displayTitle);
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