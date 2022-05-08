import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class MostCommonWord_819 {
    public static String mostCommonWord(String paragraph, String[] banned) {
        String returnvalue = "";
        String s = paragraph;

        s = s.replaceAll(",", "##")
                .replaceAll("!", "##")
                .replaceAll("\\?", "##")
                .replaceAll("\'", "##")
                .replaceAll(";", "##")
                .replaceAll("\\.", "##")
                .replaceAll(" ", "##");
        String[] s1 = s.toLowerCase().split("##");
        //Arrays.stream(s1).toList().forEach(s2 -> System.out.print(s2+","));

        String regex = "[^a-z]";
        Pattern pattern = Pattern.compile(regex);
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length; i++) {
            StringBuilder newStr = new StringBuilder();
            s1[i] = s1[i].trim();
            if (s1[i].equals("")) continue;
            for (int j = 0; j < s1[i].length(); j++) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(s1[i].charAt(j));
                Matcher m = pattern.matcher(stringBuilder);
                if (!m.find()) {
                    newStr.append(s1[i].charAt(j));
                }
            }
            if (map.containsKey(newStr.toString())) {
                int in = map.get(newStr.toString());
                map.put(newStr.toString(), in + 1);
            } else {
                map.put(newStr.toString(), 1);
            }

        }
//        System.out.println(map.keySet());
//        System.out.println(map.values());
        for (String delstr : banned) {
            if (map.containsKey(delstr))
                map.remove(delstr);
        }

        Integer integer = map.values().stream().max(Integer::compareTo).get();
        Set<String> set = map.keySet();
        List<String> list = set.stream().toList();
        for (int k = 0; k < map.keySet().size(); k++) {
            if (map.get(list.get(k)) == integer) {
                returnvalue = list.get(k);
            }
        }


        return returnvalue;

    }

    public static void main(String[] args) {
        //String s="Bob hit a ball, the hit BALL flew far after it was hit.";
        String s = "a, a, a, a, b,b,b,c, c";
        String[] str = {"a"};
        System.out.println(mostCommonWord(s, str));

    }


}
