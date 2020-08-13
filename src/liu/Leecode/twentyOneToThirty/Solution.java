package liu.Leecode.twentyOneToThirty;

import liu.Leecode.entity.ListNode;
import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 21. 合并两个有序链表

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val) {
                node.next = l1;
                l1 = l1.next;
                node = node.next;
            }
            else {
                node.next = l2;
                l2 = l2.next;
                node = node.next;
            }
        }
        if(l1 == null && l2!=null){
            node.next = l2;
        }else {
            node.next = l1;
        }
        return head.next;
    }
    /**
     * 22. 括号生成
     */
    public List<String> generateParenthesis(int n) {
        List<String> stringList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        func(stringBuilder,0,0,n,stringList);
        return stringList;
    }

    public void func(StringBuilder stringBuilder, int open, int close, int max, List<String> re){
        if(open+close == max*2) re.add(stringBuilder.toString());
        else {
            if(open<max){
                stringBuilder.append("(");
                func(stringBuilder,open+1,close,max,re);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }
            if(close<open){
                stringBuilder.append(")");
                func(stringBuilder,open,close+1,max,re);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }
        }
    }




    /**
     * 23. 合并K个排序链表
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode ans = new ListNode(-1);
        ans.next = lists[0];
        for(int i=1;i<lists.length;i++){
            ListNode temp = lists[i];
            ListNode p = ans;
            while(p.next!=null&&temp!=null){
                if(p.next.val>temp.val){
                    ListNode tt = temp;
                    temp = temp.next;
                    tt.next = p.next;
                    p.next = tt;
                }
                p = p.next;
            }
            if(p.next==null&&temp!=null) {
                p.next = temp;
            }
        }
        return ans.next;
    }

    /**
     * 24. 两两交换链表中的节点
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        int num = 0;
        ListNode headNode = new ListNode(-1);
        headNode.next = head;
        ListNode node = headNode;
        while(node.next != null){
            if(num%2 == 0&&node.next.next!=null){
                ListNode temp = node.next;
                node.next = node.next.next;
                temp.next = node.next.next;
                node.next.next=temp;
            }
            node = node.next;
            num ++;
        }
        return headNode.next;
    }
    /**
     * 25.
     */

    /**
     * 26. 删除排序数组中的重复项
     */
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int i = 0;
        while(i<length){
            if(i==0) {
                i++;
                continue;
            }
            if(nums[i]==nums[i-1]){
                length --;
                for(int j=i;j<length;j++){
                    nums[j]=nums[j+1];
                }
            }
            else i++;
        }
        return length;
    }
    //双指针
    public int removeDuplicatesByDoublePointer(int[] nums) {
        int slow = 0;
        int fast = 1;
        while(fast<nums.length){
            if(nums[slow] == nums[fast]) fast++;
            else nums[++slow] = nums[fast];
        }
        return slow+1;
    }


}
