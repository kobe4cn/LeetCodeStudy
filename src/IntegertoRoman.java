import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//12. 整数转罗马数字
public class IntegertoRoman {
    public String intToRoman(int num) {
        int[] nums={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String replace="";
        for (int i=0;i<nums.length;i++
             ) {
            while(num>=nums[i]){
                num-=nums[i];
                replace+=roman[i];
            }
        }
        return replace;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int num = Integer.parseInt(line);

            String ret = new IntegertoRoman().intToRoman(num);

            String out = (ret);

            System.out.print(out);
        }
    }
}
