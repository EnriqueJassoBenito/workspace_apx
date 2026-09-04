package com.bbva.sitd.batch.stepone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class RecordsItemProcessor implements ItemProcessor<String, String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecordsItemProcessor.class);
    
    @Override
    public String process(String argInReader) throws Exception {
        
        LOGGER.info("@@@ Que me llego del reader {}", argInReader);

        return argInReader;
    }
}