package fooddelivery.orders;

/**
 * Undo last order cancellation using a Stack.
 * Member: FARISH CHAI
 *
 */
public class UndoStack {

    // Private Node class to represent links in the custom stack
    private static class Node {
        Order data;
        Node next;

        Node(Order data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top; // Points to the top element of the stack (LIFO access point)
    private int size;

    public UndoStack() {
        this.top = null;
        this.size = 0;
    }

    public void push(Order order) {
        if (order == null) return;

        Node newNode = new Node(order);
        
        // Link the new node to point to the current top node
        newNode.next = top;
        // Move the top pointer to point to our brand new node
        top = newNode;
        
        size++;
        System.out.println("Order #" + order.getOrderId() + " pushed to undo history stack.");
    }

    public Order pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow: No actions available to undo.");
            return null;
        }

        // Keep a reference to the data we want to return
        Order poppedOrder = top.data;
        // Shift the top pointer down to the next node in the chain
        top = top.next;
        
        size--;
        return poppedOrder;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}