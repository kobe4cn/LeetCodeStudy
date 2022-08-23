import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1455. 检查单词是否为句中其他单词的前缀
public class Check_If_a_Word_Occurs_As_1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if(strings[i].indexOf(searchWord)==0){
                return i+1;
            }
        }
        return -1;
    }

    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String sentence = stringToString(line);
            line = in.readLine();
            String searchWord = stringToString(line);

            int ret = new Check_If_a_Word_Occurs_As_1455().isPrefixOfWord(sentence, searchWord);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
