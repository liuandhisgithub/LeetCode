package liu.Leecode;

import java.util.ArrayList;
import java.util.List;

public class leecode1637 {
    public int maxWidthOfVerticalArea(int[][] points) {
        int max = 0;
        List<Integer> list = new ArrayList<>();
        for(int[] i : points){
            list.add(i[0]);
        }
        list.sort(Integer::compareTo);
        int l = list.get(0);
        for(Integer integer : list){
            max = max > integer - l?max:integer - l;
            l = integer;
        }
        return max;
    }
}
