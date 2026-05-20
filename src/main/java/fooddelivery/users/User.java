package fooddelivery.users;

public class User {

    private String userId;
    private String name;
    private String phone;
    private String address;

    //assigning the user id , name , phone number , and address to the object
    public User(String userId, String name, String phone, String address) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
    
    //get the userId
    public String getId(){
        return this.userId;
    }
    
    // for the userId they cant change once already set when they register
    
    //get the name
    public String getName(){
        return this.name;
    }
    
    //set the name (if the user might want to change name in the future )
    public void setName(String name){
        this.name = name ;
    }
    
    //get the user phone number 
    public String getPhone(){
        return this.phone;
    }
    
    //set the phone number (if the user might want to change their phone number )
    public void setPhone(String phone){
        this.phone = phone ;
    }
    
    //get the userAddress
    public String getAddress(){
        return this.address;
    }
    
    //set the address (if the user might want to change address in the future)
    public void setAddress(String address){
        this.address = address ;
    }
    
    @Override
    public String toString() {
        return "User{userId='" + userId + "', name='" + name + "', phone='" + phone + "', address='" + address + "'}";
        //example : User{userId='U001', name='Ahmad', phone='01234567', address='no 10 jaofsfnnjfnd'}
    }
}
