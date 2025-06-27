package com.learn;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Issue Book\n2. Return Book\n3. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID to issue: ");
                    int bookIdIssue = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int userIdIssue = sc.nextInt();
                    lib.issueBook(bookIdIssue, userIdIssue);
                    break;
                case 2:
                    System.out.print("Enter Book ID to return: ");
                    int bookIdReturn = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int userIdReturn = sc.nextInt();
                    lib.returnBook(bookIdReturn, userIdReturn);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
