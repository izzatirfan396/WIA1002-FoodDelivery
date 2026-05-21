package fooddelivery.users;

/**
 * Represents a restaurant registered in the system.
 * Member: izzat
 */
public class Restaurant {

    private String restaurantId;
    private String name;
    private String address;

    //assigning the passed id , name , and address of a restaurant created 
    public Restaurant(String restaurantId, String name, String address) { 
        this.restaurantId = restaurantId;
        this.name = name;
        this.address = address;
    }
    
    //get the restaurant id
    public String getId(){
        return this.restaurantId;
    }
    
    // for the userId they cant change once already set when they register
    
    //get the name
    public String getName(){
        return this.name;
    }
    
    //set the name (if the restaurant might want to change name in the future )
    public void setName(String name){
        this.name = name ;
    }
    
    
    //get the restaurant address
    public String getAddress(){
        return this.address;
    }
    
    //set the address (if the restaurant might want to change address in the future)
    public void setAddress(String address){
        this.address = address ;
    }

    @Override
    public String toString() {
        return "Restaurant{restaurantId='" + restaurantId + "', name='" + name + "', address='" + address + "'}";
         //example : User{restaurantId='U001', name='kfc', address='no 10 jaofsfnnjfnd'}
    }
}
