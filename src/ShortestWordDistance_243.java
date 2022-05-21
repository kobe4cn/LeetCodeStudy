import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//243. 最短单词距离
public class ShortestWordDistance_243 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        //Map<String, List<Integer>> map=new HashMap<>();
        List<Integer> word1index=new ArrayList<>();
        List<Integer> word2index=new ArrayList<>();
        for (int i = 0; i < wordsDict.length; i++) {
            if(wordsDict[i].equals(word1)){
                word1index.add(i);
            }
            if(wordsDict[i].equals(word2)){
                word2index.add(i);
            }
        }
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

    public static String[] stringToStringArray(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }

    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] wordsDict = stringToStringArray(line);
            line = in.readLine();
            String word1 = stringToString(line);
            line = in.readLine();
            String word2 = stringToString(line);

            int ret = new ShortestWordDistance_243().shortestDistance(wordsDict, word1, word2);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
