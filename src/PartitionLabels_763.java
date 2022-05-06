import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels_763 {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
    public static List<Integer> partitionLabels(String s) {
        List<Integer> list=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(String.valueOf(s.charAt(i)),i);
        }
        int start=0;
        int last=0;
        for (int i = 0; i <s.length() ; i++) {
            last=Math.max(last,map.get(String.valueOf(s.charAt(i))));
            if(last==i){
                list.add(last-start+1);
                start=last+1;
            }
        }
        return list;
    }
}
