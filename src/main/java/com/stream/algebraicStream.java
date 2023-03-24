package com.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class algebraicStream {

    /**
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     */
    @Test
    public void getSumOfTarget() {
        int[] nums = {2, 7, 15, 11}; //{2,7,11,15};
        int[] result = twoSum(nums, 10);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    @Test
    public void availableVal() {
        Integer[] arrayInt = {-1, -2, -3, -5, 0, 1, 2, 4, 5};
        List list = Arrays.asList(arrayInt);
        for (int i = 0; i < list.size(); i++) {
            int val = (int) list.get(i);
            if (0 > val) {  // - - = + //- + = -
                if (list.contains(-val)) {
                    System.out.println(val + " " + (-val));
                }
            }
        }
    }

    @Test
    public void reverse() {
        int[] array = {5, 6, 7, 3, 9, 1};
        reverse(array, 3);
        // Expected o/p: 1,9,3,5,6,7
    }

    private static void reverse(int[] array, int k) {
        int[] rev = new int[6];
        int j = 0;
        int t = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (i >= k) {
                rev[j] = array[i];
                System.out.print("\t" + rev[j]);
                j++;
            } else {
                rev[j] = array[t];
                System.out.print("\t" + rev[j]);
                j++;
                t++;
            }
        }

    }
}
