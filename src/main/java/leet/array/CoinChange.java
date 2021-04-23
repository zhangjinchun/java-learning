package leet.array;

import java.util.*;

/**
 * 322. 零钱兑换
 * @author zhangjinchun
 * @date 2021/4/23
 */
public class CoinChange {

    /**
     * 动态规划
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        // 给 0 占位
        int[] dp = new int[amount + 1];

        // 注意：因为要比较的是最小值，这个不可能的值就得赋值成为一个最大值
        Arrays.fill(dp, amount + 1);

        // 理解 dp[0] = 0 的合理性，单独一枚硬币如果能够凑出面值，符合最优子结构
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        if (dp[amount] == amount + 1) {
            dp[amount] = -1;
        }

        return dp[amount];
    }

    /**
     * 广度优先遍历
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[amount + 1];

        visited[amount] = true;
        queue.offer(amount);

        // 排序是为了加快广度优先遍历过程中，对硬币面值的遍历，起到剪枝的效果
        Arrays.sort(coins);

        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer head = queue.poll();
                for (int coin : coins) {
                    int next = head - coin;
                    // 只要遇到 0，就找到了一个最短路径
                    if (next == 0) {
                        return step;
                    }

                    if (next < 0) {
                        // 由于 coins 升序排序，后面的面值会越来越大，剪枝
                        break;
                    }

                    if (!visited[next]) {
                        queue.offer(next);
                        // 添加到队列的时候，就应该立即设置为 true
                        // 否则还会发生重复访问
                        visited[next] = true;
                    }
                }
            }
            step++;
        }
        // 进入队列的顶点都出队，都没有看到 0 ，就表示凑不出当前面值
        return -1;
    }

    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        int amount = 12;
        int result = coinChange2(coins, amount);
        System.out.println(result);
    }
}
