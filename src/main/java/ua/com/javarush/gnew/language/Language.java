package ua.com.javarush.gnew.language;

import java.util.ArrayList;
import java.util.Set;

public abstract class Language {
    private LanguageCode code;
    private ArrayList<Character> alphabet;
    private Set<String> commonWords;

    public Language(LanguageCode code, ArrayList<Character> alphabet, Set<String> commonWords) {
        this.code = code;
        this.alphabet = alphabet;
        this.commonWords = commonWords;
    }

    public ArrayList<Character> getAlphabet() {
        return alphabet;
    }

    public Set<String> getCommonWords() {
        return commonWords;
    }

    public LanguageCode getCode() {
        return code;
    }


    public abstract void test();

}
