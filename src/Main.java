import java.util.Scanner;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstGuess = sc.nextInt();
        int secondGuess = sc.nextInt();
        int thirdGuess = sc.nextInt();
        int max = 7;
        int min = 0;

    }
    public static int Random(int min, int max) {
        return (int) (Math.random() * (max - min));
    }
}