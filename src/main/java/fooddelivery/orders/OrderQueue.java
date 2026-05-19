package fooddelivery.orders;

/**
 * Module 2 - Order Processing using a Queue
 * Member: FARISH CHAI
 *
 * Data Structure: Queue (linked-list based, implement manually)
 * Responsibilities:
 * - Enqueue new orders
 * - Dequeue orders for processing (FIFO)
 * - Display current order queue
 */
public class OrderQueue {

    // Private Node class to represent links in the custom queue
    private static class Node {
        Order data;
        Node next;

        Node(Order data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // Points to the front of the queue (for dequeue/peek)
    private Node tail; // Points to the back of the queue (for enqueue)
    private int size;

    public OrderQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void enqueue(Order order) {
        if (order == null) return;
        
        Node newNode = new Node(order);
        
        // If queue is empty, the new node becomes both head and tail
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode; // Link the old tail to the new node
            tail = newNode;      // Move the tail pointer to the new node
        }
        size++;
        System.out.println("Enqueued successfully: " + order.getOrderId());
    }

    public Order dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow: No orders to process.");
            return null;
        }
        
        Order removedData = head.data;
        head = head.next; // Advance the head pointer to the next item
        
        // If the queue just became empty, clean up the tail pointer too
        if (head == null) {
            tail = null;
        }
        
        size--;
        return removedData;
    }

    public Order peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        return head.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("\n[Order Queue is currently empty]");
            return;
        }
        
        System.out.println("\n--- Current Order Queue (FIFO) ---");
        Node current = head;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.data);
            current = current.next;
            position++;
        }
        System.out.println("----------------------------------");
    }

    public void showMenu() {
        // This structural sub-menu handles interacting manually inside Main.java tests
        System.out.println("\n=== Module 2: Order Processing Menu ===");
        System.out.println("1. View Order Queue");
        System.out.println("2. Process Next Order (Dequeue)");
        System.out.println("3. Check Front Order (Peek)");
        System.out.println("4. Back to Main System");
    }
}