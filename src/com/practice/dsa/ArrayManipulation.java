package com.practice.dsa;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayManipulation {

    /**
     * Given an array of size 'N' and an integer 'target'
     * Find the indices of two number (i,j) such that their sum is equal to target
     * And (i != j).You can assume that there will be only one solution.
     * <p>
     * LEGACY APPROACH - Brute Force approach
     */
    public static void findTargetIndices(int[] inputArray, int target) {
        if (inputArray.length != 0 && inputArray.length >= 2) {
            for (int i = 0; i < inputArray.length; i++) {
                for (int j = i + 1; j < inputArray.length; j++) {
                    if (inputArray[i] + inputArray[j] == target) {
                        System.out.println("Target summed up at indices i = " + i + " and j = " + j);
                        break;
                    } else {
                        continue;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Please provide an array with size at least 2");
        }
    }


    /**
     * SCALER APPROACH - OPTIMIZES
     */
    public static void findTwoMatchingTarget(int[] inputArray, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inputArray.length; i++) {
            int secondNumber = target - inputArray[i];
            if (hashMap.containsKey(secondNumber)) {
                System.out.println(hashMap.get(secondNumber) + " " + i);
                break;
            }
            hashMap.put(inputArray[i], i);
        }
    }


    /**
     * Given an array of size 'N' and an integer 'target'
     * Find the all possible triplets {a[i] + a[j] + a[k]} == target and i!=j!=k and solution must be unique.
     * <p>
     * a[i] +a[j] + a[k] = target, a[j] + a[k] = target - a[i]
     */
    private static void findTripletsMatchingTarget(int[] inputArray2, int target2, int length) {
        Arrays.sort(inputArray2);
        for (int i = 0; i < length; i++) {
            if (i == 0 || inputArray2[i] != inputArray2[i - 1]) {
                int j = i + 1, k = length - 1;
                int newTarget = target2 - inputArray2[i];

                //APPLYING 2 POINTER APPROACH
                while (j < k) {
                    if (inputArray2[j] + inputArray2[k] == newTarget) {
                        System.out.println(inputArray2[i] + " " + inputArray2[j] + " " + inputArray2[k]);

                        //ignoring duplicates
                        while (j < k && inputArray2[j] == inputArray2[j + 1]) {
                            j++;
                        }
                        while (j < k && inputArray2[k] == inputArray2[k - 1]) {
                            k--;
                        }

                        j++;
                        k--;
                    } else if (inputArray2[j] + inputArray2[k] < newTarget) {
                        j++;
                    } else {
                        k--;
                    }
                }

            }
        }
    }

    /**
     * Given a number check the smallest number possible whose product is the given number
     * <p>
     * <p>
     * logic - Divide number from 9 to 2 and increment frequency of divisor.
     */
    private static int findSmallestNumberProductActualNumber(int givenNumber) {
        String answer = "";
        for (int i = 9; i > 1; i--) {
            while (givenNumber % i == 0) {
                givenNumber = givenNumber / i;
                answer = i + answer;
            }
        }

        if (givenNumber != 1) {
            return -1;
        } else {
            return Integer.parseInt(answer);
        }
    }

    /**
     * Given an array 'n' find the majority item and return it if it's value is n/2.
     * If no majority is found then return -1
     * <p>
     * MOOR's VOTING ALGORITHM
     */
    private static int findMajorityRepeatedItemInArray(int[] arr) {

        //MOOR's VOTING ALGORITHM - START
        int candidate = arr[0];
        int vote = 1;
        for (int i = 1; i < arr.length; i++) {
            if (candidate == arr[i]) {
                ++vote;
            } else {
                --vote;
            }

            if (vote == 0) {
                candidate = arr[i];
                vote = 1;
            }
        }
        //MOOR's VOTING ALGORITHM - END

        //verify if candidate is the actual answer or not
        vote = 0;
        for (int i : arr) {
            if (candidate == i) {
                ++vote;
            }
        }

        if (vote > arr.length / 2) {
            return candidate;
        } else {
            return -1;
        }
    }

    /**
     * Given a matrix of N*N rotate it clockwise in 90 deg without using any extra space.
     */
    private static void printMatrixPost90Transpose(int[][] arr) {
        // STEP 1 - Taking transpose of given matrix
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        print2DMatrix(arr);
        System.out.println();
        // STEP 2 - Swap the columns
        int left = 0, right = arr[0].length - 1;
        while (left < right) {
            for (int i = 0; i < arr.length; i++) {
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;
            }
            left++;
            right--;
        }

        print2DMatrix(arr);
    }

    private static void print2DMatrix(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    /**
     * Print the matrix in spiral format
     */

    private static void printMatrixSpirally(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int rmin = 0, rmax = arr.length - 1, cmin = 0, cmax = arr[0].length - 1;

        int count = 0;
        System.out.println();
        while (count < (n * m)) {
            //top boundary
            for (int col = cmin; col <= cmax && count < (n * m); col++) {
                System.out.print(arr[rmin][col] + " ");
                count++;
            }
            rmin++;
            //right boundary
            for (int row = rmin; row <= rmax && count < (n * m); row++) {
                System.out.print(arr[row][cmax] + " ");
                count++;
            }
            cmax--;
            //bottom boundary

            for (int col = cmax; col >= cmin && count < (n * m); col--) {
                System.out.print(arr[rmax][col] + " ");
                count++;
            }
            rmax--;
            //left boundary
            for (int row = rmax; row >= rmin && count < (n * m); row--) {
                System.out.print(arr[row][cmin] + " ");
                count++;
            }
            cmin++;
        }
    }

    /**
     * reverse all array elements
     */
    private static void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
        System.out.println("\n");
        for (int i1 : arr) {
            System.out.print(i1 + " ");
        }
    }

    /**
     * find sum of array elements
     */
    private static void sum(int[] arr) {
        int sum = 0;

        for (int i : arr) {
            sum += i;
        }

        System.out.println("\n" + sum);
    }

    /**
     * find max of array elements
     */
    private static void max(int[] arr) {
        int max = 0;

        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        System.out.println("\n" + max);
    }

    /**
     * find transpose of given 2D array
     */
    private static void transpose(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        System.out.println("\n");
        for (int i = 0; i < a.length; i++) {
            for (int i1 = 0; i1 < a[0].length; i1++) {
                System.out.print(a[i][i1] + " ");
            }
            System.out.println();
        }
    }


    private static Collection<Integer> removeEvenNumbers(List<Integer> l) {

        return l.stream().filter(number -> number % 2 != 0).collect(Collectors.toList());
    }

    public static void main(String[] args) {

        int[] sumOf2GivesTarget = {12, 56, 22, 7, 89, 44, 62, 31};
        int[] sumOf3GivenTarget = {7, -6, 3, 8, -1, 8, -11};
        int[] majorityItemInArray = {3, 2, 1, 2, 5, 7, 2, 2, 2};
        int[] reverse = {3, 4, 5, 6, 2, 1};
        int[][] rotateMatrixByNinty = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        int targetFor2Matching = 106;
        int targetFor3Matching = 0;

        // Solution 1]
        findTwoMatchingTarget(sumOf2GivesTarget, targetFor2Matching);

        // Solution 2]
        findTripletsMatchingTarget(sumOf3GivenTarget, targetFor3Matching, sumOf3GivenTarget.length);

        //Solution 3]
        System.out.println(findSmallestNumberProductActualNumber(targetFor2Matching));

        //Solution 4]
        System.out.println(findMajorityRepeatedItemInArray(majorityItemInArray));

        //Solution 5]
        printMatrixPost90Transpose(rotateMatrixByNinty);
        printMatrixSpirally(rotateMatrixByNinty);

        reverse(reverse);
        sum(reverse);
        max(reverse);

        transpose(rotateMatrixByNinty);

        System.out.println("\n" + removeEvenNumbers(Arrays.asList(13, 5, 72, 88, 41, 7, 31)));
    }


}

