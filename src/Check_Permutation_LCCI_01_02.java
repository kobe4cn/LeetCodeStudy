import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Check_Permutation_LCCI_01_02 {
    public boolean CheckPermutation(String s1, String s2) {
        char[] s1a = s1.toCharArray();
        char[] s2a=s2.toCharArray();
        Arrays.sort(s1a);
        Arrays.sort(s2a);
        s1 = new String(s1a);
        s2=new String(s2a);

        if(s1.equals(s2)){
            return true;
        }
        return false;
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

            boolean ret = new Check_Permutation_LCCI_01_02().CheckPermutation(s1, s2);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
