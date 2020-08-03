package liu.Leecode.zeroToTen;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Solution {

    /**
     * 2020/7/31
     * 1.两数之和
     */
    public static int[] twoSum(int[] nums,int target){
        int[] re = new int[3];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    re[0]=i;
                    re[1]=j;
                }
            }
        }
        return re ;
    }
    public static int[] twoSumByHash(int[] nums,int target){
        Map<Integer,Integer> numMap = new HashMap<Integer, Integer>();
        for(int i = 0;i<nums.length;i++){
            numMap.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int other = target - nums[i];
            if(numMap.get(other)!=null &&numMap.get(other) != i){
                return new int[]{i,numMap.get(other)};
            }
        }
        return null;
    }

    /**
     * 2020/8/1
     * 2.两数之和
     */
   public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resoult = l1;
        while(l2!=null){
            if(l1!=null){
                l1.val = l1.val+l2.val;
            }
            if(l1.next == null&&l2.next!=null){
                l1.next = new ListNode(0);
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode node = resoult;
        int upper = 0;
        while(node!=null || upper!=0){

            node.val = node.val+upper;
            upper = 0;
            if (node.val>=10) {
                node.val -= 10;
                upper = 1;
            }
            if(node.next==null && upper == 1){
                ListNode nodeNext= new ListNode(0);
                node.next = nodeNext;
            }
            node = node.next;
        }
        return resoult;
    }

    /**
     * 3.无重复最长字串
     * 使用hashmap来进行查找，空间换时间
     */
    public int lengthOfLongestSubstring(String s) {
        Map<String,Integer> stringMap = new HashMap<>();
        int end=0;
        int re = 0 ;
        for(int index = 0; index < s.length(); index++){
            String temp = String.valueOf(s.charAt(index));
            if(stringMap.get(temp)!=null){
                int tindex = stringMap.get(temp);
                if(tindex >= end){
                    re  = re>index-end?re:index-end;
                    end = tindex+1;
                }
            }
            re  = re>index-end?re:index-end+1;
            stringMap.put(temp,index);
        }
        return re;
    }

    /**
     * 4. 寻找两个正序数组的中位数
     * O(m+n)的算法
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Float> nums3 = new ArrayList<Float>();
        int num1Top = 0;
        int num2Top = 0;
        while(num1Top<nums1.length&&num2Top<nums2.length){
            if(nums1[num1Top]<nums2[num2Top]){
                nums3.add(Float.valueOf(nums1[num1Top]));
                num1Top++;
            }
            else {
                nums3.add(Float.valueOf(nums2[num2Top]));
                num2Top++;
            }
        }
        if(num1Top<nums1.length){
            for(int i=num1Top;i<nums1.length;i++){
                nums3.add(Float.valueOf(nums1[i]));
            }
        }
        if(num2Top<nums2.length){
            for(int i=num2Top;i<nums2.length;i++){
                nums3.add(Float.valueOf(nums2[i]));
            }
        }
        int nums3Length = nums3.size();
        if(nums3Length%2 == 0){
            return (nums3.get(nums3Length/2)+nums3.get(nums3Length/2-1))/2;
        }
        else return nums3.get(nums3Length/2);
    }
    /**
     * 5.最长回文子串
     */
    public String longestPalindrome(String s) {
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        for(int i = 0 ;i<s.length();i++){
            for(int j = 0;j<s.length();j++){
                dp[i][j] = false;
            }
        }

        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                int k = i+j;
                if(k>s.length()) break;
                if(j==0) dp[i][k] = true;
                else if(j==1) dp[i][k] = s.charAt(i) == s.charAt(k);
                else dp[i][k] = (dp[i+1][k-1]&&(s.charAt(i)==s.charAt(k));
            }
        }
        int maxLength = 1;
        int maxTop = 0;
        int maxEnd = 0;
        for(int i=0;i<s.length();i++){
            for(int j = i+1;j<s.length();j++){
                if(dp[i][j]){
                    if(j-i > maxLength){
                        maxLength = j-i;
                        maxTop = i;
                        maxEnd = j;
                    }
                }
            }
        }
        return s.substring(maxTop,maxEnd);

    }
}


