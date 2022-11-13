import java.util.LinkedHashMap;
import java.util.Map;

//791. 自定义字符串排序
public class Custom_Sort_String_791 {
    public String customSortString(String order, String s) {
        Map<Character,Integer> map=new LinkedHashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i),0);
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            Integer integer1 = map.computeIfPresent(s.charAt(i), (character, integer) -> ++integer);
            if(integer1==null){
                sb.append(s.charAt(i));
            }
        }
        StringBuilder res=new StringBuilder();
        map.forEach((character, integer) -> {
            for (int i = 0; i < integer; i++) {
                res.append(character);
            }
        });
        res.append(sb);
        return res.toString();
    }

    public static void main(String[] args){
        Custom_Sort_String_791 custom_sort_string_791=new Custom_Sort_String_791();
        String s = custom_sort_string_791.customSortString("cba", "abcd");
        System.out.println(s);
    }
}
