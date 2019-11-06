package se.lexicon.tor;

import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class BasicCalculator {

    static Scanner sc;

    public static void main(String[] args) {
        mathLoop();
    }

    //Mathing loop
    public static void mathLoop() {
        sc = new Scanner(System.in);

        writeL("\nOpening Tor.calc ver. 1.1\n"); //println, talks to user

        boolean keepRunningMenu = true; //flag for keeping the program running

        while (keepRunningMenu) { //keeps running the whole program

            writeL("Available operators are: + - / * sqrt (squareroot of current result) power (power of)\nWrite \"New\" to view the result and finish\nOr you can exit by writing \"Stop\"\n");

            boolean keepCalculatingLine = true;

            /*
            asks for the first number from the user, reused again later

            this is so that you don't start calculating on an operand, now you get that first number to calculate with
            only done at startup, the rest you calculate on the sum of this seed
             */

            Double oldNum = askNum();

            while (keepCalculatingLine) { //keeps mathing on this lineage of operations

                //ask an operator, ask another number, calculate, use in next calc

                double[] result;

                String input = askOp();

                //checks if stop or result, also sqrt
                switch (input) {
                    case "STOP":
                        exit();
                    case "NEW":
                        keepCalculatingLine = false;
                        break;
                    case "SQRT":
                        result = sqrt(oldNum);
                        oldNum = result[0];
                        if (result[1] == -1) {
                            writeL("That didn't work, invalid math, annulled");
                        }
                        writeL("Result: " + oldNum);
                        break;
                    default:
                        oldNum = operand(oldNum, input);
                        if (oldNum == null) {
                            keepCalculatingLine = false;
                        }
                }
            }
            keepRunningMenu = askForContinue();
        }
    }

    //exit method

    static void exit(){
        writeL("\nByebye\n");
        System.exit(0);
    }

    //writing methods, just less effort, kinda lazy

    static void write(String text) {

        System.out.print(text);

    }

    static void writeL(String text) {

        System.out.println(text);

    }

    //getting input from user

    static double askNum() {
        while (true) {
            write("Write a number, any number: ");
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                writeL("Invalid number, please write a number");
            }
        }
    }

    static String askOp() {

        String[] validOps = {"+", "-", "/", "*", "SQRT", "POWER", "NEW", "STOP",};

        while (true) {
            write("Now write a command to use: ");
            String operator = sc.nextLine().toUpperCase();
            for (String op : validOps) {
                if (op.equals(operator)) {
                    return operator;
                }
            }
            writeL("Not an operator, please write a valid one");
        }
    }

    static double[] askForArray() {
        while (true) {
            try {
                write("Write as many numbers as you'd like on this line: ");
                String addSubLine = sc.nextLine();
                Scanner addSubReader = new Scanner(addSubLine);
                double[] addSubArguments = new double[0];
                while (addSubReader.hasNext()) {
                    String check = addSubReader.next();
                    switch (check.toUpperCase()) {
                        case "NEW":
                            return null;
                        case "STOP":
                            exit();
                    }
                    addSubArguments = addToArray(addSubArguments, Double.parseDouble(check));
                }
                return addSubArguments;
            } catch (Exception e) {
                writeL("Please enter a line of numbers with spaces in between them");
            }
        }
    }

    //menu lines for restart and exit

    static boolean askForContinue() {

        while (true) {

            writeL("Want to do more math? (y/n)");

            switch (sc.nextLine().toLowerCase()) {
                case "y":
                    writeL("Oh, that's nice, let's go then!");
                    return true;
                case "n":
                    write("Okay then, byebye");
                    return false;
                default:
                    writeL("\nEnter either \"y\" or \"n\"\n");
            }
        }
    }

    //math operands

    static Double operand(double oldNum, String input) {

        double[] result = new double[0];
        double newNum = 0;

        switch (input) {
            case "+":
            case "-":
                result = askForArray();
                if (result == null) {
                    return null;
                }
                break;
            default:
                newNum = askNum(); //another number, needed for these operations
        }

        switch (input) {
            case "+":
                oldNum = add(oldNum, result);
                break;
            case "-":
                oldNum = sub(oldNum, result);
                break;
            case "/":
                result = div(oldNum, newNum);
                oldNum = result[0];
                if (result[1] == -1) {
                    writeL("you tried to divide by 0, annulled");
                }
                break;
            case "*":
                oldNum = mul(oldNum, newNum);
                break;
            case "POWER":
                oldNum = pow(oldNum, newNum);
                break;
            default:
                writeL("Invalid operator");
        }

        writeL("Result: " + oldNum);
        return oldNum;
    }

    static double add(double num1, double num2) {
        return num1 + num2;
    }

    static double add(double oldNum, double... numbers) {
        for (double number : numbers) {
            oldNum += number;
        }
        return oldNum;
    }

    static double sub(double num1, double num2) {
        return num1 - num2;
    }

    static double sub(double oldNum, double... numbers) {
        for (double number : numbers) {
            oldNum -= number;
        }
        return oldNum;
    }

    static double mul(double num1, double num2) {
        return num1 * num2;
    }

    static double[] div(double num1, double num2) {
        double[] array = {num1, 0};
        if (num2 != 0) {
            array[0] = num1 / num2;
        } else {
            array[1] = -1;
        }
        return array;
    }

    static double pow(double num1, double num2) {
        return Math.pow(num1, num2);
    }

    static double[] sqrt(double num1) {
        double[] array = {num1, 0};
        if (num1 >= 0) {
            array[0] = Math.sqrt(num1);
            return array;
        } else {
            array[1] = -1;
            return array;
        }
    }

    static double[] addToArray(double[] array, double number) {
        int oldLength = array.length;
        array = Arrays.copyOf(array, array.length + 1);
        array[oldLength] = number;
        return array;
    }

}
