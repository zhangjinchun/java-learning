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
        System.out.println("Hello World!");
    }

    public int getMinNotInArray(int[] request) {
        if (request == null) {
            return -1;
        }
        int len = request.length;
        int min = request[0];
        for (int left=0; left < len; len++) {
            for (int i=1; i< len; i++) {
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
            if (min > request[left] + 1) {
                return request[left] + 1;
            }
        }

        return request[len-1] +1;
    }
}
