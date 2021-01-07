package liu.Leecode;

import java.util.ArrayList;
import java.util.List;

public class leecode807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] verticalMax = new int[grid.length];
        int[] horizontalMax = new int[grid.length];
        for(int i=0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                if(verticalMax[j] < grid[i][j] ) verticalMax[j] = grid[i][j];
                if(horizontalMax[i] < grid[i][j]) horizontalMax[i] = grid[i][j];
            }
        }
        int re = 0;
        for(int i=0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                int t = verticalMax[j] < horizontalMax[i] ? verticalMax[j] : horizontalMax[i];
                re += t - grid[i][j];
            }
        }
        return re;
    }
}
