package com.storeparsers.microservices.citilinkparserservice.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeparsers.microservices.citilinkparserservice.config.SpringApplicationContext;
import com.storeparsers.microservices.citilinkparserservice.entity.ComputerComponent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.kafka.core.KafkaTemplate;

import java.io.IOException;

public class CitilinkPageParser<E extends ComputerComponent> implements Runnable {

    private Document document;
    private Elements components;
    private final String url;
    private final E component;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private final ApplicationContext applicationContext;

    @SuppressWarnings("unchecked")
    public CitilinkPageParser(String url, E component) {
        this.url = url;
        this.component = component;
        applicationContext = SpringApplicationContext.getApplicationContext();
        ResolvableType type = ResolvableType.forClassWithGenerics(KafkaTemplate.class, String.class, String.class);
        ObjectProvider<Object> provider = applicationContext.getBeanProvider(type);
        this.kafkaTemplate = (KafkaTemplate<String, String>) provider.getObject();
        this.objectMapper = applicationContext.getBean(ObjectMapper.class);
    }

    @Override
    public void run() {
        try {
            document = Jsoup.connect(url).get();
            components = retrieveAllComponents();
            for (int i = 0; i < components.size(); i++) {
                E comp = retrieveParsedComponent(i);
                String json = objectMapper.writeValueAsString(comp);
                kafkaTemplate.send("graphics-card", json);
            }
        } catch (IOException e) {
            String message = String.format("Exception during parsing page (url = %s); nested exception: %s",
                    url, e.getMessage());
            throw new ComputerComponentParseException(message, e);
        }
    }

    private E retrieveParsedComponent(int elemNum) {
        Element element = components.get(elemNum);
        CitilinkElementParser<E> elementParser = new CitilinkElementParser<>(element, component);
        return elementParser.getComponent();
    }

    private Elements retrieveAllComponents() {
        return document.select("div.product_data__gtm-js");
    }
}
