package ua.com.javarush.gnew.runner;

import ua.com.javarush.gnew.application.ApplicationContext;
import ua.com.javarush.gnew.crypto.CaesarCypher;
import ua.com.javarush.gnew.crypto.Cypher;
import ua.com.javarush.gnew.file.FileManager;
import ua.com.javarush.gnew.file.TxtFileManager;
import ua.com.javarush.gnew.language.EngLanguage;
import ua.com.javarush.gnew.language.Language;
import ua.com.javarush.gnew.language.LanguageCode;

import java.nio.file.Path;
import java.util.*;

public class ApplicationLoader {
    private static ApplicationLoader instance;
    private static final ApplicationContext applicationContext = ApplicationContext.getInstance();

    private ApplicationLoader() {
    }

    public static ApplicationLoader getInstance() {
        if (instance == null) {
            instance = new ApplicationLoader();
        }
        return instance;
    }

    public void loadApplication() {
        applicationContext.setArgumentsParser(new ArgumentsParser());
        applicationContext.setCypher(new CaesarCypher(createLanguage()));
    }

    private Language createLanguage(){
        ArrayList<Character> englishAlphabet = loadAlphabet();
        Set<String > englishCommonWords = loadCommonWords();
        System.out.println(englishCommonWords);

        return new EngLanguage(LanguageCode.EN, englishAlphabet, englishCommonWords);
    }

    private ArrayList<Character> loadAlphabet(){
        return new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
    }

    private Set<String> loadCommonWords(){
        FileManager fileManager = new TxtFileManager();
        String read = fileManager.read(Path.of(Objects.requireNonNull(getClass().getResource("/dictionary/EN/EN-most-common-words.txt")).getPath()));
        if (read != null) {
            return new HashSet<>(Arrays.asList(read.split("\n")));
        }
        return new HashSet<>();
    }
}
