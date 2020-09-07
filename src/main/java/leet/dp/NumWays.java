package leet.dp;

import com.google.gson.Gson;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * @author zhangjinchun
 * @date 2020/9/6
 */
public class NumWays {

    /**
     * 动态规划，定义三个变量，空间复杂度为O(1)
     * @param n
     * @return
     */
    public static int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[3];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <=n; i++) {
            dp[2] = dp[0] + dp[1];
            if (dp[2] >= 1000000007) {
                dp[2] = dp[2] % 1000000007;
            }
            dp[0] = dp[1];
            dp[1] = dp[2];
        }

        return dp[2];
    }

    public static void main(String[] args) {

        int result = numWays(3);
        System.out.println(new Gson().toJson(result));
    }
}
