import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList_206 {
    public ListNode reverseList(ListNode head) {
        List<Integer> list=new ArrayList<>();

        if(head==null) return null;
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        int len=list.size()-1;
        ListNode node1=new ListNode(list.get(len));
        ListNode node=node1;
        for (int i = len-1; i>=0; i--) {
                node.next= new ListNode(list.get(i));
                node=node.next;
        }

        return node1;

    }

    public ListNode getListNode(List<Integer> list,ListNode node,int i){
        ListNode ln=node;
        while(i>=0){
            ln.val=list.get(i);
            if(i-1>0){
                ListNode node1 = new ListNode(list.get(i - 1));
                ln.next=node1;
            }


            i--;
            getListNode(list,node,i);
        }
        return node;
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            ListNode ret = new ReverseLinkedList_206().reverseList(head);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}
