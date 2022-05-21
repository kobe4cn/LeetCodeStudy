import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//212. 单词搜索 II
public class WordSearchII_212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> list=new ArrayList<>();
        Map<Character, List<Integer[]>> characterLinkedListMap = initMap(board);

        for(String str:words) {
            int i = 0;
            Map<Character, List<Integer[]>> map=new HashMap<>(characterLinkedListMap);
            Map<Character, List<Integer[]>> overmap=new HashMap<>(characterLinkedListMap);
            List<Character> checkstr=new ArrayList<>();
            if(str.length()==1){
                if(map.containsKey(str.charAt(0))){
                    checkstr.add(str.charAt(0));
                }

            }
            while (i + 1 <str.length()) {
                List<Integer[]> list1 = map.get(str.charAt(i));
                if(list1!=null){
                    for (int j = 0; j < list1.size(); j++) {
                        Integer[] temp=list1.get(j);
                        Integer y=temp[0];//行
                        Integer x=temp[1];//列
                        List<Integer[]> list2 = overmap.get(str.charAt(i+1));
                        if(list2!=null){
                            list2.remove(temp);
                        }

                        List<Integer[]> templist2 = new ArrayList<>();
                        Integer[] left={y,x-1};
                        Integer[] up={y-1,x};
                        Integer[] right={y,x+1};
                        Integer[] down={y+1,x};
                        if(list2==null){
                            list2=new ArrayList<>();
                        }
                        list2.stream().forEach(integers -> {
                            if(integers[0]==left[0] && integers[1]==left[1]){
                                templist2.add(integers);
                            }
                            if(integers[0]==up[0] && integers[1]==up[1]){
                                templist2.add(integers);
                            }
                            if(integers[0]==right[0] && integers[1]==right[1]){
                                templist2.add(integers);
                            }
                            if(integers[0]==down[0] && integers[1]==down[1]) {
                                templist2.add(integers);
                            }
                        });

                        if(templist2.size()==0){
                            continue;
                        }
//                        overmap.get(str.charAt(i+1))
                        map.put(str.charAt(i+1),templist2);
                        if(checkstr.size()>i){
                            checkstr.set(i,str.charAt(i));
                        }else{
                            checkstr.add(i,str.charAt(i));
                        }
                        if(checkstr.size()>i+1){
                            checkstr.set(i+1,str.charAt(i+1));
                        }else{
                            checkstr.add(i+1,str.charAt(i+1));
                        }
                    }
                }else{
                    break;
                }
                i++;
            }
            if(checkstr.size()==str.length()){
                list.add(str);
            }
        }
        return list;
    }



    public Map<Character, List<Integer[]>> initMap(char[][] board){
        Map<Character, List<Integer[]>> map=new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                Integer[] temp={i,j};
                if(map.containsKey(board[i][j])){
                    map.get(board[i][j]).add(temp);
                }else{
                    List<Integer[]> list=new ArrayList<>();
                    list.add(temp);
                    map.put(board[i][j],list);
                }
            }
        }
        return map;
    }

    public static void main(String[] args) {
//        char[][] s={{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
//        String[] str={"oath","pea","eat","rain"};
//        char[][] s={{'a','b'},{'c','d'}};
//        String[] str={"abcb"};
//        char[][] s={{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};
////        String[] str={"oa","oaa"};
        char[][] s={{'a',},{'b'}};
        String[] str={"aba"};
        List<String> list=new WordSearchII_212().findWords(s,str);
        list.stream().forEach(System.out::println);
    }
}
