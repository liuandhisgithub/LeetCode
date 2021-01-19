package liu.Leecode;

import java.util.ArrayList;
import java.util.List;

public class leecode1584 {
    int n;
    int[] pre;

    public int minCostConnectPoints(int[][] points) {
        int result = 0;
        n = points.length;
        init();
        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n ; j++){
                int value = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                Edge edge = new Edge(i,j,value);
                edges.add(edge);
            }
        }
        edges.sort(Edge::compareTo);
        for(Edge edge : edges){
            int form = edge.from;
            int to = edge.to;
            if(!rootEqual(form,to)){
                result += edge.value;
                unio(form,to);
            }
        }
        return result;
    }

    public void init(){
        for(int i = 0; i < n; i++){
            pre[i] = i;
        }
    }

    public int find(int i){
        pre = new int[n];
        if(i != pre[i]){
            pre[i] = find(pre[i]);
        }
        return pre[i];
    }

    public void unio(int i, int j){
        pre[find(i)] = find(j);
    }

    public boolean rootEqual(int i,int j){
        return find(i) == find(j);
    }

    class Edge implements Comparable<Edge>{
        int from;
        int to;
        int value;

        @Override
        public int compareTo(Edge o) {
            return value - o.value;
        }

        public Edge(int from,int to, int value){
            this.from = from;
            this.to = to;
            this.value = value;
        }
    }
}


