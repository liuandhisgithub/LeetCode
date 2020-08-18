package liu.Leecode.thirtyOneToFourTy;

import java.util.Arrays;

public class Solution {
    /**
     * 31. 下一个排列
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int index = nums.length - 2;
        while(index >= 0 && nums[index] >= nums[index + 1]){
            index--;
        }
        if(index>=0){
            int j = index + 1;
            while(j<nums.length&&nums[j]>nums[index]){
                j++;
            }
            j--;
            int temp = nums[index];
            nums[index] = nums[j];
            nums[j] = temp;
        }
        for(int i = index + 1;i<nums.length;i++){
            for(int j = i + 1; j<nums.length;j++){
                if(nums[i]>nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
