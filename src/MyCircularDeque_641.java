import java.util.LinkedList;

//641. 设计循环双端队列
public class MyCircularDeque_641 {
    LinkedList<Integer> list;
    int size;
    public MyCircularDeque_641(int k) {
        size=k;
        list=new LinkedList<>();
    }

    public boolean insertFront(int value) {
        if(list.size()==size){
            return false;
        }
        return list.offerFirst(value);
    }

    public boolean insertLast(int value) {
        if(list.size()==size){
            return false;
        }
        return list.offerLast(value);
    }

    public boolean deleteFront() {
        Integer first = list.pollFirst();
        if(first==null){
            return false;
        }else{
            return true;
        }
    }

    public boolean deleteLast() {
        Integer last = list.pollLast();
        if(last==null){
            return false;
        }else{
            return true;
        }
    }

    public int getFront() {
        if(list.size()==0) {
            return -1;
        }
        return list.getFirst();

    }

    public int getRear() {
        if(list.size()==0) {
            return -1;
        }
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean isFull() {
        if(list.size()==size){
            return true;
        }else{
            return false;
        }
    }
}
