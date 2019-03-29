// tag: Linked List DS implemented

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val=x;
    }
    ListNode(int[] arr) {
        this(arr[0]); // use the base constructor
        // use head to represent the first element of ListNode; change head won't affect this
        ListNode head = this;  
        for(int i=1; i<arr.length; i++) {
            head.next = new ListNode(arr[i]);
            head = head.next;
        }
    }
    // ListNode's String form: [<nodeVal>]
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode node = this;
        while(node != null) {
            sb.append(node.val + " ");
            node = node.next;
        }
        sb.setLength(sb.length()-1);
        sb.append("]");
        return sb.toString();
            
    }
}

public class MergeSortedLists {
    public ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null || l1==null) {
            return l1==null ? l2 : l1;
        }
        ListNode res=null;
        ListNode pointer=null;
        if(l1.val < l2.val) {
            res = l1;
            l1 = l1.next;
        }
        else {
            res = l2;
            l2 = l2.next;
        }
        pointer = res;
        // l1 != null, NOT l1.next != null(would exclude the last one)
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                pointer.next = l1;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        } 
        if (l1 == null) {
            pointer.next = l2;
        } 
        else if(l2 == null) {pointer.next = l1;}
        return res;
    }
    public static void main(String[] args) {
        int[] list1 = {1,2,7};
        int[] list2 = {1,3,7};
        ListNode l1 = new ListNode(list1);
        ListNode l2 = new ListNode(list2);
        MergeSortedLists ms = new MergeSortedLists();
        ListNode merged = ms.merge(l1, l2);
        //System.out.println(l2.toString());
        System.out.println(merged);
        }
}