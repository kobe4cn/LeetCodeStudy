import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//2900 · LinkedList 去除重复元素
public class Lintcode_2900 {
    public static LinkedList<String> Weighting(LinkedList<String> list) {
        List<String> temp=new ArrayList<>();
        while(!list.isEmpty()){
            String peek = list.peek();
            if(temp.contains(peek)){
                list.remove();
            }else{
                temp.add(peek);
            }
        }
        return list;
    }
}
