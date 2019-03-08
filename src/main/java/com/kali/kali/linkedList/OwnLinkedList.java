package com.kali.kali.linkedList;

import com.kali.linkedList.OwnNode;

public class OwnLinkedList {
    private com.kali.linkedList.OwnNode head = null;
    private com.kali.linkedList.OwnNode rare = null;

    public void addNodeAtEnd(int intVal) {
        if (head == null) {
            com.kali.linkedList.OwnNode newNode = new com.kali.linkedList.OwnNode();
            newNode.VALUE = intVal;
            head = newNode;
            rare = newNode;
        } else {
            com.kali.linkedList.OwnNode newNode = new com.kali.linkedList.OwnNode();
            newNode.VALUE = intVal;
            rare.NEXT_NODE = newNode;
            rare = newNode;
        }
    }

    public void addNodeAtFirst(int intVal) {
        if (head == null) {
            com.kali.linkedList.OwnNode newNode = new com.kali.linkedList.OwnNode();
            newNode.VALUE = intVal;
            head = newNode;
            rare = newNode;
        } else {
            com.kali.linkedList.OwnNode newNode = new com.kali.linkedList.OwnNode();
            newNode.VALUE = intVal;
            newNode.NEXT_NODE = head;
            head = newNode;
        }
    }

    public com.kali.linkedList.OwnNode middleNodeWithEff() {
        com.kali.linkedList.OwnNode runner = head;
        com.kali.linkedList.OwnNode middle = head;
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
        com.kali.linkedList.OwnNode runner = head;
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
