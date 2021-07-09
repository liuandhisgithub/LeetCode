package liu.Leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leecode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> re = new ArrayList<>();
        dfs(re,0,new LinkedList<Integer>(),nums);
        return re;
    }

    public void dfs(List<List<Integer>> re, int index, List<Integer> now, int[] nums){
        if(index == nums.length){
            if(!re.contains(now))
                re.add(new LinkedList<>(now));
        } else{
            for(int i = 0; i <= now.size(); i++){
                now.add(i,nums[index]);
                dfs(re, index+1,now,nums);
                now.remove(i);
            }
        }
    }
}
