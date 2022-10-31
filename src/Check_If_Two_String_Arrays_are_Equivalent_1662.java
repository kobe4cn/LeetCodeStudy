import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//1662. 检查两个字符串数组是否相等
public class Check_If_Two_String_Arrays_are_Equivalent_1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if(Arrays.stream(word1).reduce((s, s2) -> s+s2).get().equals(Arrays.stream(word2).reduce((s, s2) -> s+s2).get())){
            return true;
        }
        return false;
    }
    public static String[] stringToStringArray(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] word1 = stringToStringArray(line);
            line = in.readLine();
            String[] word2 = stringToStringArray(line);

            boolean ret = new Check_If_Two_String_Arrays_are_Equivalent_1662().arrayStringsAreEqual(word1, word2);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
