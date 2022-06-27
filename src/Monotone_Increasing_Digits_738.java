import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//738. 单调递增的数字
public class Monotone_Increasing_Digits_738 {
    public int monotoneIncreasingDigits(int n) {
//        int result=0;
//        for (int i = n; i >= 0; i--) {
//            StringBuilder stringBuilder = new StringBuilder();
//            stringBuilder.append(i);
//            int length = stringBuilder.length();
//            if(length==1){
//                return i;
//            }
//            boolean check = true;
//            int j = 0;
//            while (check && j+1 < length) {
//                int compare = Character.compare(stringBuilder.charAt(j), stringBuilder.charAt(j + 1));
//
//                if (j + 1 < length && compare>0) {
//                    check=false;
//                    break;
//                }
//                j++;
//            }
//            if(check){
//                return Integer.parseInt(stringBuilder.toString());
//            }
//        }
//        return result;
        String[] strings = (n + "").split("");
        int start = strings.length;
        for (int i = strings.length - 1; i > 0; i--) {
            if (Integer.parseInt(strings[i]) < Integer.parseInt(strings[i - 1])) {
                strings[i - 1] = (Integer.parseInt(strings[i - 1]) - 1) + "";
                start = i;
            }
        }
        for (int i = start; i < strings.length; i++) {
            strings[i] = "9";
        }
        return Integer.parseInt(String.join("",strings));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Monotone_Increasing_Digits_738().monotoneIncreasingDigits(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
