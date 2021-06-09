package liu.vjudge.kuangbin4.A;

import java.util.Scanner;

public class Main {

    int n; // 节点个数
    int m; // 边个数
    int[] head;
    int[] u;
    int[] v;
    int[] w;
    int[] next;
    int num; //当前已经存储了几条边
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }

    private void init(){
        head = new int[n+5];
        u = new int[m];
        v = new int[m];
        w = new int[m];
        next = new int[m];
        for(int i = 0; i < head.length ; i++){
            head[i] = -1;
        }
        num = 0;
    }

    private void add(int _u,int _v,int _w){
        u[num] = _u;
        v[num] = _v;
        w[num] = _w;
        next[num] = head[_u];
        head[_u] = num++;
    }
}
