//792. 匹配子序列的单词数
public class Number_Matching_Subsequences_792 {
    public int numMatchingSubseq(String s, String[] words) {
        int count=0;
        //StringBuilder sb=new StringBuilder(s);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int index=-1;
            boolean check=true;
            //StringBuilder sb1=new StringBuilder(word);
            for (int j = 0; j < word.length(); j++) {
                String substring = word.substring(j, j + 1);
                int temp = s.indexOf(substring, index+1);
                if(temp>index){
                    index=temp;
                }else{
                    check=false;
                    break;
                }
            }
            if(check){
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args){
        String a="rwpddkvbnnuglnagtvamxkqtwhqgwbqgfbvgkwyuqkdwhzudsxvjubjgloeofnpjqlkdsqvruvabjrikfwronbrdyyjnakstqjac";
        String[] words={"wpddkvbnn","lnagtva","kvbnnuglnagtvamxkqtwhqgwbqgfbvgkwyuqkdwhzudsxvju","rwpddkvbnnugln","gloeofnpjqlkdsqvruvabjrikfwronbrdyyj","vbgeinupkvgmgxeaaiuiyojmoqkahwvbpwugdainxciedbdkos","mspuhbykmmumtveoighlcgpcapzczomshiblnvhjzqjlfkpina","rgmliajkiknongrofpugfgajedxicdhxinzjakwnifvxwlokip","fhepktaipapyrbylskxddypwmuuxyoivcewzrdwwlrlhqwzikq","qatithxifaaiwyszlkgoljzkkweqkjjzvymedvclfxwcezqebx"};
        Number_Matching_Subsequences_792 number_matching_subsequences_792=new Number_Matching_Subsequences_792();
        int abcde = number_matching_subsequences_792.numMatchingSubseq(a, words);
        System.out.println(abcde);


    }
}
