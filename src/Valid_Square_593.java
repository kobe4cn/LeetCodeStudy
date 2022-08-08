import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//593. 有效的正方形
public class Valid_Square_593 {

    int xcount;
    int ycount;
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        //判断是否超过两个点再同一直线上
        xcount=0;
        ycount=0;
        List<Integer> list=new ArrayList<>();
        //p1-p2
        int side1=getLen(p1,p2);
        list.add(side1);
        //p1-p3
        int side2=getLen(p1,p3);
        list.add(side2);
        //p1-p4
        int side3=getLen(p1,p4);
        list.add(side3);
        //p2-p3
        int side4=getLen(p2,p3);
        list.add(side4);
        //p2-p4
        int side5=getLen(p2,p4);
        list.add(side5);
        //p3-p4
        int side6=getLen(p3,p4);
        list.add(side6);
        if(xcount>2){
            return false;
        }
        if(ycount>2){
            return false;
        }
        List<Integer> collect = list.stream().distinct().collect(Collectors.toList());
        if(collect.size()>2){
            return false;
        }
        if(collect!=null && collect.size()==2){
            int x=collect.get(0);
            int y=collect.get(1);
            if(x<y && (x*2)!=y){
                return false;
            }else if(x>y && (2*y)!=x){
                return false;
            }
        }
        return true;
    }

    public int getLen(int[] p1,int[] p2){
        int p1x=p1[0];
        int p1y=p1[1];
        int p2x=p2[0];
        int p2y=p2[1];
        if(p1x==p2x) {
            xcount++;
        }
        if(p1y==p2y){
            ycount++;
        }
        int x=Math.abs(p1x-p2x);
        int y=Math.abs(p1y-p2y);
        if(x==0){
            return (int)Math.pow(y,2);
        }else if(y==0){
            return (int)Math.pow(x,2);
        }else{
            return (int)(Math.pow(x,2)+Math.pow(y,2));
        }
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] p1 = stringToIntegerArray(line);
            line = in.readLine();
            int[] p2 = stringToIntegerArray(line);
            line = in.readLine();
            int[] p3 = stringToIntegerArray(line);
            line = in.readLine();
            int[] p4 = stringToIntegerArray(line);

            boolean ret = new Valid_Square_593().validSquare(p1, p2, p3, p4);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }

}
