package ua.com.javarush.gnew.runner;

import java.nio.file.Path;

public class RunOptions {
    /**
     * Command to be executed.
     * -e option for encryption.
     * -d option for decryption.
     * -b option for brute force.
     */
    private final Command command;

    /**
     * Key to be used for encryption or decryption.
     * For encryption mode, this is the shift value.
     * -k option is required.
     */
    private final Integer key;

    /**
     * Path to the file to be processed.
     * For encryption and decryption modes, this is the file to be encrypted or decrypted.
     * -f option is required.
     */
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
