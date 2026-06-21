package com.feasthub.service;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BackupService {
    public void backupData() {
        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            Path backupDir = Paths.get("backup", "backup_" + timestamp);
            Files.createDirectories(backupDir);
            copyIfExists("data/recipes.csv", backupDir.resolve("recipes.csv"));
            copyIfExists("data/pantry.csv", backupDir.resolve("pantry.csv"));
            copyIfExists("data/support-log.csv", backupDir.resolve("support-log.csv"));
            System.out.println("Backup completed: " + backupDir);
        } catch (IOException e) {
            System.out.println("Backup failed: " + e.getMessage());
        }
    }

    private void copyIfExists(String source, Path destination) throws IOException {
        Path sourcePath = Paths.get(source);
        if (Files.exists(sourcePath)) {
            Files.copy(sourcePath, destination, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    public void printRecoverySteps() {
        System.out.println("Recovery steps:");
        System.out.println("1. Open the backup folder.");
        System.out.println("2. Copy recipes.csv, pantry.csv, and support-log.csv.");
        System.out.println("3. Paste them into the data folder.");
        System.out.println("4. Restart the application and verify records.");
    }
}
