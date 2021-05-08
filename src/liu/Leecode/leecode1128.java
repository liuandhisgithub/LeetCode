package liu.Leecode;

import java.util.HashMap;
import java.util.Map;

public class leecode1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String,Integer> map = new HashMap<>();
        for(int[] dominoe : dominoes){
            int sum = dominoe[0] + dominoe[1];
            int mun = dominoe[0] * dominoe[1];
            String t = ""+sum+mun;
            if(map.containsKey(t)){
                Integer a = map.get(t);
                a++;
                map.put(t,a);
            } else {
                map.put(t,1);
            }
        }
        int re = 0;
        for(String a : map.keySet()){
            Integer x = map.get(a);
            re+=x-1;
        }
        return re;
    }

}
