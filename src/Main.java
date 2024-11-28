import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> guesses = new ArrayList<>();
        ArrayList<Integer> locationOfBoxes = new ArrayList<>();
        int attempts = 0;
        int maxAttempts = 5;
        RandomBoxes(locationOfBoxes);
        while (attempts < maxAttempts) {
            Guesses(guesses);
            System.out.println(checkBoxes(locationOfBoxes, guesses));
            guesses.clear();
            attempts++;
        }
    }
    static void Guesses(ArrayList<Integer> guesses) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input 3 digits: ");
        for (int i = 0; i < 3; i++) {
            int guess = sc.nextInt();
            if (guess>7 || guess<0 ) {
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
    static int checkBoxes(ArrayList<Integer> locationOfBoxes, ArrayList<Integer> guesses) {
        int correct = 0;
        for (int i = 0; i < 3; i++) {
            if (locationOfBoxes.contains(guesses.get(i))) {
                correct++;
            }
        }
        return correct;
    }
}