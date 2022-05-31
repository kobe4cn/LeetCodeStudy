import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//242. 有效的字母异位词
public class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars1);
        if(Arrays.compare(chars,chars1)!=0){
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
            String s = stringToString(line);
            line = in.readLine();
            String t = stringToString(line);

            boolean ret = new ValidAnagram_242().isAnagram(s, t);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
