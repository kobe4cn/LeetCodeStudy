import java.util.Arrays;
import java.util.stream.IntStream;

public class MedianofTwoSortedArrays_4 {
    public static void main(String[] args) {


        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1 = nums1.length;
        int num2 = nums2.length;
        int[] num = Arrays.copyOf(nums1, num1 + num2);
        System.arraycopy(nums2, 0, num, num1, num2);
        int[] ints = Arrays.stream(num).sorted().toArray();
        if (ints.length == 1) {
            return ints[0];
        } else {
            int singleordouble = (num1 + num2) % 2;
            int temp = (num1 + num2) / 2;
            if (singleordouble == 0) {

                return (ints[temp] + ints[temp - 1])/2.0;

            } else {
                return ints[temp];
            }
        }
    }
}
