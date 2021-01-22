package liu.Leecode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 没有ac
 */
public class leecode1489 {
    int[] pre;
    private void init(int n){
        pre = new int[n];
        for(int i = 0; i < n; i++){
            pre[i] = i;
        }
    }

    private int find(int i){
        if(i != pre[i]){
            pre[i] = find(pre[i]);
        }
        return pre[i];
    }
    private void unio(int i,int j){
        pre[find(i)] = find(j);
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        init(n);
        List<Edge> edgeList = new ArrayList<>();
        for(int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            Edge e = new Edge(i,edge[0],edge[1],edge[2]);
            edgeList.add(e);
        }
        edgeList.sort((o1,o2) -> (o1.val - o2.val));
        Edge edge = edgeList.get(0);
        int tempv = edge.val;
        int tempi = edge.index;
        unio(edge.form,edge.to);
        List<Integer> trueEdge = new ArrayList<>();
        List<Integer> fakerEdge = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(tempi);
        for(int i = 1; i < edgeList.size(); i++){
            edge = edgeList.get(i);
            if(tempv == edge.val){
                if(find(edge.to) == find(edge.form)){
                    tempi = edge.index;
                    tempv = edge.val;
                    temp.add(tempi);
                    fakerEdge.addAll(temp);
                    temp.clear();
                } else {
                    tempi = edge.index;
                    tempv = edge.val;
                    temp.add(tempi);
                    unio(edge.to,edge.form);
                }
            } else {
                trueEdge.addAll(temp);
                temp.clear();
                if(find(edge.to) != find(edge.form)){
                    tempv = edge.val;
                    tempi = edge.index;
                    temp.add(tempi);
                    unio(edge.to,edge.form);
                }
            }
        }
        if(temp.size() == 1 || (n-temp.size() - 1 == trueEdge.size())){
            trueEdge.addAll(temp);
        } else if(temp.size() != 0){
            fakerEdge.addAll(temp);
        }
        List<List<Integer>> re = new ArrayList<>();
        re.add(trueEdge);
        re.add(fakerEdge);
        return re;
    }

    class Edge{
        int index;
        int form;
        int to;
        int val;

        public Edge(int index, int form, int to, int val) {
            this.index = index;
            this.form = form;
            this.to = to;
            this.val = val;
        }
    }

}
