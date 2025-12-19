package com.example.automation.utils;

import java.util.List;
import java.util.Map;

public interface DataReader {
    List<Map<String, String>> getData(String filePath);
}
