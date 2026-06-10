package fooddelivery.orders;

import fooddelivery.utils.InputHelper;
import java.util.Scanner;

/**
 * Module 2 - Order Processing using a Queue
 * Member: FARISH CHAI
 *
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

    private Node head; // Points to the front of the queue
    private Node tail; // Points to the back of the queue
    private int size;
    
    //Track orderIdCounter as a class-level instance variable 
    private int orderIdCounter = 1; 

    public OrderQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void enqueue(Order order) {
        if (order == null) return;
        
        Node newNode = new Node(order);
        
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode; 
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
        head = head.next;
        
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
        
        System.out.println("\n--- Current Order Queue (FIFO) ---\n");
        Node current = head;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.data);
            current = current.next;
            position++;
        }
        System.out.println("----------------------------------");
    }
    
    public void showMenu(Scanner sc, UndoStack undoStack) {
        int orderChoice = -1;

        while (true) {
            System.out.println("\n--- Order Processing Menu ---\n");
            System.out.println("1. View Order Queue");
            System.out.println("2. Process Next Order "); //dequeue
            System.out.println("3. Check Front Order ");//peek
            System.out.println("4. Place New Mock Order");
            System.out.println("5. Cancel Current Order "); // push to stack
            System.out.println("6. Undo Last Cancellation "); // pop from stack
            System.out.println("0. Back to Main System\n");
            System.out.print("Enter choice: ");

            orderChoice = InputHelper.readInt(sc);

            switch (orderChoice) {
                // View All Order
                case 1:
                    display();
                    break;
                
                // Process Next Order
                case 2:
                    Order processed = dequeue();
                    if (processed != null) {
                        processed.setStatus("PROCESSING");
                        System.out.println("Dispatched to Kitchen: " + processed);
                    }
                    break;
                    
                // Check the next highest priority order
                case 3:
                    Order front = peek();
                    if (front != null) System.out.println("Next up: " + front);
                    break;
                    
                // Place New Order
                case 4:
                    System.out.println("\n--- Create Mock Order ---");

                    System.out.print("Enter Food Item: ");
                    String food = InputHelper.readString(sc);

                    System.out.print("Enter Total Price: ");
                    double price = InputHelper.readDouble(sc);
                    
                    while (price < 0) {
                        System.out.println("[ERROR]: Price cannot be negative. Re-enter Price: ");
                        price = InputHelper.readDouble(sc);
                    }

                    String generatedId = "ORD-" + String.format("%03d", orderIdCounter++);
                    System.out.println("\nExecuting operational enqueue...");
                    enqueue(new Order(generatedId, "USER-101", "REST-707", food, price));
                    break;
                
                // Cancel current order
                case 5:
                    Order toCancel = dequeue();
                    if (toCancel != null) {
                        toCancel.setStatus("CANCELLED");
                        undoStack.push(toCancel);
                        System.out.println("Cancelled: " + toCancel.getOrderId() + " moved to history.");
                    }
                    break;
                
                // Undo Last Cancellation
                case 6:
                    Order revertedOrder = undoStack.pop();
                    if (revertedOrder != null) {
                        revertedOrder.setStatus("PENDING");
                        enqueue(revertedOrder);
                        System.out.println("Restored back to queue: " + revertedOrder.getOrderId());
                    }
                    break;
                
                // Back to Main System
                case 0:
                    System.out.println("Returning to Main Menu");
                    return; 

                default:
                    System.out.println("Invalid option.");
            }
        }
    } 
}