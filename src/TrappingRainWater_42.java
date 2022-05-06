import java.util.Arrays;
import java.util.Comparator;

public class TrappingRainWater_42 {
    public static void main(String[] args) {
        //6
        //int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        //9
        //int[] height={4,2,0,3,2,5};
        //1
        //int[] height = {4, 2, 3};
        //1
        //int[] height={5,4,1,2};
        //83
        int[] height={6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3};

        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
//        int[] heightsort=Arrays.stream(height).toArray();
        //目前最高的柱子
        int high = height[0];
        int waters=getWater(height,high);

//        if(waters==0){
//            int[] heightrev=new int[height.length];
//            for (int i = 0; i < height.length; i++) {
//                heightrev[i]=height[height.length-1-i];
//            }
//            high = heightrev[0];
//            waters=getWater(heightrev,high);
//        }
        //第一个和最后一个是不能存在水收集可能的
        return waters;
    }


    public static int getWater(int[] height,int high){
        //目前最高柱子的索引
        int highestindex = 0;
        int waters = 0;
        int watertemp = 0;
        for (int i = 0; i < height.length; i++) {

            if (i + 1 < height.length) {
                int water = high - height[i + 1];
                if (water > 0)
                    watertemp = watertemp + water;
                else if (water <= 0) {
                    waters = waters + watertemp;
                    watertemp = 0;
                    high = height[i + 1];
                    highestindex = i + 1;
                    i = highestindex - 1;
                }
            } else if (highestindex + 1 < height.length) {
                //从最后一个往highestindex找
                int len=height.length-highestindex;
                int[] l=new int[len];
                for (int j = 0; j < len; j++) {
                    l[j]=height[height.length-1-j];
                }
                watertemp = 0;
                high=l.length>0?l[0]:0;
                //highestindex=0;
                //watertemp=0;
                waters=waters+getWater(l,high);
            }
        }
        return waters;
    }
}
