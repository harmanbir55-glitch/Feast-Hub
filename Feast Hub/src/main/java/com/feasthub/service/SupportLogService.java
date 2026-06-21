package com.feasthub.service;

import com.feasthub.util.CsvUtil;
import java.time.LocalDateTime;
import java.util.*;

public class SupportLogService {
    private static final String SUPPORT_FILE = "data/support-log.csv";

    public void displayLogs() {
        List<String> logs = CsvUtil.readLines(SUPPORT_FILE);
        if (logs.isEmpty()) {
            System.out.println("No support logs available.");
            return;
        }
        for (String log : logs) {
            System.out.println(log);
        }
    }

    public void addLog(String problem, String solution, String status) {
        List<String> logs = CsvUtil.readLines(SUPPORT_FILE);
        int ticket = 1000 + logs.size() + 1;
        logs.add(ticket + "," + problem + "," + solution + "," + status + "," + LocalDateTime.now());
        CsvUtil.writeLines(SUPPORT_FILE, logs);
        System.out.println("Support ticket added to problems and solutions log.");
    }
}
