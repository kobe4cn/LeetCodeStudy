import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trie {
    List<String> list;
    public Trie() {
        list=new ArrayList<>();
    }

    public void insert(String word) {
        list.add(word);
    }

    public boolean search(String word) {
        return list.contains(word);
    }

    public boolean startsWith(String prefix) {
        int len=prefix.length();
        List<String> collect = list.stream().filter(s -> {
            if(s.length()>=len) {
                String temp = s.substring(0, len);
                return temp.equals(prefix);
            }else {
                return false;
            }
        }).collect(Collectors.toList());
        if(collect.size()>0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String t="app";
        int temps=t.length();
        String dd="applke";
        String kk=dd.substring(0,temps);
        List<String> s=new ArrayList<>();
        s.add("applke");
        s.add("tttt");
        s.add("appls");
        s.add("attsss");

        Trie trie=new Trie();
        trie.insert("apple");
        trie.search("apple");   // return True
        trie.search("app");     // return False
        boolean test=trie.startsWith("app");
        System.out.println(test);// return True
        trie.insert("app");
        System.out.println(trie.search("app"));







    }
}