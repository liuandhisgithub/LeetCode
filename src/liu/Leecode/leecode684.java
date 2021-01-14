package liu.Leecode;

public class leecode684 {
    private int[] pre;
    private int n;
    public int[] findRedundantConnection(int[][] edges) {
        n = edges.length + 1;
        pre = new int[n];
        init();
        for(int[] edge : edges){
            int f = edge[0];
            int t = edge[1];
            if(find(f) == find(t)){
                return edge;
            }
            unio(f,t);
        }
        return null;
    }
    private void init(){
        for(int i = 0 ;i < n ; i ++){
            pre[i] = i ;
        }
    }

    private int find(int i){
        if(i != pre[i]){
            pre[i] = find(pre[i]);
        }
        return pre[i];
    }

    private void unio(int i ,int j){
        pre[find(i)] = find(j);
    }

}
