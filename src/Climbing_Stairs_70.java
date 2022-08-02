import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Climbing_Stairs_70 {
    public int climbStairs(int n) {
        int[] temp=new int[n+1];
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        temp[1]=1;
        temp[2]=2;
        for (int i = 3; i < n+1; i++) {
            temp[i]=temp[i-1]+temp[i-2];
        }
        return temp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Climbing_Stairs_70().climbStairs(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
