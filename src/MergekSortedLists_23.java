import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MergekSortedLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> listnodelist = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if (node == null) {
                continue;
            }
            listnodelist.addAll(getListNode(node));
        }

        return serListNode(listnodelist);
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
        System.out.print(listnodelist.toString());
        return listnodelist;
    }

    public static ListNode serListNode(List<Integer> listnodelist) {
        List<Integer> integerList = listnodelist.stream().sorted().collect(Collectors.toList());
        System.out.println(integerList.toString());
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


    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 4, 4, 5, 6};
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(5);
        list.add(6);
        ListNode node = serListNode(list);
        System.out.println(node);
    }

}
