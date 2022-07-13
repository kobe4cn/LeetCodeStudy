import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

//735. 行星碰撞
public class Asteroid_Collision_735 {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> queue=new LinkedList<>();
        for (int i = 0; i < asteroids.length; i++) {

            while(!queue.isEmpty() && asteroids[i]<0){
                if(Math.abs(asteroids[i])>queue.getLast() && queue.getLast()>0){
                    queue.removeLast();
                }else if(Math.abs(asteroids[i])==queue.getLast()){
                    queue.removeLast();
                    asteroids[i]=0;
                }else if(Math.abs(asteroids[i])<queue.getLast()){
                    asteroids[i]=0;
                }else{
                    queue.offer(asteroids[i]);
                    break;
                }
            }
            if((queue.isEmpty() && asteroids[i]!=0) || asteroids[i]>0)
                queue.offer(asteroids[i]);
        }
        return queue.stream().mapToInt(Integer::intValue).toArray();

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

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] asteroids = stringToIntegerArray(line);

            int[] ret = new Asteroid_Collision_735().asteroidCollision(asteroids);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}
