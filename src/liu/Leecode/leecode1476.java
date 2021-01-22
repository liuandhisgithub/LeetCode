package liu.Leecode;

import java.util.ArrayList;
import java.util.List;

public class leecode1476 {

    class SubrectangleQueries {
        int[][] rectangle;
        List<History> historyList ;
        class History{
            int row1;
            int col1;
            int row2;
            int col2;
            int value;

            public History(int row1, int col1, int row2, int col2, int value) {
                this.row1 = row1;
                this.col1 = col1;
                this.row2 = row2;
                this.col2 = col2;
                this.value = value;
            }
        }
        private boolean inHistory(History history,int row,int col){
            return row >= history.row1 && row <= history.row2 && col >= history.col1 && col <= history.col2;
        }

        public SubrectangleQueries(int[][] rectangle) {
            this.rectangle = rectangle;
            historyList = new ArrayList<>();
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            History history = new History(row1,col1,row2,col2,newValue);
            historyList.add(0,history);
        }

        public int getValue(int row, int col) {
            for(History history : historyList){
                if(inHistory(history,row,col)){
                    return history.value;
                }
            }
            return rectangle[row][col];
        }
    }
}


