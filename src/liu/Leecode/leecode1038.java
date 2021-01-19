package liu.Leecode;

import java.util.ArrayList;
import java.util.List;

public class leecode1038 {
    List<TreeNode> re ;
    public TreeNode bstToGst(TreeNode root) {
        re = new ArrayList<>();
        func(root);
        int num = 0;
        for(TreeNode treeNode : re){
            treeNode.val += num;
            num = treeNode.val;
        }
        return root;
    }

    public void func(TreeNode root){
        if(root != null) {
            func(root.right);
            re.add(root);
            func(root.left);
        }
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
