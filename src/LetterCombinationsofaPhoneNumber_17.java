import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//17. 电话号码的字母组合
public class LetterCombinationsofaPhoneNumber_17 {

    Map<Integer,List<Character>> keymap;
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList<>();
        }
        initMap();
        List<String> returnlist=new ArrayList<>();
        int[] digarr=new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            switch (digits.charAt(i)){
                case '2':
                    digarr[i]=2;
                    break;
                case '3':
                    digarr[i]=3;
                    break;
                case '4':
                    digarr[i]=4;
                    break;
                case '5':
                    digarr[i]=5;
                    break;
                case '6':
                    digarr[i]=6;
                    break;
                case '7':
                    digarr[i]=7;
                    break;
                case '8':
                    digarr[i]=8;
                    break;
                case '9':
                    digarr[i]=9;
                    break;

            }
        }
        int strlen=digits.length();
        //每个数字对应一个字符串的集合，这个集合可能是3位或者是4位的
        //count用来计算，这个集合已经被遍历的数据，最后一位开始，每次达到这个集合循环的次数之后，往上一个位置上面增加1，
        //比如234  这个数字对应的是abc def ghi 这三个数组，当 取了a，和d之后需要深度遍历ghi之后，将 def这队列的索引往下移动一位增加1，
        //count数组就是用来计算和判断是否要往上面一个数字上近位，countlen数组就是为了判断每个数字对应的字母个数，因为7和9对应的是4位

        int[] count=new int[strlen];

        int[] countlen=new int[strlen];
        for (int i = 0; i < countlen.length; i++) {
            countlen[i]=keymap.get(digarr[i]).size();
        }
        //Arrays.stream(count).forEach(value -> value=1);
        int i=0;
        //2
        //
        while(count[0]<=countlen[0]){
            count[strlen-1]=i;
            int c=strlen-1;

            while(c-1>=0){
                //3
                if(count[c]!=0 && count[c]%countlen[c]==0){
                    count[c-1]+=1;
                    count[c]=0;
                }
                c--;
            }
            //3
            if(count[0]==countlen[0]){
                break;
            }
            Arrays.stream(count).forEach(System.out::print);
            System.out.println();
            StringBuilder stringBuilder=new StringBuilder();
            for (int j = 0; j <count.length ; j++) {
                List<Character> characters = keymap.get(digarr[j]);
                stringBuilder.append(characters.get(count[j]));
            }
            System.out.println(stringBuilder.toString());
            returnlist.add(stringBuilder.toString());

            i++;
            //3
            if(i>countlen[strlen-1]){
                i=1;
            }
            System.out.println("\n");
        }
        //count for

        return returnlist;
    }

    public void initMap(){
        String ss="abcdefghijklmnopqrstuvwxyz";
        keymap=new HashMap<>();
        int i=0;
        int j=2;
        while(j<=9){
            if(j==7 ||  j==9){
                char[] chas=ss.substring(i,i+4).toCharArray();
                i+=4;
                List<Character> chs=new ArrayList<>();
                chs.add(chas[0]);
                chs.add(chas[1]);
                chs.add(chas[2]);
                chs.add(chas[3]);
                keymap.put(j,chs);
            }else {
                char[] chas = ss.substring(i, i + 3).toCharArray();
                i += 3;
                List<Character> chs=new ArrayList<>();
                chs.add(chas[0]);
                chs.add(chas[1]);
                chs.add(chas[2]);
                keymap.put(j,chs);
            }

            j++;

        }
    }


    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String digits = stringToString(line);

            List<String> ret = new LetterCombinationsofaPhoneNumber_17().letterCombinations(digits);

            String out = stringListToString(ret);

            System.out.print(out);
        }
    }
}
