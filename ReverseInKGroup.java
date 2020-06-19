public class ReverseInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<=1) return head;

        int len = listLength(head);
        int iterations = (int)len/k;

        ListNode prev = new ListNode(0);
        ListNode start = head;
        ListNode result = prev;

        for(int i =0 ; i< iterations; i++) {
            ListNode current = start;
            ListNode next = start.next;
            for(int j = 1; j < k; j++ ) {
                ListNode temp = next.next;
                next.next = current;
                current = next;
                next = temp;
            }
            prev.next = current;
            prev = start;
            start.next = next;
            start = next;
        }
        return result.next;
    }
    public int listLength(ListNode n) {
        ListNode temp = n;
        int len = 0;
        while(temp!=null) {
            temp = temp.next;
            len++;
        }
        return len;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);
        head.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        System.out.println( new ReverseInKGroup().reverseKGroup(head, 2).val);
    }
}
