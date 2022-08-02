import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//676. 实现一个魔法字典
public class Implement_Magic_Dictionary_676 {

    Map<Integer,List<String>> maps;
    public Implement_Magic_Dictionary_676() {

        maps=new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (int i = 0; i < dictionary.length; i++) {
            int keylen=dictionary[i].length();
            List<String> list=new ArrayList<>();
            if(maps.containsKey(keylen)){
                 list=new ArrayList<>(maps.get(keylen));
                 list.add(dictionary[i]);
                 maps.put(keylen,list);
            }else{
                list.add(dictionary[i]);
                maps.put(keylen,list);
            }
        }
    }

    public boolean search(String searchWord) {
        int strlen=searchWord.length();
        List<String> list = maps.get(strlen);
        if(list==null){
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            StringBuilder stringBuilder=new StringBuilder(list.get(i));
            StringBuilder stringBuilder1=new StringBuilder(searchWord);
            for (int j = 0; j < stringBuilder.length(); j++) {
                if(stringBuilder.charAt(j)!=stringBuilder1.charAt(j)){
                    stringBuilder1.setCharAt(j,stringBuilder.charAt(j));
                    if(stringBuilder.toString().equals(stringBuilder1.toString())){
                        return true;
                    }else{
                        break;
                    }
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Implement_Magic_Dictionary_676 magicDictionary=new Implement_Magic_Dictionary_676();
        String[] str={"hello","hallo","leetcode","judge"};
        magicDictionary.buildDict(str);
        System.out.println(magicDictionary.search("hello"));
        System.out.println(magicDictionary.search("hallo"));
        System.out.println(magicDictionary.search("hell"));
        System.out.println(magicDictionary.search("leetcodd"));
        System.out.println(magicDictionary.search("judge"));
//        System.out.println(magicDictionary.search("f"));


    }
}
