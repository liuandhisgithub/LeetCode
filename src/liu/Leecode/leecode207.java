package liu.Leecode;

public class leecode207 {
    private int[] pre;
    private int n;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        n = numCourses;
        pre = new int[n];
        init();
        for(int[] prerequisite : prerequisites){
            int f = prerequisite[0];
            int t = prerequisite[1];
            if(find(f) == find(t)) return false;
            unio(f,t);
        }
        return true;
    }

    private void init(){
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

    private void unio(int i, int j){
        pre[find(i)] = find(j);
    }
}
