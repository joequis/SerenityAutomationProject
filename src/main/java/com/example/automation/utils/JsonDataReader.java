package com.example.automation.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class JsonDataReader implements DataReader {
    
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Map<String, String>> getData(String filePath) {
        try {
            return objectMapper.readValue(new File(filePath), new TypeReference<List<Map<String, String>>>(){});
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
