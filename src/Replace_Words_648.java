import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//648. 单词替换
public class Replace_Words_648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] split = sentence.split(" ");
        List<String> list = dictionary.stream().sorted((o1, o2) -> o1.length() - o2.length()).collect(Collectors.toList());
        for (int i = 0; i < split.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                int index = split[i].indexOf(list.get(j));
                if(index==0){
                    //sentence = sentence.replaceAll(split[i], list.get(j));

                    split[i]=list.get(j);
                    break;
                }
            }
        }
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i < split.length; i++) {

            if(i!=0){
                builder.append(" ");
                builder.append(split[i]);
            }else{
                builder.append(split[i]);
            }
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("aa");
        list.add("aaa");
        list.add("aaaa");
        String sent= "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";

        new Replace_Words_648().replaceWords(list,sent);
    }




}
