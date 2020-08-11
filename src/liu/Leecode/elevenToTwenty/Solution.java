package liu.Leecode.elevenToTwenty;


import java.util.*;

public class Solution {
    /**
     * 11. 盛最多水的容器
     * 双指针解法，又是一次面向答案编程
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int re=0;
        int top = 0,end = height.length-1;
        while(top<end){
            int temp ;
            if(height[top]>height[end]){
                temp = height[end] * (end - top);
                end --;
            }
            else {
                temp = height[top] * (end-top);
                top ++;
            }
            re = re>temp?re:temp;
        }
        return re;
    }

    /**
     * 12.整数转罗马数字
     * 面向答案ac*2
     * @param num
     * @return
     */

    public String intToRoman(int num) {
        String re = "";
        String[] roman = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] number = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        for(int i=0;i<roman.length;i++){
            while(num>=number[i]){
                re+=roman[i];
                num -= number[i];
            }
        }
        return re;
    }
    /**
     * 13. 罗马数字转整数
     * 和上题相似，感觉看了半个题解
     */
    public int romanToInt(String s) {
        int re=0;
        Map<String,Integer> map = new HashMap<String, Integer>();
        String[] roman = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] number = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        for(int i=0;i<roman.length;i++){
            map.put(roman[i],number[i]);
        }
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            int number1 = map.get(""+chars[i]);
            if(i+1<chars.length){
                int number2 = map.get(""+chars[i+1]);
                if(number1<number2){
                    number1 = map.get(""+chars[i]+chars[i+1]);
                    i++;
                }
            }
            re+=number1;
        }
        return re;
    }
    /**
     * 14. 最长公共前缀
     */
    public String longestCommonPrefix(String[] strs) {
        String re="";
        if(strs.length==0) return re;
        char[] temp = strs[0].toCharArray();
        for(int i=0;i<temp.length;i++){
            boolean jud = true;
            for(String str:strs){
                if(str.toCharArray().length>i){
                    if(str.toCharArray()[i]!=temp[i]) jud = false;
                }
                else {
                    jud = false;
                }
            }
            if(!jud) break;
            re+=temp[i];
        }
        return re;
    }
    /**
     * 15.三数之和
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i = 0; i<nums.length;i++){
            if(i!=0&&nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<nums.length;j++){
                if(j!=i+1&&nums[j] == nums[j-1]) continue;
                int k = 0-nums[i]-nums[j];
                int index;
                if(map.get(k)!=null) index = map.get(k);
                else  index = -1;
                if(index!=-1&&index>i&&index>j){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[index]);
                    re.add(list);
                }
            }
        }
        return  re;
    }

    /**
     * 16. 最接近的三数之和
     */
    public int threeSumClosest(int[] nums, int target) {
        int min = 0x3f3f3f3f;
        int re = target;
        Arrays.sort(nums);
        for (int i = 0;i<nums.length;i++){
            int top = i+1;
            int end = nums.length - 1;
            while(top<end){
                if(min>Math.abs(nums[i]+nums[top]+nums[end] - target)){
                    re = nums[i]+nums[top]+nums[end];
                    min = Math.abs(nums[i]+nums[top]+nums[end] - target);
                }
                if(nums[i]+nums[top]+nums[end] > target){
                    end--;
                }
                else top++;
            }
        }
        return  re;
    }
}
