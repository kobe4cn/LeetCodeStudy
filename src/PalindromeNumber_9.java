import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//9. 回文数
public class PalindromeNumber_9 {
    public boolean isPalindrome(int x1) {
        int x=x1;
        if(x<0){
            return false;
        }
        int retruns = 0;
        while(x!=0){
            //integer最大值为10位数的10进制
            //如果溢出x也必须是10位数，而且在反转最后一位数的时候溢出
            //int型最大值时21亿多，也就是说x的最后一位最大为2
            //因此只要res*10不溢出，res*10加x的最后一位一定不会溢出
            if(retruns<Integer.MIN_VALUE/10 || retruns>Integer.MAX_VALUE/10){
                return false;
            }

            retruns=retruns*10+x%10;
            x/=10;
        }
        if (retruns!=x1){
            return false;
        }
        return true;
    }


    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);

            boolean ret = new PalindromeNumber_9().isPalindrome(x);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
