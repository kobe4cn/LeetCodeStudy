import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//28. 实现 strStr()
public class mplement_strStr_28 {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        int[] next = new int[needle.length()];
        char[] strchars = haystack.toCharArray();
        char[] chars = needle.toCharArray();
        getNext(next,needle);
        int j = 0;
        for (int i = 0; i < strchars.length; i++) {

            if (strchars[i] == chars[j]) {
                if (j == needle.length()-1) {
                    return i - needle.length() + 1;
                } else {
                    j++;
                }
            } else if (strchars[i] != chars[j]) {
                if(j==0){
                    continue;
                }else {
                    j = next[j - 1];
                    i--;
                }
            }
        }
        return -1;
    }


    //KMP算法，一切的关键在于next数组的构建，next数组的构建的重点是，找到一个字符串中的相同字符，并且判断前后重复次数
    //比如aa，重复数就是1，因为两个a
    //如果是aaba，按照前缀去掉最后一个，后缀去掉第一个来算，这个重复数是，切记第一个数组永远是0开始，0101，
    //比如aabaa 的重复数就是01012，
    //KMP的重点是指当如果出现其中一个字符比较不一致的情况下，可以从next数组的减一位的值开始比较，没有必要重新开始比较
    //next数组维护的就是next对应索引下的字符的重复数的索引值

    public void getNext(int[] next, String needle) {
        char[] chars = needle.toCharArray();
        int j = 0;
        next[0] = j;
        for (int i = 1; i < chars.length; i++) {
            while (j > 0 && chars[j] != chars[i]) {
                j = next[j - 1];
            }
            if (chars[j] == chars[i]) {
                j++;
                next[i] = j;
            }

        }
    }


    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String haystack = stringToString(line);
            line = in.readLine();
            String needle = stringToString(line);

            int ret = new mplement_strStr_28().strStr(haystack, needle);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
