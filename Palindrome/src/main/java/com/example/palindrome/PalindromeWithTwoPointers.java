package com.example.palindrome;

import java.util.Deque;
import java.util.LinkedList;

public final class PalindromeWithTwoPointers {
    private PalindromeWithTwoPointers() {
        /* utility */
    }

    /**
     * Implement a method that uses the two-pointer technique
     *
     * @param s input string (must not be null)
     * @return true if palindrome
     * @throws IllegalArgumentException if s is null
     */
    public static boolean isPalindrome(String s) {
        if (s == null) throw new IllegalArgumentException("String is null");
        String p = normalize(s);
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < p.length(); i++)
            deque.add(p.charAt(i));
        for  (int i = 0; i < p.length()/2; i++)
            if (deque.removeFirst() != deque.removeLast()) return false;

        return true;
    }

    // package-private for testing if needed
    static String normalize(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}

