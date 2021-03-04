package zad2;

public class ExceptionTest {

    public static void main(String[] args) {
        String string = "str";
        try {
            double number = Double.parseDouble(string);
            System.out.println("Number: " + number);
        } catch (NumberFormatException e) {
            System.err.println("Wrong format");
        } finally {
            System.out.println("Successful exception catch");
        }
    }
}
