package com.storeparser.microservice.citilinkparserservice.service;

import com.storeparser.microservice.citilinkparserservice.entity.ComputerComponent;
import com.storeparser.microservice.citilinkparserservice.parser.CitilinkPageParser;
import com.storeparser.microservice.citilinkparserservice.parser.ComputerComponentParseException;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class ComputerComponentServiceImpl implements ComputerComponentService {

    @Value("${citilink.parser.timeout}")
    private int timeout;

    @Override
    public <E extends ComputerComponent> void parseAll(String url, Class<E> requiredType) {
        try {
            int pageCount = retrievePageCount(url);
            int threadNum = Math.min(ManagementFactory.getThreadMXBean().getThreadCount(), pageCount);
            ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
            for (int i = 1; i <= pageCount; i++) {
                String pageUrl = String.format("%s?p=%d", url, i);
                CitilinkPageParser<E> pageParser = new CitilinkPageParser<>(pageUrl, requiredType);
                executorService.submit(pageParser);
            }
            executorService.shutdown();
            boolean finished = executorService.awaitTermination(timeout, TimeUnit.SECONDS);
            if (!finished) {
                log.warn(String.format("Parsing was not finished during %s s timeout," +
                        " some data might not be loaded", timeout));
            }
        } catch (Exception e) {
            throw new ComputerComponentParseException(String.format(
                    "Exception during multithreaded parsing (url = %s); nested exception: %s",
                    url, e.getMessage()), e);
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
