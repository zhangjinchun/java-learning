package leet.stack;

import com.google.gson.Gson;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author zhangjinchun
 * @date 2020/9/6
 */
public class CQueue {

    private Stack<Integer> stackA;
    private Stack<Integer> stackB;

    public CQueue() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    public void appendTail(int value) {
        stackA.push(value);
    }

    public int deleteHead() {
        if (stackB.isEmpty()) {
            if (stackA.isEmpty()) {
                return -1;
            }
            while (!stackA.isEmpty()) {
                int temp = stackA.pop();
                stackB.push(temp);
            }
        }
        return stackB.pop();
    }

    public static void main(String[] args) {
        CQueue obj = new CQueue();
        obj.appendTail(9);
        obj.appendTail(10);
        obj.appendTail(11);
        int param_2 = obj.deleteHead();
        System.out.println(new Gson().toJson(param_2));
        obj.appendTail(12);
        obj.appendTail(13);
        param_2 = obj.deleteHead();
        System.out.println(new Gson().toJson(param_2));
    }
}
