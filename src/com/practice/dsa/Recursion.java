package com.practice.dsa;

public class Recursion {

    /**
     * print all numbers till N given N recursively
     */
    static void printN(int n) {
        if (n == 0) {
            return;
        }

        printN(n - 1);
        System.out.println(n);
    }

    /**
     * print all array elements recursively
     */
    static void printArray(int[] a, int i) {
        if (i == a.length) {
            return;
        }

        System.out.println(a[i]);
        printArray(a, i + 1);

    }

    static int factorial(int n) {
        if (n == 0) {
            return 1;
        }

        int res = factorial(n - 1);
        return res * n;
    }

    public static void main(String[] args) {

        int[] a = {1, 2, 3};
        printN(a[a.length - 1]);
        printArray(a, 0);

        System.out.println(factorial(3));


    }
}
