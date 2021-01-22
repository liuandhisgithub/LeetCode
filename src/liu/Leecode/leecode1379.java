package liu.Leecode;

import java.util.Stack;

public class leecode1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> two = new Stack<>();
        stack.push(original);
        two.push(cloned);
        while (!stack.empty()){
            TreeNode t = stack.pop();
            TreeNode t2 = two.pop();
            if(t == target){
                return t2;
            }
            if(t != null){
                stack.push(t.left);
                stack.push(t.right);
            }
            if(t2 != null){
                two.push(t2.left);
                two.push(t2.right);
            }
        }
        return null;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
