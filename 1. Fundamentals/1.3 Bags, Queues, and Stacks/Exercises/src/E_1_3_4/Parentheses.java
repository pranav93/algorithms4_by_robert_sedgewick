package E_1_3_4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {

    char[] closingBrackets = new char[] { ']', '}', ')' };
    char[] openingBrackets = new char[] { '[', '{', '(' };

    public static void main(String[] args) {
        Parentheses p = new Parentheses();

        while (!StdIn.isEmpty()) {
            String input = StdIn.readString();
            boolean res = p.isBalanced(input);
            StdOut.println(res);
        }
    }

    private boolean isBalanced(String input) {
        StackChar s = new StackChar();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int closingIndex = this.isInClosingBracket(c);
            if (closingIndex >= 0) {

                if (s.isEmpty()) {
                    return false;
                }

                char top = s.top();
                if (this.openingBrackets[closingIndex] == top) {
                    s.pop();
                } else {
                    return false;
                }
            } else {
                s.push(c);
            }
        }

        return s.isEmpty();
    }

    private int isInClosingBracket(char item) {
        for (int i = 0; i < this.closingBrackets.length; i++) {
            if (this.closingBrackets[i] == item) {
                return i;
            }
        }
        return -1;
    }
}