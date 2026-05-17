package fooddelivery.main;

import fooddelivery.users.UserManager;
import fooddelivery.orders.OrderQueue;
import fooddelivery.orders.UndoStack;
import fooddelivery.riders.RiderPriorityQueue;
import fooddelivery.routes.Graph;
import fooddelivery.routes.Dijkstra;
import fooddelivery.search.FoodBST;
import fooddelivery.search.DataCache;
import fooddelivery.utils.InputHelper;
import java.util.Scanner;

/**
 * WIA1002 Data Structures Group Project
 * Smart Food Delivery System
 *
 * Group Leader: [Your Name]
 * Members: [M1], [M2], [M3], [M4], [M5]
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        System.out.println("==========================================");
        System.out.println("     SMART FOOD DELIVERY SYSTEM");
        System.out.println("==========================================");

        do {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. User & Restaurant Management");
            System.out.println("2. Order Processing");
            System.out.println("3. Rider Assignment");
            System.out.println("4. Route Finder");
            System.out.println("5. Food Search");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = InputHelper.readInt(sc);

            switch (choice) {
                case 1:
                    // TODO (M1): call UserManager menu
                    System.out.println("[Module 1 - User & Restaurant Management] Coming soon.");
                    break;
                case 2:
                    // TODO (M2): call OrderQueue menu
                    System.out.println("[Module 2 - Order Processing] Coming soon.");
                    break;
                case 3:
                    // TODO (M3): call RiderPriorityQueue menu
                    System.out.println("[Module 3 - Rider Assignment] Coming soon.");
                    break;
                case 4:
                    // TODO (M4): call Dijkstra menu
                    System.out.println("[Module 4 - Route Finder] Coming soon.");
                    break;
                case 5:
                    // TODO (M5): call FoodBST menu
                    System.out.println("[Module 5 - Food Search] Coming soon.");
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
