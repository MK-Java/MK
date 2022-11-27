/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.time.LocalDateTime;
import java.util.ArrayList;

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
public class Account {
    
    private final long accountNumber;
    private final Customer customer;
    private double balance;
    private final ArrayList<Transaction> transactions;
    private final boolean hasLimitedWithdrawals;
    private static final double SAVING_INTEREST = 5.80;
    
    /**
     * constructor with  parameters
     * @param accountNumber
     * @param customer
     * @param hasLimitedWithdrawals 
     */

    public Account(long accountNumber, Customer customer, boolean hasLimitedWithdrawals) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.hasLimitedWithdrawals = hasLimitedWithdrawals;
        transactions = new ArrayList<Transaction>();
    }
/**
 * getter for getAccountNumber
 * @return account number
 */
    public long getAccountNumber() {
        return accountNumber;
    }
/**
 * getter for getCustomer
* @return customer
 */
    public Customer getCustomer() {
        return customer;
    }
/**
 * getter for getBalance
 * @return balance
 */
    public double getBalance() {
        return balance;
    }
/**
 * getter for Transactions
 * @return transactions
 */
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
/**
 * getter for hasLimitedWithdrawals
 * @return hasLimitedWithdrawals
 */
    public boolean isHasLimitedWithdrawals() {
        return hasLimitedWithdrawals;
    }
/**
 * getter for savings_interest
 * @return SAVING_INTEREST
 */
    public static double getSAVING_INTEREST() {
        return SAVING_INTEREST;
    }
/**
 *  generateStatement method
 * @return string
 */
    public String generateStatement() {
        String statement = "";
        if (hasLimitedWithdrawals) {
            statement = statement + customer.toString()+"\n" + "Account Number: " + accountNumber + "\n" + "Account Information:-	Interest Rate: 5.80%" + "\n" + "Transaction Limit for withdrawal: 7 Transactions" + "\n" + "-------------------------------------------------------------------------------\n";
        } else {
            statement = statement + customer.toString()+"\n" + "Account Number: " + accountNumber + "\n" + "Account Information:-	Interest Rate: 5.80%" + "\n" + "Transaction Limit for withdrawal: No Limit" + "\n" + "-------------------------------------------------------------------------------\n";
        }

        statement = statement + "Transaction Type    Transaction Time         Amount          Additional Charges       Status    " + "\n";
        for (int i = 0; i < transactions.size(); i++) {
            statement = statement + String.format("%-20s%-25s%-16.2f%-25.2f%-10s\n", transactions.get(i).getTransactionType(), transactions.get(i).getTransactionTime(), transactions.get(i).getAmount(), transactions.get(i).getAdditionalCharges(), transactions.get(i).getStatus());

        }

        return statement;
    }
/**
 * getNoofWithdrawals method
 * @return number of withdrawals
 */
    public int getNoofWithdrawals() {
        int record = 0;
        for (Transaction trans : transactions) {
            if (trans.getTransactionType().equals("WITHDRAW")) {
                if (trans.getTransactionTime().getMonthValue() == 3) {
                    record++;
                }
            }
        }
        return record;
    }
/**
 * @param transaction
 * @return status
 */
    public String makeTransaction(Transaction transaction) {
        String str = "";
        int withdraw = 0;
        int length = transactions.size();
        for (int i = 0; i < length; i++) {
            if (transaction.getTransactionType().equals("WITHDRAW")) {
                if (transactions.get(i).getTransactionTime().getMonthValue() == transaction.getTransactionTime().getMonthValue()) {
                    withdraw++;
                }
            }
        }

        if (transaction.getTransactionType().equals("WITHDRAW")) {
            if (balance < transaction.getAmount()) {
                transaction.setAdditionalCharges(0);
                transaction.setStatus("FAILED");
                str = "Insufficient Balance";
            } else {
                if (hasLimitedWithdrawals) {
                    if (withdraw > 7) {
                        transaction.setAdditionalCharges(0);
                        transaction.setStatus("FAILED");
                        str = "MaxTransactions";
                    } else {
                        transaction.setAdditionalCharges(0);
                        transaction.setStatus("SUCCESS");
                        str = "Transaction Successful";
                        balance = balance - transaction.getAmount();
                        balance = (Math.round(balance * 100)) / 100.0;
                    }
                } else {
                    if (withdraw > 6) {
                        double addCharges = (transaction.getAmount() * (SAVING_INTEREST + 1)) / 100;
                        addCharges = (Math.round(addCharges) * 100) / 100.0;
                        transaction.setAdditionalCharges(addCharges);
                        transaction.setStatus("SUCCESS");
                        str = "Transaction Successful";
                        balance = balance - transaction.getAmount() - addCharges;
                        balance = (Math.round(balance * 100)) / 100.0;
                    } else {
                        transaction.setAdditionalCharges(0);
                        transaction.setStatus("SUCCESS");
                        str = "Transaction Successful";
                        balance = balance - transaction.getAmount();
                        balance = (Math.round(balance * 100)) / 100.0;
                    }

                }
            }
        } else if (transaction.getTransactionType().equals("ONLINEPURCHASE")) {
            if (balance < transaction.getAmount()) {
                transaction.setAdditionalCharges(0);
                transaction.setStatus("FAILED");
                str = "Insufficient Balance";
            } else {
                double addCharges = 1.99;
                //addCharges =(Math.round(addCharges)*100)/100.0;
                transaction.setAdditionalCharges(addCharges);
                transaction.setStatus("SUCCESS");
                str = "Transaction Successful";
                balance = balance - transaction.getAmount() - addCharges;
                balance = (Math.round(balance * 100)) / 100.0;
            }
        } else if (transaction.getTransactionType().equals("DEPOSIT")) {
            transaction.setAdditionalCharges(0);
            transaction.setStatus("SUCCESS");
            str = "Transaction Successful";
            balance = balance + transaction.getAmount();
            balance = (Math.round(balance * 100)) / 100.0;
        }

        transactions.add(transaction);
        return str;
    }
}