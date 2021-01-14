package liu.Leecode;

public class leecode1395 {
    public int numTeams(int[] rating) {
        int re = 0;
        for(int i = 0; i < rating.length; i++){
            int ll = 0;
            int lm = 0;
            int rl = 0;
            int rm = 0;
            for(int j = 0;j<rating.length;j++){
                if(j < i){
                    if(rating[i] < rating[j]){
                        lm ++;
                    } else if(rating[i] > rating[j]){
                        ll ++;
                    }
                } else if(j > i){
                    if(rating[i] < rating[j]){
                        rm ++;
                    } else if(rating[i] > rating[j]){
                        rl ++;
                    }
                }
            }
            re+=(lm * rl + ll * rm);
        }
        return re;
    }
}
