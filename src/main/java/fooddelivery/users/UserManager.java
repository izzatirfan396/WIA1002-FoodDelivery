package fooddelivery.users;

import fooddelivery.utils.InputHelper;
import java.util.Scanner;


public class UserManager {
    
    //Manage the User and Restaurant in the two type of linkedList , which one is User type and Restaurant type
    MyLinkedList<User> userList ; 
    MyLinkedList<Restaurant> restaurantList ;

    public UserManager() { //Constructor create the list for both types
        userList = new MyLinkedList<>();
        restaurantList = new MyLinkedList<>();
    }
    
    public void addUser(User e){ // add a user object into the list
        userList.add(e);
    }
    
    public void removeUser(User e){ // remove a user from the list
        userList.remove(e); 
    } 
    
    public void displayUser(){
         if(userList.size>0){
                System.out.printf("%-15s %-30s %-12s %-10s%n", "ID", "Name", "Phone", "Address" ); //display all the user in formatted and clean way
                for (int i = 0; i < userList.size; i++) {
                    String id = userList.get(i).getId();
                    String name = userList.get(i).getName();
                    String phone = userList.get(i).getPhone();
                    String address = userList.get(i).getAddress();
                System.out.printf("%-15s %-30s %-12s %-10s%n", id, name, phone, address);
                }
                }else{
                    System.out.println("There is no User registered !");
                }
    }
    
     public User findUserById(String ic){ // find the object that contains the id input 
        for (int i = 0; i < userList.size; i++) {
            if(userList.get(i).getId().equals(ic)){
                return userList.get(i);
            }
        }
        return null ;
    }
    
    public boolean checkUserId(String ic){ // to ensure the id entered is unique
        for (int i = 0; i < userList.size; i++) {
            if(userList.get(i).getId().equals(ic)){
                return false;
            }
        }
        return true ;
    }

    public void addRestaurant( Restaurant e ){
        restaurantList.add(e);
    }

    public void removeRestaurant( Restaurant e ){ 
        restaurantList.remove(e); 
    } 

    public void displayRestaurant(){
        if(restaurantList.size>0){
                System.out.printf("%-15s %-30s %-10s%n ", "ID", "Name", "Address" ); //display all the user in formatted and clean way
                for (int i = 0; i < restaurantList.size; i++) {
                    String id = restaurantList.get(i).getId();
                    String name = restaurantList.get(i).getName();
                    String address = restaurantList.get(i).getAddress();
                System.out.printf("%-15s %-30s %-10s%n", id, name, address);
                }
                }else{
                    System.out.println("There is no Restaurant registered !");
                }
    }
    
    public Restaurant findRestaurantById(String id){ //find the object that contains the id input 
        for (int i = 0; i < restaurantList.size; i++) {
            if(restaurantList.get(i).getId().equals(id)){
                return restaurantList.get(i);
            }
        }
        return null ;
    }
    
    public boolean checkRestaurantId(String id){ // to ensure the id entered is unique
        for (int i = 0; i < restaurantList.size; i++) {
            if(restaurantList.get(i).getId().equals(id)){
                return false;
            }
        }
        return true ;
    }
    
   
    
    public void showMenu(Scanner sc) { 
        
        //declared variable outside the switch-case block to ensure that all case can reuse the same variables declared
        int choice ; 
        String id ; 
        String name ;
        String phone ; 
        String address ; 
        
    do{
        System.out.println("--- User & Restaurant Management ---");
        System.out.println();
        System.out.println("1. Register New User ");
        System.out.println("2. Remove User");
        System.out.println("3. Display All User");
        System.out.println("4. Register New Restaurant");
        System.out.println("5. Remove Restaurant");
        System.out.println("6. Display All Restaurant");
        System.out.println("0. Exit");
        System.out.println("------------------------------------");    
        System.out.println("Enter choice: ");
        choice = InputHelper.readInt(sc);
        System.out.println();
        
        switch(choice){
            case 1 :
                
                System.out.println("Enter IC number  : ");
                 id = InputHelper.readString(sc);
                System.out.println();
                
                if(checkUserId(id)){ //Check to ensure that no duplicated id is entered (ID should be unique)
                
                System.out.println("Enter name : ");
                 name = InputHelper.readString(sc);
                System.out.println();
                
                System.out.println("Enter phone number : ");
                 phone = InputHelper.readString(sc);
                System.out.println();
                
                System.out.println("Enter Address : ");
                 address = InputHelper.readString(sc);
                System.out.println();
                
                userList.add(new User(id , name , phone , address )); // create the object User to assign the fields needed in constructor
                System.out.println("User succesfully registered ! ");
                
                }else{
                    System.out.println("IC entered is already registered !"); // if the id is alredy registered 
                }
                break;
                
            case 2 : { // this curly braces indicate this block of codes so that the variable target declared here only belong in this block not for other cases
                System.out.println("Enter the IC user want to be delete : ");
                id = InputHelper.readString(sc);
                User targetUser = findUserById(id); // save the user that contain the id entered to variable "target"
                if(targetUser!=null){ //if the user exist it wont equal to null 
                    userList.remove(targetUser); // remove the user
                    System.out.println("Succesfully removed !"); 
                }else{
                    System.out.println("Invalid IC entered.");
                }
                break ;
            }    
            case 3 : 
                
                displayUser();// just call the readily method to display
                break ; 
                
            case 4 :
                System.out.println("Enter ID number  : ");
                 id = InputHelper.readString(sc);
                System.out.println();
                
                if(checkRestaurantId(id)){
                
                System.out.println("Enter name : ");
                 name = InputHelper.readString(sc);
                System.out.println();
                
                System.out.println("Enter Address : ");
                 address = InputHelper.readString(sc);
                System.out.println();
                
                restaurantList.add(new Restaurant(id , name , address )); // create the object Restaurant to assign the fields needed in constructor
                System.out.println("Restaurant succesfully registered ! ");
                }else{
                    System.out.println("ID is already taken !");
                }
                break;
                
            case 5 : { // this curly braces indicate this block of codes so that the variable target declared here only belong in this block not for other cases
                System.out.println("Enter the ID user want to be delete : ");
                id = InputHelper.readString(sc);
                Restaurant targetRestaurant = findRestaurantById(id); // save the restaurant object that contain the id entered to variable "target"
                if(targetRestaurant!=null){ //if the restaurant  exist it wont equal to null 
                    restaurantList.remove(targetRestaurant); // remove the restaurant
                    System.out.println("Succesfully removed !"); 
                }else{ 
                    System.out.println("Invalid ID entered.");
                }
                break ;
            }   
            case 6 : 
                displayRestaurant(); // just call the readily method
                break ;    
                
            case 0 :
                System.out.println("Returning to Main Menu !"); 
                break;
                
                
        
        }
    } while(choice!=0) ; // will repeat until the choice == 0 
       
    }
}
