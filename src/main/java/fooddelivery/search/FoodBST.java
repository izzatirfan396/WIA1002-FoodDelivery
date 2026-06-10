package fooddelivery.search;

import java.util.Scanner;
import java.io.PrintStream;

/**
 * Module 5 - Food Search using a Binary Search Tree
 * Member: ZUL DANIAL
 * Finalized to resolve NetBeans console buffer/lag issues and Scanner deadlocks.
 */
public class FoodBST {

    private Node root;
    private DataCache fastCache;
    private final PrintStream out = System.out;

    private class Node {
        FoodItem data;
        Node left, right;

        Node(FoodItem data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public FoodBST(DataCache cache) {
        this.root = null;
        this.fastCache = cache;
    }

    public void insert(FoodItem item) {
        root = insertRecursive(root, item);
        fastCache.put(item.getItemId(), item);
    }

    private Node insertRecursive(Node current, FoodItem item) {
        if (current == null) return new Node(item);
        int compareResult = item.getName().compareToIgnoreCase(current.data.getName());
        if (compareResult < 0) current.left = insertRecursive(current.left, item);
        else if (compareResult > 0) current.right = insertRecursive(current.right, item);
        return current;
    }

    public FoodItem search(String name) {
        return searchRecursive(root, name);
    }

    private FoodItem searchRecursive(Node current, String name) {
        if (current == null) return null;
        int compareResult = name.compareToIgnoreCase(current.data.getName());
        if (compareResult == 0) return current.data;
        return compareResult < 0 ? searchRecursive(current.left, name) : searchRecursive(current.right, name);
    }

    public void displayInOrder() {
        if (root == null) {
            out.println("No food items available.");
        } else {
            inOrder(root);
        }
        out.flush();
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            out.println(node.data);
            inOrder(node.right);
        }
    }

    public void delete(String name) {
        FoodItem itemToDelete = search(name);
        if (itemToDelete != null) fastCache.remove(itemToDelete.getItemId());
        root = deleteRecursive(root, name);
    }

    private Node deleteRecursive(Node current, String name) {
        if (current == null) return null;
        int compareResult = name.compareToIgnoreCase(current.data.getName());
        if (compareResult < 0) current.left = deleteRecursive(current.left, name);
        else if (compareResult > 0) current.right = deleteRecursive(current.right, name);
        else {
            if (current.left == null) return current.right;
            if (current.right == null) return current.left;
            current.data = findSmallest(current.right);
            current.right = deleteRecursive(current.right, current.data.getName());
        }
        return current;
    }

    private FoodItem findSmallest(Node root) {
        FoodItem smallest = root.data;
        while (root.left != null) {
            smallest = root.left.data;
            root = root.left;
        }
        return smallest;
    }

    public void showMenu(Scanner sharedSc) {
        int choice = -1;

        do {
            out.println("\n--- FOOD MENU MANAGEMENT (M5) ---");
            out.println("1. Add Food Item");
            out.println("2. Search Food Item by Name (BST Search)");
            out.println("3. Display All Food Items (Alphabetical - InOrder)");
            out.println("4. Remove Food Item");
            out.println("5. Fast Lookup by Item ID (HashMap Cache Verification)");
            out.println("0. Back to Main Menu");
            out.println("---------------------------------");
            out.print("Enter choice: ");
            out.flush();

            try {
                String line = sharedSc.nextLine().trim();
                if (line.isEmpty()) continue;
                choice = Integer.parseInt(line);
            } catch (Exception e) {
                out.println("Invalid input. Please enter a number.");
                out.flush();
                continue;
            }

            switch (choice) {
                case 1:
                    out.print("Enter Item ID:"); out.flush(); String id = sharedSc.nextLine().trim();
                    out.print("Enter Food Name:"); out.flush(); String name = sharedSc.nextLine().trim();
                    out.print("Enter Category:"); out.flush(); String cat = sharedSc.nextLine().trim();
                    out.print("Enter Price:"); out.flush(); double price = Double.parseDouble(sharedSc.nextLine().trim());
                    out.print("Enter Restaurant ID:"); out.flush(); String restId = sharedSc.nextLine().trim();
                    insert(new FoodItem(id, name, cat, price, restId));
                    out.println(">>> " + name + " added!"); out.flush();
                    break;
                case 2:
                    out.print("Enter food name to search:"); out.flush();
                    FoodItem found = search(sharedSc.nextLine().trim());
                    out.println(found != null ? "[Found]: " + found : "Not found."); out.flush();
                    break;
                case 3:
                    displayInOrder();
                    break;
                case 4:
                    out.print("Enter name to remove:"); out.flush();
                    delete(sharedSc.nextLine().trim());
                    out.println(">>> Processed."); out.flush();
                    break;
                case 5:
                    out.print("Enter ID for HashMap lookup:"); out.flush();
                    FoodItem cached = fastCache.get(sharedSc.nextLine().trim());
                    out.println(cached != null ? "[Cache Hit]: " + cached : "Not in cache."); out.flush();
                    break;
            }
        } while (choice != 0);
    }
}