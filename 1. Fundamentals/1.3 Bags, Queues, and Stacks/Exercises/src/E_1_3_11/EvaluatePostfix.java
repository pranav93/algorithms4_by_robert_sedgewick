package E_1_3_11;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EvaluatePostfix {
    static String[] operators = { "+", "-", "*", "/", "^" };

    public static void main(String[] args) {
        String input = StdIn.readLine();
        String[] inpArr = input.split(" ");
        StackDouble stackOperand = new StackDouble();

        for (int i = 0; i < inpArr.length; i++) {
            String item = inpArr[i];
            if (isoperator(item)) {
                double op1 = stackOperand.pop();
                double op2 = stackOperand.pop();
                double res = apply(op2, op1, item);
                stackOperand.push(res);
            } else {
                stackOperand.push(Double.parseDouble(item));
            }
        }

        StdOut.printf("The result is %f\n", stackOperand.pop());
    }

    static double apply(double operand1, double operand2, String operator) {
        double res = 0;
        switch (operator) {
            case "+":
                res = operand1 + operand2;
                break;
            case "-":
                res = operand1 - operand2;
                break;
            case "*":
                res = operand1 * operand2;
                break;
            case "/":
                res = operand1 / operand2;
                break;
            case "^":
                res = Math.pow(operand1, operand2);
                break;
        }
        return res;
    }

    static boolean isoperator(String item) {
        if (item.equals(")")) {
            return true;
        }
        for (int i = 0; i < operators.length; i++) {
            if (operators[i].equals(item)) {
                return true;
            }
        }
        return false;
    }
}