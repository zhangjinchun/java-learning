package nowcoder;

import java.util.*;

/**
 * @author zhangjinchun
 * @date 2021/2/24
 */
public class MainDemo {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);

        // 读取一维整数数组输入
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (str == null || str.length() == 0 || str.equals("input is null")) {
            System.out.println(-1);
            return;
        }
        System.out.println(str);
        String[] strArr = str.split(" ");
        System.out.println(Arrays.toString(strArr));
        int[] request = new int[strArr.length];
        for (Integer i = 0; i < request.length; i++) {
            request[i] = Integer.parseInt(strArr[i]);
        }

        System.out.println(Arrays.toString(request));
        int resust = getMinNotInArray(request);
        System.out.println(resust);
        System.out.println("Hello World!");
    }

    public static int getMinNotInArray(int[] request) {
        if (request == null) {
            return -1;
        }
        int len = request.length;
        int min = request[0];
        if (len == 1) {
            return request[0] == 1 ? 2 : 1;
        }
        for (int left = 0; left < len - 1; left++) {
            for (int i = left + 1; i < len - 1; i++) {
                if (request[i] < request[left]) {
                    int temp = request[left];
                    request[left] = request[i];
                    request[i] = temp;
                }
            }
            if (left == 0) {
                if (request[left] > 1) {
                    return 1;
                }
            } else if (request[left] > request[left - 1] + 1 && request[left] > 1) {
                return Math.max(request[left - 1] + 1, 1);
            }
        }

        return request[len - 1] + 1;
    }
}
