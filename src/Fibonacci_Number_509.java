import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//509. 斐波那契数
public class Fibonacci_Number_509 {
    public int fib(int n) {
        int[] F=new int[n+1];
        if(n==2){
            return 1;
        }
        if(n==0){
            return 0;
        }
        F[0]=0;
        F[1]=1;

        for (int i = 2; i <n+1 ; i++) {
               F[i]=F[i-1]+F[i-2];
        }
        return F[n];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Fibonacci_Number_509().fib(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
