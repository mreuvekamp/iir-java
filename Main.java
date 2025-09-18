// Java program for simple calculator
import java.lang.*;
import java.util.Scanner;

// Driver class
class Main {
    // main function
    public static void main(String[] args)
    {
        // Stores two numbers
        double number1;
        double number2;

        // Take input from the user
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the numbers:");

        // Take the inputs
        number1 = scanner.nextDouble();

        System.out.println("Enter the operator (+,-,*,/):");

        char operator = scanner.next().charAt(0);
        double result = 0;

        switch (operator) {
            // case to add two numbers
            case '+':
                result = number1 + number2;
                break;

            // case to divide two numbers
            case '/':
                result = number1 / number2;
                break;

            default:
                System.out.println("Unknown operator");
        }

        System.out.println("The final result:");
        System.out.println();

        // print the final result
        System.out.println(number1 + " " + operator + " " + number2
            + " = " + result);
    }
}
