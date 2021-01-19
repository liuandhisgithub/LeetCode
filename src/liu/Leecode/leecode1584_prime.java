package liu.Leecode;

import java.util.*;

public class leecode1584_prime {
    int[] from ;
    int[] to;
    int[] value;
    int[] head;
    int[] next;
    int num;
    boolean[] jud;
    int n,m;
    int content ;

    private void init(){
        from = new int[m];
        to = new int[m];
        value = new int[m];
        head = new int[m];
        next = new int[m];
        jud = new boolean[m];
        num = 0;
        content = 0;
        for(int i = 0; i < m; i++){
            this.head[i] = -1;
        }
    }

    private void add(int from, int to, int value){
        this.from[num] = from;
        this.to[num] = to;
        this.value[num] = value;
        this.next[num] = head[from];
        this.head[from] = num;
        num++;
    }

    class Edge implements Comparable<Edge>{
        int to;
        int value;

        @Override
        public int compareTo(Edge o) {
            return value - o.value;
        }

        public Edge(int to,int value){
            this.to = to;
            this.value = value;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        n = points.length;
        m = n*n;
        init();
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int value = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                add(i,j,value);
                add(j,i,value);
            }
        }
        return prime(0);
    }

    private int prime(int root){
        int result = 0;
        Queue<Edge> edgeSet = new PriorityQueue<>();
        Edge edge = new Edge(root,0);
        edgeSet.add(edge);
        while(content < n){
            edge = edgeSet.poll();
            if(jud[edge.to]) continue;
            result += edge.value;
            jud[edge.to] = true;
            for(int head = this.head[edge.to] ; head != -1; head = next[head]){
                if(!jud[to[head]]){
                    edgeSet.add(new Edge(to[head],value[head]));
                }
            }
            content++;
        }
        return  result;
    }

}
