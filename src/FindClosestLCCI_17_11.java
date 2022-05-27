import java.util.ArrayList;
import java.util.List;

//面试题 17.11. 单词距离
public class FindClosestLCCI_17_11 {
    public int findClosest(String[] words, String word1, String word2) {
        List<Integer> word1list=new ArrayList<>(), word2list=new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String temp=words[i];
            if(temp.equals(word1)){
                word1list.add(i);
            }else if(temp.equals(word2)){
                word2list.add(i);
            }
        }
        int min=Integer.MAX_VALUE;
        for (Integer integer:word1list
             ) {
            for (Integer integer1:word2list
                 ) {
                int res=0;
                if(integer<integer1){
                    res=integer1-integer;
                }else{
                    res=integer-integer1;
                }
                min=Math.min(min,res);
            }
        }
        return min;
    }
}
