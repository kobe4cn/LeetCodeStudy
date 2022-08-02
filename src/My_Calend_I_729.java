import java.util.Map;
import java.util.TreeMap;

///729. 我的日程安排表 I
public class My_Calend_I_729 {
    TreeMap<Integer,Integer> map;
    public My_Calend_I_729() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> floorEntry = map.floorEntry(start);
        Map.Entry<Integer, Integer> ceilingEntry = map.ceilingEntry(start);
        if(floorEntry!=null){
            Integer value = floorEntry.getValue();
            if(value>start  ){
                return false;
            }
        }
        if(ceilingEntry!=null){
            Integer key = ceilingEntry.getKey();
            if(key<end){
                return false;
            }
        }
        map.put(start,end);
        return true;
    }


}
