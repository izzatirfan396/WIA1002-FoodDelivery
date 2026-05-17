package fooddelivery.search;

/**
 * Module 5 - Food Search using a Binary Search Tree
 * Member: [M5 Name]
 *
 * Data Structure: BST (sorted by food item name alphabetically)
 * Responsibilities:
 *   - Insert food items into the BST
 *   - Search for a food item by name (O log n)
 *   - Display all items in sorted order (in-order traversal)
 *   - Delete a food item
 */
public class FoodBST {

    private Node root;

    private class Node {
        FoodItem data;
        Node left, right;

        Node(FoodItem data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public FoodBST() {
        root = null;
    }

    public void insert(FoodItem item) {
        // TODO (M5): insert food item into BST by name (alphabetical key)
    }

    public FoodItem search(String name) {
        // TODO (M5): search for food item by name, return null if not found
        return null;
    }

    public void delete(String name) {
        // TODO (M5): delete food item by name
    }

    public void displayInOrder() {
        // TODO (M5): in-order traversal — prints all items alphabetically
        inOrder(root);
    }

    private void inOrder(Node node) {
        // TODO (M5): recursive in-order traversal
    }

    public void showMenu() {
        // TODO (M5): implement the sub-menu for this module
    }
}
