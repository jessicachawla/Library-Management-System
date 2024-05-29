package org.example;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class LibraryPortal {
    public static void main(String[] args) {
        Lib library = new Lib();

        System.out.println("Library Portal initialized....");
        System.out.println("---------------------------------");

        Scanner scan = new Scanner(System.in);
        int x;
        do{
            System.out.println("1. Enter as a librarian");
            System.out.println("2. Enter as a member");
            System.out.println("3. Exit");
            System.out.println("---------------------------------");
            System.out.println("Enter your choice");

            x = scan.nextInt();
            System.out.println("---------------------------------");


            switch (x) {
                case 1 -> libMenu(library);
                case 2 -> {
                    scan.nextLine();
                    System.out.println("Enter name: ");
                    String mem_name = scan.nextLine();
                    System.out.println("Enter phone number: ");
                    long mem_phnum = scan.nextLong();
                    if (library.checkmem(mem_phnum) != null) {
                        if (Objects.equals(library.checkmem(mem_phnum).getName(), mem_name)) {
                            System.out.println("Welcome " + mem_name + ". Member ID: " + mem_phnum);
                            System.out.println("---------------------------------");
                            membermenu(library, mem_phnum);
                        } else {
                            System.out.println("wrong name inputted");
                            System.out.println("---------------------------------");
                        }
                    } else {
                        System.out.println("Member with Name: " + mem_name + " and Phone No: " + mem_phnum + " doesn't exist");
                        System.out.println("---------------------------------");
                    }
                }
                case 3 -> {
                    System.out.println("Thanks for visiting!");
                    System.out.println("---------------------------------");
                }
            }
        }while (x!=3);
    }
    private static void libMenu(Lib lib){
        Scanner scan = new Scanner(System.in);
        int x;

        do {
            System.out.println("Librarian Menu");
            System.out.println("1. Register a member");
            System.out.println("2. Remove a member");
            System.out.println("3. Add a book");
            System.out.println("4. Remove a book");
            System.out.println("5. View all members with their books and fines to be paid");
            System.out.println("6. View all books");
            System.out.println("7. Back");
            System.out.println("---------------------------------");
            System.out.print("Enter your choice: ");

            x = scan.nextInt();
            System.out.println("---------------------------------");
            scan.nextLine();

            switch (x) {
                case 1 -> {
                    System.out.println("Name: ");
                    String name = scan.nextLine();
//                    scan.next();
                    System.out.println("Phone Number: ");
                    long phnum = scan.nextLong();
                    int check_phnum = String.valueOf(phnum).length();
                    if(check_phnum!=10){
                        System.out.println("Phone number must contain 10 digits");
                        System.out.println("---------------------------------");
                        break;
                    }
//                    while (true) {
//                        System.out.println("Phone Number: ");
//                        if (scan.hasNextInt()) {
//                            phnum = scan.nextInt();
//                            break;
//                        } else {
//                            System.out.println("Invalid input. Please enter a valid integer for the phone number.");
//                            scan.next();
//                        }
//                    }
                    System.out.println("Roll number: ");
                    int rollno = scan.nextInt();
                    System.out.println("Age: ");
                    int age = scan.nextInt();
                    System.out.println(lib.addmem(name, phnum, rollno, age));
                    System.out.println("---------------------------------");
                }
                case 2 -> {
                    System.out.println("Enter the phone number of the member to be removed: ");
                    long phone = scan.nextLong();
                    System.out.println(lib.removemem(phone));
                    System.out.println("---------------------------------");
                }
                case 3 -> {
                    System.out.println("Title : ");
                    String title_add = scan.nextLine();
                    System.out.println("Author: ");
                    String author_add = scan.nextLine();
                    System.out.println("Copies: ");
                    int copies_add = scan.nextInt();
                    System.out.println(lib.addbook(title_add, author_add, copies_add));
                    System.out.println("---------------------------------");
                }
                case 4 -> {
                    System.out.println("Enter the book title: ");
                    String title_rem = scan.nextLine();
                    System.out.println("Enter Book id: ");
                    int id_rem = scan.nextInt();
                    Book book_rem = lib.checkbook(id_rem);
                    if (book_rem != null) {
                        System.out.println(lib.removeBook(book_rem));
                    } else System.out.println("Book: " + title_rem + " with Book id " + id_rem + " not found.");
                    System.out.println("---------------------------------");
                }
                case 5 -> {
                    System.out.println("List of all members with their books and fines to be paid");
                    System.out.println();
                    lib.printmembers();
                    System.out.println("---------------------------------");
                }
                case 6 -> {
                    System.out.println("LIST OF ALL BOOKS ");
                    System.out.println();
                    lib.printbooks();
                    System.out.println("---------------------------------");
                }
                case 7 -> System.out.println("---------------------------------");
                default -> {
                    System.out.println("Please choose a valid option");
                    System.out.println("---------------------------------");
                }
            }
        }while(x!=7);

    }

    private static void membermenu(Lib lib, long phnum) {
        Scanner scan = new Scanner(System.in);
        int x;

        do {
            System.out.println("1. List Available Books");
            System.out.println("2. List My Books");
            System.out.println("3. Issue book");
            System.out.println("4. Return book");
            System.out.println("5. Pay Fine");
            System.out.println("6. Back");
            System.out.println("---------------------------------");
            System.out.println("Enter your choice: ");

            x = scan.nextInt();
            System.out.println("---------------------------------");


            switch (x) {
                case 1:
                    System.out.println("LIST OF AVAILABLE BOOKS IN THE LIBRARY ");
                    System.out.println();
                    lib.printavailablebooks();
                    System.out.println("---------------------------------");
                    break;

                case 2:
                    System.out.println("List of my books");
                    System.out.println();

                    Mem mem = lib.checkmem(phnum);
                    List<Book> borrowed = mem.getBorrowed();
                    if (!borrowed.isEmpty()) {
                        for (Book book : borrowed) {
                            System.out.println("Title: " + book.getTitle());
                            System.out.println("Author: " + book.getAuthor());
                            System.out.println("Book id: " + book.getId());
                            System.out.println();
                        }
                    } else System.out.println("No borrowed books");
                    System.out.println("---------------------------------");
                    break;

                case 3:
                    Mem mem_is = lib.checkmem(phnum);
                    if(mem_is.getFine()!=0 || mem_is.no_of_borrowed()>1){
                        System.out.println("Not eligible for issuing book");
                        System.out.println("---------------------------------");
                        break;
                    }else{
                        lib.printavailablebooks();
                        System.out.println();
                        scan.nextLine();
                        System.out.println("Enter the title of the book: ");
                        String title_is= scan.nextLine();
                        System.out.println("Enter the id of the book: ");
                        int id_is = scan.nextInt();
                        Book issuebook = lib.checkbook(id_is);

                        if(issuebook!=null){
                            if(Objects.equals(issuebook.getTitle(), title_is)){
                                mem_is.borrow(issuebook);
                                System.out.println(title_is+" with book id "+ id_is+ " has been issued to "+mem_is.getName());
                            }else System.out.println("Title and book id do not match");
                        }else System.out.println("Book not available/does not exist in lib");
                        System.out.println("---------------------------------");
                        break;
                    }

                case 4:
                    Mem member = lib.checkmem(phnum);
                    List<Book> borrowed_ret = member.getBorrowed();

                    if (!borrowed_ret.isEmpty()) {
                        for (Book book : borrowed_ret) {
                            System.out.println("Title: " + book.getTitle());
                            System.out.println("Author: " + book.getAuthor());
                            System.out.println("Book id: " + book.getId());
                            System.out.println();
                        }
                        System.out.println("Enter the id of the book to return: ");
                        int id_ret = scan.nextInt();

                        for (Book book : borrowed_ret) {
                            if (book.getId() == id_ret) {
                                String bookTitle = book.getTitle();
                                //Book ret_book = lib.checkbook(id_ret);
                                member.retbook(id_ret);
                                System.out.println("Book :"+ bookTitle+ " with Book ID: " + id_ret + " returned successfully."+ member.getFine() +" Rupees has been charged for "+ (member.getFine()/3)+" days");
                                break;
                            }
                        }
                    } else System.out.println("No borrowed books");
                    System.out.println("---------------------------------");
                    break;

                case 5:
                    Mem mem_finepay = lib.checkmem(phnum);
                    if(mem_finepay.getFine()==0){
                        System.out.println("No fine due");
                    }
                    else{
                        System.out.println("You had a total fine of Rs. "+ mem_finepay.getFine()+ "  It has been paid successfully!");
                        mem_finepay.setFine(0);
                    }
                    System.out.println("---------------------------------");
                case 6:
                    System.out.println("---------------------------------");
                    break;

                default:
                    System.out.println("Please choose a valid option");
                    System.out.println("---------------------------------");
                    break;
            }

        }while(x!=6);
    }

}
