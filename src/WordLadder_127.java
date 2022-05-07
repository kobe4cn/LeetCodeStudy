import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class WordLadder_127 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //如果endword不在wordlist中直接就不需要再做判断了，该list不可能有转换的可能
        if (!wordList.contains(endWord)) {
            return 0;
        }

        wordList.remove(endWord);
        List<String> firstForList=new ArrayList<>();
        for(String word:wordList){
            int check=0;
            for (int j = 0; j < endWord.length(); j++) {
                if(endWord.charAt(j)!=word.charAt(j)){
                    check++;
                }
            }
            if(check==1){
                firstForList.add(word);
            }
        }
        PriorityQueue<Integer> queue=new PriorityQueue<>((o1, o2) -> o1-o2);
        for(String forlsit:firstForList) {

            List<String> temp = new ArrayList<>(wordList);
            List<String> temp1=new ArrayList<>();
            temp.remove(forlsit);
            if(!temp.contains(beginWord))
                temp1.add(beginWord);
            temp1.addAll(temp);

            List<String> list = new ArrayList<>();
            list.add(endWord);
            list.add(forlsit);
//        checkForChangeWord(endWord, wordList, beginWord, new ArrayList<>(), queues);
            if(list.contains(beginWord)&&list.contains(endWord)){
                return list.size();
            }
            List<String> returnlist = getLength(forlsit, temp1, beginWord, list);
            if(returnlist.size()>2){
                queue.add(returnlist.size());
            }
        }

        return queue.isEmpty()?0:queue.peek();
    }
    public static List<String> getLength(String endWord,List<String> wordlist1,String beginWord,List<String> list){
        List<String> strlist=new ArrayList<>(list);
        List<String> wordlist=new ArrayList<>(wordlist1);

        for (int i = 0; i < wordlist.size() ; i++) {

            String word=wordlist.get(i);
            if(endWord.length()!=word.length()){
                continue;
            }
            int check=0;
            for (int j = 0; j < endWord.length(); j++) {
                if(endWord.charAt(j)!=word.charAt(j)){
                    check++;
                }
            }
            //表示有一个char位置不同的两个单词
            if(check==1){
                wordlist.remove(word);
                i--;
                strlist.add(word);
                if(word==beginWord){
                    //wordlist.add(beginWord);

                    return strlist;
                }else {
                    return getLength(word, wordlist, beginWord, strlist);
                }
            }
        }
        return strlist;
    }



    public static void main(String[] args) {
        List<String> wordlist = new ArrayList<>();

//        wordlist.add("hot");
//        wordlist.add("dot");
//        wordlist.add("dog");
//        wordlist.add("lot");
//        wordlist.add("log");
        //wordlist.add("cog");
        //System.out.println(wordlist.contains("coe"));
//
//        wordlist.add("a");
//        wordlist.add("b");
//        wordlist.add("c");

        wordlist.add("hot");
        wordlist.add("cog");
        wordlist.add("dog");
        wordlist.add("tot");
        wordlist.add("hog");


        wordlist.add("hop");
        wordlist.add("pot");
        wordlist.add("dot");



//        System.out.println(ladderLength("hit", "cog", wordlist));
        System.out.println(ladderLength("hot", "dog", wordlist));
        //List<String> list = checkForChangeWord("cog", wordlist);
        // System.out.println(list.toString());

    }
}
