import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//1624. 两个相同字符之间的最长子字符串
public class Largest_Substring_Between_Two_Equal_Characters_1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, List<Integer>> map=new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            List<Integer> list = map.getOrDefault(s.charAt(i), new ArrayList<>());
            list.add(i);
            map.put(s.charAt(i),list);
        }
        Iterator<List<Integer>> iterator = map.values().iterator();
        int max=-1;
        while(iterator.hasNext()){
            List<Integer> list = iterator.next();
            if(list.size()>=2){
                max=Math.max(max,(list.get(list.size()-1)-list.get(0)-1));
            }
        }
        return max;
    }
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            int ret = new Largest_Substring_Between_Two_Equal_Characters_1624().maxLengthBetweenEqualCharacters(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
