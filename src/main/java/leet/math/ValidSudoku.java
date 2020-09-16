package leet.math;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * 36. 有效的数独
 * @author zhangjinchun
 * @date 2020/9/16
 */
public class ValidSudoku {

    /**
     * 三个二维数组分别存放行、列、小宫数字是否出现
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        // 整个board有9行，第二维的维数10是为了让下标有9，和数独中的数字9对应。
        // 哈希表存储每一行的每个数是否出现过，默认初始情况下，每一行每一个数都没有出现过
        int[][] row = new int[9][10];
        // 存储每一列的每个数是否出现过，默认初始情况下，每一列的每一个数都没有出现过
        int[][] col = new int[9][10];
        // 存储每一个box的每个数是否出现过，默认初始情况下，在每个box中，每个数都没有出现过。整个board有9个box。
        int[][] box = new int[9][10];
        for(int i=0; i<9; i++){
            for(int j = 0; j<9; j++){
                // 遍历到第i行第j列的那个数,我们要判断这个数在其所在的行有没有出现过，
                // 同时判断这个数在其所在的列有没有出现过
                // 同时判断这个数在其所在的box中有没有出现过
                if(board[i][j] == '.') {
                    continue;
                }
                int curNumber = board[i][j]-'0';
                if(row[i][curNumber] == 1) {
                    return false;
                }
                if(col[j][curNumber] == 1) {
                    return false;
                }
                if(box[j/3 + (i/3)*3][curNumber] == 1){
                    return false;
                }

                // 之前都没出现过，现在出现了，就给它置为1，下次再遇见就能够直接返回false了。
                row[i][curNumber] = 1;
                col[j][curNumber] = 1;
                box[j/3 + (i/3)*3][curNumber] = 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        boolean result = isValidSudoku(board);
        System.out.println(new Gson().toJson(result));
    }
}
