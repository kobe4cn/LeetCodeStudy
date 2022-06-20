import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1108. IP 地址无效化
public class Defanging_an_IP_Address_1108 {
    public String defangIPaddr(String address) {
        String all = address.replaceAll("\\.", "[.]");
        return all;
    }
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String address = stringToString(line);

            String ret = new Defanging_an_IP_Address_1108().defangIPaddr(address);

            String out = (ret);

            System.out.print(out);
        }
    }
}
