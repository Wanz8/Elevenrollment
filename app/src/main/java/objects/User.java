/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package objects;
/**
 *
 * @author tgbad
 */
public abstract class User {
    //public static void main(String[] args) { System.out.println("Hello World!"); }    
    protected String name;
    protected String email; 
    protected int id;
    protected User type;
    protected String stringType;
    protected static int count = 1;
    protected static int staffIdCount = 1;
        
    protected String address;
    protected long phone;
    //protected Person emergency contact;
    
    public String getName(){
        return name;
    }        
    public String getEmail(){
        return email + "@myumanitoba.ca";
    }
    public int getId(){
        return id;
    }
    public String getUserType() {
        return stringType;
    }        
    public void setName(String firstName, String lastName){
        //name and email is set
        name = firstName + " " + lastName;
        email = firstName + lastName;
    }
    
    public void printUserInfo()
    {
        System.out.println(this.getName() + ", " + this.getEmail() + ", id - " + this.getId() + ", " + this.getUserType());
    }
    
    public void setPhoneNumber(int num)
    {
        phone = num;
    }
    
    public void setAddress(String addr)
    {
        address = addr;
    }
}



