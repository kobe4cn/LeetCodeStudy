import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//1021. 删除最外层的括号
public class RemoveOutermostParentheses_1021 {
    public String removeOuterParentheses(String s) {
        StringBuilder result=new StringBuilder();
        Stack<Character> characters=new Stack<>();
        char[] arr=s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (characters.isEmpty() && arr[i] == '(') {
                characters.push(')');
            } else if (arr[i] == '(') {
                characters.push(')');
                result.append('(');
            } else if (arr[i] == ')') {

                characters.pop();
                if (!characters.isEmpty()) {
                    result.append(')');
                }
            } else {
                result.append(arr[i]);
            }
        }
        return result.toString();
    }


    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            String ret = new RemoveOutermostParentheses_1021().removeOuterParentheses(s);

            String out = (ret);

            System.out.print(out);
        }
    }
}
