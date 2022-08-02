import java.util.LinkedList;

public class Design_Circular_Queue_622 {
    LinkedList<Integer> queue;
    int size;
    public Design_Circular_Queue_622(int k) {
        queue=new LinkedList<>();
        size=k;
    }

    public boolean enQueue(int value) {
        if(queue.size()<size){
            queue.offer(value);
            return true;
        }else{
            return false;
        }
    }

    public boolean deQueue() {
        if(queue.poll()!=null){
            return true;
        }else{
            return false;
        }
    }

    public int Front() {
        if(queue==null || queue.size()==0){
            return -1;
        }else {
         return   queue.getFirst();
        }
    }

    public int Rear() {
        if(queue==null || queue.size()==0){
            return -1;
        }else {
            return   queue.getLast();
        }
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean isFull() {
        if(queue!=null && queue.size()==size){
            return true;
        }else{
            return false;
        }
    }
}
