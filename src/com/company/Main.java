package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static long[][] morseDigits;

    public static void main(String[] args) {
        long DOT, DASH, AND;
        DOT = 200;             // dot is one unit (here 200ms)
        DASH = 600;            // dash is 3 units
        AND = 200;             // space between parts of the same digit is one unit

        morseDigits = new long[][]{  // time on, time off, time on, ..., time off, time on; always start & end with time ON
                {AND, DASH, AND, DASH, AND, DASH, AND, DASH, AND, DASH},     // 0, AND,  index 35
                {AND, DOT, AND, DASH, AND, DASH, AND, DASH, AND, DASH},      // 1, AND,  index 26
                {AND, DOT, AND, DOT, AND, DASH, AND, DASH, AND, DASH},       // 2
                {AND, DOT, AND, DOT, AND, DOT, AND, DASH, AND, DASH},        // ...
                {AND, DOT, AND, DOT, AND, DOT, AND, DOT, AND, DASH},
                {AND, DOT, AND, DOT, AND, DOT, AND, DOT, AND, DOT},
                {AND, DASH, AND, DOT, AND, DOT, AND, DOT, AND, DOT},
                {AND, DASH, AND, DASH, AND, DOT, AND, DOT, AND, DOT},
                {AND, DASH, AND, DASH, AND, DASH, AND, DOT, AND, DOT},
                {AND, DASH, AND, DASH, AND, DASH, AND, DASH, AND, DOT},      // 9
        };
        long[] output = intToMorse(19);
        for (long i : output) {
            System.out.println(i);
        }
    }

    public static long[] intToMorse(int n) {
        char[] nChars = Integer.toString(n).toCharArray();
        long[] output = new long[nChars.length * 10];
        for (int i = 0; i < nChars.length; i++) {
            char currentChar = nChars[i];
            int asInt = currentChar - '0';
            long[] morseForCurrent = morseDigits[asInt];
            System.arraycopy(morseForCurrent, 0, output, i * 10, 10);
        }
        return output;

    }
}
