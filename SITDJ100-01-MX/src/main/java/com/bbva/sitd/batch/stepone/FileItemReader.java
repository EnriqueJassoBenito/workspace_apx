package com.bbva.sitd.batch.stepone;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class FileItemReader implements FieldSetMapper<String> {

    @Override
    public String mapFieldSet(FieldSet row) throws BindException {

        String param1 = row.readString("TITULO");
        String param2 = row.readString("TIPO");

        return param2;
    }

}

//archivo--->[render] --- String --->[Processor]----String----[writer]