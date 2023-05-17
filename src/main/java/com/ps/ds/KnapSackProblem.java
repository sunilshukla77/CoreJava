package com.ps.ds;

public class KnapSackProblem {

    static int knapSack(int W, int wt[], int val[], int n)
    {

        int dp[][]= new int[n + 1][W + 1];

        for(int i=0; i<=W; i++)
        {
            dp[0][i] = 0;
        }

        for(int i=0; i<=n; i++)
        {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] > j) {
                    System.out.println(dp[i][j] + " " + dp[i - 1][j]);
                    dp[i][j] = dp[i - 1][j];
                    System.out.println("dp[i][j] : " +dp[i][j]);
                }
                else {

                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                    System.out.println("Max dp[i][j] " +dp[i][j]);
                }
            }
        }

        return dp[n][W];
    }

    public static void main (String[] args)
    {
        int val[] = { 10, 40, 30, 50 };
        int wt[] = { 5, 4, 6, 3 };
        int W = 10;
        int n = 4;

        System.out.println(knapSack(W, wt, val, n));

    }
}

// Refer : https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-DP/video/MTE0MA%3D%3D