package liu.Leecode;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class leecode1726 {
    public int tupleSameProduct(int[] nums) {
        int re = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j ++){
                if(i == j) continue;
                for(int k = 0; k < nums.length;k ++){
                    if(i == k || j == k) continue;
                    for(int m = 0; m < nums.length ; m++){
                        if(m == i || m == j || m == k) continue;
                        if(nums[i] * nums[j] == nums[k] * nums[m]){
                            re++;
                        }
                    }
                }
            }
        }
        return re;
    }
}
