package com.core.problem.solving;

public class Add2Num {
    public static void main(String[] args) {

        int[] nums = {2,5,5,11}; //{2,7,11,15};
        int[] result= twoSum(nums, 10);
        System.out.println(result[0]+" "+ result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        for(int i=0; i < nums.length-1; i++){
            for(int j=1; j < nums.length; j++){
                if((nums[i] + nums[j]) == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}

/*
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
