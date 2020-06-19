public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode prevNode = null;
        ListNode currentNode = head;
        ListNode nextNode = null;
        ListNode resultNode;
        if ( head.next != null) {
            nextNode = head.next;
            resultNode = nextNode;
        } else {
            return head;
        }
        while(currentNode != null && currentNode.next != null) {
            nextNode = currentNode.next;
            ListNode temp = nextNode.next;
            nextNode.next = currentNode;
            currentNode.next = temp;
            if( prevNode != null) {
                prevNode.next = nextNode;
            }
            prevNode = currentNode;
            currentNode = temp;
        }
        return resultNode;
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
        h4.next = null;
        System.out.println( new SwapNodesInPairs().swapPairs(head));
    }

}
