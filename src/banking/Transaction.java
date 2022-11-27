/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.time.LocalDateTime;

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
public class Transaction {
    
    private double additionalCharges;
    private double amount;
    private String status;
    private LocalDateTime transactionTime;
    private String transactionType;
/**
 * Constructor with parameters
 * @param transactionType
 * @param amount
 * @param transactionTime 
 */
    public Transaction(String transactionType, double amount, LocalDateTime transactionTime) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionTime = transactionTime;

    }
/**
 * Getter for getAdditionalCharges
 * @return additional charges
 */
    public double getAdditionalCharges() {
        return additionalCharges;
    }
/**
 * Getter for getAmount
 * @return amount
 */
    public double getAmount() {
        return amount;
    }
/**
 * Getter for getStatus
 * @return status
 */
    public String getStatus() {
        return status;
    }
/**
 * Getter for getTransactionTime
 * @return transaction time
 */
    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }
/**
 * Getter for getTransactionType
 * @return transaction type
 */
 
    public String getTransactionType() {
        return transactionType;
    }
/**
 * Setter for setAdditionalCharges
 * @param additionalCharges 
 */
    public void setAdditionalCharges(double additionalCharges) {
        this.additionalCharges = additionalCharges;
    }
/**
 * Setter for setAmount
 * @param amount 
 */
    public void setAmount(double amount) {
        this.amount = amount;
    }
/**
 * Setter for setStatus
 * @param status 
 */
    public void setStatus(String status) {
        this.status = status;
    }
/**
 * Setter for transactionTime
 * @param transactionTime 
 */
    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }
/**
 * Setter for transactionType
 * @param transactionType 
 */
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
/**
 * toString() method 
 */

    @Override
    public String toString() {
        return transactionType + "             " + transactionTime + "      " + String.format("%.2f", amount) + "         " + additionalCharges + "                     " + status;
    }

    
}