package lab3aZad1;

import java.util.Scanner;

public class ComputeByMenu {

    private double x;
    private Scanner input = new Scanner(System.in);

    public ComputeByMenu(double x) {
        this.x = x;
    }

    public void displayMenu(){

        for (int i = 0; i < 60; i++){
            System.out.println();
        }

        System.out.printf("%s",
                "1.\tВъведи число x в плаваща запетая\n" +
                "2.\tПресметни и изведи exp(x)\n" +
                "3.\tПресметни и изведи sin(x)\n" +
                "4.\tПресметни и изведи floor(x)\n" +
                "5.\tКрай\n");
    }

    public void doSelection(int choice) {
        switch (choice){
            case 1: System.out.print("x = ");
            x = input.nextDouble(); break;
            case 2: System.out.println("exp(x) = "
                    + Math.exp(x)); break;
            case 3: System.out.println("sin(x) = "
                    + Math.sin(x)); break;//Math.toRadians()
            case 4: System.out.println("floor(x) = "
                    + Math.floor(x)); break;
            case 5: System.exit(0);
        }
    }

    public void getUserChoice() {
        while(true) {
            displayMenu();
            int choice;

            do{
                System.out.print("Pick a number from 1 to 5: ");
                choice = input.nextInt();
            } while(choice > 5 || choice < 1);

            doSelection(choice);

            System.out.print("Press enter to continue...");
            input.nextLine();
            input.nextLine();
        }
    }
}
