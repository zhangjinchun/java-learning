package leet.array;

/**
 * 11. 盛最多水的容器
 * @author zhangjinchun
 * @date 2021/4/23
 */
public class MaxArea {

    /**
     * 双指针法
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j){
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
}
