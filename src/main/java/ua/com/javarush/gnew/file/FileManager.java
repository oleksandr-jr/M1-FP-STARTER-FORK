package ua.com.javarush.gnew.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    public String read(Path filePath) throws IOException {
        return Files.readString(filePath);
    }

    public void write(Path filePath, String content) throws IOException {
        Files.writeString(filePath, content);
    }
}
