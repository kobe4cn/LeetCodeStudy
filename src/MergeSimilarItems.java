//2363.合并相似的物品
import java.util.*;

/*
 * @lc app=leetcode.cn id=2363 lang=java
 *
 * [2363] 合并相似的物品
 */

// @lc code=start
public class  MergeSimilarItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer,Integer> map=new TreeMap<>((o1, o2) -> o1-o2);
        for (int i = 0; i < items1.length; i++) {
            map.put(items1[i][0], items1[i][1]);
        }
        for (int i = 0; i < items2.length; i++) {
            int value=items2[i][1];
            map.computeIfPresent(items2[i][0],(integer, integer2) -> integer2+value );
            map.computeIfAbsent(items2[i][0],integer -> value);
        }
        List<List<Integer>> result=new ArrayList();
       Iterator it= map.keySet().iterator();
        while(it.hasNext()){
            Integer i =(Integer) it.next();
            List<Integer> items=new ArrayList<Integer>();
            items.add(i);
            items.add(map.get(i));
            result.add(items);
        }
        return result;
    }
}
// @lc code=end

