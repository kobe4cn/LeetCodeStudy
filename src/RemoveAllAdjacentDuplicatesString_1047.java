/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] 删除字符串中的所有相邻重复项
 */

// @lc code=start
class RemoveAllAdjacentDuplicatesString_1047 {
    public String removeDuplicates(String str) {
        //System.out.println(s.charAt(0));
        StringBuilder s=new StringBuilder(str);
        
        
        int strlen=s.length();
        for (int i = 0; i < strlen-1; i++) {
                if(s.charAt(i)==s.charAt(i+1)){
                    s.delete(i, i+2);
                    i=i==0?-1:i-2;
                    strlen=s.length();
                    continue;
                }
        }
        return s.toString();
    }
}
// @lc code=end

