package liu.Leecode;

public class leecode628 {
    public int maximumProduct(int[] nums) {
        int max = 0;
        int lastMax = 0;
        int lasterMax = 0;
        int min = Integer.MAX_VALUE;
        int lastMin = min;

        for(Integer i : nums){
            if(i > max){
                lasterMax = lastMax;
                lastMax = max;
                max = i;
            }
            if(i < min){
                lastMin = min;
                min = i;
            }
        }
        int a = Integer.max(min*lastMin,max*lasterMax);
        return a*lasterMax;
    }
}
