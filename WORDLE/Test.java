package WORDLE;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = scanner.nextLine();
        Game.play_game(word); // the program plays until the word is guessed correct and not till 6 rounds.
    }
    
}
