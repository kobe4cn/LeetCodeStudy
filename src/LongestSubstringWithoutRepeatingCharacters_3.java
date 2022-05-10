

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int lenth=0;
        int len=chars.length;
        for (int i = 0; i < len; i++) {
            int j=i+1;
            List<Character> list=new ArrayList<>();
            list.add(chars[i]);
            while(j<len){
                if(chars[i]==chars[j]){
                    break;
                }
                if(list.contains(chars[j])){
                    break;
                }
                list.add(chars[j]);
                j++;
            }
            lenth=Math.max(list.stream().distinct().collect(Collectors.toList()).size(),lenth);
        }
        return lenth;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = line;

            int ret = new LongestSubstringWithoutRepeatingCharacters_3().lengthOfLongestSubstring(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
