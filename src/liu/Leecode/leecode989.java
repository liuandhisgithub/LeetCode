package liu.Leecode;

import java.util.ArrayList;
import java.util.List;

public class leecode989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> re = new ArrayList<>();
        int up = 0;
        for(int i = A.length -1 ; i >= 0 ; i--){
            int t = K % 10;
            K /= 10;
            int r = A[i] + t + up;
            up = 0;
            if(r >= 10){
                r -= 10;
                up = 1;
            }
            re.add(0,r);
        }
        while (K > 0){
            int t = K % 10;
            K /= 10;
            int r = t + up;
            up = 0;
            if(r >= 10){
                r -= 10;
                up = 1;
            }
            re.add(0,r);
        }
        if(up != 0){
            re.add(0,up);
        }
        return re;
    }
}
