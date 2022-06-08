import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Evaluate_Reverse_Polish_Notation_150 {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> list=new LinkedList<>();

        for (String str: tokens
             ) {
            if(str.equals("+")){
                int x=list.poll();
                int y=list.poll();
                list.addFirst(x+y);
            }else if(str.equals("*")){
                int x=list.poll();
                int y=list.poll();
                list.addFirst(x*y);
            }else if(str.equals("-")){
                int x=list.poll();
                int y=list.poll();
                list.addFirst(y-x);
            }else if(str.equals("/")){
                int x=list.poll();
                int y=list.poll();
                list.addFirst(y/x);
            }else{
                list.addFirst(Integer.parseInt(str));
            }
        }
        return list.poll();
    }


    public static String[] stringToStringArray(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] tokens = stringToStringArray(line);

            int ret = new Evaluate_Reverse_Polish_Notation_150().evalRPN(tokens);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
