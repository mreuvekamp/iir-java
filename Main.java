// Java program for simple calculator

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Driver class
class Main {
    // main function
    public static void main(String[] args) {
        unprioritizedWithStore();
//        unprioritizedWithoutStore();
    }

    private static void unprioritizedWithStore() {
        // Stores the numbers
        List<Double> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        boolean resultIsCalculated = true;
        boolean shouldReadNumber = true;

        // Take input from the user
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            if (shouldReadNumber) {
                numbers.add(scanner.nextDouble());
                shouldReadNumber = false;
            } else {
                operators.add(scanner.next());
                shouldReadNumber = true;
            }
        }

        if (numbers.size() - operators.size() != 1) {
            System.out.println("Wrong number of numbers (%d) vs number of operators (%d)".formatted(numbers.size(), operators.size()));
            return;
        }

        double result = 0;
        int numberIndex = 0;
        int operatorIndex = 0;

        for (Double number : numbers) {
            ++numberIndex;

            if (numberIndex == 1) {
                result = number;
            } else {
                switch (operators.get(operatorIndex++)) {
                    // case to add two numbers
                    case "+":
                        result = result + number;
                        break;

                    // case to subtract two numbers
                    case "-":
                        result = result - number;
                        break;

                    // case to multiply two numbers
                    case "*":
                        result = result * number;
                        break;

                    // case to divide two numbers
                    case "/":
                        if (number == 0) {
                            resultIsCalculated = false;
                            System.out.println();
                            System.out.println("Cannot divide by zero!");
                        } else {
                            result = result / number;
                        }
                        break;

                    default:
                        System.out.println("Unknown operator");
                }
            }
        }

        if (resultIsCalculated) {
            System.out.println("The final result:");
            System.out.println();

            // print the final result
            System.out.println(result);
        }
    }

    private static void unprioritizedWithoutStore() {
        boolean resultIsCalculated = true;
        boolean shouldReadNumber = true;
        boolean hasStarted = false;
        String operator = null;

        double result = 0;

        // Take input from the user
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            if (shouldReadNumber) {
                double number = scanner.nextDouble();

                if (!hasStarted) {
                    hasStarted = true;
                    result = number;
                } else {
                    resultIsCalculated = true;

                    switch (operator) {
                        // case to add two numbers
                        case "+":
                            result = result + number;
                            break;

                        // case to subtract two numbers
                        case "-":
                            result = result - number;
                            break;

                        // case to multiply two numbers
                        case "*":
                            result = result * number;
                            break;

                        // case to divide two numbers
                        case "/":
                            if (number == 0) {
                                resultIsCalculated = false;
                                System.out.println();
                                System.out.println("Cannot divide by zero!");
                            } else {
                                result = result / number;
                            }
                            break;

                        default:
                            System.out.println("Unknown operator");
                    }
                }

                shouldReadNumber = false;
            } else {
                operator = scanner.next();
                shouldReadNumber = true;
                resultIsCalculated = false;
            }
        }

        if (resultIsCalculated) {
            System.out.println("The final result:");
            System.out.println();

            // print the final result
            System.out.println(result);
        }
    }
}
