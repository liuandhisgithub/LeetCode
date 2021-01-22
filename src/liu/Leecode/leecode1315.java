package liu.Leecode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class leecode1315 {
    public int sumEvenGrandparent(TreeNode root) {
        int re = 0;
        List<TreeNode> treeNodeList = new ArrayList<>();
        treeNodeList.add(root);
        for(int i = 0 ;i < treeNodeList.size() ;i++){
            TreeNode temp = treeNodeList.get(i);
            if(temp != null){
                treeNodeList.add(temp.left);
                treeNodeList.add(temp.right);
            }
        }
        Iterator<TreeNode> iterator = treeNodeList.iterator();
        while(iterator.hasNext()){
            TreeNode temp = iterator.next();
            if(temp != null){
                if(temp.val%2==0){
                    re+=func(temp.left);
                    re+=func(temp.right);
                }
            }
        }
        return re;
    }

    private int func(TreeNode root){
        int re = 0;
        if(root != null){
            TreeNode l = root.left;
            if(l != null){
                re += l.val;
            }
            TreeNode r = root.right;
            if(r != null){
                re += r.val;
            }
        }
        return re;
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
