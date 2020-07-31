package liu.Leecode.zeroToTen;

import java.util.HashMap;
import java.util.Map;
public class Solution {

    /**
     * 2020/7/31
     * 1.两数之和
     */
    public static int[] twoSum(int[] nums,int target){
        int[] re = new int[3];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    re[0]=i;
                    re[1]=j;
                }
            }
        }
        return re ;
    }
    public static int[] twoSumByHash(int[] nums,int target){
        Map<Integer,Integer> numMap = new HashMap<Integer, Integer>();
        for(int i = 0;i<nums.length;i++){
            numMap.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int other = target - nums[i];
            if(numMap.get(other)!=null &&numMap.get(other) != i){
                return new int[]{i,numMap.get(other)};
            }
        }
        return null;

    }
}
