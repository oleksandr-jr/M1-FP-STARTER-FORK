package ua.com.javarush.gnew.runner.executor;

import ua.com.javarush.gnew.crypto.Cypher;
import ua.com.javarush.gnew.file.FileManager;
import ua.com.javarush.gnew.runner.RunOptions;

import java.nio.file.Path;

public class BruteforceExecutor extends AbstractExecutor {

    public BruteforceExecutor(RunOptions runOptions, Cypher<Integer> cypher, FileManager fileManager) {
        super(runOptions, cypher, fileManager);
    }

    @Override
    public String executeCypherCommand(String content) {
        return cypher.bruteForce(content);
    }

    @Override
    public Path getNewFilePath() {
        String newFileName = fileName.substring(0, fileName.length() - 4) + " [BRUTEFORCED].txt";

        return runOptions.getFilePath().resolveSibling(newFileName);
    }
}
