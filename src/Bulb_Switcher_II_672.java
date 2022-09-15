//672. 灯泡开关 Ⅱ
public class Bulb_Switcher_II_672 {
    public int flipLights(int n, int m) {
        switch(n){
            case 0:
                return 0;
            case 1:
                int temp=m>0?1:0;
                return temp+1;
            case 2:
               int temp1= m>1?1:0;
               int temp2=m>0?1:0;
                return (temp1+temp2*2+1);
        }
        switch(m){
            case 0:
                return 1;
            case 1:
                return 4;
            case 2:
                return 7;
        }
        return 8;
    }

}
