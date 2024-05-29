package org.example;

import java.util.ArrayList;
import java.util.List;


public class Lib {
    private final List<Book> allbooks;
    private final List<Mem> members;
    private int helperforauto = 0;

    public Lib(){
        this.allbooks = new ArrayList<>();
        this.members = new ArrayList<>();
    }
    public Book checkbook(int id){
        for (Book book : allbooks) {
            if(book.getId()==id){
                return book;
            }
        }return null;
    }
    public String addbook(String title , String author , int copies){
        for (int i = 0; i < copies; i++) {
            helperforauto++;
            allbooks.add(new Book(helperforauto,title, author));
        }
        return "Books added successfully!";

    }
    public String removeBook(Book book){
        if (book.availbook()){
            allbooks.remove(book);
            return "Book removed sucessfully!";
        }else return "Book has been borrowed, cant be removed at the moment";
    }


    public Mem checkmem(long phone){
        for (Mem member : members) {
            if(member.getPhnum()==phone){
                return member;
            }
        }return null;
    }
    public String addmem(String name, long phnum, int rollno, int age){
        if(checkmem(phnum)!=null){
            return "Already a member!";
        }
        else{
            members.add(new Mem(name, phnum,rollno,age));
            return "Member added successfully!";
        }
    }

    public String removemem(long phnum){
        Mem rem_member = checkmem(phnum);
        if(checkmem(phnum)!=null){
            members.remove(rem_member);
            return "Member removed successfully!";
        }else return "Member doesnt exist!";
    }

    public void printbooks(){
        for (Book book : allbooks){
            System.out.println("Book ID     : "+ book.getId());
            System.out.println("Book Title  : "+ book.getTitle());
            System.out.println("Book Author : "+ book.getAuthor());
            System.out.println("Available   : "+ (book.getAvailable_copies()==1));
            System.out.println();
        }
    }

    public void printavailablebooks(){
        for (Book book : allbooks){
            if (book.availbook()){
                System.out.println("Book ID     : "+ book.getId());
                System.out.println("Book Title  : "+ book.getTitle());
                System.out.println("Book Author : "+ book.getAuthor());

                System.out.println();
            }
        }
    }
    public void printmembers(){
        for (Mem mem:members){
            System.out.println("Name : "+ mem.getName());
            System.out.println("Phone No. : "+ mem.getPhnum());
            System.out.println("Age : "+ mem.getAge());
            System.out.println("Roll No. : "+ mem.getRollno());
            System.out.println("Balance : "+ mem.getFine());
            List<Book> borrowed = mem.getBorrowed();
            System.out.println("Borrowed book list ");
            if(!borrowed.isEmpty()){
                for (Book book:borrowed){
                    int i=1;
                    System.out.println("Borrowed book "+i+" title: " + book.getTitle());
                }
            }
            else System.out.println("No borrowed books");
            System.out.println();
        }
    }
}
