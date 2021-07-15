package liu.Leecode;

import java.util.Arrays;

/**
 * @author ljl
 */
public class leecode1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] - arr[i - 1] > 1){
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[arr.length - 1];
    }
}
