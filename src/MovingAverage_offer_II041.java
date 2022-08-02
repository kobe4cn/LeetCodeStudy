import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage_offer_II041 {
    int size;
    Queue<Integer> queue;
    public MovingAverage_offer_II041(int size) {
        this.size=size;
        queue=new LinkedList<>();
    }

    public double next(int val) {
        if(queue.size()<size){
            queue.offer(val);
        }else{
            queue.poll();
            queue.offer(val);
        }
        return queue.stream().mapToDouble(Integer::doubleValue).sum()/queue.size();
    }
}
