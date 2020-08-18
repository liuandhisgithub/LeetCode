package liu.Leecode.test;


import liu.Leecode.thirtyOneToFourTy.Solution;

public class test {
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,3};
        solution.nextPermutation(nums);
        System.out.println(nums[0]);
    }
}

