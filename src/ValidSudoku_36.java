import java.util.ArrayList;
import java.util.List;

//36. 有效的数独
public class ValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        List<Character> s0=new ArrayList<>();
        List<Character> s1=new ArrayList<>();
        List<Character> s2=new ArrayList<>();
        List<Character> s3=new ArrayList<>();
        List<Character> s4=new ArrayList<>();
        List<Character> s5=new ArrayList<>();
        List<Character> s6=new ArrayList<>();
        List<Character> s7=new ArrayList<>();
        List<Character> s8=new ArrayList<>();

        for (int i = 0; i < len; i++) {
            List<Character> linelist = new ArrayList<>();
            List<Character> rowlist = new ArrayList<>();
            char[] row = board[i];
            for (char c : row) {
                if (c != '.') {
                    rowlist.add(c);
                }
            }
            //判断行是否有重复的数字
            long rowsize = rowlist.size();
            long rowsizedist = rowlist.stream().distinct().count();
            if (rowsize != rowsizedist) {
                return false;
            }

            for (int j = 0; j < len; j++) {
                //去掉点
                if (board[j][i] != '.') {
                    linelist.add(board[j][i]);
                }
                if (i < 3) {
                    if(j<3){
                        char temp=board[i][j];
                        if(temp!='.'){
                            s0.add(temp);
                        }
                    }
                    if(j>=3 && j<6){
                        char temp=board[i][j];
                        if(temp!='.'){
                            s1.add(temp);
                        }
                    }
                    if(j>=6){
                        char temp=board[i][j];
                        if(temp!='.'){
                            s2.add(temp);
                        }
                    }
                } else if (i >= 3 && i < 6) {
                    if(j<3){
                        char temp=board[i][j];
                        if(temp!='.'){
                            s3.add(temp);
                        }
                    }
                    if(j>=3 && j<6){
                        char temp=board[i][j];
                        if(temp!='.'){
                            s4.add(temp);
                        }
                    }
                    if(j>=6){
                        char temp=board[i][j];
                        if(temp!='.'){
                            s5.add(temp);
                        }
                    }
                } else if (i >= 6) {
                    if(j<3){
                        char temp=board[i][j];
                        if(temp!='.'){
                            s6.add(temp);
                        }
                    }
                    if(j>=3 && j<6){
                        char temp=board[i][j];
                        if(temp!='.'){
                            s7.add(temp);
                        }
                    }
                    if(j>=6){
                        char temp=board[i][j];
                        if(temp!='.'){
                            s8.add(temp);
                        }
                    }
                }


            }
            //判断一列是否有重复的数字
            long linesize = linelist.size();
            long linesizedit = linelist.stream().distinct().count();
            if (linesize != linesizedit) {
                return false;
            }


        }
        if(s0.size()!=s0.stream().distinct().count()){
            return false;
        }
        if(s1.size()!=s1.stream().distinct().count()){
            return false;
        }
        if(s2.size()!=s2.stream().distinct().count()){
            return false;
        }
        if(s3.size()!=s3.stream().distinct().count()){
            return false;
        }
        if(s4.size()!=s4.stream().distinct().count()){
            return false;
        }
        if(s5.size()!=s5.stream().distinct().count()){
            return false;
        }
        if(s6.size()!=s6.stream().distinct().count()){
            return false;
        }
        if(s7.size()!=s7.stream().distinct().count()){
            return false;
        }
        if(s8.size()!=s8.stream().distinct().count()){
            return false;
        }


        return true;
    }


}
