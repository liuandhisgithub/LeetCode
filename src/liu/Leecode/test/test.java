package liu.Leecode.test;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class test {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.err.println(solution.halvesAreAlike("AbCdEfGh"));
    }


}

class Solution {
    public boolean halvesAreAlike(String s) {
        List<Character> characterList = new ArrayList<Character>();
        characterList.add('a');
        characterList.add('i');
        characterList.add('e');
        characterList.add('o');
        characterList.add('u');
        characterList.add('A');
        characterList.add('E');
        characterList.add('I');
        characterList.add('O');
        characterList.add('U');

        char[] chars = s.toCharArray();
        int length = s.length();
        int num = 0;
        int a=0,b=0;
        for(char c : chars){
            if(characterList.contains(c)){
                if(num < length/2){
                    b++;
                }
                a++;
            }
            num++;
        }

        return b == a-b;
    }
}

