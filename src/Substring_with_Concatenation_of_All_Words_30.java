import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//30. 串联所有单词的子串
public class Substring_with_Concatenation_of_All_Words_30 {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        int length = words[0].length();
        int size = words.length;
        //移动等于words数组里面所有值的substring，但是每次只能往后移动一位
        for (int i = 0; i < s.length();i++) {
            int endindex = i + length * size;
            if (endindex <= s.length()) {
                String substring = s.substring(i, i + length * size);
                StringBuilder stringBuilder = new StringBuilder(substring);

                //找到相应的substring之后再按照words中每个数组的长度，提取substring压入map，如果出现多次重复的数据，就value++。
                Map<String,Integer> map=new HashMap<>();

                for (int j = 0; j < stringBuilder.length(); ) {
                    String substring1 = stringBuilder.substring(j, j + length);

                    if(map.containsKey(substring1)){
                        map.computeIfPresent(substring1,(s1, integer) -> ++integer);
                    }else{
                        map.put(substring1,1);
                    }
                    j+=length;
                }

                for (int k = 0; k < words.length; k++) {
                    //与数组匹配的时候每次都将map中的value--，希望的目的就是所有的value都等于0；小于0和>0都是不行的。
                    map.computeIfPresent(words[k],(s1, integer) -> --integer );

                }
                //如果map的value中值有出现！=0的值，数量不是0那就表示不是完全匹配，就不能放入list中保存。
                long count = map.values().stream().filter(integer -> integer != 0).count();
                if (count==0)
                    list.add(i);
            }
        }
        return list;
    }


    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static String[] stringToStringArray(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            line = in.readLine();
            String[] words = stringToStringArray(line);

            List<Integer> ret = new Substring_with_Concatenation_of_All_Words_30().findSubstring(s, words);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}
