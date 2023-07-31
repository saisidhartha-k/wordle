package WORDLE;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Game {

        public static void play_game(String word)
        {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            builder.append("-");
        }
        List<String> words = null;

        try {
            words = Files.readAllLines(Paths.get("WORDLE/words.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int rounds = 0;
        while (true) 
        {
            String guess = words.get(random.nextInt(words.size()));
            System.out.println("guessed word :" + " " + guess);

            if (guess.equals(word)) {
                System.out.println("Computer guessed the word correctly");
                return;
            }
            List<Character> greenList = new ArrayList<>();
            List<Character> yellowList = new ArrayList<>();
            List<Character> greyList = new ArrayList<>();

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess.charAt(i)) {
                    greenList.add(word.charAt(i));
                    builder.setCharAt(i, word.charAt(i));
                }
                else if (word.contains(String.valueOf(guess.charAt(i)))) {
                    yellowList.add(guess.charAt(i));
                } 
                else {
                    greyList.add(guess.charAt(i));
                }
            }
            System.out.println(builder.toString());
            System.out.println("Green list: " + greenList);
            System.out.println("Yellow list: " + yellowList);
            System.out.println("Grey list: " + greyList);
            System.out.println("Round number :" + " " + rounds++);
            System.out.println();
            if (!builder.toString().contains("-"))
            {
                System.out.println("Computer guessed the word correctly");
                return;
            }
        }
    }
}
