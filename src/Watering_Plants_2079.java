import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2079. 给植物浇水
public class Watering_Plants_2079 {
    public int wateringPlants(int[] plants, int capacity1) {
        int capacity=capacity1;
        int count=0;
        for (int i = 0; i < plants.length; i++) {
            if(capacity>=plants[i]){
                capacity=capacity-plants[i];
                count++;
            }
            if(i+1<plants.length){
                if(capacity<plants[i+1]){
                    count+=i+1;
                    count+=i+1;
                    capacity=capacity1;
                }
            }
        }
        return count;
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
            int[] plants = stringToIntegerArray(line);
            line = in.readLine();
            int capacity = Integer.parseInt(line);

            int ret = new Watering_Plants_2079().wateringPlants(plants, capacity);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
