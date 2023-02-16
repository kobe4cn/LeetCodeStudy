import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class RemoveDuplicatesSortedList_83 {
    public ListNode deleteDuplicates(ListNode head) {
        List<Integer> list=new ArrayList<>();
//        list.add(head.val);
//        ListNode result=new ListNode(head.val);
//        if(head.next!=null){
//            head=head.next;
//        }
        while(head!=null){
            if(!list.contains(head.val)) {
                list.add(head.val);
            }
                head=head.next;
        }
       return serListNode(list);
    }

    public static ListNode serListNode(List<Integer> listnodelist) {
        List<Integer> integerList = listnodelist.stream().sorted().collect(Collectors.toList());
      //  System.out.println(integerList.toString());
        ListNode listNode1 = new ListNode(0);
        ListNode listNode = listNode1;
        int i = 0;
        while (i < integerList.size()) {
            ListNode temp = new ListNode(integerList.get(i));
            listNode.next = temp;
            listNode = listNode.next;
            i++;
        }
        return listNode1.next;
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
            
            ListNode ret = new RemoveDuplicatesSortedList_83().deleteDuplicates(head);
            
            String out = listNodeToString(ret);
            
            System.out.print(out);
        }
    }
}
