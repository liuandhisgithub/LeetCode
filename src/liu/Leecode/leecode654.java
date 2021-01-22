package liu.Leecode;

public class leecode654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return find(nums,0,nums.length -1);
    }

    public TreeNode find(int[] nums, int start, int end){
        if(start > end) return null;
        int max = nums[start];
        int index = start;
        for(int i = start; i <= end; i++){
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        TreeNode treeNode = new TreeNode(max);
        treeNode.left = find(nums,start,index - 1);
        treeNode.right = find(nums,index + 1, end);
        return treeNode;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
