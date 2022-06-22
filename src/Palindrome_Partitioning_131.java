import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//131. 分割回文串
public class Palindrome_Partitioning_131 {
    LinkedList<String> list=new LinkedList<>();
    StringBuilder stringBuilder=new StringBuilder();
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtracking(s,0);
        return result;
    }

    public void backtracking(String s,int startindex){

        if(startindex>=s.length()){
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = startindex; i <s.length() ; i++) {
            if(isPalindrome(s,startindex,i)){
                String str=s.substring(startindex,i+1);
                list.add(str);
            }else
                continue;
            backtracking(s,i+1);
            list.removeLast();
        }

    }
    public boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Palindrome_Partitioning_131().partition("aab");
    }


}
