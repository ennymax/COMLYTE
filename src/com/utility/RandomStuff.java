package com.utility;

import org.apache.commons.lang.RandomStringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomStuff {
    private static Random rand = new Random();

    public String RandomWords() {
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        return generatedString;
    }


    public String ListRandom() {

        String fileName = System.getProperty("user.dir") + "\\Config\\words.txt";
        File wordList = new File(fileName);
        List<String> words = new ArrayList<>();
        Scanner reader = null;

        try {
            reader = new Scanner(wordList);
        } catch (FileNotFoundException e) {
            System.out.println("file \"" + fileName + "\" not found");
            System.exit(0);
        }

        while (reader.hasNextLine()) {
            String word = reader.nextLine();
            words.add(word);
        }

        int wordNum = words.size();
        int place;
        place = rand.nextInt(wordNum);
        String s = words.get(place);
        System.out.println(s);
        return s;
    }
}

