import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

///1217. 玩筹码
public class Minimum_Cost_to_Move_Chips_to_217 {
    public int minCostToMoveChips(int[] position) {
        int count=Integer.MAX_VALUE;
        for (int i = 0; i < position.length; i++) {
            int tempcount=0;
            int key=position[i];
            for (int j = 0; j < position.length;j++){
                if(Math.abs(position[j]-position[i])%2!=0){
                    tempcount++;
                }
            }
            count=Math.min(tempcount,count);

        }
        return count;
//        int count=Integer.MAX_VALUE;
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//
//        for (int i = 0; i < position.length; i++) {
//            if(map.containsKey(position[i])){
//                map.computeIfPresent(position[i],(integer, integer2) -> ++integer2);
//            }else{
//                map.put(position[i],1);
//            }
//        }
//        LinkedHashMap<Integer, Integer> collect=map.entrySet().stream().sorted((o1, o2) -> o2.getValue()-o1.getValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldValue, newValue) -> oldValue, LinkedHashMap::new));
//        Iterator<Map.Entry<Integer, Integer>> iterator = collect.entrySet().iterator();
//        Map.Entry<Integer, Integer> next = iterator.next();
//        Integer key = next.getKey();
//        List<Integer> keylist=new ArrayList<>();
//        keylist.add(key);
//        while(iterator.hasNext()){
//            Map.Entry<Integer, Integer> next1 = iterator.next();
//            if(next.getValue()==next1.getValue()){
//                keylist.add(next1.getKey());
//            }
//        }
//
//
//        for (int i = 0; i <keylist.size() ; i++) {
//            Integer keys=keylist.get(i);
//            int tempcount=0;
//            Iterator<Map.Entry<Integer, Integer>> iterators = collect.entrySet().iterator();
//            while(iterators.hasNext()){
//                Map.Entry<Integer, Integer> next1 = iterators.next();
//                if(Math.abs(keys-next1.getKey())%2!=0){
//                    tempcount+=next1.getValue();
//                }
//            }
//            count = Math.min(count, tempcount);
//        }
//        return count;

    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] position = stringToIntegerArray(line);

            int ret = new Minimum_Cost_to_Move_Chips_to_217().minCostToMoveChips(position);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
