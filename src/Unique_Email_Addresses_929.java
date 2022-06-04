import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//929. 独特的电子邮件地址
public class Unique_Email_Addresses_929 {
    public int numUniqueEmails(String[] emails) {
        for (int i = 0; i <emails.length ; i++) {
            String[] split = emails[i].split("@");
            String replaceStr = split[0].replaceAll("\\.", "");
            int index = replaceStr.indexOf("+");
            if(index>0){
                replaceStr = replaceStr.substring(0, index);
            }
            split[0]=replaceStr;
            emails[i]=split[0]+"@"+split[1];
        }
       return (int) Arrays.stream(emails).distinct().count();
    }


    public static String[] stringToStringArray(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] emails = stringToStringArray(line);

            int ret = new Unique_Email_Addresses_929().numUniqueEmails(emails);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
