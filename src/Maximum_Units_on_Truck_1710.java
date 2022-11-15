import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//1710. 卡车上的最大单元数
public class Maximum_Units_on_Truck_1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        List<int[]> collect = Arrays.stream(boxTypes).sorted((o1, o2) -> o2[1] - o1[1]).collect(Collectors.toList());

        int total=0;
        for (int i = 0; i < collect.size() ; i++) {
            int[] ints = collect.get(i);
            if(truckSize>0){
                if(truckSize>ints[0]){
                    truckSize=truckSize-ints[0];
                    total+=ints[0]*ints[1];
                }else{
                    total+=truckSize*ints[1];
                    truckSize=0;
                }
            }
        }
        return total;
    }

    public static  void main(String[] args){
        int[][] boxTypes={{5,10},{2,5},{4,7},{3,9}};
        int trucksize=10;
        Maximum_Units_on_Truck_1710 maximum_units_on_truck_1710=new Maximum_Units_on_Truck_1710();
        int i = maximum_units_on_truck_1710.maximumUnits(boxTypes, trucksize);
        System.out.println(i);
    }
}
