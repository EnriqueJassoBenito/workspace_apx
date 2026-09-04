package com.bbva.sitd.batch.stepone;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

public class RecordsItemWriter implements ItemWriter<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecordsItemWriter.class);

    @Override
    public void write(List<? extends String> arg0) throws Exception {

        for(String in:arg0) {
            // Hacermo algo
            // Invocar libreria para el acceso a los datos que recibio el writer
            LOGGER.info("@@@ que recibio el writer {}", in);
        }
    }
}