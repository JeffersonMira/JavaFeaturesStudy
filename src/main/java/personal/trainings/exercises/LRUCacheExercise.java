package personal.trainings.exercises;

import java.util.HashMap;

/**
 * Problem Statement:
 * Design and implement a Least Recently Used (LRU) Cache. The cache should support the following operations:
 *
 * get(key: int): Get the value (or -1 if the key does not exist) of the key if the key exists in the cache.
 * put(key: int, value: int): Add or update the value of the key. When the cache reaches its capacity, it should invalidate the least recently used item before inserting a new item.
 * Constraints:
 *
 * The cache should be initialized with a maximum size (capacity).
 * The operations must be completed in O(1) time.
 * Specifications:
 * Create a class called LRUCache that has:
 * A constructor that takes an integer capacity as input.
 * Methods get(key: int) → int and put(key: int, value: int).
 */
public class LRUCacheExercise {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2); // capacity = 2
        cache.put(1, 1); // cache is {1=1}
        cache.put(2, 2); // cache is {1=1, 2=2}
        cache.get(1);    // returns 1
        cache.put(3, 3); // evicts key 2, cache is {1=1, 3=3}
        cache.get(2);    // returns -1 (not found)
        cache.put(4, 4); // evicts key 1, cache is {3=3, 4=4}
        cache.get(1);    // returns -1 (not found)
        cache.get(3);    // returns 3
        cache.get(4);    // returns 4
    }
}

class LRUCache {

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    // Node class for doubly linked list
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> map; // To hold key and corresponding node in the DLL
    private Node head; // Dummy head of the doubly linked list
    private Node tail; // Dummy tail of the doubly linked list
    private int capacity; // Capacity of the LRU cache
    private int size; // Current size of the cache

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();

        // Initialize the doubly linked list with dummy head and tail nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    // Get the value of the key if it exists in the cache
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1; // Key does not exist
        }

        // Move the accessed node to the front (mark it as most recently used)
        Node node = map.get(key);
        moveToFront(node);

        System.out.println(node.value);
        return node.value;
    }

    // Add a key-value pair to the cache
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Update the existing node
            Node node = map.get(key);
            node.value = value;
            moveToFront(node);
        } else {
            // If the cache is full, remove the least recently used (tail.prev) node
            if (size == capacity) {
                Node lruNode = tail.prev; // The least recently used node
                map.remove(lruNode.key); // Remove from hashmap
                removeNode(lruNode); // Remove from linked list
                size--;
            }
            // Create a new node and insert it
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addNode(newNode);
            size++;
        }
    }

    // Move the node to the front of the doubly linked list
    private void moveToFront(Node node) {
        removeNode(node);
        addNode(node);
    }

    // Helper function to add a node right after the head
    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // Helper function to remove a node from the linked list
    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}