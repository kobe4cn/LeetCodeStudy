import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//829. 连续整数求和
public class Consecutive_Numbers_Sum_829 {
    public int consecutiveNumbersSum(int n) {
        int result=1;
        int start=0;
        if(n%2==0){
            //从一半的位置往前遍历
            start=n/2;
//            for (int i = start; i>0; i--) {
//                int count=i;
//                int pre=i;
//                while(count<=n){
//                    if(count==n){
//                        result++;
//                        break;
//                    }else {
//                        if(pre-1==0) break;
//                        count = count + pre - 1;
//                        pre=pre-1;
//                    }
//                }
//            }
        }else{
            start=(n+1)/2;

        }
        for (int i = start; i>0; i--) {
            int count=i;
            int pre=i;
            while(count<=n){
                if(count==n){
                    result++;
                    break;
                }else {
                    if(pre-1==0) break;
                    count = count + pre - 1;
                    pre=pre-1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Consecutive_Numbers_Sum_829().consecutiveNumbersSum(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
