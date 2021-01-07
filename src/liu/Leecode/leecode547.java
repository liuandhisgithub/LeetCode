package liu.Leecode;

import java.util.HashSet;
import java.util.Set;

public class leecode547 {
    int[] pre;
    int n ;
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        pre = new int[n];
        init();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1){
                    add(i,j);
                }
            }
        }
        int re = 0;
        for(int i =0;i<n;i++){
            if(pre[i] == i) {
                re++;
            }
        }
        return re;
    }

    private void init(){
        for(int i = 0;i<n;i++){
            pre[i] = i;
        }
    }
    private int get(int a){
        if(pre[a] == a) return a;
        int k = get(pre[a]);
        pre[a] = k;
        return k;
    }

    private void add(int a,int b){
        pre[get(a)] = get(b);
    }
}
