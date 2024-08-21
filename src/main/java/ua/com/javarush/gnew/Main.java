package ua.com.javarush.gnew;

import ua.com.javarush.gnew.crypto.Cypher;
import ua.com.javarush.gnew.file.FileManager;
import ua.com.javarush.gnew.runner.ArgumentsParser;
import ua.com.javarush.gnew.runner.Command;
import ua.com.javarush.gnew.runner.RunOptions;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Cypher cypher = new Cypher();
        FileManager fileManager = new FileManager();
        ArgumentsParser argumentsParser = new ArgumentsParser();
        RunOptions runOptions = argumentsParser.parseArguments(args);


        try {

            if (runOptions.getCommand() == Command.ENCRYPT){
                String content = fileManager.read(runOptions.getFilePath());
                String encryptedContent = cypher.encrypt(content, runOptions.getKey());

                // Add suffix to the file name before .txt
                String fileName = runOptions.getFilePath().getFileName().toString();
                String newFileName = fileName.substring(0, fileName.length() - 4) + " [ENCRYPTED].txt";
                Path newFilePath = runOptions.getFilePath().resolveSibling(newFileName);
                fileManager.write(newFilePath, encryptedContent);

            }

        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            return;
        }



    }
}