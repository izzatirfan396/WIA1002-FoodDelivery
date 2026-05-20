package fooddelivery.users;


public class UserManager<T> {
    
    MyLinkedList<T> list ;

    public UserManager() {
        list = new MyLinkedList<>();
    }
    
    public void add(T e){
        list.add(e);
    }
    
    public void remove(T e){
        list.remove(e); 
    }
    
   
    
    public void showMenu() {
       
    }

  
}
