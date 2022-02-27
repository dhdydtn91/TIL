package linkedList;


import java.util.*;

public class ReverseLinkedLists {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode result = solve(head);

        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode solve (ListNode current) {

        ListNode next = null;
        ListNode prev = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
