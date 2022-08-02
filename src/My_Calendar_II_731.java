import java.util.TreeMap;

public class My_Calendar_II_731 {
//    TreeMap<Integer, List<Integer>> map;
    TreeMap<Integer,Integer> map;
    public My_Calendar_II_731() {
map=new TreeMap<>();
    }

    public boolean book(int start, int end) {
        map.put(start,map.getOrDefault(start,0)+1);
        map.put(end,map.getOrDefault(end,0)-1);
        int active=0;
        for (int i :map.values()) {
            active+=i;
            if(active>=3){
                map.put(start,map.get(start)-1);
                map.put(end,map.get(end)+1);
                return  false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        My_Calendar_II_731 MyCalendar = new My_Calendar_II_731();
        MyCalendar.book(10, 20); // returns true
        MyCalendar.book(50, 60); // returns true
        MyCalendar.book(10, 40); // returns true
        MyCalendar.book(5, 15); // returns false
        MyCalendar.book(5, 10); // returns true
        MyCalendar.book(25, 55); // returns true


    }
}
