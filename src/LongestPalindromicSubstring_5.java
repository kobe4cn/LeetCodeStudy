public class LongestPalindromicSubstring_5 {
    public static void main(String[] args) {
   // System.out.println(longestPalindrome("aacabdkacaa"));
        System.out.println(longString("aacabdkacaa"));

    }
    public static String longString(String str){
        char[][] dp=new char[str.length()][str.length()];
        char[] charstr=str.toCharArray();
        int maxLen=1;
        int begin=0;
        //string拆分成两个X轴和Y轴一致的一张二维表格，i和j相同未知的数据一定是相同的，设置为T，循环X轴和Y轴，
        // 因为是对角线为分界，所以循环的y轴即j只需要从i+1开始循环

        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j < str.length(); j++) {
                //基于二维数组，对角线一定一样数据的逻辑，所以如果i和j相同的情况下，该未知的数据为T
                if(i==j){
                    dp[i][j]='T';
                    continue;
                }
                //当找到i未知和j未知上的char一样的情况下，就需要遍历该位置的斜下方位置的数据都必须为T直到遍历到中轴线为止都必须为T
                if (charstr[i]==charstr[j]){
                    dp[i][j] = 'T';
                    int left=i;
                    int right=j;
                    while(left<right){
                        if(charstr[left+1]!=charstr[right-1]){
                            dp[i][j] = 'F';
                            break;
                        }
                        left++;
                        right--;
                    }
                    //如果从i和j的位置遍历往斜下方直到中线位置都是T那就表示为该位置之前的位置都是一致的
                    if(dp[i][j]=='T'){
                        if(j-i+1>maxLen) {
                            begin = i;
                            maxLen = j - i + 1;
                        }
                    }

                }
            }
        }
        return str.substring(begin,begin+maxLen);
    }


}
