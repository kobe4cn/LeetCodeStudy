import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

//1700. 无法吃午餐的学生数量
public class Number_of_Students_Unable_to_Eat_Lunch_1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        LinkedList<Integer> list=new LinkedList<>();
        for (int i = 0; i < students.length; i++) {
            list.offer(students[i]);
        }
        for (int i = 0; i < sandwiches.length; i++) {
            while(!list.isEmpty()) {
                if(!list.contains(sandwiches[i])){
                    return list.size();
                }
                if(sandwiches[i]==list.getFirst()){
                    list.remove();

                    break;
                }else{
                    Integer remove = list.remove();
                    list.offerLast(remove);
                }
            }
        }
        return 0;
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
            int[] students = stringToIntegerArray(line);
            line = in.readLine();
            int[] sandwiches = stringToIntegerArray(line);

            int ret = new Number_of_Students_Unable_to_Eat_Lunch_1700().countStudents(students, sandwiches);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
