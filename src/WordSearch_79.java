import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearch_79 {
    public static void main(String[] args) {
        //case ------------------

        char[][] board={{'A','A','A','A','A','A'},
                {'A','A','A','A','A','A'},
                {'A','A','A','A','A','A'},
                {'A','A','A','A','A','A'},
                {'A','A','A','A','A','A'},
                {'A','A','A','A','A','A'}};
        String word="AAAAAAAAAAAAAAB";
        //case -------------------
        //char[][] board= {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};


 //String word="ABCCED";
        //String word="SEE";
        // String word="ABCB";
//        char[][] board= {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
//String word="ABCESEEEFS";
        //case ----------------------
//        char[][] board= {{'b','b','a','a','b','a'},{'b','b','a','b','a','a'},{'b','b','b','b','b','b'},
//                {'a','a','a','b','a','a'},
//                {'a','b','a','a','b','b'}};
//        String word= "abbbababaa";

        //case  ---------------
//        char[][] board= {{'b','b','b','a','b','b'},{'b','a','b','b','a','a'},{'b','a','b','a','a','a'},
//                {'a','a','a','a','b','a'},
//                {'a','b','b','b','b','a'},{'a','a','b','b','a','a'}};
//
//        String word= "abbbbaabbbbb";

        //case  ---------
       // char[][] SEE= {{'a'},{'a'}};
        //String word="aaa";

        System.out.println(exist(board,word));
    }

    public static boolean exist(char[][] board, String word) {
        Map<Character,List<int[]>> map=initMap(board);
        char[] wordArr=word.toCharArray();
        int i=0;
        while(i<wordArr.length){
            if(!map.containsKey(wordArr[i]))
                return false;
            i++;
        }

        if (map.containsKey(wordArr[0])) {
            boolean check=false;
            List<int[]> list=map.get(wordArr[0]);
            Map<String,int[]> resultMap=new HashMap<>();
            for (int j = 0; j < list.size(); j++) {
                int[] chr=list.get(j);
                Map<String,int[]> returnMap=new HashMap<>();
                returnMap.put(chr[0]+""+chr[1],chr);
                if(checkString(chr,map,wordArr,0,returnMap)) {
                    return true;
                }
                resultMap=returnMap;
            }
        }else{
            return false;
        }

        return false;
    }
    public static boolean checkString(int[] chr,Map<Character,List<int[]>> map,char[] wordArr,int i,Map<String,int[]> returnMap){
        int y=chr[0];
        int x=chr[1];
        if(i+1<wordArr.length){
            char s=wordArr[i+1];
            //System.out.print(s);
            if(map.containsKey(s)){
                List<int[]> list=map.get(s);
                boolean right=false;
                boolean left=false;
                boolean up=false;
                boolean down=false;
                for (int j = 0; j < list.size(); j++) {
                    int[] ints = list.get(j);
                    if (ints[0] == y && ints[1] == x) {
                        continue;
                    }
                    if (!returnMap.containsKey(ints[0]+""+ints[1])){
                        //判断右边
                        if (ints[0] == y && ints[1] == x+1) {
                            i++;

                            returnMap.put(ints[0]+""+ints[1],ints);
                            right = checkString(ints, map, wordArr, i, returnMap);
                            if(!right){
                                returnMap.remove(ints[0]+""+ints[1]);
                                i--;
                            }
                        }
                        //判断左边
                        if (ints[0] == y && ints[1] == x-1) {
                            i++;
                            returnMap.put(ints[0]+""+ints[1],ints);
                            left = checkString(ints, map, wordArr, i, returnMap);
                            if(!left){
                                returnMap.remove(ints[0]+""+ints[1]);
                                i--;
                            }
                        }

                        //判断下边
                        if (ints[1] == x && ints[0] == y+1  ) {
                            i++;
                            returnMap.put(ints[0]+""+ints[1],ints);
                            down = checkString(ints, map, wordArr, i, returnMap);
                            if(!down){
                                returnMap.remove(ints[0]+""+ints[1]);
                                i--;
                            }
                        }
                        //判断上边
                        if (ints[1] == x && ints[0] == y-1 ) {
                            i++;
                            returnMap.put(ints[0]+""+ints[1],ints);
                            up = checkString(ints, map, wordArr, i, returnMap);
                            if(!up){
                                returnMap.remove(ints[0]+""+ints[1]);
                                i--;
                            }
                        }

                    }
                }
                if(left||right||up||down){
                    return true;
                }else{
                    return false;
                }

            }else{
                return false;
            }
        }
        return true;

    }


    public static Map<Character, List<int[]>> initMap(char[][] board){
        Map<Character,List<int[]>> map=new HashMap<>();

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if(map.containsKey(board[y][x])){
                    List<int[]> list=map.get(board[y][x]);
                    int[] temp={y,x};
                    list.add(temp);
                    map.put(board[y][x], list);
                }else{
                    List<int[]> list=new ArrayList<>();
                    int[] temp={y,x};
                    list.add(temp);
                    map.put(board[y][x], list);
                }
            }
        }
        return map;
    }
}
