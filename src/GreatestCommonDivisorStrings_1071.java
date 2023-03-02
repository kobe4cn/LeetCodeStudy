/*
 * @lc app=leetcode.cn id=1071 lang=java
 *
 * [1071] 字符串的最大公因子
 */

// @lc code=start
class GreatestCommonDivisorStrings_1071 {
    public String gcdOfStrings(String s1, String s2) {
        StringBuilder str1=new StringBuilder(s1);
        StringBuilder str2=new StringBuilder(s2);
        int len1=str1.length();
        int len2=str2.length();
        if(len1>len2){
            while(str2.length()>=0){
            String replaceAll1 = s1.replaceAll(str2.toString(), "");
            String replaceAll2= s2.replaceAll(str2.toString(), "");
            if(replaceAll1.equals("") && replaceAll2.equals("")){
                return str2.toString();
            }else{
                int temp=str2.length()-1;
                if(temp<0){
                    break;
                }
                str2.deleteCharAt(temp);
            }
            }
        }else{
            while(str1.length()>=0){
                String replaceAll1 = s2.replaceAll(str1.toString(), "");
                String replaceAll2= s1.replaceAll(str1.toString(), "");
                if(replaceAll1.equals("") && replaceAll2.equals("")){
                    return str1.toString();
                }else{
                    int temp=str1.length()-1;
                    if(temp<0){
                        break;
                    }
                    str1.deleteCharAt(temp);
                }
                }
        }
        return "";
    }
}
// @lc code=end

