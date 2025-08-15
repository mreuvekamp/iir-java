// Java program for simple calculator

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Driver class
class Main {
    // main function
    public static void main(String[] args) {
        NumbersAndOperators numbersAndOperators = readNumbersAndOperators();
        List<Double> numbers = numbersAndOperators.numbers;
        List<String> operators = numbersAndOperators.operators;

        if (numbers.size() - operators.size() != 1) {
            System.out.println("Wrong number of numbers (%d) vs number of operators (%d)".formatted(numbers.size(), operators.size()));
            return;
        }

        prioritized(numbers, operators);
    }

    private static NumbersAndOperators readNumbersAndOperators() {
        List<Double> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();

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

        return new NumbersAndOperators(numbers, operators);
    }

    private static void prioritized(List<Double> numbers, List<String> operators) {
        List<Double> newNumbers = new ArrayList<>();
        List<String> newOperators = new ArrayList<>();

        double leftHandNumber = 0;
        int numberIndex = 0;
        int operatorIndex = 0;

        for (Double number : numbers) {
            ++numberIndex;

            if (numberIndex == 1) {
                leftHandNumber = number;
            } else {
                String operator = operators.get(operatorIndex++);
                switch (operator) {
                    case "+", "-":
                        newNumbers.add(leftHandNumber);
                        newOperators.add(operator);
                        leftHandNumber = number;
                        break;

                    case "*":
                        leftHandNumber = leftHandNumber * number;
                        break;

                    case "/":
                        if (number == 0) {
                            System.out.println();
                            System.out.println("Cannot divide by zero!");
                        } else {
                            leftHandNumber = leftHandNumber / number;
                        }
                        break;

                    default:
                        System.out.println("Unknown operator");
                }
            }
        }

        newNumbers.add(leftHandNumber);

        unprioritized(newNumbers, newOperators);
    }

    private static void unprioritized(List<Double> numbers, List<String> operators) {
        boolean resultIsCalculated = true;

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

    private record NumbersAndOperators(List<Double> numbers, List<String> operators) {
    }
}
