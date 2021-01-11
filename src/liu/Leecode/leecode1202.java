package liu.Leecode;

import java.lang.reflect.Array;
import java.util.*;

public class leecode1202 {
    int pre[] ;
    int n ;
    private void init(){
        for(int i = 0; i < n ; i++){
            pre[i] = i ;
        }
    }
    private int find(int i){
        if(pre[i] != i){
            pre[i] = find(pre[i]);
        }
        return pre[i];
    }

    private void unit(int i,int j){
        pre[find(i)] = find(j);
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        n = s.length();
        pre = new int[n];
        init();
        for(List<Integer> pair : pairs){
            unit(pair.get(0),pair.get(1));
        }
        Map<Integer,PriorityQueue<Character>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int k = find(i);
            PriorityQueue<Character> characterList;
            if(map.containsKey(k)){
                characterList = map.get(k);
            } else{
                characterList = new PriorityQueue<>();
            }
            characterList.offer(s.charAt(i));
            map.put(k,characterList);
        }
        StringBuilder re = new StringBuilder();
        for(int i = 0; i < n ;i++){
            int k = find(i);
            re.append(map.get(k).poll());
        }
        return re.toString();
    }

    public static void main(String[] args) {
        List<List<Integer>> a = new ArrayList<>();
        List<Integer> t = Arrays.asList(0,3);
        List<Integer> t2 = Arrays.asList(0,2);
        List<Integer> t3 = Arrays.asList(1,2);
        a.add(t);
        a.add(t2);
        a.add(t3);
        System.err.println(new leecode1202().smallestStringWithSwaps("dcab",a));
    }

}
