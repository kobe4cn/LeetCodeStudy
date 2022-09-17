import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//670. 最大交换
public class Maximum_Swap_670 {
    public int maximumSwap(int num) {
        String string = Integer.toString(num);
        //char[] char1=string.toCharArray();
        char[] chars = string.toCharArray();
        Arrays.sort(chars);

        for (int i = chars.length-1; i>0; i--) {
            if(string.charAt(string.length()-i-1)!=chars[i]){
                char temp=string.charAt(string.length()-i-1);
                int index = string.lastIndexOf(chars[i]);
                StringBuilder stringBuilder=new StringBuilder(string);
                stringBuilder.setCharAt(string.length()-i-1,chars[i]);
                stringBuilder.setCharAt(index,temp);
                string= stringBuilder.toString();
                break;
            }
        }
        return Integer.parseInt(string);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int num = Integer.parseInt(line);

            int ret = new Maximum_Swap_670
                    ().maximumSwap(num);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
