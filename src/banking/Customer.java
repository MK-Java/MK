/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

/**
 * Class: 44542 OBJECT-ORIENTED PROG 03FA22
 *
 * @author Pitchaiah Lella 
 * Description: Making sure everything works 
 * Due:10/26/2022 
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. 
 * I have not given my code to any other student and will not share this code with
 * anyone under my circumstances.
 */
public class Customer {

    private String dob;
    private String firstName;
    private String lastName;
/**
 * constructor parameters
 * @param dob
 * @param firstName 
 * @param lastName 
 */
    public Customer(String dob, String firstName, String lastName) {
        this.dob = dob;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
/**
 * Getter for getDob
 * @return date of birth
 */
    public String getDob() {
        return dob;
    }
/**
 * Getter for getFirstName
 * @return first Name
 */
    public String getFirstName() {
        return firstName;
    }
/**
 * Getter for getLastName
 * @return last Name
 */
    public String getLastName() {
        return lastName;
    }
/**
 * Setter for setDob
 * @param dob 
 */
    public void setDob(String dob) {
        this.dob = dob;
    }
/**
 * Setter for setFirstName
 * @param firstName 
 */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
/**
 * Setter for setLastName
 * @param lastName 
 */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
/**
 * toString() method
 */
    @Override
    public String toString() {
        return "Name: " + lastName + ", " + firstName + "\n" + "Date of Birth: " + dob;
    }

}
