import java.util.Arrays;

public class Orderly_Queue_899 {
    public String orderlyQueue(String s, int k) {
        if (k==1){
            String ss=s;
            int len=s.length();
            for (int i = 0; i < len-1; i++) {
                s=s.substring(1)+s.charAt(0);
                if(s.compareTo(ss)<0) ss=s;
            }
            return ss;
        }else{
            char[] chars=s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
}
