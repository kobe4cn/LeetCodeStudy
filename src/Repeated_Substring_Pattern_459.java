import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//459. 重复的子字符串
public class Repeated_Substring_Pattern_459 {
    public boolean repeatedSubstringPattern(String s) {
        int[] next=new int[s.length()];
        char[] chars = s.toCharArray();
        int j=0;
        next[0]=j;
        for (int i = 1; i < chars.length; i++) {
            while(j>0 && chars[i]!=chars[j]){
                j=next[j-1];
            }
            if(chars[i]==chars[j]){
                j++;
                next[i]=j;
            }
        }
        //最长公共前后缀长度为next[len-1],即最后一个数组
        //字符串的长度减去最长公共后缀，如果可以被字符串的长度整除说明有重复的子字符串
        if(next[chars.length-1]!=0 && chars.length%(chars.length-next[chars.length-1])==0){
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
            String s = stringToString(line);

            boolean ret = new Repeated_Substring_Pattern_459().repeatedSubstringPattern(s);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
