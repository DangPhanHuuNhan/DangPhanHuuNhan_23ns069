package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class textEditorModel {
    public void saveToFile(List<String> lines, File file) {
        try (PrintWriter writer = new PrintWriter(file)) {
            lines.forEach(writer::println);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> loadFromFile(File file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            lines = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public List<File> getAllFilesInDirectory(File directory) {
        List<File> fileList = new ArrayList<>();
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    fileList.addAll(getAllFilesInDirectory(file));
                } else {
                    fileList.add(file);
                }
            }
        }
        return fileList;
    }
}
