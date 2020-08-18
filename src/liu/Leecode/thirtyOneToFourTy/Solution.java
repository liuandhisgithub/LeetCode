package liu.Leecode.thirtyOneToFourTy;

import java.util.Arrays;

public class Solution {
    /**
     * 31. 下一个排列
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int index = nums.length - 1;
        while(index > 0 && nums[index] < nums[index-1]){
            index -- ;
        }
        if(index == 0) {
            Arrays.sort(nums);
            return ;
        }
        index --;
        int index2 = index+1;
        while(index2<nums.length&&nums[index]<nums[index2]){
            index2++;
        }
        index2--;
        int temp = nums[index2];
        nums[index2] = nums[index];
        nums[index] = temp;
        return;
    }
}
