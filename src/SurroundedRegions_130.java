import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//130. 被围绕的区域
public class SurroundedRegions_130 {
    public void solve(char[][] board) {
        //数组的第一行，第一列，最后一行，最后一列都不需要扫描，边界上面的0不会被X填充，所以不用去管
        //遍历行，从第二行，第二列开始遍历
        int row=1;//行

        //初始化边框中含o为F
        initboard(board);
       //列
        while(row<board.length-1){
            int line=board[row].length;
            int list=1;
            while(list<line-1){
                //判断是否为o
                if(board[row][list]=='O'){
                   // board[row][list]='S';
                    List<int[]> falseMap =new ArrayList<>();
                    if(checkBorad(board,row,list,falseMap)){

                        board[row][list]='X';
                    }else{
                        board[row][list]='F';
                    }
                }
                list++;
            }
            row++;
        }

        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[i].length ; j++) {
                if(board[i][j]=='F')
                    board[i][j]='O';

            }
        }

            //遍历列
    }

    public void initboard(char[][] board){
        int i=0;
        while(i<board.length){
            if(i==0 || i== board.length-1){
                int k=0;
                while(k<board[i].length-1){
                    if(board[i][k]=='O')
                        board[i][k]='F';
                k++;
                }
            }else{
                int k=0;
                int line=board[i].length-1;
                if(board[i][k]=='O' ){
                    board[i][k]='F';
                }
                if(board[i][line]=='O'){
                    board[i][line]='F';
                }
            }
            i++;
        }
    }

    public boolean checkBorad(char[][] board,int row,int list,List<int[]> falseMap){
        //总行
        int totalrow=board.length;
//        //总列
        int totallist=board[0].length;
        List<int[]> temp=new ArrayList<>();
        int check=0;
        //判断左，上，右，下
        char left=board[row][list-1];
        char up=board[row-1][list];
        char right=board[row][list+1];
        char down=board[row+1][list];
        check+=left=='X'?1:0;
        check+=up=='X'?1:0;
        check+=right=='X'?1:0;
        check+=down=='X'?1:0;
        if(check==4){
            return true;
        }
        if(left=='F' || right=='F' || up=='F'||down=='F'){
            board[row][list]='F';
            return false;
        }
        if(left=='O'){
            int[] r={row,list-1};
            temp.add(r);
        }
        if(up=='O'){
            int[] r={row-1,list};
            temp.add(r);
        }
        if(right=='O'){
            int[] r={row,list+1};
            temp.add(r);
        }
        if(down=='O'){
            int[] r={row+1,list};
            temp.add(r);
        }
        int[] point={row,list};
        falseMap.add(point);
        board[row][list]='S';
        boolean ret=true;
        for (int[] ar:temp
             ) {
            if(board[ar[0]][ar[1]]!='S'){
                if(!checkBorad(board,ar[0],ar[1],falseMap)){
                    ret=false;
                    board[ar[0]][ar[1]]='F';
                    changeFalseMap(falseMap,board);
                }
            }
        }
        if(!ret){
            board[row][list]='F';
            changeFalseMap(falseMap,board);
            return false;
        }
        //这里只是假设找到递归到最后一个节点，它可能也依赖于别的节点来判断，这里只能假设其他的节点都是成功能的，因为目前这个最终点的其他节点都满足true，只有关联的节点不明确，因为之前的节点可能存在其他1个或者三个节点需要再去dfs遍历查询
        //这样只能假设父节点是没有问题的为真，因为父节点的其他点还没有判断，不过这些点都被存在falsemap里面，最终只有有任何一个节点返回false的情况下，又会重置之前可能被误判为true的节点。

        board[row][list]='X';
        return ret;
    }

    public void changeFalseMap(List<int[]> map,char[][] board){
        for(int[] s:map){
            board[s[0]][s[1]]='F';
        }
    }

    //判断上下左右是否都被x包围，如果被包围则该位置设置成x
    //如果周围出现o，那需要判断o目前所处的位置是否为边界，以及该0周围是否有x包围
//    public void setFalse(char[][] board,int row,int list,int gao,int chang,List<int[]> map){
//        if(row-1>0){
//            if(board[row-1][list]=='O'){
//                board[row-1][list]='F';
//                int[] temp={row-1,list};
//                map.add(temp);
//            }
//        }
//        if(row+1<gao-1){
//            if(board[row+1][list]=='O'){
//                board[row+1][list]='F';
//                int[] temp={row+1,list};
//                map.add(temp);
//            }
//        }
//        if(list-1>0){
//            if(board[row][list-1]=='O'){
//                board[row][list-1]='F';
//                int[] temp={row,list-1};
//                map.add(temp);
//            }
//        }
//        if(list+1<chang-1){
//            if(board[row][list+1]=='O'){
//                board[row][list+1]='F';
//                int[] temp={row,list+1};
//                map.add(temp);
//            }
//        }
//    }
//    public boolean checkBorad(char[][] board,int row,int list,List<int[]> falseMap){
//        board[row][list]='S';
//        //int[] ints={row,list};
//        //tempboard.add(ints);
//        //总行
//        int totalrow=board.length;
//        //总列
//        int totallist=board[0].length;
//        int check=0;
//        //判断左边
//        if(board[row][list-1]=='X'){
//            check++;
//        }else{
//            if(list-1!=0){
//                if(board[row][list-1]=='F'){
//                    board[row][list]='F';
//                    int[] tp={row,list};
//                    falseMap.add(tp);
//                    return false;
//                }
//                if(board[row][list-1]=='S'){
//                    check++;
//                }
//                if(board[row][list-1]=='O') {
//                    boolean checks = checkBorad(board, row , list-1,falseMap);
//                    if (checks) {
//                        board[row][list-1]='X';
//                        check++;
//                    } else {
//                        board[row][list] = 'F';
//                        board[row][list-1]='F';
//                        int[] tp1={row,list-1};
//                        falseMap.add(tp1);
//                        int[] tp={row,list};
//                        falseMap.add(tp);
//                        return false;
//                    }
//                }
//            }else {
//                board[row][list]='F';
//                int[] tp={row,list};
//                falseMap.add(tp);
//                return false;
//            }
//        }
//        //判断上
//        if(board[row-1][list]=='X'){
//            check++;
//        }else{
//            //判断o是否在边界上面
//            if(row-1!=0){
//                if(board[row-1][list]=='F'){
//                    board[row][list]='F';
//                    int[] tp={row,list};
//                    falseMap.add(tp);
//                    return false;
//                }
//                if(board[row-1][list]=='S'){
//                    check++;
//                }
//                if(board[row-1][list]=='O') {
//                    boolean checks = checkBorad(board, row - 1, list,falseMap);
//                    if (checks) {
//                        board[row-1][list]='X';
//                        check++;
//                    } else {
//                       board[row][list] = 'F';
//                       board[row-1][list]='F';
//                       int[] tp1={row-1,list};
//                       falseMap.add(tp1);
//                        int[] tp={row,list};
//                        falseMap.add(tp);
//                        return false;
//                    }
//                }
//            }else {
//                board[row][list]='F';
//                int[] tp={row,list};
//                falseMap.add(tp);
//                return false;
//            }
//        }
//        //判断右边
//        if(board[row][list+1]=='X'){
//            check++;
//        }else{
//            if(list+1!=totallist-1){
//                if(board[row][list+1]=='F'){
//                    board[row][list]='F';
//                    int[] tp={row,list};
//                    falseMap.add(tp);
//                    return false;
//                }
//                if(board[row][list+1]=='S'){
//                    check++;
//                }
//                if(board[row][list+1]=='O') {
//                    boolean checks = checkBorad(board, row , list+1,falseMap);
//                    if (checks) {
//                        board[row][list+1]='X';
//                        check++;
//                    } else {
//                        board[row][list] = 'F';
//                        board[row][list+1]='F';
//                        int[] tp1={row,list+1};
//                        falseMap.add(tp1);
//                        int[] tp={row,list};
//                        falseMap.add(tp);
//                        return false;
//                    }
//                }
//            }else {
//                board[row][list]='F';
//                int[] tp={row,list};
//                falseMap.add(tp);
//                return false;
//            }
//        }
//        //判断下
//        if(board[row+1][list]=='X'){
//            check++;
//        }else{
//            if(row+1!=totalrow-1){
//                if(board[row+1][list]=='F'){
//                   board[row][list]='F';
//                    int[] tp={row,list};
//                    falseMap.add(tp);
//                    return false;
//                }
//                if(board[row+1][list]=='S'){
//                    check++;
//                }
//                if(board[row+1][list]=='O') {
//                    boolean checks = checkBorad(board, row + 1, list,falseMap);
//                    if (checks) {
//                        board[row+1][list]='X';
//                        check++;
//                    } else {
//                        board[row][list] = 'F';
//                        board[row+1][list]='F';
//                        int[] tp1={row+1,list};
//                        falseMap.add(tp1);
//                        int[] tp={row,list};
//                        falseMap.add(tp);
//                        return false;
//                    }
//                }
//            }else {
//                board[row][list]='F';
//                int[] tp={row,list};
//                falseMap.add(tp);
//                return false;
//            }
//        }
//
//
//
//        if(check==4){
//            return true;
//        }
//       // board[row][list]='F';
//        return false;
//    }

    public static void main(String[] args) {
//        char[][] chars={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
//        char[][] chars={{'O','O','O'},{'O','O','O'},{'O','O','O'}};
        char[][] chars={{'X','O','X','O','X','O','O','O','X','O'}
                       ,{'X','O','O','X','X','X','O','O','O','X'}
                       ,{'O','O','O','O','O','O','O','O','X','X'}
                       ,{'O','O','O','O','O','O','X','O','O','X'}
                       ,{'O','O','X','X','O','X','X','O','O','O'}
                       ,{'X','O','O','X','X','X','O','X','X','O'}
                       ,{'X','O','X','O','O','X','X','O','X','O'}
                       ,{'X','X','O','X','X','O','X','O','O','X'} //
                       ,{'O','O','O','O','X','O','X','O','X','O'}
                       ,{'X','X','O','X','X','X','X','O','O','O'}};
//                        {{'O','X','O','O','O','X'}
//                       ,{'O','O','X','X','X','O'}
//                       ,{'X','X','X','X','X','O'}
//                       ,{'O','O','O','O','X','X'}
//                       ,{'X','X','O','O','X','O'}
//                       ,{'O','O','X','X','X','X'}};

//                {{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
//                {{'X','O','X','X'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'}};
        new SurroundedRegions_130().solve(chars);

        System.out.println(Arrays.asList(Arrays.stream(chars).toList()));
    }

}
