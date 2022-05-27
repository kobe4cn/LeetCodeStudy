import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//269. 火星词典
public class AlienDictionary_269 {
    public String alienOrder(String[] words) {
        return "";
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
            String[] words = stringToStringArray(line);

            String ret = new AlienDictionary_269().alienOrder(words);

            String out = (ret);

            System.out.print(out);
        }
    }
}

