package com.practice.dsa;

import java.util.Locale;

public class StringManipulation {

    /**
     * Removing all vowels in the string
     */
    private static String removeVowels(String value) {
        char[] arr = value.toLowerCase(Locale.ENGLISH).toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                arr[i] = ' ';
            }
        }
        return new String(arr);
    }

    /**
     * Reverse the vowels in the string
     */
    private static String reverseVowels(String value) {
        char[] arr = value.toLowerCase().toCharArray();
        int i = 0, j = arr.length - 1;

        while (i < j) {

            while (arr[i] != 'a' && arr[i] != 'e' && arr[i] != 'i' && arr[i] != 'o' && arr[i] != 'u') {
                i++;
            }
            while (arr[j] != 'a' && arr[j] != 'e' && arr[j] != 'i' && arr[j] != 'o' && arr[j] != 'u') {
                j--;
            }

            if (i >= j) {
                break;
            }

            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }


        return new String(arr);
    }

    /**
     * Replace all uppercase characters to lowercase characters
     */
    private static void convertUprToLwr(String val) {
        char[] c = val.toCharArray();

        /**
         * 'A' - 'E' == 'a' - 'e'
         * 'E' - 'A' = 'e' - 'a'
         * 'E' = 'A' + 'a' = 'e'
         * */
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= 'A' && c[i] <= 'Z') {
                int res = c[i] - 'A' + 'a';
                c[i] = (char) res;
            }
        }

        System.out.println(new String(c));
    }


    public static void main(String[] args) {

        System.out.println(removeVowels("WELCOME TO THE JUNGLE"));
        System.out.println(reverseVowels("YOU CAN DO IT"));
        convertUprToLwr("wElComeTosCaLeR");
    }
}
