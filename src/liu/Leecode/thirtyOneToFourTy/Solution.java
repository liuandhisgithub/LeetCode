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
        //排序 交换排序
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
    /**
     * 34 在排序数组中查找元素的第一个和最后一个位置
     */
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int mid = (end + start) / 2;
            if(nums[mid] == target){
                start = mid;
                end = mid;
                break;
            } else if(nums[mid] > target){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if(start >= nums.length || nums[start] != target ) {
            return new int[]{-1,-1};
        }
        else {
            while(start >= 0 && nums[start] == target){
                start --;
            }
            while (end < nums.length && nums[end] == target){
                end ++;
            }
            return new int[]{start+1, end-1};
        }
    }
    /**
     * 35. 搜索插入位置
     */
    public int searchInsert(int[] nums, int target) {
        return 0;
    }

}
