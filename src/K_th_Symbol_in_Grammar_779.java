import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//779. 第K个语法符号
public class K_th_Symbol_in_Grammar_779 {
    public int kthGrammar(int n, int k) {

            if (n == 1) {
                return 0;
            }
            return (k & 1) ^ 1 ^ kthGrammar(n - 1, (k + 1) / 2);
        }





    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            int ret = new K_th_Symbol_in_Grammar_779().kthGrammar(n, k);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
