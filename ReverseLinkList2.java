public class ReverseLinkList2 {

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
        System.out.println( new Solution().reverseBetween(head, 2, 5).val);
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if( m==n ) {
            return head;
        }
        ListNode mp = head;
        ListNode np = null;
        ListNode prevmp = null;
        ListNode nextnp = null;
        for ( int i =1 ; i < m; i++) {
            prevmp = mp;
            mp = mp.next;
        }
        if(prevmp != null) prevmp.next = null;

        ListNode currentNode = mp;
        np = mp.next;
        mp.next = null;
        nextnp = np.next;
        np.next = currentNode;
        currentNode = np;
        int c = m+2;
        while (c <= n) {
            c++;
            np = nextnp;
            nextnp = nextnp.next;
            np.next = currentNode;
            currentNode = np;
        }
        ///------------------------------

        mp.next = nextnp;
        if( prevmp != null) {
            prevmp.next = np;
        } else {
            return np;
        }
        return head;
    }

    void print(ListNode l) {
        ListNode temp = l;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }


}
