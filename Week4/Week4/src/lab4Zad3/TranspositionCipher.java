package lab4Zad3;

import java.util.Scanner;

public class TranspositionCipher {

    public static void main(String[] args) {
        String plainText;
        String keyText;
        String cipherText = "";
        Scanner input = new Scanner(System.in);

        System.out.print("Plain text: ");
        plainText = input.next();
        System.out.print("Key text: ");
        keyText = input.next();

        int cipherKey = keyText.length(); //keyText.toCharArray().length;
        char[] toCipher = plainText.toCharArray();
        int rowsLength;
        if (plainText.length() % cipherKey == 0){
            rowsLength = plainText.length() / cipherKey;
        }else{
            rowsLength = plainText.length() / cipherKey + 1;
        }

        char[][] encryption = new char[rowsLength][cipherKey];
        int rowCounter = 0;
        for (int i = 0; i < toCipher.length; i++){

           if (i != 0 && i % cipherKey == 0){ //6, 12, 18, ...
               rowCounter++;
           }
            encryption[rowCounter][i % cipherKey] =
                    toCipher[i];
        }

        for (int i = 0; i < encryption.length; i++){
            for (int j = 0; j < encryption[i].length; j++){
                System.out.print(encryption[i][j] + " ");
            }
            System.out.println();
        }


        for (int i = 0; i < encryption[0].length; i++) {// 0 1 2 3 4 5
            for (int j = 0; j < encryption.length; j++) { // 0 1 2
                cipherText += encryption[j][i];
            }
        }
        //thisistheplaintext

        System.out.println("Cipher: " + cipherText);
    }
}
