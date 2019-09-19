package com.InterviewProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Amazon_Copy_Linked_List {

    static class ALNode {
        public int value;
        public ALNode next;
        public ALNode arbitrary;

        public ALNode(int val) {
            this.value = val;
            this.next = null;
            this.arbitrary = null;
        }

        public ALNode() {
            this.value = -1;
            this.next = null;
            this.arbitrary = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ALNode alNode = (ALNode) o;
            return value == alNode.value &&
                    Objects.equals(next, alNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, next);
        }
    }

    ALNode deepCopy(ALNode head)
    {
        // WRITE YOUR CODE HERE
        if (head == null) {
            return null;
        }
        ALNode newHead = new ALNode(head.value);
        ALNode travOrig = head;
        ALNode travCopy = newHead;

        Map<ALNode, ALNode> nodeToPreviousNodeMap = new HashMap<>();

        //nodeToPreviousNodeMap.put()
        while (travOrig.next != null) {
            travOrig = travOrig.next;
            ALNode next = new ALNode(travOrig.value);
            travCopy.next = next;
            nodeToPreviousNodeMap.put(travOrig, travCopy);
            travCopy = travCopy.next;
        }

        ALNode travOrig1 = head;
        ALNode travCopy1 = newHead;
        while (travOrig1.next != null) {
            ALNode arbitraryOrig = travOrig1.arbitrary;
            ALNode prevCopy = nodeToPreviousNodeMap.get(arbitraryOrig);
            if (prevCopy == null) {
                travCopy1.arbitrary = newHead;
            } else {
                travCopy1.arbitrary = prevCopy.next;
            }
            travOrig1 = travOrig1.next;
            travCopy1 = travCopy1.next;
        }
        ALNode arbitraryOrig = travOrig1.arbitrary;
        ALNode prevCopy = nodeToPreviousNodeMap.get(arbitraryOrig);
        if (prevCopy == null) {
            travCopy1.arbitrary = newHead;
        } else {
            travCopy1.arbitrary = prevCopy.next;
        }

        return newHead;
        /*newHead.next = head.next;
        ALNode prevTrav = newHead;
        newHead.arbitrary = head.arbitrary;
        ALNode travOrig = head.next;
        while (travOrig != null) {
            ALNode travCopy = new ALNode(travOrig.value);
            travCopy.next = travOrig.next;
            travCopy.arbitrary = travOrig.arbitrary;
            travOrig = travOrig.next;
            prevTrav.next = travCopy;
        }
        return newHead;*/
    }

    public static void main(String[] args) {
        Amazon_Copy_Linked_List acll = new Amazon_Copy_Linked_List();
        ALNode head = new ALNode(1);
        head.next = new ALNode(2);
        head.next.next = new ALNode(3);
        head.next.next.next = new ALNode(4);
        head.arbitrary = head.next;
        head.next.arbitrary = head.next.next.next;
        head.next.next.arbitrary = head;
        head.next.next.next.arbitrary = head.next.next;
        acll.deepCopy(head);
    }

}
