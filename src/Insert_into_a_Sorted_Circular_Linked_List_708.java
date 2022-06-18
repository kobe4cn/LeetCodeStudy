import java.util.Map;
import java.util.TreeMap;

//708. 循环有序列表的插入
public class Insert_into_a_Sorted_Circular_Linked_List_708 {

    public Node insert(Node head, int insertVal) {
        //将开始节点保存下来，以便后面进行判断next对象已经是最初开始遍历的对象了。结束遍历，这个循环的链表已经遍历完了
        Node check = head;
        if (head == null) {
            Node node1 = new Node(insertVal);
            node1.next = node1;
            return node1;
        }
        //遍历完的数据直接丢到排序的Map里面
        TreeMap<Integer, Node> map = new TreeMap<>(Integer::compareTo);
        //如果head.next等于check了，表示已经循环完了
        while (head.next != null) {

            map.putIfAbsent(head.val, head);
            if (head.next == check)
                break;
            head = head.next;
        }
        //通过TreeMap的特性找到比这个值小的数，然后插到他的后面
        Map.Entry<Integer, Node> integerNodeEntry = map.floorEntry(insertVal);
        if (integerNodeEntry != null) {


            while (head.next != null) {
                //通过map的特性可以直接找到比要插入的数小的值对象
                if (head == integerNodeEntry.getValue()) {
                    //这里要做一个判断，这个链表只有一个值，所以一直是自己循环，先要判断next不是自己，再要判断，head的val与next的val是否一致
                    //如果一致就一直遍历下去，直到next不一致了之后在它之后增加。
                    while (head != head.next && head.val == head.next.val) {
                        head = head.next;
                    }
                    Node temp = head.next;
                    head.next = new Node(insertVal);
                    head = head.next;
                    head.next = temp;
                    //多做一次循环是因为需要找到开始对象返回判定才是正确的，所以多循环了一次。
                    //如果这个数据很多的话，是不是就超时了也不知道。哈哈，暂时是过了
                    while (head.next != null) {
                        if (head == check) {
                            return head;
                        }
                        head = head.next;
                    }
                }
                head = head.next;
            }

        }


        Map.Entry<Integer, Node> integerNodeEntry1 = map.ceilingEntry(insertVal);
        if (integerNodeEntry1 != null) {

            while (head.next != null) {
                if (head.next == integerNodeEntry1.getValue()) {
                    Node temp = head.next;
                    head.next = new Node(insertVal);
                    head = head.next;
                    head.next = temp;
                    while (head.next != null) {
                        if (head == check) {
                            return head;
                        }
                        head = head.next;
                    }
                }
                head = head.next;
            }
        }
        return null;
    }
}





