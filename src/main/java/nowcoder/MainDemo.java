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

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(str);
        String[] strArr = str.split(" ");
        System.out.println(Arrays.toString(strArr));
        int[] request = new int[strArr.length];
        for (Integer i=0; i< request.length;i++) {
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
        for (int left=0; left < len -1; left++) {
            for (int i=left +1; i< len-1; i++) {
                if (request[i] < min) {
                    min = request[i];
                    int temp = request[left];
                    request[left] = request[i];
                    request[i] = temp;
                }
            }
            if (left == 0 && request[left]>1) {
                return 1;
            }
            if (request[left+1] > request[left] + 1) {
                return request[left] + 1;
            }
        }

        return request[len-1] +1;
    }
}
