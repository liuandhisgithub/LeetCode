package liu.Leecode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ljl
 */
public class leecode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer,List<String>> re = new HashMap<>();
        for(String s : strs){
            List<String> temp = re.getOrDefault(getHashCode(s),new ArrayList<>());
            temp.add(s);
            re.put(getHashCode(s),temp);
        }
        return  re.values().stream().collect(Collectors.toList());
    }

    public Integer getHashCode(String strs){
        String[] re = strs.split("");
        Arrays.sort(re);
        return Arrays.asList(re).hashCode();
    }

    public static void main(String[] args) {
        new leecode49().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
}
