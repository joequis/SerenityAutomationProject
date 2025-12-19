package com.example.automation.utils;

import java.util.List;
import java.util.Map;
import java.util.Collections;

// Requires Apache POI dependency to be fully functional
public class ExcelDataReader implements DataReader {

    @Override
    public List<Map<String, String>> getData(String filePath) {
        // Implementation for reading Excel files using Apache POI would go here
        // For now returning empty list to demonstrate modularity
        System.out.println("Reading data from Excel file: " + filePath);
        return Collections.emptyList();
    }
}
