import java.util.Arrays;
import java.util.LinkedList;

//703. 数据流中的第 K 大元素
public class KthLargest {
    //    List<Integer> list;
//    int[] num;
//    int[] num;
    LinkedList<Integer> list;
    int kn;

    public KthLargest(int k, int[] nums) {
        list = new LinkedList<>();

            Arrays.stream(nums).forEach(value -> list.add(value));
        kn = k - 1;
    }

    public int add(int val) {
        //list.add(val);
        //list=list.stream().sorted((o1, o2) -> o2-o1).toList();

        list.add(val);
        list.sort((o1, o2) -> o2 - o1);

        return list.get(kn);
    }

    public static void main(String[] args) {
        int[] nums = {-10, 1, 3, 1, 4, 10, 3, 9, 4, 5, 1};//{4, 5, 8, 2};//[[7,[-10,1,3,1,4,10,3,9,4,5,1]]
        KthLargest kthLargest = new KthLargest(7, nums);
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8
    }
}
