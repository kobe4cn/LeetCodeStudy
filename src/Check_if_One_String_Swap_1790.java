import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//1790. 仅执行一次字符串交换能否使两个字符串相等
public class Check_if_One_String_Swap_1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        Map<Integer,Character> map=new HashMap<>();
        Map<Integer,Character> map1=new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i)!=s2.charAt(i)){
                map.put(i,s1.charAt(i));
                map1.put(i,s2.charAt(i));
            }
        }
        if(map.size()>2){
            return false;
        }
        if(!map.values().containsAll(map1.values())) {
            return false;
        }
        return true;
    }

    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s1 = stringToString(line);
            line = in.readLine();
            String s2 = stringToString(line);

            boolean ret = new Check_if_One_String_Swap_1790().areAlmostEqual(s1, s2);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
