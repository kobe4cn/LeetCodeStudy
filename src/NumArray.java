//307. 区域和检索 - 数组可修改
public class NumArray {
    int[] numarr;
    public NumArray(int[] nums) {
        numarr=nums;
    }

    public void update(int index, int val) {
        numarr[index]=val;
    }

    public int sumRange(int left, int right) {
        int temp=0;
        while(left<=right){
            temp=temp+numarr[left];
            left++;
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] nums={1, 3, 5};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0,2));
        numArray.update(1,2);
        System.out.println(numArray.sumRange(0,2));
    }
}