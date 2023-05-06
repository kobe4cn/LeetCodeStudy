/*
 * @lc app=leetcode.cn id=2432 lang=java
 *
 * [2432] 处理用时最长的那个任务的员工
 */

// @lc code=start
class EmployeeWorkedLongestTask_2432 {
    public int hardestWorker(int n, int[][] logs) {
        int maxvalue=0;
        int num=0;
        for (int i = 0; i < logs.length; i++) {
            if(i==0){
                maxvalue=logs[i][1]-0;
                num=logs[i][0];
            }else{
                int value=logs[i][1]-logs[i-1][1];
                if(maxvalue<value){
                   
                        maxvalue=value;
                        num=logs[i][0];
                    
                }else if(maxvalue==value){
                    if(logs[i][0]<num){
                        maxvalue=value;
                        num=logs[i][0];
                    }
                }
            }

        }
        return num;
    }
}
// @lc code=end

