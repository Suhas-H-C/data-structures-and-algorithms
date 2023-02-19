package com.practice.dsa;

/**
 * SKETCHING AND ANALYSING IS REQUIRED
 * */
public class SortingManipulation {

    /**
     * selection sort - selecting an element as minimum and comparing, if another smaller is found then swapping is performed.
     * will find the element that must be placed at first, second, third and so on...
     */
    private static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minVal = a[i], midInd = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < minVal) {
                    minVal = a[j];
                    midInd = j;
                }
            }
            int temp = a[i];
            a[i] = a[midInd];
            a[midInd] = temp;
        }

        for (int i : a) {
            System.out.print(i + " ");
        }
    }


    /**
     * bubble sort - placing the largest element at the last index and loop only till second last
     */
    private static void bubbleSort(int[] a) {
        System.out.println("\n");
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    /**
     * Insertion sort - sorts the array while inserting the elements based of comparing
     */
    private static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }

        System.out.println("\n");
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] selectionSort = {2, 8, 4, -1, 7, 10, 5, 6};
        int[] bubbleSort = {32, 5, 13, 7, 8, 9, 3, 4, 7, 90, 21};
        int[] insertionSort = {5, 7, 2, 1, 8};

        selectionSort(selectionSort);
        bubbleSort(bubbleSort);
        insertionSort(insertionSort);
    }
}
