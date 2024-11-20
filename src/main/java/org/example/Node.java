package org.example;

public class Node {
    private Integer frequency;
    private Character val;
    private Node leftChild;
    private Node rightChild;

    public Node(Node leftChild, Node rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        frequency = leftChild.frequency + rightChild.frequency;
        val = null;
    }

    public Node(Integer frequency, Character val) {
        this.frequency = frequency;
        this.val = val;
        this.rightChild = null;
        this.leftChild = null;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public String toString() {
        return "" + val + " " + frequency + " " + leftChild + " " + rightChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Character getVal() {
        return val;
    }
}