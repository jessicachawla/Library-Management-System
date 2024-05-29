package org.example;

import java.time.LocalDateTime;
import java.time.Duration;

public class Book {

    //private static int helperforauto = 0;
    private final int id;
    private final String title;
    private final String author;
    private int available_copies;
    private LocalDateTime issue;
    private LocalDateTime due;
    //private List<Mem> borrowed;

    public Book(int id, String title , String author){
        //helperforauto++;
        this.id = id;
        this.title = title;
        this.author = author;
        this.available_copies = 1;
        //this.borrowed=new ArrayList<>();
    }
    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }
    public int getId() {
        return id;
    }
    public int getAvailable_copies(){
        return available_copies;
    }

    public void setAvailable_copies(int available_copies) {
        this.available_copies = available_copies;
    }

    public boolean availbook(){
        return available_copies != 0;
    }

//    public String reduce(){
//        if (availbook()) {
//            available_copies--;
//            return "Number of available copies has been reduced";
//        }else return "No copies available";
//    }
    public void borrow() {
        if (availbook()) {
            available_copies--;
            //borrowed.add(member);
            issue = LocalDateTime.now();
            due = issue.plusSeconds(10);
        }
    }
    public void retbook(Mem member){
        available_copies++;
        //borrowed.remove(member);

        LocalDateTime ret = LocalDateTime.now();
        if(due != null && ret.isAfter(due) && issue!=null){
            double no_of_sec = Duration.between(due, ret).getSeconds();
            member.updatefine(no_of_sec*3);
        }
    }
}