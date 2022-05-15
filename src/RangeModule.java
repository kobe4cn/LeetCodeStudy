import java.util.NavigableMap;
import java.util.TreeMap;

//715. Range 模块
public class RangeModule {
    //Map的key是起始left，value是right
    TreeMap<Integer,Integer> map;



    public RangeModule() {
        map = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        if(left>right){ return;}
        Integer start=map.floorKey(left);
        if(start==null)
            start=map.ceilingKey(left);
        while(start!=null && start<=right){
            int end=map.get(start);
            if(end>=left){
                map.remove(start);

                if(start<left){
                    left=start;
                }
                if(end>right)
                    right=end;
            }
            start=map.ceilingKey(end);
        }
        map.put(left,right);
    }

    public boolean queryRange(int left, int right) {
        Integer start=map.floorKey(left);
        if (start == null) {
            return false;
        }
        return map.get(start)>=right;
    }

    public void removeRange(int left, int right) {
        if(left>right){ return;}
        Integer start=map.floorKey(left);
        if(start==null)
            start=map.ceilingKey(left);
        while(start!=null && start<=right){
            int end=map.get(start);
            if(end>=left){
                map.remove(start);
                if(start<left){
                    map.put(start,left);
                }
                if(end>right)
                    map.put(right,end);
            }
            start=map.ceilingKey(end);
        }
    }

    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();
        rangeModule.test();
        //rangeModule.addRange(1, 4);
        rangeModule.addRange(11, 24);
        System.out.println("test");
    }

    public void test() {
//        map.put(1,2);
//        map.put(2,3);
        map.put(10,20);
        map.put(25, 27);
        map.put(27, 30);

        NavigableMap<Integer, Integer> map1 = map.subMap(3, true, 9, false);
        map1.size();
    }
}