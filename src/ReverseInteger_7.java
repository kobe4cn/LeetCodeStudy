import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//7. 整数反转
public class ReverseInteger_7 {
    public int reverse(int x) {
        int retruns = 0;
        while(x!=0){
            //integer最大值为10位数的10进制
            //如果溢出x也必须是10位数，而且在反转最后一位数的时候溢出
            //int型最大值时21亿多，也就是说x的最后一位最大为2
            //因此只要res*10不溢出，res*10加x的最后一位一定不会溢出
            if(retruns<Integer.MIN_VALUE/10 || retruns>Integer.MAX_VALUE/10){
                return 0;
            }

            retruns=retruns*10+x%10;
            x/=10;
        }

//第二种傻的写法，通过string转换，但是会出现超界的情况，直接捕获异常
//        if (x < 0) {
//            String str = String.valueOf(x);
//            StringBuilder stringBuilder = new StringBuilder(str.substring(1));
//            StringBuilder reverse = stringBuilder.reverse();
//            try {
//                retruns = Integer.parseInt(str.charAt(0) + reverse.toString());
//            } catch (NumberFormatException e) {
//                return 0;
//            }
//        } else {
//            String str = String.valueOf(x);
//            StringBuilder stringBuilder = new StringBuilder(str);
//            StringBuilder reverse = stringBuilder.reverse();
//            try {
//                retruns = Integer.parseInt(reverse.toString());
//            } catch (NumberFormatException e) {
//                return 0;
//            }
//        }
//
        return retruns;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);

            int ret = new ReverseInteger_7().reverse(x);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
