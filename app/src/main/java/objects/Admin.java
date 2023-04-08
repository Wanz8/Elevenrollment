/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;
/**
 *
 * @author tgbad
 */
public class Admin extends User {
    private String password;
        
    public Admin(String firstName, String lastName) {
        name = firstName + " " + lastName;
        email = firstName + lastName;
        id = staffIdCount++;
        type = this;
        stringType = "Admin";
        address = "null";
        phone = 0000000000;
        
        this.password = "Asdf";
    }

}