package liu.Leecode;

public class leecode1725 {
    public int countGoodRectangles(int[][] rectangles) {
        int max = 0;
        int num = 0;
        for(int[] rectangle : rectangles){
            int x = Math.min(rectangle[0],rectangle[1]);
            if(x > max){
                max = x;
                num = 1;
            } else if(x == max){
                num ++;
            }
        }
        return num;
    }
}
