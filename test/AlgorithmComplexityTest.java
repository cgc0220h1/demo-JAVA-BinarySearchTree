import java.util.Scanner;

public class AlgorithmComplexityTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String input = scanner.nextLine();

        int[] frequentChar = new int[255];
        for (int index = 0; index < input.length(); index++) {
            int ascii = (int) input.charAt(index);
            frequentChar[ascii] += 1;
        }

        int max = 0;
        char character = (char) 255;
        for (int index = 0; index < frequentChar.length; index++) {
            if (frequentChar[index] > max) {
                max = frequentChar[index];
                character = (char) index;
            }
        }
        System.out.println("The most appearing letter is: "
                + "'"
                + character
                + "'"
                + " with "
                + max
                + " times");
    }
}
