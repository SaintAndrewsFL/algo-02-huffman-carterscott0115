package org.example;

import java.util.Comparator;

public class Compare implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        return Integer.compare(o1.getFrequency(), o2.getFrequency());
    }
}
