package ua.com.javarush.gnew.runner;

import java.nio.file.Path;

public class RunOptions {
    private final Command command;
    private final Integer key;
    private final Path filePath;

    public RunOptions(Command command, Integer key, Path filePath) {
        this.command = command;
        this.key = key;
        this.filePath = filePath;
    }

    public Command getCommand() {
        return command;
    }

    public Integer getKey() {
        return key;
    }

    public Path getFilePath() {
        return filePath;
    }

    @Override
    public String toString() {
        return "CommandOptions{" +
                "command='" + command + '\'' +
                ", key=" + key +
                ", filePath=" + filePath +
                '}';
    }
}
