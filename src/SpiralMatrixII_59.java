import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//59. 螺旋矩阵 II
public class SpiralMatrixII_59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        // 循环次数
        int loop = n / 2;

        // 定义每次循环起始位置
        int startX = 0;
        int startY = 0;

        // 定义偏移量
        int offset = 1;

        // 定义填充数字
        int count = 1;

        // 定义中间位置
        int mid = n / 2;
        while (loop > 0) {
            int i = startX;
            int j = startY;

            // 模拟上侧从左到右
            for (; j<startY + n -offset; ++j) {
                res[startX][j] = count++;
            }

            // 模拟右侧从上到下
            for (; i<startX + n -offset; ++i) {
                res[i][j] = count++;
            }

            // 模拟下侧从右到左
            for (; j > startY; j--) {
                res[i][j] = count++;
            }

            // 模拟左侧从下到上
            for (; i > startX; i--) {
                res[i][j] = count++;
            }

            loop--;

            startX += 1;
            startY += 1;

            offset += 2;
        }

        if (n % 2 == 1) {
            res[mid][mid] = count;
        }

        return res;
    }


    public static String int2dArrayToString(int[][] array) {
        if (array == null) {
            return "null";
        }
        if (array.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int[] item1 : array) {
            for(int item:item1) {
                sb.append(Integer.toString(item));
                sb.append(",");
            }
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int[][] ret = new SpiralMatrixII_59().generateMatrix(n);

            String out = int2dArrayToString(ret);

            System.out.print(out);
        }
    }


//        if(xflag){
//                if(xincrease) {
//                    if (x+1<=n) {
//                        if(result[y][x]==0) {
//                            result[y][x] = i;
//                            x++;
//                        }else{
//                            xflag = false;
//                            xincrease=false;
//                            yincrease=true;
//                            y++;
//                        }
//                    } else {
//                        xflag = false;
//                        xincrease=false;
//                        yincrease=true;
//                        y++;
//                    }
//                }else{
//                    if (x-1>=0) {
//                        if(result[y][x]==0) {
//                            result[y][x] = i;
//                            x--;
//                        }else{
//                            xflag = false;
//                            xincrease=true;
//                            yincrease=false;
//                            y--;
//                        }
//                    } else {
//                        xflag = false;
//                        xincrease=true;
//                        yincrease=false;
//                        y--;
//                    }
//                }
//            }else{
//                if(yincrease) {
//                    if (y+1<=n) {
//                        if(result[y][x]==0) {
//                            result[y][x] = i;
//                            y++;
//                        }else{
//                            xflag = true;
//                            yincrease=false;
//                            x--;
//                        }
//                    } else {
//                        xflag = true;
//                        yincrease=false;
//                        x--;
//                    }
//                }else{
//                    if (y-1>=0) {
//                        if(result[y][x]==0) {
//                            result[y][x] = i;
//                            y--;
//                        }else{
//                            xflag = true;
//                            yincrease=true;
//                            x--;
//                        }
//                    } else {
//                        xflag = true;
//                        yincrease=true;
//                        x--;
//                    }
//                }
//            }
//        }
}
