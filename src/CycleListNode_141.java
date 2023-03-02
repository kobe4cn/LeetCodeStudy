import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class CycleListNode_141 {
    public boolean hasCycle(ListNode head) {
        List<ListNode> list=new ArrayList<>();
        while(head!=null && head.next!=null){
            list.add(head);
            if(list.contains(head)){
                return true;
            }
            head=head.next;
        }
        return false;
    }
}
// @lc code=end

