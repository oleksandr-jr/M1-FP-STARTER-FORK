package ua.com.javarush.gnew.crypto;

import ua.com.javarush.gnew.language.Language;

import java.util.ArrayList;
import java.util.Collections;

public class CaesarCypher implements Cypher<Integer> {
    private final Language language;

    public CaesarCypher(Language language) {
        this.language = language;
    }

    public String encrypt(String input, Integer key) {
        int intKey = Math.negateExact(key);

        ArrayList<Character> rotatedAlphabet = new ArrayList<>(language.getAlphabet());
        Collections.rotate(rotatedAlphabet, intKey);
        char[] charArray = input.toCharArray();

        StringBuilder builder = new StringBuilder();
        for (char symbol : charArray) {
            builder.append(processSymbol(symbol, rotatedAlphabet));
        }
        return builder.toString();
    }

    public String decrypt(String input, Integer key) {
        int calculatedKey = (language.getAlphabet().size() - key) % (language.getAlphabet().size());
        return encrypt(input, calculatedKey);
    }

    public String bruteForce(String input) {

        for (int i = 1; i < language.getAlphabet().size(); i++) {
            String decryptedText = decrypt(input, i);

            String[] words = decryptedText.split("\\s+");
            int commonWords = 0;
            for (String word : words) {
                if (language.getCommonWords().contains(word)) {
                    commonWords++;

                    if (commonWords > words.length / 9) {
                        return decryptedText;
                    }
                }
            }
        }

        return "";
    }

    private Character processSymbol(char symbol, ArrayList<Character> rotatedAlphabet) {
        boolean upperCase = Character.isUpperCase(symbol);
        char lowerCaseChar = Character.toLowerCase(symbol);

        if (!language.getAlphabet().contains(lowerCaseChar)) {
            return symbol;
        }
        int index = language.getAlphabet().indexOf(lowerCaseChar);

        if (upperCase) {
            return Character.toUpperCase(rotatedAlphabet.get(index));
        }

        return rotatedAlphabet.get(index);
    }
}
