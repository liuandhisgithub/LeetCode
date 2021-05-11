package liu.Leecode;

import java.util.HashSet;
import java.util.Set;

public class leecode1734 {
    /**
     *  a ^ b ^ a = b
     *  所以 encode[1] = re[1] ^ re[2]
     *  encode[1] ^ e[2] = r[1] ^ r[2] ^ r[2] ^ r[3] = r[1] ^ r[3]
     *
     */

    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int all = 0;
        int som = 0;
        for(int i = 1; i <= n; i++){
            all = all ^ i;
            if(i % 2 == 0){
                som = som ^ encoded[i-1];
            }
        }
        int f = all ^ som;
        int r[] = new int[n];
        r[0] = f;
        for(int i = 0; i < encoded.length ;i ++){
            r[i+1] = r[i] ^ encoded[i];
        }
        return r;
    }

    public static void main(String[] args) {
        new leecode1734().decode(new int[]{3,1});
    }
}
