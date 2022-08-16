import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

//1656. 设计有序流
public class Design_an_Ordered_Stream_1656 {
    TreeMap<Integer,String> map;
    int size;
    int count;
    public Design_an_Ordered_Stream_1656(int n) {
        map=new TreeMap<>(Integer::compareTo);
        size=n;
        count=1;
    }

    public List<String> insert(int idKey, String value) {
        map.put(idKey,value);
        if(idKey==count){
            List<String> res=new ArrayList<>();
            for (int i = idKey; i <= size; i++) {
                if(map.containsKey(i)){
                    res.add(map.get(i));
                    count=i+1;
                }else{
                    break;
                }
            }

            return res;
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Design_an_Ordered_Stream_1656 os= new Design_an_Ordered_Stream_1656(5);
        os.insert(3, "ccccc"); // 插入 (3, "ccccc")，返回 []
        os.insert(1, "aaaaa"); // 插入 (1, "aaaaa")，返回 ["aaaaa"]
        os.insert(2, "bbbbb"); // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
        os.insert(5, "eeeee"); // 插入 (5, "eeeee")，返回 []
        os.insert(4, "ddddd"); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]


    }
}
