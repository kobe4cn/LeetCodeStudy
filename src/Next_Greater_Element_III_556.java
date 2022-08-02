import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//556. 下一个更大元素 III
public class Next_Greater_Element_III_556 {
    //题目的本质就是从后往前遍历，找到当前位置，比前一位置大的数，就可以准备交换，但是在交换之前，第一个是判断下这个位置之后的位置上有没有比当前位置上数字更小的数来跟前一位交换，如果有就拿最小的数字交换，同时交换位置i-1位之后的元素因为题目是要求最小数字，所以必须得按照顺序排序下。
    //一次次的提交之后，出现的场景不断的优化和考虑清楚，所以代码思路挺乱的。哈哈

    public int nextGreaterElement(int n) {
        String sn=String.valueOf(n);
        char[] chars = sn.toCharArray();
        List<Integer> list=new ArrayList<>();
        List<Character> pre=new ArrayList<>();

        int changepoint=-1;
        for (int i = chars.length-1; i >0; i--) {
            if(i>0) {

                if (chars[i] > chars[i - 1]){
                    if(pre.size()>0){
                        pre.add(chars[i]);
                        List<Character> characters = new ArrayList<>(pre.stream().sorted().toList());
//                        int inttemp=-1;
//                        char temp='-1';
                        for (int j = 0; j < characters.size(); j++) {
                            if(characters.get(j)>chars[i-1]){
                               char temp=chars[i-1];
                                chars[i-1]= characters.get(j);
                                characters.set(j,temp);
                                break;
                            }
                        }
                        pre=new ArrayList<>(characters);
//                        characters.add(inttemp,temp);
                        changepoint=i-1;
                        break;
                    }else{
                        char temp = chars[i - 1];
                        chars[i - 1] = chars[i];
                        chars[i] = temp;
                        changepoint=i-1;
                        break;
                    }
//
                }else{
                    pre.add(chars[i]);
                }
            }
        }
        StringBuilder str=new StringBuilder();
        if(pre.size()>0) {
            char[] chars1 = Arrays.copyOfRange(chars, 0, changepoint + 1);

            for (char c : chars1
            ) {
                str.append(c);
            }
            pre.stream().sorted(Character::compareTo).forEach(
                    integer -> str.append(integer)
            );
        }else{
            for (char c : chars
                 ) {
                str.append(c);
            }
        }
        if(Long.parseLong(str.toString())>Integer.MAX_VALUE){
            return -1;
        }
        int anInt =(int)Long.parseLong(str.toString()) ;
        if (anInt>n){
            return anInt;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Next_Greater_Element_III_556().nextGreaterElement(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
