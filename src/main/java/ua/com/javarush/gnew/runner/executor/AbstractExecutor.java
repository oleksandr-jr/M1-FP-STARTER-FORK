package ua.com.javarush.gnew.runner.executor;

import ua.com.javarush.gnew.application.ApplicationContext;
import ua.com.javarush.gnew.crypto.Cypher;
import ua.com.javarush.gnew.file.FileManager;
import ua.com.javarush.gnew.runner.RunOptions;

import java.nio.file.Path;

public abstract class AbstractExecutor {
    protected ApplicationContext applicationContext = ApplicationContext.getInstance();
    protected Cypher<Integer> cypher = applicationContext.getCypher();
    protected String fileName;
    protected FileManager fileManager;
    protected RunOptions runOptions;

    public AbstractExecutor(RunOptions runOptions, Cypher<Integer> cypher, FileManager fileManager) {
        this.runOptions = runOptions;
        this.cypher = cypher;
        this.fileManager = fileManager;
    }


    public void execute() {
        String content = fileManager.read(runOptions.getFilePath());
        String encryptedContent = this.executeCypherCommand(content);
        Path newFilePath = getNewFilePath();
        fileManager.write(newFilePath, encryptedContent);
    }

    public abstract String executeCypherCommand(String content);
    public abstract Path getNewFilePath();
}
