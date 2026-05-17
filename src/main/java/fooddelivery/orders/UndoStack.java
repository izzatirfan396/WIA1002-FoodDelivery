package fooddelivery.orders;

/**
 * Undo last order cancellation using a Stack.
 * Member: [M2 Name]
 *
 * Data Structure: Stack (linked-list based, implement manually)
 * Responsibilities:
 *   - Push a cancelled order onto the stack
 *   - Pop (undo) the last cancellation
 */
public class UndoStack {

    // TODO (M2): implement your Stack node and fields here

    private int size;

    public UndoStack() {
        // TODO (M2): initialise top, size
        this.size = 0;
    }

    public void push(Order order) {
        // TODO (M2): push a cancelled order onto the stack
    }

    public Order pop() {
        // TODO (M2): undo — pop the last cancelled order
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
