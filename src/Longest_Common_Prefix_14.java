import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

//14. 最长公共前缀
public class Longest_Common_Prefix_14 {
    public String longestCommonPrefix(String[] strs) {
        List<String> list =  Arrays.stream(strs).sorted((o1, o2) -> o1.length() - o2.length()).toList();
        String result="";
        char[] chars = list.get(0).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int finalI = i;
            long count = list.stream().filter(s ->
                s.charAt(finalI) == chars[finalI]
            ).count();
            if(count==strs.length){
                result+=chars[i];
            }else{
                return result;
            }
        }
        return result;
    }

    public static String[] stringToStringArray(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] strs = stringToStringArray(line);

            String ret = new Longest_Common_Prefix_14().longestCommonPrefix(strs);

            String out = (ret);

            System.out.print(out);
        }
    }
}
