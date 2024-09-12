package ua.com.javarush.gnew.language;

import java.util.ArrayList;
import java.util.Set;

public class EngLanguage extends Language {
    public EngLanguage(LanguageCode code, ArrayList<Character> alphabet, Set<String> commonWords) {
        super(code, alphabet, commonWords);
    }

    public void test() {
        ArrayList<Character> alphabet = super.getAlphabet();
    }
}
