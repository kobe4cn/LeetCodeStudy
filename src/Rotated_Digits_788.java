import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//788. Rotated Digits
public class Rotated_Digits_788 {
    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            String s = String.valueOf(i);
            s = s.replaceAll("[+0,+1,+8]", "");
            if (!"".equals(s)) {
                s = s.replaceAll("[+2,+5,+6,+9]", "");
                if ("".equals(s)) {
                    count += 1;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Rotated_Digits_788().rotatedDigits(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
