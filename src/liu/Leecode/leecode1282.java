package liu.Leecode;

import java.util.*;

public class leecode1282 {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> re = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        //按组的数量分组，如果他们所属组人数相同就放一起
        for(int index = 0; index < groupSizes.length; index++){
            if(map.containsKey(groupSizes[index])){
                map.get(groupSizes[index]).add(index);
            } else{
                List<Integer> list = new ArrayList<>();
                list.add(index);
                map.put(groupSizes[index],list);
            }
        }
        //拿出所属组数量为i的全部人
        for(Integer i : map.keySet()){
            List<Integer> v = map.get(i);
            //分组，知道把人用完为止
            while(!v.isEmpty()){
                List<Integer> t = new ArrayList<>();
                //出队，每次出队i个人加入一个组
                for(int j = 0 ; j < i; j++){
                    t.add(v.get(0));
                    v.remove(0);
                }
                re.add(t);
            }
        }

        return re;
    }
}
