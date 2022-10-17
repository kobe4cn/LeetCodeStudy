import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//904. 水果成篮
public class Fruit_Into_Baskets_904 {
    public int totalFruit(int[] fruits) {
        if(Arrays.stream(fruits).distinct().count()<=2){
            return fruits.length;
        }
        int max=0;
        for (int i = 0; i < fruits.length; i++) {
            int count=-1;
           // int change=0;
            Map<Integer,Integer> map=new HashMap<>();
            map.put(fruits[i],1);
            while(!map.isEmpty() && map.keySet().size()==1){
                i++;
                if(i>=fruits.length){
                    i--;
                    break;
                }
                if(map.containsKey(fruits[i])){
                    map.computeIfPresent(fruits[i],(integer, integer2) -> ++integer2);
                }else{
                    i--;
                    break;
                }
            }
            for (int j = i+1; j < fruits.length; j++) {
                if(map.containsKey(fruits[j])){

                    map.computeIfPresent(fruits[j],(integer, integer2) -> ++integer2);
                }else {
                    map.computeIfAbsent(fruits[j],integer -> 1);
                }

                if(map.keySet().size()>2){
                    count=map.values().stream().reduce((integer, integer2) -> integer+integer2).get()-1;
                    break;
                }

//                if(fruits[i]!=fruits[j]){
//                    if(j-1!=i){
//                        if(fruits[j]!=fruits[j-1]){
//                            change++;
//                            count++;
//                        }else{
//                            count++;
//                        }
//                    }else {
//                        change++;
//                        count++;
//                    }
//                }else {
//                    count++;
//                }
//                if(change>1){
//                    count--;
//                    break;
//                }
            }
            if(count==-1){
                count=map.values().stream().reduce((integer, integer2) -> integer+integer2).get();
            }
            max=Math.max(count,max);

        }
        return max;
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
            int[] fruits = stringToIntegerArray(line);

            int ret = new Fruit_Into_Baskets_904().totalFruit(fruits);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
