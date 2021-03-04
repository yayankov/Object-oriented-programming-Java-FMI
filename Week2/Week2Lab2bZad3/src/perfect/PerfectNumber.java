package perfect;

public class PerfectNumber {
    private final static int NUMBER_PER_LINE = 5;
    //create constant, both method and constant are static so we can call in main method

    public static boolean isPerfect( int number){
        int sum = 1;
        int half = number/2; //no need to look for multipliers after that
        int counter = 0;
        for (int i = 2; i <= half; i++){
            if (number % i == 0){ //check if i is a multiplier
                System.out.printf("%d\t",i); //print number with distance
                sum += i; //add number to sum
                counter++;
                if (counter % NUMBER_PER_LINE == 0){ //print new line when numbers per line is reached
                    System.out.println();
                }
            }

        }
        return number == sum; //check if sum is equal to number and return true if so
    }

    public static void main(String[] args) {
        System.out.println(isPerfect(200));
        //print true if number in brackets is perfect
    }
}
