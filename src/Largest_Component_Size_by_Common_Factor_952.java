import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//952. 按公因数计算最大组件大小
public class Largest_Component_Size_by_Common_Factor_952 {
    public int largestComponentSize(int[] nums) {
        List<Integer> list2=new ArrayList<>();
        List<Integer> list3=new ArrayList<>();
        List<Integer> list5=new ArrayList<>();
        List<Integer> list7=new ArrayList<>();
        List<Integer> result=new ArrayList<>();
       // int list2=0,list3=0,list5=0,list7=0;
        for (int i = 0; i < nums.length; i++) {
            int count=0;
            List<Integer> list=new ArrayList<>();
            if(nums[i]%2==0){
                list2.add(nums[i]);
                list.add(2);
            }
            if(nums[i]%3==0){
                list3.add(nums[i]);
                list.add(3);            }
            if(nums[i]%5==0){
                list5.add(nums[i]);
                list.add(5);
            }
            if(nums[i]%7==0){
                list7.add(nums[i]);
                list.add(7);
            }
            if(list.size()>1){
                if(result.size()==0) {
                    result.addAll(list);
                }
                else {
                    for (int j = 0; j < list.size(); j++) {
                        if(result.contains(list.get(j))){
                            result.addAll(list);
                            break;
                        }
                    }
                }
//                if(result.stream().distinct().count()==4){
//                    return nums.length;
//                }
            }
        }
        List<Integer> collect = result.stream().distinct().collect(Collectors.toList());
        List<Integer> res=new ArrayList<>();
        for (int i = 0; i < collect.size(); i++) {
            if(collect.get(i)==2){
                res.addAll(list2);
                list2=null;
            }else if(collect.get(i)==3){
                res.addAll(list3);
                list3=null;
            }else if(collect.get(i)==5){
                res.addAll(list5);
                list5=null;
            }else if(collect.get(i)==7){
                res.addAll(list7);
                list7=null;
            }
        }
        int max = (int)res.stream().distinct().count();

        int l2=0,l3=0,l5=0,l7=0;
        if(list2!=null){
            l2=list2.size();
            max=Math.max(max,l2);
        }
        if(list3!=null){
            l3=list3.size();
            max=Math.max(max,l3);
        }
        if(list5!=null){
            l5=list5.size();
            max=Math.max(max,l5);
        }
        if(list7!=null){
            l7=list7.size();
            max=Math.max(max,l7);
        }
        return max;



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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            int ret = new Largest_Component_Size_by_Common_Factor_952().largestComponentSize(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
