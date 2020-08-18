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

    /**
     * 27. 移除元素
     */
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        int slow = 0;
        int fast = 1;
        boolean jud = false;
        while(nums[slow] == val&&fast<nums.length){
            nums[slow] = nums[fast];
            fast++;
        }
        if(fast == nums.length&&nums[slow] == val) return 0;
        else if(fast == nums.length&&nums[slow] != val) return 1;
        slow++;
        while(fast<nums.length&&slow<nums.length){
            if(nums[fast] == val || jud) {
                fast++;
                jud = false;
            }
            else {
                nums[slow++] = nums[fast];
                jud = true;
            }
        }
        return slow;
    }

    /**
     * 27 更优美的双指针
     * @param nums
     * @param val
     * @return
     */
    public int removeElementBetter(int[] nums, int val) {
        int slow = 0;
        for(int fast = 0; fast<nums.length; fast++) {
            if(nums[fast] == val) continue;
            else nums[slow] = nums[fast];
            slow++;
        }
        return slow;
    }

    /**
     * 28. 实现 strStr()
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int size = needle.length();
        if(size == 0 ) return 0;
        for(int i = 0; i<=haystack.length() - size; i++){
            if(haystack.substring(i,i+size).equals(needle)) return i;
        }
        return -1;
    }

    /**
     * 29.两数相除
     * 耗时太长，之后尝试用位运算优化，不清楚Java的位运算符是不是>> <<
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if(divisor == 1) {
            return dividend;
        }
        if(divisor == -1){
            if(dividend == -2147483648) return 2147483647;
            else return -dividend;
        }
        int re = 0;
        boolean isPositive = dividend>0;
        isPositive = divisor>0?isPositive:!isPositive;
        if(dividend > 0) dividend = -dividend;
        if(divisor > 0) divisor = -divisor;
        while(dividend<=divisor){
            dividend -= divisor;
            re++;
        }
        return isPositive?re:-re;
    }
}
