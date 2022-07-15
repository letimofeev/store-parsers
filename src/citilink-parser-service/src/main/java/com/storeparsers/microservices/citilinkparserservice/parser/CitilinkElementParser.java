package com.storeparsers.microservices.citilinkparserservice.parser;

import com.storeparsers.microservices.citilinkparserservice.config.CitilinkUrls;
import com.storeparsers.microservices.citilinkparserservice.config.SpringApplicationContext;
import com.storeparsers.microservices.citilinkparserservice.entity.ComputerComponent;
import org.jsoup.nodes.Element;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class CitilinkElementParser<E extends ComputerComponent> {

    protected Element element;
    protected E component;
    protected Map<String, String> properties;

    private Element titleElement;
    private final ApplicationContext applicationContext;

    public CitilinkElementParser(Element element, E component) {
        this.element = element;
        this.component = component;
        this.applicationContext = SpringApplicationContext.getApplicationContext();

        properties = new HashMap<>();

        parsePrice();
        parseTitleElement();
        saveProperties();
    }

    public E getComponent() {
        return component;
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