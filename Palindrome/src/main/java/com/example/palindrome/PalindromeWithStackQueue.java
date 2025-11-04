package com.example.palindrome;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
public class PalindromeWithStackQueue {

    /**
     * Implement a method that uses a Stack and a Queue
     * to determine whether the input string is a palindrome.
     * Palindromes read the same forwards and backwards,
     * ignoring case and non-alphanumeric characters.
     * Use Stack and Queue provided by Java's standard library.
     */
    public static boolean isPalindrome(String s)
    {
        if (s == null) throw new IllegalArgumentException("String is null");
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        String p = normalize(s);
        for (int i = 0; i < p.length(); i++) {
            stack.push(p.charAt(i));
            queue.add(p.charAt(i));
        }
        while (!stack.isEmpty() || !queue.isEmpty()) {
            if (stack.pop() != queue.poll()) { return false; }
        }
        return true;
    }

    // Optional helper method for normalization
    public static String normalize(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}
