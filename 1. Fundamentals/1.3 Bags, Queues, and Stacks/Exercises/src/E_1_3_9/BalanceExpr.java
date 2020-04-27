package E_1_3_9;

import edu.princeton.cs.algs4.StdOut;

public class BalanceExpr {
    public static void main(String[] args) {
        String input = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        String[] inputArr = input.split(" ");
        StackStr stackOperands = new StackStr();
        StackStr stackOperators = new StackStr();

        for (int i = 0; i < inputArr.length; i++) {
            char ch = inputArr[i].charAt(0);
            if (Character.isDigit(ch)) {
                stackOperands.push(inputArr[i]);
            } else {
                if (ch == ')') {
                    String operator = stackOperators.pop();
                    String operand2 = stackOperands.pop();
                    String operand1 = stackOperands.pop();
                    String newOperand = '(' + operand1 + operator + operand2 + ')';
                    stackOperands.push(newOperand);
                } else {
                    stackOperators.push(inputArr[i]);
                }
            }
        }
        StdOut.println(stackOperands.pop());
    }
}