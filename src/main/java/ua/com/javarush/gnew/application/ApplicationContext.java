package ua.com.javarush.gnew.application;

import ua.com.javarush.gnew.crypto.Cypher;
import ua.com.javarush.gnew.file.FileManager;
import ua.com.javarush.gnew.file.TxtFileManager;
import ua.com.javarush.gnew.runner.ArgumentsParser;

public class ApplicationContext {
    private static ApplicationContext instance;

    private ArgumentsParser argumentsParser;
    private FileManager fileManager;
    private Cypher<Integer> cypher;



    private ApplicationContext() {
    }

    public static ApplicationContext getInstance() {
        if (instance == null) {
            instance = new ApplicationContext();
        }
        return instance;
    }

    public void setFileManager(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public void setArgumentsParser(ArgumentsParser argumentsParser) {
        this.argumentsParser = argumentsParser;
    }

    public void setCypher(Cypher<Integer> cypher) {
        this.cypher = cypher;
    }

    public ArgumentsParser getArgumentsParser() {
        return argumentsParser;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public Cypher<Integer> getCypher() {
        return cypher;
    }
}
