import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//172. 阶乘后的零
public class Factorial_Trailing_Zeroes_172 {
    public int trailingZeroes(int n) {
        int count=0;
        while(n>=5){
            count+=n/5;
            n/=5;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Factorial_Trailing_Zeroes_172().trailingZeroes(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
