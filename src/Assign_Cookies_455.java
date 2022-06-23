import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//455. 分发饼干
public class Assign_Cookies_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        //if(s.length>=g.length){
        for (int intg : g
        ) {
            for(int i=0;i<s.length;i++)
            {
                if (intg <= s[i]) {
                    count++;
                    s[i] = 0;
                    break;
                }
            }
        }
//        }else{
//            for (int ints:s
//                 ) {
//                for (int intg:g
//                     ) {
//                    if(intg<=ints){
//                        count++;
//                        intg=0;
//                    }else if(intg>ints){
//                        break;
//                    }
//                }
//            }
//        }
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
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] g = stringToIntegerArray(line);
            line = in.readLine();
            int[] s = stringToIntegerArray(line);

            int ret = new Assign_Cookies_455().findContentChildren(g, s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
