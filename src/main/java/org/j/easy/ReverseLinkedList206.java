package org.j.easy;

import org.j.ListNode;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 206反向单向链表。
 * @date 2020-08-27 16:38
 **/
public class ReverseLinkedList206 {
    /**
     * 反向单向链表。
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }


    public static void main(String[] args) {

    }
}

