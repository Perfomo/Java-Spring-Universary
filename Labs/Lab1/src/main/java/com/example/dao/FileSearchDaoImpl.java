package com.toleyko.dao;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class FileSearchDaoImpl implements FileSearchDAO {
    final private String FILE_NAME = "wordBD.txt";

    @Override
    public int findAndGetWordFrequence(String targetWord) throws IOException {
        URL url = this.getClass()
                .getClassLoader()
                .getResource(FILE_NAME);

        if(url == null) {
            throw new IllegalArgumentException(FILE_NAME + " is not found 1");
        }
        File file = new File(url.getFile());
        Scanner scanner = new Scanner(file);
        int wordFreq = 0;
        System.out.println("Target word: " + targetWord);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
            String[] words = line.split(", ");
            for (String word : words) {
                System.out.println(word);
                if (word.equals(targetWord)) {
                    wordFreq++;
                }
            }
        }
        return wordFreq;
    }
}
