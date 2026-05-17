package fooddelivery.riders;

/**
 * Module 3 - Rider Assignment using a Priority Queue (Min-Heap)
 * Member: [M3 Name]
 *
 * Data Structure: Min-Heap (array-based)
 * Responsibilities:
 *   - Insert riders with a priority value
 *   - Assign the highest priority (lowest value) rider to an order
 *   - Update rider availability after assignment
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
    }

    public Rider assignRider() {
        // TODO (M3): remove and return the min-priority rider (root of heap), then sift down
        return null;
    }

    public Rider peek() {
        // TODO (M3): return the min-priority rider without removing
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void siftUp(int index) {
        // TODO (M3): bubble up to maintain heap property
    }

    private void siftDown(int index) {
        // TODO (M3): bubble down to maintain heap property
    }

    public void display() {
        // TODO (M3): print all riders currently in the queue
    }

    public void showMenu() {
        // TODO (M3): implement the sub-menu for this module
    }
}
