package topics.Practice.Implementation.Jul925;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        deleteNode(node);
        insertNode(node);
        return node.value;
    }

    void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            deleteNode(node);
        }
        if(map.size() >= capacity) {
            Node node = tail.prev;
            deleteNode(node);
            map.remove(node.key);
        }
        Node newNode = new Node(key, value);
        insertNode(newNode);
        map.put(key, newNode);
    }

    public void insertNode(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


}

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
