package lab4Zad2;
/*
Write a Java application that prompts the user to enter a sequence of numbers
and displays the distinct numbers in the sequence. Assume that the input ends
with 0 and 0 is not counted as a number in the sequence. (Use class ArrayList)
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class DistinctNumbers {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList list = new ArrayList(); //distinct numbers

        System.out.print("Number Sequence: ");
        String line = input.nextLine();
        //1.1  23.5 4.4   4.4 3.1  3.3 0 3.1 2.2
        //1,2,3,4,2,1,2,0,3,5
        String[] numbersString = line.split("\\s+|,");
        double[] numbers = new double[numbersString.length];

        for (int i = 0; i < numbersString.length; i++){
            numbers[i] = Double.parseDouble(numbersString[i]);
            if(numbers[i] == 0){
                System.out.println("Distinct numbers: " + list);
                System.exit(0);
            }
            if (!list.contains(numbers[i])){
                list.add(numbers[i]);
            }
        }

        /*
        Scanner input = new Scanner(System.in);
        ArrayList list = new ArrayList(); //distinctNumbers
        int number; // or double

        System.out.print("Number: ");
        number = input.nextInt();
        while(number != 0){
            if (!list.contains(number)){
                list.add(number);
            }
            System.out.print("Next number: ");
            number = input.nextInt();
        }

        System.out.println("Distinct numbers: " + list);
         */

        /*
        Scanner input = new Scanner(System.in);
        ArrayList list = new ArrayList(); //distinctNumbers
        int number; // or double

        System.out.print("Number: ");
        number = input.nextInt();
        while(number != 0){
            list.add(number);
            System.out.print("Next number: ");
            number = input.nextInt();
        }

        HashSet<Integer> set = new HashSet<Integer>(list); //distinct

        System.out.println("Distinct numbers: " + set);

         */
    }
}
