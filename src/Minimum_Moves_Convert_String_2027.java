import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2027. 转换字符串的最少操作次数
public class Minimum_Moves_Convert_String_2027 {
    public int minimumMoves(String s) {
        char[] chars = s.toCharArray();
        int count=0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='X'){
                chars[i]=0;
                if(i+1<chars.length)
                chars[i+1]=0;
                if(i+2< chars.length)
                chars[i+2]=0;
                i=i+1;
                count++;
            }
        }
        return count;
    }
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            int ret = new Minimum_Moves_Convert_String_2027().minimumMoves(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
