package fooddelivery.users;

import fooddelivery.utils.InputHelper;
import java.util.Scanner;


public class UserManager {
    
    
    MyLinkedList<User> userList ;
    MyLinkedList<Restaurant> restaurantList ;

    public UserManager() {
        userList = new MyLinkedList<>();
        restaurantList = new MyLinkedList<>();
    }
    
    public void addUser(User e){
        userList.add(e);
    }
    
    public void removeUser(User e){
        userList.remove(e); 
    } 
    
    public void displayUser(){
        for (int i = 0; i < userList.size ; i++) {
            System.out.print(userList.get(i)+ " ");
        }
        System.out.println("");
    }

    public void addRestaurant( Restaurant e ){
        restaurantList.add(e);
    }

    public void removeRestaurant( Restaurant e ){
        restaurantList.remove(e); 
    } 

    public void displayRestaurant(){
        for (int i = 0; i < restaurantList.size ; i++) {
            System.out.print(restaurantList.get(i)+ " ");
        }
        System.out.println("");
    }
    
   
    
    public void showMenu() { 
        Scanner sc = new Scanner(System.in);
        System.out.println("--- User & Restaurant Management ---");
        System.out.println();
        System.out.println("1. Register New User ");
        System.out.println("2. Remove User");
        System.out.println("3. Display All User");
        System.out.println("4. Register New Restaurant");
        System.out.println("5. Remove Restaurant");
        System.out.println("6. Display All Restaurant");
        System.out.println("0. Exit");
        
        System.out.print("Enter choice: ");
        
        int choice = InputHelper.readInt(sc);
        
        switch(choice){
            case 1 :
                System.out.print("Enter IC number  : ");
                String ic = InputHelper.readString(sc);
                System.out.println();
                
                System.out.print("Enter name : ");
                String name = InputHelper.readString(sc);
                System.out.println();
                
                System.out.print("Enter phone number : ");
                String phone = InputHelper.readString(sc);
        }
       
    }

  
}
