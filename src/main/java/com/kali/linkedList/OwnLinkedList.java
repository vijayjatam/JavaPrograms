package com.kali.linkedList;

public class OwnLinkedList {
    private OwnNode head = null;
    private OwnNode rare = null;

    public void addNodeAtEnd(int intVal) {
        if (head == null) {
            OwnNode newNode = new OwnNode();
            newNode.VALUE = intVal;
            head = newNode;
            rare = newNode;
        } else {
            OwnNode newNode = new OwnNode();
            newNode.VALUE = intVal;
            rare.NEXT_NODE = newNode;
            rare = newNode;
        }
    }

    public void addNodeAtFirst(int intVal) {
        if (head == null) {
            OwnNode newNode = new OwnNode();
            newNode.VALUE = intVal;
            head = newNode;
            rare = newNode;
        } else {
            OwnNode newNode = new OwnNode();
            newNode.VALUE = intVal;
            newNode.NEXT_NODE = head;
            head = newNode;
        }
    }

    public OwnNode middleNodeWithEff() {
        OwnNode runner = head;
        OwnNode middle = head;
        while (runner != null) {
            if (runner.NEXT_NODE != null && runner.NEXT_NODE.NEXT_NODE != null) {
                middle = middle.NEXT_NODE;
                runner = runner.NEXT_NODE.NEXT_NODE;
            } else {
                break;
            }
        }
        return middle;
    }

    public int size() {
        int size = 0;
        OwnNode runner = head;
        OwnNode middle = head;
        while (runner != null) {
            size++;
            if (runner.NEXT_NODE != null && runner.NEXT_NODE.NEXT_NODE != null) {
                middle = middle.NEXT_NODE;
                runner = runner.NEXT_NODE.NEXT_NODE;
                size++;
            } else if (runner.NEXT_NODE != null) {
                size++;
                break;
            } else {
                break;
            }
        }
        return size;
    }
}
