package liu.Leecode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class leecode1302 {
    private int maxDeep = 0;

    public int deepestLeavesSum(TreeNode root) {
        func(root,0);
        return func2(root,0);
    }

    /**
     * 中序遍历 查看最深深度
     */
    public void func(TreeNode treeNode,Integer deepNum){
        if(treeNode != null){
            if(maxDeep<deepNum) maxDeep = deepNum;
            if(treeNode.left != null){
                func(treeNode.left,deepNum+1);
            }
            if(treeNode.right != null){
                func(treeNode.right, deepNum+1);
            }
        }
    }

    /**
     * 中序遍历计算结果
     * @param treeNode
     * @return
     */
    public Integer func2(TreeNode treeNode,Integer deepNum){
        if(treeNode == null) return 0;
        if(deepNum == maxDeep ){
            return treeNode.val;
        } else{
            return func2(treeNode.left,deepNum+1) + func2(treeNode.right,deepNum +1);
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
               this.right = right;
    }
}
