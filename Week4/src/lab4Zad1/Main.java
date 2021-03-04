package lab4Zad1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CaesarCipher.encrypt("TOY");
        CaesarCipher.decrypt("WRB");

        Scanner input = new Scanner(System.in);
        int choice;
        while (true) {
            do {
                System.out.print("Pick 1 for encryption, " +
                        "2 for decryption or 3 for exit: ");
                choice = input.nextInt();
            } while (choice != 1 && choice != 2 && choice != 3);

            /*
            if (choice == 1) {
                System.out.print("Enter word to encrypt: ");
                String wordToEncrypt = input.next().toUpperCase();
                CaesarCipher.encrypt(wordToEncrypt);
            }
            else if (choice == 2) {
                System.out.print("\nEnter word to decrypt: ");
                String wordToDecrypt = input.next().toUpperCase();
                CaesarCipher.decrypt(wordToDecrypt);
            } else
                System.exit(0);
             */

            switch (choice){
                case 1:
                    System.out.print("Enter word to encrypt: ");
                    String wordToEncrypt = input.next().toUpperCase();
                    CaesarCipher.encrypt(wordToEncrypt);
                    break;
                case 2:
                    System.out.print("\nEnter word to decrypt: ");
                    String wordToDecrypt = input.next().toUpperCase();
                    CaesarCipher.decrypt(wordToDecrypt);
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
