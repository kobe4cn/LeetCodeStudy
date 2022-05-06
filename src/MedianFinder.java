// Find Median from Data Stream 295

import java.util.*;
import java.util.stream.Collectors;

public class MedianFinder  {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        min=new PriorityQueue<>();

        max=new PriorityQueue<>((o1, o2) -> o2-o1);
    }

    public void addNum(int num) {
        max.add(num);
        min.add(max.remove());
        if(min.size()>max.size()){
            max.add(min.remove());
        }
    }
    public double findMedian() {
        if(max.size()==min.size()){
            return (max.peek()+min.peek())/2.0;

        }else{
            return max.peek();
        }
    }
    /*
    *可以实现但是算法复杂度太大了，每次都需要重新对数组进行排序

    transient int[] nums;
    public MedianFinder() {
        nums=new int[0];
    }
    public void addNum(int num) {
        int len=nums.length;
        if(len==0){
            nums=new int[1];
            nums[0]=num;
        }else{
            int[] temp = Arrays.copyOf(nums, len + 1);
            temp[len]=num;
            if(temp[len-1]<num){
                nums=temp;
            }else {
                nums = Arrays.stream(temp).sorted().toArray();
            }
            }
    }
    public double findMedian() {
        int len=nums.length;
        if (len == 1) {
            return nums[0];
        } else {
            int singleordouble = len % 2;
            int temp = len / 2;
            if (singleordouble == 0) {

                return (nums[temp] + nums[temp-1])/2.0;

            } else {
                return nums[temp];
            }
        }
    }
    */
    public static void main(String[] args) {
        MedianFinder finder=new MedianFinder();
        finder.addNum(-1);
        System.out.println(finder.findMedian());
        finder.addNum(-2);
        System.out.println(finder.findMedian());
        finder.addNum(-3);
        System.out.println(finder.findMedian());
        finder.addNum(-4);
        System.out.println(finder.findMedian());
        finder.addNum(-5);
        System.out.println(finder.findMedian());
    }




}
