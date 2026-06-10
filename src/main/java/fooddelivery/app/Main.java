package fooddelivery.app;

import fooddelivery.users.UserManager;
import fooddelivery.riders.RiderPriorityQueue;
import fooddelivery.search.FoodBST;
import fooddelivery.search.DataCache;
import fooddelivery.utils.InputHelper;
import fooddelivery.routes.Dijkstra;
import fooddelivery.routes.Graph;
import fooddelivery.routes.Location;
import fooddelivery.orders.Order;
import fooddelivery.orders.OrderQueue;
import fooddelivery.orders.UndoStack;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        
        UserManager um = new UserManager(); 
        RiderPriorityQueue rpq = new RiderPriorityQueue();
        DataCache dataCache = new DataCache();
        FoodBST foodMenu = new FoodBST(dataCache);
        Graph mapGraph = new Graph();
        Dijkstra routeFinder = new Dijkstra(mapGraph);
        OrderQueue orderQueue = new OrderQueue();
        UndoStack undoStack = new UndoStack();
        int orderIdCounter = 1;
        
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
            System.out.println("Enter choice: ");

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
                    orderQueue.showMenu(sc, undoStack);
                    break;
                case 3:
                    rpq.showMenu(sc);
                    break;
                case 4:
                    routeFinder.showMenu(sc);  
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