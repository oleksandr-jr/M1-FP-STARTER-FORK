package ua.com.javarush.gnew.runner;

import java.nio.file.Path;

public class ArgumentsParser {
    public RunOptions parseArguments(String[] args) {
        Command command = null;
        Integer key = null;
        Path filePath = null;

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

            switch (arg) {
                case "-e":
                    command = Command.ENCRYPT;
                    break;

                case "-d":
                    command = Command.DECRYPT;
                    break;

                case "-bf":
                    command = Command.BRUTEFORCE;
                    break;

                case "-k":
                    if (i + 1 < args.length) {
                        key = Integer.parseInt(args[++i]);
                    } else {
                        throw new IllegalArgumentException("Missing value for key");
                    }
                    break;

                case "-f":
                    if (i + 1 < args.length) {
                        filePath = Path.of(args[++i]);
                    } else {
                        throw new IllegalArgumentException("Missing value for file");
                    }
                    break;

                default:
                    throw new IllegalArgumentException("Unknown argument: " + arg);
            }
        }

        if (command == null) {
            throw new IllegalArgumentException("Command (-e, -d, or -bf) is required");
        }

        if ("bruteforce".equals(command) && key != null) {
            throw new IllegalArgumentException("Key should not be provided with brute force mode");
        }

        if (!"bruteforce".equals(command) && key == null) {
            throw new IllegalArgumentException("Key is required for encrypt or decrypt mode");
        }

        if (filePath == null) {
            throw new IllegalArgumentException("File path is required");
        }

        return new RunOptions(command, key, filePath);
    }

}
