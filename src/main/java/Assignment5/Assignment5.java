package Assignment5;

import java.util.Scanner;

public class Assignment5 {

    public static void main(String[] args) {
        System.out.println("[DNA Reverser and Translator]");
        System.out.print("Enter a sequence: ");
        final String sequence = new Scanner(System.in).nextLine();
        boolean valid = DNALib.validator(sequence.toUpperCase());
        if (valid) {
            System.out.println("Your DNA sequence reversed and translated is: ");
            final String reverse = DNALib.reverser(sequence);
            final String inverse = DNALib.inverser(reverse);
            final String translation = DNALib.translator(inverse);
            System.out.println(translation);
        } else {
            System.out.println("Your DNA sequence is not valid.");
        }
    }
}
