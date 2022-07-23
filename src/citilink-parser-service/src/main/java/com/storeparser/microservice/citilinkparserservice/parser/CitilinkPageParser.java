package com.storeparser.microservice.citilinkparserservice.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.storeparser.microservice.citilinkparserservice.broker.KafkaTopicNameFactory;
import com.storeparser.microservice.citilinkparserservice.config.SpringApplicationContext;
import com.storeparser.microservice.citilinkparserservice.entity.ComputerComponent;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class CitilinkPageParser<T extends ComputerComponent> implements Runnable {

    public static AtomicInteger counter = new AtomicInteger();

    private Document document;
    private Elements elements;
    private final Class<T> requiredType;
    private final String url;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private final ApplicationContext applicationContext;

    @SuppressWarnings("unchecked")
    public CitilinkPageParser(String url, Class<T> requiredType) {
        this.url = url;
        this.requiredType = requiredType;
        applicationContext = SpringApplicationContext.getApplicationContext();
        ResolvableType type = ResolvableType.forClassWithGenerics(KafkaTemplate.class,
                String.class, String.class);
        ObjectProvider<Object> provider = applicationContext.getBeanProvider(type);
        this.kafkaTemplate = (KafkaTemplate<String, String>) provider.getObject();
        this.objectMapper = applicationContext.getBean(ObjectMapper.class);
    }

    @Override
    public void run() {
        log.debug("[ParserLogging] Begin of method CitilinkPageParser.run, thread: " +
                Thread.currentThread().getName());
        long startTimeMillis = System.currentTimeMillis();
        try {
            document = Jsoup.connect(url).get();
            elements = retrieveAllElements();
            for (Element element : elements) {
                T component = retrieveParsedComponent(element);
                sendComponentJsonToKafka(component);
                counter.incrementAndGet();
            }
        } catch (Exception e) {
            throw new ComputerComponentParseException(String.format(
                    "Exception during parsing page (url = %s); nested exception: %s",
                    url, e.getMessage()), e);
        }
        long timeElapsed = System.currentTimeMillis() - startTimeMillis;
        log.debug(String.format("[ParserLogging] End of method CitilinkPageParser.run," +
                        " thread %s; Time elapsed: %d ms",
                Thread.currentThread().getName(), timeElapsed));
    }

    private void sendComponentJsonToKafka(T component) throws JsonProcessingException {
        String componentJsonRepresentation = objectMapper.writeValueAsString(component);
        String topicName = applicationContext.getBean(KafkaTopicNameFactory.class)
                .getTopicName(requiredType);
        kafkaTemplate.send(topicName, componentJsonRepresentation);
    }

    private T retrieveParsedComponent(Element element) {
        CitilinkElementParser<T> elementParser =
                new CitilinkElementParser<>(element, requiredType);
        return elementParser.getComponent();
    }

    private Elements retrieveAllElements() {
        return document.select("div.product_data__gtm-js");
    }
}
