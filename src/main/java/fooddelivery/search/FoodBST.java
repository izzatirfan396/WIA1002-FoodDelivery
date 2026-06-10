package fooddelivery.search;

import java.util.Scanner;
import java.io.PrintStream;

/**
 * Module 5 - Food Search using a Binary Search Tree
 * Member: ZUL DANIAL
 * * Note: Fixed the annoying NetBeans console lag by forcing out.flush() everywhere.
 * Also added safeguards so users can't accidentally crash the demo with typos,
 * duplicate IDs, or broken price formats.
 */
public class FoodBST {

    private Node root;
    private DataCache fastCache; // Syncs with the HashMap for O(1) lookups
    private final PrintStream out = System.out;

    // Simple pointer-based tree node
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

    // Adds to both structures at the same time to keep them in sync
    public void insert(FoodItem item) {
        root = insertRecursive(root, item);
        fastCache.put(item.getItemId(), item);
    }

    // Standard recursive BST insertion sorted alphabetically by item name
    private Node insertRecursive(Node current, FoodItem item) {
        if (current == null) return new Node(item);
        
        int compareResult = item.getName().compareToIgnoreCase(current.data.getName());
        
        if (compareResult < 0) {
            current.left = insertRecursive(current.left, item); // Go left if smaller
        } else if (compareResult > 0) {
            current.right = insertRecursive(current.right, item); // Go right if bigger
        }
        return current;
    }

    public FoodItem search(String name) {
        return searchRecursive(root, name);
    }

    // Binary search through the tree by food name (ignoring capital letters)
    private FoodItem searchRecursive(Node current, String name) {
        if (current == null) return null;
        
        int compareResult = name.compareToIgnoreCase(current.data.getName());
        
        if (compareResult == 0) return current.data; // Found it!
        
        // Pick a side and keep diving down
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

    // Traverses Left -> Root -> Right to automatically print items alphabetically
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            out.println(node.data);
            inOrder(node.right);
        }
    }

    public boolean delete(String name) {
        FoodItem itemToDelete = search(name);
        if (itemToDelete == null) {
            return false; // Tells the menu that this item doesn't exist, nothing to do
        }
        
        // Remove from the HashMap cache first, then deal with the tree pointers
        fastCache.remove(itemToDelete.getItemId());
        root = deleteRecursive(root, name);
        return true;
    }

    private Node deleteRecursive(Node current, String name) {
        if (current == null) return null;
        
        int compareResult = name.compareToIgnoreCase(current.data.getName());
        
        if (compareResult < 0) {
            current.left = deleteRecursive(current.left, name);
        } else if (compareResult > 0) {
            current.right = deleteRecursive(current.right, name);
        } else {
            // Case 1 & 2: Node has 0 or only 1 child
            if (current.left == null) return current.right;
            if (current.right == null) return current.left;
            
            // Case 3: Node has two children. Find the successor to take its place.
            current.data = findSmallest(current.right);
            current.right = deleteRecursive(current.right, current.data.getName());
        }
        return current;
    }

    // Helper to find the absolute leftmost node in a subtree (the minimum value)
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
                    out.print("Enter Item ID:"); 
                    out.flush(); 
                    String id = sharedSc.nextLine().trim();

                    // Guard 1: Stop users from breaking the HashMap with a duplicate ID
                    if (fastCache.contains(id)) {
                        out.println(">>> [ERROR]: Item ID " + id + " already exists in the system cache!");
                        out.flush();
                        break;
                    }

                    out.print("Enter Food Name:"); 
                    out.flush(); 
                    String name = sharedSc.nextLine().trim();

                    // Guard 2: Stop users from spamming identical names into the BST
                    if (search(name) != null) {
                        out.println(">>> [ERROR]: Food item '" + name + "' already exists in the menu tree!");
                        out.flush();
                        break;
                    }

                    // Guard 3: Autocomplete logic so typos/short words match the right category
                    out.print("Enter Category (Fast Food, Healthy, Beverage, Dessert):"); 
                    out.flush(); 
                    String inputCat = sharedSc.nextLine().trim().toLowerCase();
                    String cat = "Other"; 

                    if (inputCat.startsWith("fast") || inputCat.contains("food")) {
                        cat = "Fast Food";
                    } else if (inputCat.startsWith("heal") || inputCat.contains("health")) {
                        cat = "Healthy";
                    } else if (inputCat.startsWith("bev") || inputCat.startsWith("drin") || inputCat.contains("bev")) {
                        cat = "Beverage";
                    } else if (inputCat.startsWith("des") || inputCat.startsWith("swe") || inputCat.contains("dess")) {
                        cat = "Dessert";
                    } else if (!inputCat.isEmpty()) {
                        // Quick fix: if they enter something else entirely, capitalize the first letter nicely
                        cat = inputCat.substring(0, 1).toUpperCase() + inputCat.substring(1);
                    }

                    // Guard 4: Try-catch block to stop the app from crashing if they type text or letters for price
                    double price = 0.0;
                    out.print("Enter Price:"); 
                    out.flush(); 
                    try {
                        price = Double.parseDouble(sharedSc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        out.println(">>> [ERROR]: Invalid price layout input. Defaulted to RM0.00");
                        out.flush();
                    }

                    out.print("Enter Restaurant ID:"); 
                    out.flush(); 
                    String restId = sharedSc.nextLine().trim();

                    insert(new FoodItem(id, name, cat, price, restId));
                    out.println(">>> " + name + " added under category [" + cat + "] successfully!"); 
                    out.flush();
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
                    String nameToDelete = sharedSc.nextLine().trim();
                    
                    // Guard 5: Give clear feedback so the user actually knows if deletion worked
                    if (delete(nameToDelete)) {
                        out.println(">>> [Success]: '" + nameToDelete + "' removed from tree and cache index!");
                    } else {
                        out.println(">>> [Error]: Food item name not found. No records altered.");
                    }
                    out.flush();
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