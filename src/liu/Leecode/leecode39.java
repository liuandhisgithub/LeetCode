package liu.Leecode;

import java.util.ArrayList;
import java.util.List;

public class leecode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> re = new ArrayList<>();
        dfs(re, new ArrayList<Integer>(),target,0,candidates);
        return re;
    }


    public void dfs(List<List<Integer>> re, List<Integer> now, int target,int index,int[] candidates){
        if(target == 0){
            re.add(new ArrayList<>(now));
        }
        if(target <= 0) return;
        if(index >= candidates.length) return;
        dfs(re,now, target,index + 1, candidates);
        now.add(candidates[index]);
        dfs(re, now, target - candidates[index], index, candidates);
        now.remove(now.size() - 1);
    }

}
