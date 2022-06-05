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
        }else{
            start=(n+1)/2;

        }
        if(start==n){
            return result;
        }
        long sum=getsum(0,start);
        for (int i = start; i>0; i--) {

            int count=i;
            int pre=i;
            if(sum+count<n){
                return result;
            }else{
                sum--;
            }
            while(count<=n){
                if(count==n){
                    result++;
                    break;
                }else {
                    if(pre-1==0) break;
                    int temp=pre-1;
                    count = count + temp;
                    pre=temp;
                }
            }
        }
        return result;
    }

    public long getsum(int a,int b){
        long sum = a;
        long n = b - a;
        //循环n次
        for (int i = 0; i <n ; i++) {
            a = a +1;
            sum+=a;
        }
        return sum;

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
