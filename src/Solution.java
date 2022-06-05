import java.util.Random;

//478. 在圆内随机生成点
public class Solution {
    Random random;
    double r;
    double x;
    double y;
    public Solution(double radius, double x_center, double y_center) {
        random=new Random();
        r=radius;
        x=x_center;
        y=y_center;
    }

    public double[] randPoint() {

        while(true){
            double randx=random.nextDouble()*(r*2)-r;
            double randy=random.nextDouble()*(r*2)-r;
            if(randx*randx+randy*randy<=r*r){
                return new double[]{randx+x,randy+y};
            }
        }
    }
}
