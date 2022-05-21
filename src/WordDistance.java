import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//244. 最短单词距离 II
public class WordDistance {
    HashMap<String,List<Integer>> map;
    public WordDistance(String[] wordsDict1) {
        map=new HashMap<>();
        for (int i = 0; i <wordsDict1.length; i++) {
            if(map.containsKey(wordsDict1[i])){
                map.get(wordsDict1[i]).add(i);
            }else{
                List<Integer> list=new ArrayList<>();
                list.add(i);
                map.put(wordsDict1[i], list);
            }
        }

    }

    public int shortest(String word1, String word2) {
        List<Integer> word1index=map.get(word1);
        List<Integer> word2index=map.get(word2);
//        for (int i = 0; i < wordsDict.length; i++) {
//            if(wordsDict[i].equals(word1)){
//                word1index.add(i);
//            }
//            if(wordsDict[i].equals(word2)){
//                word2index.add(i);
//            }
//        }
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < word1index.size(); i++) {
            for (int j = 0; j < word2index.size(); j++) {
                int result=word1index.get(i)-word2index.get(j);
                if(result<0){
                    result=0-result;
                }
                min=Math.min(min,result);
            }
        }
        return min;
    }
}
