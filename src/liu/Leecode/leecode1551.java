package liu.Leecode;

public class leecode1551 {
    public int minOperations(int n) {
        if(n%2 == 0){
            int t = n/2;
            return t+t*(t-1);
        } else{
            int t = n/2+1;
            return t*(t-1);
        }
    }
}
