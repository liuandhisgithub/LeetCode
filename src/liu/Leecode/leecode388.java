package liu.Leecode;

public class leecode388 {
    public int[] countBits(int num) {
        int[] re = new int[num+1];

        for(int i = 0; i <= num; i++){
            int no = 0;
            int t = i;
            while (t != 0){
                no += t % 2;
                t /= 2;
            }
            re[i]=no;
        }
        return re;
    }

    public static void main(String[] args) {
        new leecode388().countBits(2);
    }
}
