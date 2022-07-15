package com.storeparsers.microservices.citilinkparserservice.service;

import com.storeparsers.microservices.citilinkparserservice.entity.ComputerComponent;
import com.storeparsers.microservices.citilinkparserservice.parser.CitilinkPageParser;
import com.storeparsers.microservices.citilinkparserservice.parser.ComputerComponentParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ComputerComponentServiceImpl implements ComputerComponentService {

    @Override
    public <E extends ComputerComponent> void parseAll(String url, Class<E> requiredType) {
        try {
            int pageCount = retrievePageCount(url);
            int threadNum = Math.min(ManagementFactory.getThreadMXBean().getThreadCount(), pageCount);
            ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
            for (int i = 1; i <= pageCount; i++) {
                E component = requiredType.getDeclaredConstructor().newInstance();
                String pageUrl = url + String.format("?p=%d", i);
                CitilinkPageParser<E> pageParser =
                        new CitilinkPageParser<>(pageUrl, component);
                executorService.submit(pageParser);
            }
            executorService.shutdown();
        } catch (Exception e) {
            String message = String.format("Exception during multithreaded parsing (url = %s); nested exception: %s",
                    url, e.getMessage());
            throw new ComputerComponentParseException(message, e);
        }
    }

    private int retrievePageCount(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        int pageCount = 0;
        String paginator = document
                .select("div.ProductCardCategoryList__pagination")
                .select("div.PaginationWidget__wrapper-pagination")
                .text();
        String[] split = paginator.split(" ");
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("Следующая")) {
                pageCount = Integer.parseInt(split[i - 1]);
            }
        }
        return pageCount;
    }
}
