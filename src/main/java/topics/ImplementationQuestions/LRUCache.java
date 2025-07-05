package topics.ImplementationQuestions;

import java.util.HashMap;

public class LRUCache {
    HashMap<Integer, Node> cacheMap = new HashMap<>();
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int capacity;

    LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }


    int getKey(int key) {
        if(!cacheMap.containsKey(key)) return -1;
        Node nodeToBeReturned = cacheMap.get(key);
        int valueToBeReturned = nodeToBeReturned.value;
        performDeletion(nodeToBeReturned);
        performInsertion(nodeToBeReturned);
        return valueToBeReturned;
    }

    void insert(int key, int value) {
        if(cacheMap.containsKey(key)) {
            Node nodeToBeRemoved = cacheMap.get(key);
            performDeletion(nodeToBeRemoved);
        }
        if(cacheMap.size() == capacity) {
            Node nodeToBeRemoved = tail.prev;
            performDeletion(nodeToBeRemoved);
            cacheMap.remove(nodeToBeRemoved.key);
        }
        Node nodeToBeInserted = new Node(key, value);
        performInsertion(nodeToBeInserted);
        cacheMap.put(key, nodeToBeInserted);
    }

    void performDeletion(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void performInsertion(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}

class Node {
    Node prev;
    Node next;
    int key;
    int value;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}