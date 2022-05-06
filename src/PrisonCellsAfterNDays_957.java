import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PrisonCellsAfterNDays_957 {

    public static void main(String[] args) {
        int[] cells = {0, 1, 0, 1, 1, 0, 0, 1};
        System.out.println(Arrays.toString(prisonAfterNDays(cells,100000000)));
       // System.out.println(list);


    }

    public static int[] prisonAfterNDays(int[] cells, int n) {
        HashSet<String> set=new HashSet<>();
        boolean hasCycle=false;
        int count=0;
        if (cells == null || cells.length == 0 || n <= 0) {
            return cells;
        }

        for (int i = 0; i < n; i++) {
            int[] next = nextDay(cells);

            String s=Arrays.toString(next);
            //System.out.println("when i= " + i + " the key is " + Arrays.toString(next));
            if (!set.contains(s)){
                set.add(s);
                count++;
            }else{
                hasCycle=true;
                break;
            }
            cells = next;
        }
        if (hasCycle) {

            n= n % count;
            for (int i = 0; i < n; i++) {
                cells=nextDay(cells);
            }
        }
        return cells;
    }

    public static int[] nextDay(int[] cells) {
        int[] tmp = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++) {
            tmp[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        }
        return tmp;
    }
}
