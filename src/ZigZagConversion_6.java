import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//6. Z 字形变换
public class ZigZagConversion_6 {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        int numofstr = numRows - 2 + numRows;
        int rownum = numRows - 2 + 1;
        double len = s.length();
        double xlen = len / numofstr * rownum;
        int x = (int) Math.ceil(xlen);
        x=x==0?1:x;
        char[][] str = new char[numRows][x];
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            queue.add(s.charAt(i));
        }

        int y = 0;
        int xr = 0;
        boolean flag = false;
        while (!queue.isEmpty()) {
            char chars = queue.remove();
            if (y == numRows - 1) {
                flag = true;
            }
            if(y>numRows-1){
                flag=true;
                y--;
                xr++;
            }
            if (y == 0) {
                flag = false;
                //xr++;
            }
            System.out.println("char: " + chars + " y:" + y + " X:" + xr);
            str[y][xr] = chars;
            if (flag) {
                xr++;
                y--;
            } else {
                y++;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char[] chars : str) {
            for (char ss : chars
            ) {
                if (ss != '\u0000') {
                    stringBuilder.append(ss);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            line = in.readLine();
            int numRows = Integer.parseInt(line);

            String ret = new ZigZagConversion_6().convert(s, numRows);

            String out = (ret);

            System.out.print(out);
        }
    }
}
