package pg_60058;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

    }

    public static int SplitString(String p) {
        Stack<Character> stack = new Stack<>();
        int index = -1;

        for (char ch : p.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
                ++index;
                continue;
            }

            if (ch == ')') {
                if (stack.isEmpty()) {
                    break;
                }
                stack.pop();
                ++index;
            }
        }

        return index;
    }

    public static String solution(String p) {
        int startIndex = SplitString(p);
        int endIndex = p.length();

        if (startIndex == endIndex) {
            return p;
        }


    }

    public static String FixBracketPair(String str) {

    }
}
