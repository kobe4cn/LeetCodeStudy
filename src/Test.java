import java.util.ArrayList;

public class Test {
    public static  ArrayList<Integer> watch(ArrayList<Integer> blist){
        ArrayList<Integer> list=new ArrayList<>();
        blist.stream().forEach(integer -> {
            if(integer%2==0){
                list.add(integer);
            }
        });
        return list;
    }


    public static void main(String args[]){
        if(3%2==0){
            System.out.println("test");
        }
    }
}
