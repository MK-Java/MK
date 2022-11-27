/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class: 44542 OBJECT-ORIENTED PROG 03FA22
 *
 * @author Pitchaiah Lella 
 * Description: Making sure everything works 
 * Due:10/25/2022 
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. 
 * I have not given my code to any other student and will not share this code with
 * anyone under my circumstances.
 */
public class BankDriver {

     /**
     * @param args
     * @throws java.io.FileNotFoundException
     */
        // TODO code application logic here
        
        public static void main(String[] args) throws FileNotFoundException {
        DateTimeFormatter dF = DateTimeFormatter.ofPattern("yyyy-M-d H:m:s");
        ArrayList<Account> accounts = new ArrayList<>();
        Scanner scan = new Scanner(new File("C:\\Users\\S556370\\Documents\\NetBeansProjects\\Sundari_Lab07NGTesting\\src\\banking\\input.txt"));
        while (scan.hasNext()) {
            String accountType = scan.nextLine();
            String firstname = scan.next();
            String lastname = scan.nextLine();
            String dob = scan.nextLine();
            long accountNo = scan.nextLong();
            scan.nextLine();
            boolean hasWithdrawLimit = scan.nextBoolean();
            scan.nextLine();
            Customer c = new Customer(dob, firstname, lastname);
            Account newAccount = new Account(accountNo, c, hasWithdrawLimit);
            System.out.println("------------------------------------------------------------");
            System.out.println("Name of the customer: " + c.getFirstName() + " " + c.getLastName());
            System.out.println("------------------------------------------------------------");
            String transactionType = "";
            while (!(transactionType.equals("newAccount")) && scan.hasNext()) {
                transactionType = scan.next();
                if (transactionType.equals("newAccount")) {

                } else {

                    double amount = scan.nextDouble();
                    String date1 = scan.next().trim();
                    String date2 = scan.next().trim();
                    String date = date1 +" "+date2;
                    LocalDateTime local = LocalDateTime.parse(date, dF);
                    Transaction newTransaction = new Transaction(transactionType, amount, local);
                    String res = newAccount.makeTransaction(newTransaction);
                    if (res.equals("MaxTransactions")) {
                        System.out.println("Exceeded number of withdrawals transactions. Number of available withdrawals per month: 6");

                    } else if (res.equals("Insufficient Balance")) {
                        System.out.println("Insufficient funds. Available funds: " + String.format("%.2f", newAccount.getBalance()));
                    } else if (res.equals("Transaction Successful")) {
                        System.out.println("The balance after " + transactionType + " in dollars is " + String.format("%.2f", newAccount.getBalance()));
                    }
                }
            }

            accounts.add(newAccount);
        }
        System.out.println("************************************************************************");
        System.out.println("*********Invoke getNoofWithdrawals() on Account objects**********");
        System.out.println("************************************************************************");
        for (Account acc : accounts) {
            System.out.println(acc.getCustomer().getFirstName() + " made " + acc.getNoofWithdrawals() + " withdrawals in this month.");
        }

        System.out.println("***********************************************************************");
        System.out.println("****Invoke generateStatement() on all objects in accounts ArrayList****");
        System.out.println("************************************************************************");
        for (Account aa : accounts) {
            System.out.print(aa.generateStatement());
            System.out.println("-------------------------------------------------------------------------------");
            double interest = (aa.getBalance() * Account.getSAVING_INTEREST()) / 100;

            System.out.println("Current Balance: " + String.format("%.2f", aa.getBalance()) + "		Interest: $" + String.format("%.2f", interest));
            System.out.println("************************************************************************");
        }
    }

}