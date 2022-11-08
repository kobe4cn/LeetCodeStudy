import java.util.ArrayList;
import java.util.List;

//1684. 统计一致字符串的数目
public class Count_the_Number_of_Consistent_Strings_1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        List<Character> list=new ArrayList<>();
        for (int i = 0; i < allowed.length(); i++) {
            list.add(allowed.charAt(i));
        }
        int count=0;

        for (int i = 0; i <words.length ; i++) {
            char[] chars = words[i].toCharArray();
            boolean flag=true;
            for (int j = 0; j < chars.length; j++) {
                if(!list.contains(chars[j])){
                    flag=false;
                    break;
                }
            }
            if(flag) {
                count++;
            }

        }
        return count;
    }



}
