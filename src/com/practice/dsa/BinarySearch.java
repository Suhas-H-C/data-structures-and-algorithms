package com.practice.dsa;

import java.util.Arrays;

public class BinarySearch {

    /**
     * Given a sorted array and a target,
     * find the first and last position of that target inside the array
     */
    private static void binarySearchTargetValueWithPrimitive(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int first = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                first = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        left = 0;
        right = arr.length - 1;
        int last = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("First : " + first + " Last : " + last);
    }

    /**
     * Given a sorted rotated array,
     * find the least number
     */
    private static void findLeastNumberOnSortedRotatedArray(int[] arr) {
        System.out.println();

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] < arr[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(arr[left]);

    }

    /**
     * Given a sorted rotated array,
     * find the least number
     */
    private static void findElementInArray(int[] arr) {
        Arrays.sort(arr);
        System.out.println("Searching for " + arr[5]);

        int searchFor = arr[5];

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] == searchFor) {
                System.out.println("Found " + searchFor + " at index " + mid);
                break;
            } else if (arr[mid] < searchFor) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] binarySearchPositionOfTarget = {3, 3, 3, 4, 6, 5, 7, 7, 7, 7, 7, 7, 9, 9, 9, 1, 1};
        int target = 7;
        binarySearchTargetValueWithPrimitive(binarySearchPositionOfTarget, target);

        int[] arrLeastNumberOnSortedRotatedArray1 = {7, 9, 10, 11, 12, 13, 14, 2, 4, 5};
        int[] arrLeastNumberOnSortedRotatedArray2 = {2, 4, 5, 7, 9, 10, 11, 12, 13, 14};

        findLeastNumberOnSortedRotatedArray(arrLeastNumberOnSortedRotatedArray2);
        findElementInArray(arrLeastNumberOnSortedRotatedArray1);
    }

}
