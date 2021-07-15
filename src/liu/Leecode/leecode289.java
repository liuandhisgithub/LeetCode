package liu.Leecode;

import java.util.Arrays;

/**
 * @author ljl
 */
public class leecode289 {
    public void gameOfLife(int[][] board) {
        int[][] temp = new int[board.length][];
        for(int i = 0; i < temp.length; i++){
            temp[i] = Arrays.copyOf(board[i],board[i].length);
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                int re = getNum(temp,j,i);
//                System.out.println(re);
                if(board[i][j] == 1){
                    if(re >= 2 && re <= 3){
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 0;
                    }
                } else {
                    if(re == 3){
                        board[i][j] = 1;
                    }
                }
            }
        }
    }

    private int getNum(int[][] board, int x, int y){
        int n = board.length;
        int m = board[0].length;
        int re = 0;
        int[] step = new int[]{1,0,-1};
        for(int i = 0; i < step.length; i++){
            int nowY = y + step[i];
            if(nowY < 0 || nowY >= n){
                continue;
            }
            for(int j = 0; j < step.length; j++){
                if(i == 1 && j == 1){
                    continue;
                }
                int nowX = x + step[j];
                if(nowX < 0 || nowX >= m){
                    continue;
                }
                re += board[nowY][nowX];
            }
        }
        return re;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        new leecode289().gameOfLife(a);
        System.out.printf(Arrays.toString(a));
    }
}
