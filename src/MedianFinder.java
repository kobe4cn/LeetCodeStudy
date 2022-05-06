// Find Median from Data Stream 295

import java.util.*;
import java.util.stream.Collectors;

public class MedianFinder  {
    List<Integer> nums;
//    SortedSet<Integer> nums;
    public MedianFinder() {
        nums=new ArrayList<>();

    }

    public void addNum(int num) {
        if(nums.size()==0){
            nums.add(num);
        }
        else if(num<nums.get(0)){
            List<Integer> temp=new ArrayList<>(nums);
            nums.clear();
            nums.add(num);
            nums.addAll(temp);
        }else if(num>nums.get(nums.size()-1)){
            nums.add(num);
        }else {
            nums.add(num);
            nums = nums.stream().sorted().collect(Collectors.toList());
        }
    }

    public double findMedian() {


        if (nums.size() == 1) {
            return nums.get(0);
        } else {
            int singleordouble = nums.size() % 2;
            int temp = nums.size() / 2;
            if (singleordouble == 0) {

                return (nums.get(temp) + nums.get(temp-1))/2.0;

            } else {
                return nums.get(temp);
            }
        }
    }

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
