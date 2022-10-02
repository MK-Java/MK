package mk;

import java.util.Scanner;

public class SchoolPlay {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter s for student, f for faculty, and c for community > ");
        char ticketType = sc.nextLine().charAt(0);
        System.out.print("Enter number of tickets > ");
        int noOfTickets = sc.nextInt();
        String temp = Character.toString(ticketType);
        if (temp.equalsIgnoreCase("s") || temp.equalsIgnoreCase("f") || temp.equalsIgnoreCase("c")) {
            System.out.println("Your ticket total is $" + totalTicketPrice(ticketType, noOfTickets));
        } else {
            System.out.println("You did not enter a correct code.");
        }
    }

    private static int totalTicketPrice(char ticketType, int noOfTickets) {

        switch (ticketType) {
            case 's':
                //Student - 1 ticket is $12, 2-9 tickets $10 each, 10 or more tickets $8 each
                if (noOfTickets == 1) {
                    return noOfTickets * 12; // 1 ticket is $12
                } else if (noOfTickets > 1 && noOfTickets < 10) {
                    return noOfTickets * 10; //  2-9 tickets $10 each
                } else if (noOfTickets > 9) {
                    return noOfTickets * 8; // 10 or more tickets $8 each
                }
                break;

            case 'f':
                //Faculty - 1 ticket is free, 2 or more tickets is $20 each
                if (noOfTickets == 1) {
                    return 0; // for 1 ticket, it is free for faculty.
                } else if (noOfTickets > 1) {
                    return noOfTickets * 20; //2 or more tickets is $20 each
                }
                break;
            case 'c':
                //Community -  1 ticket is $22, 2-9 tickets $18 each, 10 or more tickets $15 each
                if (noOfTickets == 1) {
                    return noOfTickets * 22; //1 ticket is $22
                } else if (noOfTickets > 1 && noOfTickets < 10) {
                    return noOfTickets * 18; //2-9 tickets $18 each
                } else if (noOfTickets > 9) {
                    return noOfTickets * 15; //10 or more tickets $15 each
                }
                break;
            default:
                return 0;
        }
        return 0;
    }

}
