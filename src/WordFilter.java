//745. 前缀和后缀搜索
public class WordFilter {
    String[] words;

    public WordFilter(String[] words) {
//        map=new TreeMap<>();
//        for (int i = 0; i < words.length; i++) {
//            int len=words[i].length();
//            if(map.containsKey(len)){
//                List<String> strings = map.get(len);
//                strings.add(words[i]);
//                map.put(len,strings);
//            }else{
//                List<String> strings=new ArrayList<>();
//                strings.add(words[i]);
//                map.put(len,strings);
//            }
//        }
        this.words=words;
    }

    public int f(String pref, String suff) {
        int len=pref.length()+suff.length();

        for (int i = words.length-1; i>=0; i--) {
//            if(words[i].length()<len){
//                return -1;
//            }
            if(words[i].startsWith(pref) && words[i].endsWith(suff)){
                return i;
            }
        }
        return -1;
    }
}
