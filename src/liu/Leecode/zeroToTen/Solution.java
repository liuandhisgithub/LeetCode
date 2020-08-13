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
        if (s.length()==0) return "";
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        int maxTop = 0;
        int maxEnd = 1;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                int k = i+j;
                if(k>=s.length()) break;
                if(i==0) dp[j][k] = true;
                else if(i==1) dp[j][k] = s.charAt(j) == s.charAt(k);
                else dp[j][k] = (dp[j+1][k-1]&&(s.charAt(j)==s.charAt(k)));
                if(dp[j][k]){
                    maxTop = j;
                    maxEnd = k+1;
                }
            }
        }
        return s.substring(maxTop,maxEnd);
    }

    /**
     * 6.Z 字形变换
     *
     */

    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        List<StringBuilder> z = new ArrayList<StringBuilder>();
        Boolean up = false;
        int row = s.length()<numRows?s.length():numRows;
        for(int i =0;i<row;i++){
            z.add(new StringBuilder());
        }
        int nowRow = 0;
        for(char c:s.toCharArray()){
            z.get(nowRow).append(c);
            if(nowRow == 0 || nowRow == numRows-1){
                up = !up;
            }
            nowRow += up?1:-1;
        }
        StringBuilder re=new StringBuilder();
        for(StringBuilder sb : z){
            re.append(sb);
        }
        return re.toString();
    }

    /**
     * 7.整数反转
     */
    public int reverse(int x) {
        Long re = new Long(0);
        Boolean isPositive = x>0;
        x = isPositive?x:-x;
        while(x>0){
            re = re*10+x%10;
            x/=10;
        }
        if( re>Math.pow(2,31) ) return 0;
        return isPositive?re.intValue():-(re.intValue());
    }

    /**
     * 8.字符串转换整数
     * 边界问题太严重了，卡了好几天，又不能用long做返回值，放弃，下一题
     */
    public long myAtoi(String str) {
        //0:start 1:signe 2:isNum 3:end
        Long max = Long.valueOf("2147483648");
        int[][] statues = new int[][]{{0,1,2,3},{3,3,2,3},{3,3,2,3},{3,3,3,3}};
        int nowStatue = 0;
        int nowCode =0;
        boolean signe = true;
        Long re = new Long("0");
        for(char c : str.toCharArray()){
            if(c==' ') nowCode = 0;
            else if(c=='+' || c== '-'){
                nowCode = 1;
                if(c=='+') signe = true;
                else signe = false;
            }
            else if(c>='0' && c<='9') nowCode = 2;
            else nowCode = 3;
            if(statues[nowStatue][nowCode] == 2){
                Long temp = re*10+Integer.valueOf(""+c);
                re = temp>max?max:temp;
                //               re = BigDecimal.valueOf(max>re*10+Integer.valueOf(""+c):re*10+Integer.valueOf());
            }
            nowStatue = statues[nowStatue][nowCode];
        }
        return signe?re:-re;
    }

    /**
     * 9.回文数
     */
    public boolean isPalindrome(int x) {
        boolean re = true;
        List<String> list = new ArrayList<String>();
        for(char c : String.valueOf(x).toCharArray()){
            list.add(""+c);
        }
        for(int i = 0;i<list.size()/2;i++){
            if(!list.get(i).equals(list.get(list.size()-i-1))){
                re = false;
            }
        }
        return re;
    }
    /**
     * 10. 正则表达式匹配
     * dp不会写，我还以为是自动机········
     */
    public boolean isMatch(String s, String p) {
        return false;
    }
}


