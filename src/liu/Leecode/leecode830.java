package liu.Leecode;

import java.util.ArrayList;
import java.util.List;

public class leecode830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> re = new ArrayList<>();
        int start = 0;
        int end = 0;
        while(start < s.length()){
            while(s.charAt(start) == s.charAt(end)){
                if(end == s.length() - 1) break;
                end++;
            }
            if(end - start >=2) {
                List<Integer> t = new ArrayList<>();
                t.add(start);
                t.add(end);
                re.add(t);
            }
            start = end;
        }
        return re;
    }
}
