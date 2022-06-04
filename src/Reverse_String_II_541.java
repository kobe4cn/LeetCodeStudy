import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//541. 反转字符串 II
public class Reverse_String_II_541 {
    public String reverseStr(String s, int k) {
        StringBuilder stringBuilder=new StringBuilder();
        char[] chars = s.toCharArray();
        int strlen=2*k;
        int i=0;
        for (i=0; i+strlen<=chars.length; i+=strlen) {
            char[] chars1 = Arrays.copyOfRange(chars, i, i + k);
            char[] reverseString = reverseString(chars1);
            stringBuilder.append(reverseString);
            char[] chars2 = Arrays.copyOfRange(chars, i+k, i + strlen);
            stringBuilder.append(chars2);
        }
        int remain=chars.length-i;
        if(remain<k){
            char[] chars1 = Arrays.copyOfRange(chars, i, chars.length);
            char[] reverseString = reverseString(chars1);
            stringBuilder.append(reverseString);
        }else if(remain<strlen && remain>=k){
            char[] chars1 = Arrays.copyOfRange(chars, i, i+k);
            char[] reverseString = reverseString(chars1);
            stringBuilder.append(reverseString);
            char[] chars2 = Arrays.copyOfRange(chars, i+k, chars.length);
            stringBuilder.append(chars2);
        }
        return stringBuilder.toString();
    }

    public char[] reverseString(char[] s) {

        int length = s.length;
        if(length%2==0){
            int left=0;
            int right=length-1;
            while(left<right){
                char temp=s[left];
                s[left]=s[right];
                s[right]=temp;
                left++;
                right--;
            }
        }else{
            int left=0;
            int right=length-1;
            while(left!=right){
                char temp=s[left];
                s[left]=s[right];
                s[right]=temp;
                left++;
                right--;
            }
        }
        return s;
    }


    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            String ret = new Reverse_String_II_541().reverseStr(s, k);

            String out = (ret);

            System.out.print(out);
        }
    }
}
