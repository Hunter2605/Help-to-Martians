import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstGuess = sc.nextInt();
        int secondGuess = sc.nextInt();
        int thirdGuess = sc.nextInt();
        ArrayList<Integer> guesses = new ArrayList<>();
        ArrayList<Integer> locationOfBoxes = new ArrayList<>();
    }
    static void Guesses(ArrayList<Integer> guesses) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            int guess = sc.nextInt();
            while (guess>7 || guess<0 ) {
                System.out.println("Incorrect input. Try again, give an integer between 0 and 7.");
            }
            guesses.add(guess);
        }
    }
    static void RandomBoxes(ArrayList<Integer> locationOfBoxes) {
        Random rand = new Random();
        while (locationOfBoxes.size()<3) {
            int location = rand.nextInt(8);
            if (!locationOfBoxes.contains(location)) {
                locationOfBoxes.add(location);
            }
        }
    }
}