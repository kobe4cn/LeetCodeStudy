import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

//473. 火柴拼正方形
public class Matchsticks_to_Square_473 {
    public boolean makesquare(int[] matchsticks) {
        TreeMap<Integer,Integer> map=new TreeMap<>(Integer::compareTo);
        //小于4不可能是正方形
        if(matchsticks.length<4){
            return false;
        }
        //等于4边的长度不一致也不行
        if(matchsticks.length==4){
            if(Arrays.stream(matchsticks).distinct().count()>1){
                return false;
            }
        }

        Arrays.sort(matchsticks);
        int sum=Arrays.stream(matchsticks).sum();
        if(sum%4!=0){
            return false;
        }
        int lenth = sum/4;
        return backtracking(matchsticks.length-1,new int[4],matchsticks,lenth);
//
    }

    public boolean backtracking(int id,int[] sq,int[] matchsticks,int lenth){
        if(id<0){
            return true;
        }
        for (int i = 0; i < sq.length; i++) {
            if(sq[i]+matchsticks[id]<=lenth){
                if(sq[i]==12){
                    System.out.println(sq);
                }
                sq[i]+=matchsticks[id];
                if(backtracking(id-1,sq,matchsticks,lenth)){ return true;}
                sq[i]-=matchsticks[id];
            }
        }
        return false;
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] matchsticks = stringToIntegerArray(line);

            boolean ret = new Matchsticks_to_Square_473().makesquare(matchsticks);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
