import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> guesses = new ArrayList<>();
        ArrayList<Integer> locationOfBoxes = new ArrayList<>();
        int attempts = 0;
        int maxAttempts = 5;
        Call(locationOfBoxes,guesses,attempts,maxAttempts);
    }

    static void Guesses(ArrayList<Integer> guesses) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input 3 digits: ");
        while (guesses.size() < 3) {
            int guess = sc.nextInt();
            if (guess >= 0 && guess <= 7) {
                guesses.add(guess);
            }
            else {
                System.out.println("Incorrect input. Try again, give an integer between 0 and 7.");
            }
        }
    }

    static void RandomBoxes(ArrayList<Integer> locationOfBoxes) {
        Random rand = new Random();
        locationOfBoxes.clear();
        while (locationOfBoxes.size()<3) {
            int location = rand.nextInt(8);
            if (!locationOfBoxes.contains(location)) {
                locationOfBoxes.add(location);
            }
        }
    }

    static int checkBoxes(ArrayList<Integer> locationOfBoxes, ArrayList<Integer> guesses) {
        int correct = 0;
        ArrayList<Integer> matchedBoxes = new ArrayList<>(); // Хранит найденные коробки

        for (int guess : guesses) {
            if (locationOfBoxes.contains(guess) && !matchedBoxes.contains(guess)) {
                correct++;
                matchedBoxes.add(guess); // Помечаем коробку как найденную
            }
        }

        if (correct == 3) {
            System.out.println("You found all the boxes!");
            System.exit(0);
        }

        return correct;
    }

    static void Call(ArrayList<Integer> locationOfBoxes, ArrayList<Integer> guesses, int attempts, int maxAttempts) {
        RandomBoxes(locationOfBoxes);

        while (true) {
            while (attempts < maxAttempts) {
                Guesses(guesses);
                int correct = checkBoxes(locationOfBoxes, guesses);
                System.out.println("Correct guesses: " + correct);
                guesses.clear();
                attempts++;

                if (correct == 3) {
                    System.out.println("Congratulations! You've won!");
                    return;
                }
            }

            System.out.println("The legs realized that boxes are being figured out.");
            System.out.println("Legs changed location of boxes.");
            RandomBoxes(locationOfBoxes);
            attempts = 0;
        }
    }
}