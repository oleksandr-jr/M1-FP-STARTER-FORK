package ua.com.javarush.gnew.crypto;

public interface Cypher<KeyType> {

    String encrypt(String input, KeyType key);

    String decrypt(String input, KeyType key);

    String bruteForce(String input);

}
