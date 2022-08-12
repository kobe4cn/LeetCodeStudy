import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//1417. 重新格式化字符串
public class Reformat_The_String_1417 {
    public String reformat(String s) {
        Queue<Character> charlist=new LinkedList<>();
        Queue<Character> intlist=new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char chr=s.charAt(i);
            if(Character.isDigit(chr)){
                intlist.offer(chr);
            }else{
                charlist.offer(chr);
            }
        }

        if(Math.abs(charlist.size()-intlist.size())>1){
            return "";
        }
        StringBuffer stringBuffer=new StringBuffer();
        int charsize=charlist.size();
        int intsize=intlist.size();
        for (int i = 0; i <s.length() ; i++) {
            if(charsize> intsize){
                if(i%2==0){
                    stringBuffer.append(charlist.remove());
                }else {
                    stringBuffer.append(intlist.remove());
                }
            }else if(intsize> charsize){
                if(i%2==0){
                    stringBuffer.append(intlist.remove());
                }else {
                   stringBuffer.append(charlist.remove());

                }
            }else{
                if(i%2==0){
                    stringBuffer.append(intlist.remove());
                }else {
                    stringBuffer.append(charlist.remove());
                }
            }
        }
        return stringBuffer.toString();
    }


    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            String ret = new Reformat_The_String_1417().reformat(s);

            String out = (ret);

            System.out.print(out);
        }
    }
}
