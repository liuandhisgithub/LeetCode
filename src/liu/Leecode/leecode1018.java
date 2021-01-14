package liu.Leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leecode1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>();
        int num = 0;
        for(int i : A){
            num = ((num<<1)+i)&7;
            result.add(num%5==0);
        }
        return result;
    }
}
