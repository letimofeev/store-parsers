package com.storeparsers.microservices.citilinkparserservice.service;

import com.storeparsers.microservices.citilinkparserservice.entity.ComputerComponent;
import com.storeparsers.microservices.citilinkparserservice.parser.CitilinkPageParser;
import com.storeparsers.microservices.citilinkparserservice.parser.ComputerComponentParseException;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class ComputerComponentServiceImpl implements ComputerComponentService {

    @Override
    public <E extends ComputerComponent> void parseAll(String url, Class<E> requiredType) {
        try {
            int pageCount = retrievePageCount(url);
            int threadNum = Math.min(ManagementFactory.getThreadMXBean().getThreadCount(), pageCount);
            ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
            for (int i = 1; i <= pageCount; i++) {
                String pageUrl = url + String.format("?p=%d", i);
                CitilinkPageParser<E> pageParser = new CitilinkPageParser<>(pageUrl, requiredType);
                executorService.submit(pageParser);
            }
            executorService.shutdown();
            int timeout = 30;
            boolean finished = executorService.awaitTermination(timeout, TimeUnit.SECONDS);
            if (!finished) {
                log.warn("Parsing was not finished during" + timeout +" s timeout," +
                        " some data might not be loaded");
            }
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
