import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedLists_21 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> listnode1 = getListNode(list1);
        //List<Integer> listnode2=getListNode(list2);
        listnode1.addAll(getListNode(list2));
        return serListNode(listnode1);

    }

    public static List<Integer> getListNode(ListNode node) {
        List<Integer> listnodelist = new ArrayList<>();
        if (node != null) {
            //System.out.println(node.val);
            listnodelist.add(node.val);
            ListNode nodenext = node.next;
            while (nodenext != null) {
                listnodelist.add(nodenext.val);
                nodenext = nodenext.next;
            }
        }
        //System.out.print(listnodelist.toString());
        return listnodelist;
    }

    public static ListNode serListNode(List<Integer> listnodelist) {
        List<Integer> integerList = listnodelist.stream().sorted().toList();
       // System.out.println(integerList.toString());
        ListNode listNode1 = new ListNode(0);
        ListNode listNode = listNode1;
        int i = 0;
        while (i < integerList.size()) {
            listNode.next = new ListNode(integerList.get(i));
            listNode = listNode.next;
            i++;
        }
        return listNode1.next;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode list1 = stringToListNode(line);
            line = in.readLine();
            ListNode list2 = stringToListNode(line);

            ListNode ret = mergeTwoLists(list1, list2);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }

        public static int[] stringToIntegerArray (String input){
            input = input.trim();
            input = input.substring(1, input.length() - 1);
            if (input.length() == 0) {
                return new int[0];
            }

            String[] parts = input.split(",");
            int[] output = new int[parts.length];
            for (int index = 0; index < parts.length; index++) {
                String part = parts[index].trim();
                output[index] = Integer.parseInt(part);
            }
            return output;
        }

        public static ListNode stringToListNode (String input){
            // Generate array from the input
            int[] nodeValues = stringToIntegerArray(input);

            // Now convert that list into linked list
            ListNode dummyRoot = new ListNode(0);
            ListNode ptr = dummyRoot;
            for (int item : nodeValues) {
                ptr.next = new ListNode(item);
                ptr = ptr.next;
            }
            return dummyRoot.next;
        }

        public static String listNodeToString (ListNode node){
            if (node == null) {
                return "[]";
            }

            StringBuilder result = new StringBuilder();
            while (node != null) {
                result.append(node.val).append(", ");
                node = node.next;
            }
            return "[" + result.substring(0, result.length() - 2) + "]";
        }

    }
