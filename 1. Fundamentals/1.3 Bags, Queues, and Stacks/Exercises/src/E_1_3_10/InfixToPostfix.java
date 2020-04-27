package E_1_3_10;

import E_1_3_9.StackStr;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class InfixToPostfix {

    static String[] precArr = { "+", "-", "*", "/", "^" };

    public static void main(String[] args) {
        String input = StdIn.readLine();
        String[] inpArr = input.split(" ");

        StackStr operatorStack = new StackStr();
        StackStr operandStack = new StackStr();

        for (int i = 0; i < inpArr.length; i++) {
            String item = inpArr[i];
            if (isoperator(item)) {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(item);
                    continue;
                }
                String top = operatorStack.top();
                if (top.equals("(")) {
                    operatorStack.push(item);
                    continue;
                }
                while (doApplyOperator(item, top)) {
                    // apply
                    top = operatorStack.pop();
                    String op2 = operandStack.pop();
                    String op1 = operandStack.pop();
                    String newOperand = op1 + " " + op2 + " " + top;
                    operandStack.push(newOperand);
                    if (operatorStack.isEmpty()) {
                        break;
                    }
                    top = operatorStack.top();
                }
                if (item.equals(")")) {
                    while (!top.equals("(")) {
                        top = operatorStack.pop();
                        String op2 = operandStack.pop();
                        String op1 = operandStack.pop();
                        String newOperand = op1 + " " + op2 + " " + top;
                        operandStack.push(newOperand);
                        top = operatorStack.top();
                    }
                    top = operatorStack.pop();
                } else {
                    operatorStack.push(item);
                }
            } else {
                if (item.equals("(")) {
                    operatorStack.push(item);
                } else {
                    operandStack.push(item);
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            String top = operatorStack.pop();
            String op2 = operandStack.pop();
            String op1 = operandStack.pop();
            String newOperand = op1 + " " + op2 + " " + top;
            operandStack.push(newOperand);
        }

        StdOut.println(operandStack.pop());
    }

    static boolean doApplyOperator(String item, String top) {
        int itemPrec = getPrec(item);
        int topPrec = getPrec(top);
        return (itemPrec >= 0) && (topPrec >= 0) && (itemPrec <= topPrec);
    }

    static boolean isoperator(String item) {
        if (item.equals(")")) {
            return true;
        }
        for (int i = 0; i < precArr.length; i++) {
            if (precArr[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    static int getPrec(String item) {
        for (int i = 0; i < precArr.length; i++) {
            if (precArr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
}