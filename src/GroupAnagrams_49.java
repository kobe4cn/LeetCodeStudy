import java.util.*;

//49. 字母异位词分组
public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new TreeMap<>();
//        List<List<String>> list1=new ArrayList<>();
        for (String str:strs
             ) {
            char[] chars = str.toCharArray();
            String s=new String(charRank(chars));
            if(map.containsKey(s)){
                map.get(s).add(str);
            }else{
                List<String> list=new ArrayList<>();
                list.add(str);
                map.put(s,list);
            }
        }
        return map.values().stream().toList();
    }

    public char[] charRank(char[] s){
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s.length-i-1; j++) {
                if(s[j]>s[j+1]){
                    char len=s[j];
                    s[j]=s[j+1];
                    s[j+1]=len;
                }
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String[] str={"eat", "tea", "tan", "ate", "nat", "bat"};
        new GroupAnagrams_49().groupAnagrams(str).stream().forEach(System.out::println);

    }
}
