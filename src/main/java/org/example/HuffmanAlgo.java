package org.example;


import com.sun.jdi.Value;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Key;
import java.util.*;


public class HuffmanAlgo {


    public static HuffmanTree encode(String text) {
        HashMap<Character, Integer> hashmap = new HashMap();
        for (int i = 0; i < text.length(); i++) {
            if (hashmap.get(text.charAt(i)) == null) {
                hashmap.put(text.charAt(i), 1);
            } else {
                hashmap.put(text.charAt(i), hashmap.get(text.charAt(i)) + 1);
                System.out.println(hashmap);
            }
        }
        PriorityQueue<Node> priorityQueue = new PriorityQueue(new Compare());
        hashmap.forEach(
                (key, value)
                        -> priorityQueue.add(new Node(value, key)));

        while (priorityQueue.size() > 1) {
            priorityQueue.add(new Node(priorityQueue.poll(), priorityQueue.poll()));
            PriorityQueue queue = priorityQueue;
            System.out.println(priorityQueue);
            //NO WAY MY CODE ACTUALLY WORKS
        }
        return new HuffmanTree(priorityQueue.poll());
    }

    public static String decode(HuffmanTree tree, String text) {
        Node currentNode = tree.rootnode;
        String textChar;
        String finalString = "";
        for(int i = 0; i < text.length() - 1; i++) {
            System.out.println("CN is on: " + currentNode);
            textChar = text.substring(i, i + 1);
            if(currentNode.getVal() != null) {
                finalString += currentNode.getVal();
                currentNode = tree.rootnode;
            }
            else if(textChar.equals("0")) {
                currentNode = currentNode.getLeftChild();
            }
            else if(textChar.equals("1")) {
                currentNode = currentNode.getRightChild();
            }
        }
        if(currentNode.getVal() != null) {
            finalString += currentNode.getVal();
            currentNode = tree.rootnode;
        }
        return finalString;
    }

    public static void breadthFirst(HuffmanTree tree) {
        Node node = tree.rootnode;
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            node = queue.remove();
            result.add(node.getFrequency());
            if(node.getLeftChild() != null) {
                queue.add(node.getLeftChild());
            }
            if(node.getRightChild() != null) {
                queue.add(node.getRightChild());
            }
        }
        System.out.println(result);
    }

    public static String readText(String textFile) {
        try {
            String desktopPath = System.getProperty("user.home") + "/Desktop/" + textFile;
            Path filePath = Paths.get(desktopPath);
            return Files.readString(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }



    public static void readTxt(String location) throws FileNotFoundException {
        /* FileReader fileReader = new FileReader(location);
        char[] charlist = new char[];
        FileReader.read(); */
    }
}


