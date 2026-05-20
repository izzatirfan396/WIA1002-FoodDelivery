package fooddelivery.users;


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
       
    }

  
}
