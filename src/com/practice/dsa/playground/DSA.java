package com.practice.dsa.playground;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DSA {

    public static void main(String[] args) {
    }

    static void sumOf2IsTarget(int[] a, int t) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            int newTarget = t - a[i];
            if (map.containsKey(newTarget))
                System.out.println(map.get(newTarget) + " " + i);
            map.put(a[i], i);
        }
    }

    static void sumOf3IsTarget(int[] a, int t) {
        for (int i = 0; i < a.length; i++) {
            if (i == 0 || a[i] != a[i - 1]) {
                int j = i + 1;
                int k = a.length - 1;
                int newTarget = t - a[i];
                while (j < k) {
                    if (newTarget == a[j] + a[k]) {
                        System.out.println(a[i] + " " + a[j] + " " + a[k]);
                        while (a[j] == a[j + 1]) j++;
                        while (a[k] == a[k - 1]) k--;
                        j++;
                        k--;
                    } else if (newTarget < (a[j] + a[k])) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
    }

    static void reverse(int[] a) {
        int i = 0, j = a.length - 1;

        while (i < j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }

        for (int elements : a) {
            System.out.print(elements + " ");
        }
    }

    static void transpose(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a[0].length; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        for (int[] ini : a) {
            for (int i : ini) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static void max(int[] a) {
        int max = -1;

        for (int i : a) {
            if (max < i)
                max = i;
        }

        System.out.println("Max element in given array is " + max);
    }

    static void printSperically(int[][] a) {
        int rmin = 0, rmax = a.length - 1, cmin = 0, cmax = a[0].length - 1, n = a.length, m = a[0].length, count = 0;

        while (count < (n * m)) {
            //top boundary
            for (int row = cmin; row <= cmax && (count < (n * m)); row++) {
                System.out.print(a[rmin][row] + " ");
                count++;
            }
            rmin++;

            //right boundary
            for (int col = rmin; col <= rmax && (count < (n * m)); col++) {
                System.out.print(a[col][cmax] + " ");
                count++;
            }
            cmax--;

            //bottom boundary
            for (int row = cmax; row >= cmin && (count < (n * m)); row--) {
                System.out.print(a[rmax][row] + " ");
                count++;
            }
            rmax--;

            //left boundary
            for (int col = rmax; col >= rmin && (count < (n * m)); col--) {
                System.out.print(a[col][cmin] + " ");
                count++;
            }
            cmin++;
        }
    }

    static void binarySearchTarget(int[] a, int target) {
        Arrays.sort(a);

        int left = 0, resultFirst = -1, resultLast = -1, right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == target) {
                resultFirst = mid;
                right = mid - 1;
            } else if (a[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        left = 0;
        right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == target) {
                resultLast = mid;
                left = mid + 1;
            } else if (a[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(resultFirst + " " + resultLast);
    }

    static void printPermutations(int[] a, int i, boolean[] select, List<Integer> ans) {
        if (i == a.length) {
            System.out.println(ans);
            return;
        }

        for (int ele = 0; ele < a.length; ele++) {
            if (select[ele] == false) {
                select[ele] = true;
                ans.add(a[ele]);
                printPermutations(a, i + 1, select, ans);
                select[ele] = false;
                ans.remove(ans.size() - 1);
            }
        }
    }

    static void printAllPossibleSubSets(int[] a, int i, List<Integer> ans) {
        if (i == a.length) {
            System.out.println(ans);
            return;
        }

        //selecting iTH element
        ans.add(a[i]);
        printAllPossibleSubSets(a, i + 1, ans);
        ans.remove(ans.size() - 1);

        //rejecting iTH element
        printAllPossibleSubSets(a, i + 1, ans);
    }

    static void printAllPossibleSubSetsEqualToTarget(int[] a, int i, int t, List<Integer> ans) {
        if (i == a.length) {
            if (t == 0)
                System.out.println(ans);
            return;
        }

        //selecting iTH element
        ans.add(a[i]);
        printAllPossibleSubSetsEqualToTarget(a, i + 1, t - a[i], ans);
        ans.remove(ans.size() - 1);

        //rejecting iTH element
        printAllPossibleSubSetsEqualToTarget(a, i + 1, t, ans);
    }
}
