package com.practice.dsa;

import java.util.ArrayList;
import java.util.List;

public class PermutationsAndBackTracking {

    /**
     * Given an array find all possible permutations
     */
    private static void printPermutations(int[] arr, int pos, boolean[] selected, ArrayList<Integer> ans) {

        if (pos == arr.length) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (selected[i] == false) {
                selected[i] = true;
                ans.add(arr[i]);
                printPermutations(arr, pos + 1, selected, ans);
                selected[i] = false;
                ans.remove(ans.size() - 1);
            }
        }
    }

    /**
     * Given an array and a target find all possible sub-sets
     */
    private static void printAllPossibleSubSets(int[] arr, int index, List<Integer> ans) {

        if (index == arr.length) {
            System.out.println(ans);
            return;
        }

        //select iTH element
        ans.add(arr[index]);
        printAllPossibleSubSets(arr, index + 1, ans);
        ans.remove(ans.size() - 1);

        //remove iTH element
        printAllPossibleSubSets(arr, index + 1, ans);
    }

    /**
     * Given an array and a target find all possible sub-sets whose sum is equal to target
     */
    private static void printAllPossibleSubSetsSumIsTarget(int[] arr, int index, int target, List<Integer> ans) {
        if (target < 0) {
            return;
        }
        if (index == arr.length) {
            if (target == 0)
                System.out.println(ans);
            return;
        }

        //select iTH element
        ans.add(arr[index]);
        printAllPossibleSubSetsSumIsTarget(arr, index + 1, target - arr[index], ans);
        ans.remove(ans.size() - 1);

        //remove iTH element
        printAllPossibleSubSetsSumIsTarget(arr, index + 1, target, ans);
    }


    /**
     * The N Queens puzzle is a problem of placing N queens on an N*N chessboard such that no 2 queens attack each other
     * Given an Integer N return all possible solutions to the N queens puzzle
     */


    public static void main(String[] args) {
        int[] permutationArray = {1, 2, 3};
        System.out.println("Printing all possible permutations...\n");
        printPermutations(permutationArray, 0, new boolean[permutationArray.length], new ArrayList<>());

        int[] printSubSetArray = {10, 20, 40, 30};
        int index = 0;
        int target = 60;
        List<Integer> ans = new ArrayList<>();

        System.out.println("Printing all possible sub sets...\n");
        printAllPossibleSubSets(printSubSetArray, index, ans);
        System.out.println("Printing sub sets whose sum is equal to target...\n");

        printAllPossibleSubSetsSumIsTarget(printSubSetArray, index, target, ans);
    }


}
