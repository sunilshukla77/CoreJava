package com.gs.hard;

//https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
public class StairCount {
    public static void main(String[] args) {
        int stair= 5;
        System.out.println("Using Recursion O(n2) "+ fab(stair+1));

        System.out.println("Using DP Time Complexity O(n) and Auxiliary space O(n) " +
                "\n "+ dpWayOfCount(stair));
        System.out.println("Using DP Time Complexity O(n) and Auxiliary space O(1) " +
                "\n "+ AuxCount(stair));
    }

    private static int AuxCount(int stair) {
        int prev1= 1; int prev2=1;
        int count =0;
        for(int i = 2; i <= stair; i++){
            count = prev1+prev2;
            prev1= prev2;
            prev2=count;
        }
        return count;
    }

    private static int dpWayOfCount(int n) {
        int[] dp = new int[n+1];
        dp[0]=1; dp[1]=1;
        for (int i = 2; i <=n; i++) {
            dp[i]= dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    //(1,1,1,1,1,1),
    //(1,1,2,1),(1,1,1,2),(1,2,1,1),(2,1,1,1)
    // (2,2,1),(2,1,2),(2,2,1)

    private static int fab(int stair){
        if(stair <= 1)
            return stair;
        return fab(stair - 1) + fab(stair - 2);  // Need to check
    }
}
