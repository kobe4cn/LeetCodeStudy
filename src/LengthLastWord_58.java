import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class LengthLastWord_58{
    public int lengthOfLastWord(String s) {
        String[] str = s.split(" ");
        int count=0;
        for (int i = 0; i < str.length; i++) {
            if(!str[i].equals(" "))
                count=str[i].length();
                //System.out.println(str[i]);
        }
        return count;
    }

    // public static String stringToString(String input) {
    //     return JsonArray.readFrom("[" + input + "]").get(0).asString();
    // }
    
    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s="   fly me   to   the moon  ";
       
            
            int ret = new LengthLastWord_58().lengthOfLastWord(s);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }

