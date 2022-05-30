import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

///468. 验证IP地址
public class ValidateIPAddress_468 {
    public String validIPAddress(String IP) {
        if (!IP.contains(".") && !IP.contains(":")) {
            return "Neither";
        }
        //若是是IPV4
        if (IP.contains(".")) {
            if (IP.endsWith(".")) {
                return "Neither";
            }
            String[] arr = IP.split("\\.");
            if (arr.length != 4) {
                return "Neither";
            }

            for (int i = 0; i < 4; i++) {
                if (arr[i].length() == 0 || arr[i].length() > 3) {
                    return "Neither";
                }
                for (int j = 0; j < arr[i].length(); j++) {
                    if (arr[i].charAt(j) >= '0' && arr[i].charAt(j) <= '9') {
                        continue;
                    }
                    return "Neither";
                }
                if (Integer.valueOf(arr[i]) > 255 || (arr[i].length() >= 2 && String.valueOf(arr[i]).startsWith("0"))) {
                    return "Neither";
                }
            }
            return "IPv4";
        }//若是是IPV4

        //若是是IPV6
        if (IP.contains(":")) {
            if (IP.endsWith(":") && !IP.endsWith("::")) {
                return "Neither";
            }
            //若是包含多个“::”，一个IPv6地址中只能出现一个“::”
            if (IP.indexOf("::") != -1 && IP.indexOf("::", IP.indexOf("::") + 2) != -1) {
                return "Neither";
            }

            //若是含有一个“::”
            if (IP.contains("::")) {
                String[] arr = IP.split(":");
                if (arr.length > 7 || arr.length < 1) {//"1::"是最短的字符串
                    return "Neither";
                }
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].equals("")) {
                        continue;
                    }
                    if (arr[i].length() > 4) {
                        return "Neither";
                    }
                    for (int j = 0; j < arr[i].length(); j++) {
                        if ((arr[i].charAt(j) >= '0' && arr[i].charAt(j) <= '9') || (arr[i].charAt(j) >= 'A' && arr[i].charAt(j) <= 'F')
                                || (arr[i].charAt(j) >= 'a' && arr[i].charAt(j) <= 'f')) {
                            continue;
                        }
                        return "Neither";
                    }
                }
                return "IPv6";
            }

            //若是不含有“::”
            if (!IP.contains("::")) {
                String[] arr = IP.split(":");
                if (arr.length != 8) {
                    return "Neither";
                }
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].length() > 4) {
                        return "Neither";
                    }
                    for (int j = 0; j < arr[i].length(); j++) {
                        if ((arr[i].charAt(j) >= '0' && arr[i].charAt(j) <= '9') || (arr[i].charAt(j) >= 'A' && arr[i].charAt(j) <= 'F')
                                || (arr[i].charAt(j) >= 'a' && arr[i].charAt(j) <= 'f')) {
                            continue;
                        }
                        return "Neither";
                    }
                }
                return "IPv6";
            }
        }//若是是IPV6
        return "Neither";
    }


    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String queryIP = stringToString(line);

            String ret = new ValidateIPAddress_468().validIPAddress(queryIP);

            String out = (ret);

            System.out.print(out);
        }
    }
}
