package org.example;

import java.util.ArrayList;
import java.util.List;

public class Mem {
    private final String name;
    private final long phnum;
    private final int rollno;
    private final int age;
    private final List<Book> borrowed;
    private int fine;

    public Mem(String name, long phnum, int rollno, int age){
        this.name=name;
        this.phnum=phnum;
        this.rollno=rollno;
        this.age=age;
        this.fine=0;
        this.borrowed = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public int getRollno() {
        return rollno;
    }

    public String getName() {
        return name;
    }

    public long getPhnum() {
        return phnum;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public List<Book> getBorrowed() {
        return borrowed;
    }
    public int no_of_borrowed(){
        return borrowed.size();
    }
    public void borrow(Book book){
        borrowed.add(book);
        book.borrow();
    }

    public void retbook(int id){
        Book book = null;
        for (Book mbook: borrowed){
            if (mbook.getId()==id){
                book=mbook;
                break;
            }
        }
        if (book!=null) {
            book.setAvailable_copies(book.getAvailable_copies() + 1);
            borrowed.remove(book);
            book.retbook(this);
        }
    }
    public void updatefine(double charge){
        fine +=(int)charge;
    }
}
