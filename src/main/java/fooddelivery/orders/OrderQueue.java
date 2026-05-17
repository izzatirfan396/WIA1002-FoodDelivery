package fooddelivery.orders;

/**
 * Module 2 - Order Processing using a Queue
 * Member: [M2 Name]
 *
 * Data Structure: Queue (linked-list based, implement manually)
 * Responsibilities:
 *   - Enqueue new orders
 *   - Dequeue orders for processing (FIFO)
 *   - Display current order queue
 */
public class OrderQueue {

    // TODO (M2): implement your Queue node and fields here
    // Hint: create a private Node class with Order data, Node next

    private int size;

    public OrderQueue() {
        // TODO (M2): initialise head, tail, size
        this.size = 0;
    }

    public void enqueue(Order order) {
        // TODO (M2): add order to the back of the queue
    }

    public Order dequeue() {
        // TODO (M2): remove and return order from the front
        return null;
    }

    public Order peek() {
        // TODO (M2): return front order without removing it
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void display() {
        // TODO (M2): print all orders in the queue
    }

    public void showMenu() {
        // TODO (M2): implement the sub-menu for this module
    }
}
