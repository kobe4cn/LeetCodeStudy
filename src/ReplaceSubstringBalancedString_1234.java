import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//1234. 替换子串得到平衡字符串
public class ReplaceSubstringBalancedString_1234 {
    public int balancedString(String s) {
        int result =0;
        //int num=s.length()/4;
        Map<Character,Integer> map=new HashMap<>();
        map.put('Q',0);
        map.put('W',0);
        map.put('E',0);
        map.put('R',0);
        for (int i = 0; i < s.length();) {
            map.computeIfPresent(s.charAt(i),(character, integer) -> ++integer);
            map.computeIfPresent(s.charAt(i+1),(character, integer) -> ++integer);
            map.computeIfPresent(s.charAt(i+2),(character, integer) -> ++integer);
            map.computeIfPresent(s.charAt(i+3),(character, integer) -> ++integer);
            if(map.get('Q')>1){
                result +=map.get('Q')-1;
            }
            if(map.get('W')>1){
                result+=map.get('W')-1;
            }
            if(map.get('E')>1){
                result+=map.get('E')-1;
            }
            if(map.get('R')>1){
                result+=map.get('R')-1;
            }
            i+=4;
            map.put('Q',0);
            map.put('W',0);
            map.put('E',0);
            map.put('R',0);
        }

        return result;
    }

    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            int ret = new ReplaceSubstringBalancedString_1234().balancedString(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
