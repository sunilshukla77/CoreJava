package com.ps.ds;

/*
 * Given an array of integers, write a Java program to find the longest increasing subsequence.
 * int[] arr = {1, 4, 2, 6, 3, 8, 9};
 * int[] lis = LongestIncreasingSubsequence.find(arr);
 * System.out.println(Arrays.toString(lis)); // Output: [1, 2, 3, 8, 9]
 */
public class lis {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 6, 3, 8, 9, 5};
        int lis = findLongestIncreasingSubsequence(arr);
        System.out.println("longest subString: " + lis);
    }

    private static int findLongestIncreasingSubsequence(int[] arr) {
        int[] tail = new int[arr.length];
        int leng = 1;
        tail[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > tail[leng - 1]) {
                tail[i] = arr[i];
                leng++;
            } else {
                int c = ceilIndx(tail, 0, leng - 1, arr[i]);
                tail[c] = arr[i];
            }
        }

        return leng;
    }

    private static int ceilIndx(int[] tail, int first, int last, int key) {
        while (last > first) {
            int mid = first + (last - first) / 2;
            System.out.println();
            if (tail[mid] >= key) {
                last = mid;
            }else{
                first=mid+1;
            }
        }
        return last;
    }
}
