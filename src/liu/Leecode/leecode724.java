package liu.Leecode;

public class leecode724 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        int some = 0;
        for(int i = 0; i < nums.length; i++){
            if(some == sum - some - nums[i]) return i;
            else some += nums[i];

        }
        return -1;
    }
}
