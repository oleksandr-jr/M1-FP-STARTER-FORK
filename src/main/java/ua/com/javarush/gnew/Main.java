package ua.com.javarush.gnew;

import ua.com.javarush.gnew.application.ApplicationContext;
import ua.com.javarush.gnew.crypto.Cypher;
import ua.com.javarush.gnew.exceptions.FileNotFoundException;
import ua.com.javarush.gnew.file.CSVFileManager;
import ua.com.javarush.gnew.file.DOCFileManager;
import ua.com.javarush.gnew.file.FileManager;
import ua.com.javarush.gnew.file.TxtFileManager;
import ua.com.javarush.gnew.language.Language;
import ua.com.javarush.gnew.runner.ApplicationLoader;
import ua.com.javarush.gnew.runner.Command;
import ua.com.javarush.gnew.runner.RunOptions;
import ua.com.javarush.gnew.runner.executor.AbstractExecutor;
import ua.com.javarush.gnew.runner.executor.BruteforceExecutor;
import ua.com.javarush.gnew.runner.executor.DecryptExecutor;
import ua.com.javarush.gnew.runner.executor.EncryptExecutor;

import java.awt.desktop.ScreenSleepEvent;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        ApplicationLoader.getInstance().loadApplication();
        ApplicationContext applicationContext = ApplicationContext.getInstance();

        Cypher<Integer> cypher = applicationContext.getCypher();
        RunOptions runOptions = applicationContext.getArgumentsParser().parse(args);

        String fileName = runOptions.getFilePath().getFileName().toString();
        String fileExtension = fileName.substring(fileName.length() - 4);

        if (fileExtension.equals(".txt")) {
            TxtFileManager fileManager = new TxtFileManager();
            applicationContext.setFileManager(fileManager);
        } else if (fileExtension.equals(".csv")) {
            applicationContext.setFileManager(new CSVFileManager());
        } else if (fileExtension.equals(".doc")) {
            applicationContext.setFileManager(new DOCFileManager());
        }

        FileManager fileManager = applicationContext.getFileManager();
        System.out.println("File extension: " + fileExtension);

        AbstractExecutor executor = getExecutor(runOptions, cypher, fileManager);

        try {
            executor.execute();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private static AbstractExecutor getExecutor(RunOptions runOptions, Cypher<Integer> cypher, FileManager fileManager) {
        return switch (runOptions.getCommand()) {
            case ENCRYPT -> new EncryptExecutor(runOptions, cypher, fileManager);
            case DECRYPT -> new DecryptExecutor(runOptions, cypher, fileManager);
            case BRUTEFORCE -> new BruteforceExecutor(runOptions, cypher, fileManager);
            default -> throw new IllegalArgumentException("Unknown command: " + runOptions.getCommand());
        };
    }
}