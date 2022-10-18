import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//548 · 两数组的交集 II
public class Intersection_of_Two_Arrays_II_548 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1=new HashMap<>();
        Map<Integer,Integer> map2=new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if(!map1.containsKey(nums1[i])){
                map1.putIfAbsent(nums1[i], 1);
            }else{
                map1.computeIfPresent(nums1[i],(integer, integer2) -> ++integer2 );
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if(!map2.containsKey(nums2[i])){
                map2.putIfAbsent(nums2[i], 1);
            }else{
                map2.computeIfPresent(nums2[i],(integer, integer2) -> ++integer2 );
            }
        }
        List<Integer> list=new ArrayList<>();
        if(map1.size()>map2.size()){
            map2.forEach((integer, integer2) -> {
                if(map1.containsKey(integer)){
                    Integer integer1 = map1.get(integer);
                    if(integer2>=integer1){
                        for (int i = 0; i < integer1; i++) {
                            list.add(integer);
                        }
                    }else if(integer2<integer1){
                        for (int i = 0; i < integer2; i++) {
                            list.add(integer);
                        }
                    }
                }
            });
        }else{
            map1.forEach((integer, integer2) -> {
                if(map2.containsKey(integer)){
                    Integer integer1 = map2.get(integer);
                    if(integer2>=integer1){
                        for (int i = 0; i < integer1; i++) {
                            list.add(integer);
                        }
                    }else if(integer2<integer1){
                        for (int i = 0; i < integer2; i++) {
                            list.add(integer);
                        }
                    }
                }
            });
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
