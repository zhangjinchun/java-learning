package leet;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import serializable.People;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author zhangjinchun
 * @date 2020/6/16
 */
public class LeetDemo {

    public static int[] intersection(int[] nums1, int[] nums2) {
        return new int[3];
    }


    public static void main(String[] args) {
        int[] s = {4,2,8,8,3,3,2};
        int[] t = {8,2,0,9};
        int[] result = intersection(s, t);
        System.out.println(new Gson().toJson(result));
    }
}
