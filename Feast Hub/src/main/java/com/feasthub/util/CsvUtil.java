package com.feasthub.util;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class CsvUtil {
    public static List<String> readLines(String path) {
        try {
            Path filePath = Paths.get(path);
            if (!Files.exists(filePath)) return new ArrayList<>();
            return Files.readAllLines(filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void writeLines(String path, List<String> lines) {
        try {
            Files.write(Paths.get(path), lines);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
