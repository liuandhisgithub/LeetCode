package liu.Leecode;

import java.util.List;

public class leecode55 {
    Boolean jud[] = null;
    public boolean canJump(int[] nums) {
        jud = new Boolean[nums.length];
        for(int i = 0; i < nums.length; i++){
            jud[i] = true;
        }
        return DFS(0,nums);
    }

    private Boolean DFS(int step,int[] nums){
        //如果可以跳超过，则返回成功
        if(step >= nums.length - 1) return true;
        //否则根据该位置判断下一步怎么跳
        //如果下一步可以跳成功  则直接返回成功
        for (int i = nums[step];i > 0; i--){
            if(step + i < nums.length && jud[step + i] == false) continue;;
            if(DFS(step + i,nums) == true) return true;
        }
        jud[step] = false;
        return false;
    }
}
