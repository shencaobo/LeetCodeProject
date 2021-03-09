package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Solution solution=new Solution();
        String s=  solution.longestPalindrome("cccc");
        System.out.print(s);

    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> t = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(')
                t.push(c);
            else if (c == ')')
                if (t.empty())
                    return false;
                else
                    t.pop();

        }

        return t.empty();
    }

}


