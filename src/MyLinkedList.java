import java.util.LinkedList;

//707. 设计链表
public class MyLinkedList {
    LinkedList<Integer> linkedList=null;
    public MyLinkedList() {
        linkedList=new LinkedList<>();
    }

    public int get(int index) {
        try {
            System.out.println(linkedList.toString());
            return linkedList.get(index);
        }catch (IndexOutOfBoundsException e){
            return -1;
        }


    }

    public void addAtHead(int val) {
        linkedList.offerFirst(val);
        System.out.println(linkedList.toString());
    }

    public void addAtTail(int val) {
        linkedList.offerLast(val);
        System.out.println(linkedList.toString());
    }

    public void addAtIndex(int index, int val) {
        if(index==linkedList.size()){
            addAtTail(val);
        }else if(index<0){
            addAtHead(val);
        }else if(index<linkedList.size()){
            //List<Integer> temp = new ArrayList<>(linkedList.subList(index, linkedList.size()));
            linkedList.add(index, val);
            //linkedList.removeRange(index+1,linkedList.size());
            //linkedList.addAll(index + 1, temp);
        }
        System.out.println(linkedList.toString());
    }

    public void deleteAtIndex(int index) {
        try {
           // List<Integer> temp=linkedList.subList(index,linkedList.size());
            linkedList.remove(index);
            //linkedList.addAll(index,temp);
        }catch (IndexOutOfBoundsException e){
            System.out.println("index invalid");
        }
        System.out.println(linkedList.toString());

    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        System.out.println(linkedList.get(1));            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.get(1));            //返回3

    }
}
