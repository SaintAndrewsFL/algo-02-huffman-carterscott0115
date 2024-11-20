package org.example;

public class Main {
    public static void main(String[] args) {
        HuffmanAlgo huffman = new HuffmanAlgo();
        HuffmanTree huffmanTree = HuffmanAlgo.encode("dum dee dum dum dum");
        System.out.println("Check");
        System.out.println(HuffmanAlgo.decode(huffmanTree, "1111"));
        HuffmanAlgo.breadthFirst(huffmanTree);
        System.out.println();
    }
}