package liu.Leecode;

public class leecode1689 {
    public int minPartitions(String n) {
        char c = 0;
        for(char a : n.toCharArray()){
            if(a > c){
                c = a;
            }
        }
        return c-'0';
    }
}
