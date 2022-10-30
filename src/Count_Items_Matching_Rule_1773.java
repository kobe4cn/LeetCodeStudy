import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

//1773. 统计匹配检索规则的物品数量
public class Count_Items_Matching_Rule_1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        AtomicInteger count= new AtomicInteger();
        items.stream().forEach(strings -> {
            Object[] objects = strings.stream().toArray();
            if(ruleKey.equals("type")){
                if(objects[0].equals(ruleValue)){
                    count.getAndIncrement();
                }
            }else if(ruleKey.equals("color")){
                if(objects[1].equals(ruleValue)){
                    count.getAndIncrement();
                }
                
            } else if (ruleKey.equals("name")) {
                if(objects[2].equals(ruleValue)){
                    count.getAndIncrement();
                }
            }
        });
        return count.intValue();
    }


}
