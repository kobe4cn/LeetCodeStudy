//2682 · 一年的第 N 天
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Lintcode_2682 {
    public String specificCates(int year, int day) throws ParseException {
        // -- write your code here --
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,0);
        calendar.set(Calendar.DAY_OF_MONTH,0);
        calendar.add(calendar.DATE,day);
        Date time=calendar.getTime();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(time);
    }
}
