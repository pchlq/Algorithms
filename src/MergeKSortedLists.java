import model.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeKSortedLists {

    public static void main(String[] args) {

        ListNode ln5 = new ListNode(6);
        ListNode ln4 = new ListNode(4, ln5);
        ListNode ln3 = new ListNode(3, ln4);
        ListNode ln1 = new ListNode(1, ln3);

        ListNode ln33 = new ListNode(9);
        ListNode ln22 = new ListNode(4, ln33);
        ListNode ln11 = new ListNode(2, ln22);

        ListNode ln222 = new ListNode(12);
        ListNode ln111 = new ListNode(7, ln222);
        ListNode ln000 = new ListNode(2, ln111);


        ListNode[] listNodes = {ln000, ln1, ln11};

        var res = mergeAll(listNodes);

        System.out.println(res);
    }

    private static ListNode mergeAll(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = mergeTwoNodes(lists[i], result);
        }

        return result;
    }

    private static ListNode mergeTwoNodes(ListNode ln1, ListNode ln2) {

        List<Integer> ln1val = retrieveValues(ln1);
        List<Integer> ln2val = retrieveValues(ln2);
        ln1val.addAll(ln2val);
        Collections.sort(ln1val);

        ListNode fake = new ListNode(-1);
        ListNode current = fake;

        for (Integer val : ln1val) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return fake.next;
    }

    private static List<Integer> retrieveValues(ListNode ln) {
        List<Integer> res = new ArrayList<>();

        while (ln != null) {
            ListNode next = ln.next;
            res.add(ln.val);
            ln = next;
        }
        return res;
    }
}
