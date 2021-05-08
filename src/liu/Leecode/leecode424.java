package liu.Leecode;

public class leecode424 {
    public int characterReplacement(String s, int k) {
        int con = 0;
        int q = 0;
        int l = 0;
        int max = 0;
        int tk = k;
        while (con < s.length()){
            tk = k;
            while (q<s.length()){
                if(s.charAt(q) != s.charAt(l)){
                    if(con == l){
                        con = q;
                    }
                    if(tk > 0){
                        tk --;
                    } else{
                        break;
                    }
                }
                q++;
            }
            max = max > (q-l)? max:q-l;
            l = con;
            q = l;
        }
        return max;
    }
}
