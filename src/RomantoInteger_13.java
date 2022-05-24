import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//13. 罗马数字转整数
public class RomantoInteger_13 {
    public int romanToInt(String s) {
//             int[] nums={1000,900,500,400,100, 90,  50, 40, 10,  9,   5,  4,   1};
//        String[] roman={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] nums={    900, 400,  90,  40,  9,   4, 1000,500,100,50, 10, 5,  1};
        String[] roman={"CM","CD","XC","XL","IX","IV","M","D","C","L","X","V","I"};
        int result=0;
        while(s.length()>0){
            for (int i=0;i<roman.length;i++) {
                int index=s.indexOf(roman[i]);
//                int lastindex=s.lastIndexOf(roman[i]);
                while(index!=-1){
                    if(s.length()==1){
                        s="";
                    }else {
                        if(roman[i].length()==2){
                            StringBuilder stringBuilder=new StringBuilder(s);
                            stringBuilder.delete(index,index+2);
                            s = stringBuilder.toString();
                        }else {
                            StringBuilder stringBuilder=new StringBuilder(s);
                            stringBuilder.deleteCharAt(index);
                            s = stringBuilder.toString();
//                            s = s.substring(index + 1);
                        }
                    }
                    index=s.indexOf(roman[i]);
                    result+=nums[i];
                }
            }
        }
        return result;
    }
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            int ret = new RomantoInteger_13().romanToInt(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
