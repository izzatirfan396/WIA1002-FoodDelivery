package fooddelivery.riders;

import fooddelivery.utils.InputHelper;
import java.util.Scanner;

/**
 * Module 3 - Rider Assignment using a Priority Queue (Min-Heap) Member: HARIZ
 * ARFAN
 *
 * Data Structure: Min-Heap (array-based) Responsibilities: - Insert riders with
 * a priority value - Assign the highest priority (lowest value) rider to an
 * order - Update rider availability after assignment
 */
public class RiderPriorityQueue {

    private Rider[] heap;
    private int size;
    private static final int CAPACITY = 50;

    public RiderPriorityQueue() {
        heap = new Rider[CAPACITY];
        size = 0;
    }

    public void insert(Rider rider) {
        // TODO (M3): insert rider into heap, then sift up
        if (size >= CAPACITY) {
            System.out.println("Error: Rider Queue is at maximum capacity!");
            return;
        }
        heap[size] = rider;
        siftUp(size);
        size++;
        System.out.println("Successfully registered: " + rider.getName());
    }

    public Rider assignRider() {
        // TODO (M3): remove and return the min-priority rider (root of heap), then sift down
        if (isEmpty()) {
            System.out.println("No riders available to assign!");
            return null;
        }

        Rider optimalRider = heap[0];
        //Flag the assigned rider as unavailable
        optimalRider.setAvailable(false);

        //Replace root with the last element in the tree array
        heap[0] = heap[size - 1];
        heap[size - 1] = null; //Prevent memory leak;
        size--;

        if (size > 0) {
            siftDown(0);
        }
        return optimalRider;
    }

    public Rider peek() {
        // TODO (M3): return the min-priority rider without removing
        if (isEmpty()) {
            return null;
        }
        return heap[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void siftUp(int index) {
        // TODO (M3): bubble up to maintain heap property
        while (index > 0) {
            int parentIndex = (index - 1) / 2;

            //Min-heap comparison: if child's priority is lower value than parent's, swap
            if (heap[index].getPriority() < heap[parentIndex].getPriority()) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void siftDown(int index) {
        // TODO (M3): bubble down to maintain heap property
        while (index < size) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int smallest = index;

            //Check if left child exists and has higher priority (lower priority value)
            if (leftChild < size && heap[leftChild].getPriority() < heap[smallest].getPriority()) {
                smallest = leftChild;
            }

            //Check if right child exists and has higher priority
            if (rightChild < size && heap[rightChild].getPriority() < heap[smallest].getPriority()) {
                smallest = rightChild;
            }

            //If the priority criteria is met, terminate sifting loop
            if (smallest == index) {
                break;
            }

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        Rider temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void display() {
        // TODO (M3): print all riders currently in the queue
        if (isEmpty()) {
            System.out.println("\n--- CURRENT AVAILABLE DELIVEY RIDERS ---");
            System.out.println("No active riders available in the dispatch system.");
            return;
        }

        System.out.println("\n=================================================");
        System.out.println("     PRIORITY DISPATCH SYSTEM LAYOUT (MIN-HEAP)  ");
        System.out.println("=================================================");
        System.out.printf(" %-7s | %-10s | %-15s | %-13s %n", "Heap", "Rider ID", "Rider Name", "Priority Rank");
        System.out.println("-------------------------------------------------");

        for (int i = 0; i < size; i++) {
            System.out.printf(" [%-3d]   | %-10s | %-15s | %-13d %n",
                    i,
                    heap[i].getRiderId(),
                    heap[i].getName(),
                    heap[i].getPriority());
        }
        System.out.println("-------------------------------------------------");
    }

    public void showMenu(Scanner sc) {
        // TODO (M3): implement the sub-menu for this module
        int choice = -1;

        do {
            System.out.println("\n--- MODULE 3: DELIVERY RIDER MANAGEMENT SYSTEM ---");
            System.out.println("1. Add/Register a New Rider");
            System.out.println("2. Peek at Highest Priority Rider");
            System.out.println("3. Assign/Dispatch Optimal Rider for Order");
            System.out.println("4. Display All Active Riders in Heap Queue");
            System.out.println("0. Return to Main Menu");
            System.out.print("Please enter your choice (1-5): ");

            choice = InputHelper.readInt(sc);
            switch (choice) {
                case 1:
                    System.out.print("Enter Rider ID: ");
                    String id = InputHelper.readString(sc);
                    System.out.print("Enter Rider Name: ");
                    String name = InputHelper.readString(sc);
                    System.out.print("Enter Rider Priority Rank (1 = Top Priority/Closest): ");
                    int priority = InputHelper.readInt(sc);

                    Rider newRider = new Rider(id, name, priority);
                    insert(newRider);
                    break;

                case 2:
                    Rider topRider = peek();
                    if (topRider != null) {
                        System.out.println("\n>>> NEXT OPTIMAL DISPATCH CANDIDATE <<<");
                        System.out.println("-------------------------------------");
                        System.out.println("Rider ID      : " + topRider.getRiderId());
                        System.out.println("Rider Name    : " + topRider.getName());
                        System.out.println("Priority Rank : " + topRider.getPriority());
                        System.out.println("-------------------------------------");
                    } else {
                        System.out.println("\nNo riders registered in the system.");
                    }
                    break;

                case 3:
                    Rider assigned = assignRider();
                    if (assigned != null) {
                        System.out.println("\n[SUCCESS] Order Dispatched!");
                        System.out.println("Assigned to Rider: [" + assigned.getRiderId() + "] " + assigned.getName());
                    }
                    break;

                case 4:
                    display();
                    break;

                case 5:
                    System.out.println("Returning back to central integration layer...");
                    break;

                default:
                    System.out.println("Invalid input selection. Choose option between 1 and 5.");
            }
        } while (choice != 5);
    }
}
