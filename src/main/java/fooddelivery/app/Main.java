package fooddelivery.app;

import fooddelivery.users.UserManager;
import fooddelivery.riders.RiderPriorityQueue;
import fooddelivery.search.FoodBST;
import fooddelivery.search.DataCache;
import fooddelivery.utils.InputHelper;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        
        UserManager um = new UserManager(); 
        RiderPriorityQueue rpq = new RiderPriorityQueue();
        DataCache dataCache = new DataCache();
        FoodBST foodMenu = new FoodBST(dataCache);

        do {
            System.out.println("\n==========================================");
            System.out.println("      SMART FOOD DELIVERY SYSTEM");
            System.out.println("==========================================");
            System.out.println("1. User & Restaurant Management");
            System.out.println("2. Order Processing");
            System.out.println("3. Rider Assignment");
            System.out.println("4. Route Finder");
            System.out.println("5. Food Search Menu");
            System.out.println("0. Exit");
            System.out.println("------------------------------------");
            System.out.print("Enter choice: ");

            try {
                String input = sc.nextLine().trim();
                if (input.isEmpty()) continue;
                choice = Integer.parseInt(input);
            } catch (Exception e) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    um.showMenu(sc);
                    break;
                case 2:
                    System.out.println("[Module 2 - Order Processing] Coming soon.");
                    break;
                case 3:
                    rpq.showMenu(sc);
                    break;
                case 4:
                    System.out.println("[Module 4 - Route Finder] Coming soon.");
                    break;
                case 5:
                    foodMenu.showMenu(sc);
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