package com.practice.dsa;

public class LinkedListManipulations {

    static class Node {
        int data;
        Node next;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }


    static Node insertToLinkedList(int a, int b, int c) {

        Node node1 = new Node();
        node1.setData(a);

        Node node2 = new Node();
        node2.setData(b);


        Node node3 = new Node();
        node3.setData(c);

        node1.setNext(node2);
        node2.setNext(node3);

        return node1;
    }

    static void traverseLinkedList(Node head) {
        Node temp = head; // for further operations
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    static void length(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        System.out.println("length : " + count);
    }

    static boolean checkK(Node head, int k) {
        Node temp = head;

        while (head != null) {
            if (head.data == k) {
                return true;
            }
            head = head.next;
        }

        return false;
    }

    public static void main(String[] args) {

        traverseLinkedList(insertToLinkedList(10, 20, 30));
        length(insertToLinkedList(10, 20, 30));
        System.out.println(checkK(insertToLinkedList(10, 20, 30), 20));
    }
}
