package linkedList;


import java.util.PriorityQueue;

public class MergekSortedLists {

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(5);


        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(7);

        ListNode [] lists = {node, node2 , node3};

        ListNode solve = solve(lists);
        while(solve != null){
            System.out.println(solve.val);
            solve = solve.next;
        }
    }

    public static ListNode solve(ListNode [] lists){
        ListNode result = new ListNode(0);
        ListNode head =  result;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for (ListNode listNode : lists) {
            pq.add(listNode);
        }

        while(!pq.isEmpty()) {
            ListNode poll = pq.poll();
            head.next = poll;
            head = head.next;

            if(poll.next != null){
                pq.offer(poll.next);
            }
        }
        return result;
    }

}
