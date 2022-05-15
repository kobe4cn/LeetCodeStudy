import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer_138 {
    public Node copyRandomList(Node head) {
        if(head==null){
            return head;
        }
        Node node=head;
        Map<Node,Node> map=new HashMap<>();
        while(node!=null){
            Node clone=new Node(node.val);
            map.put(node,clone);
          //  node=node.next;
        }
        node=head;
        while(node!=null){
//            map.get(node).next=map.get(node.next);
//            map.get(node).random=map.get(node.random);
//            node=node.next;
        }
        return map.get(head);

    }
}
