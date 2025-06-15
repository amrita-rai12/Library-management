package model;
import java.util.*;

public class User {
    private int userId;
    private String name;
    private String username;
    private String password;
    private boolean isAdmin;
    private ArrayList<Integer>borrowedBooks=new ArrayList<>();

 
    public User(int id, String name, String username, String password, boolean isAdmin){
        this.userId = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public int getUserId(){
        return userId;
    }
    public String getName(){
        return name;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public boolean getIsAdmin(){
        return isAdmin;
    }

   public ArrayList<Integer>getBorrowedBooks() {
    return borrowedBooks;
   }

   public void borrowBook(int id){
    borrowedBooks.add(id);
   }

   public void returnBook(int id){
    borrowedBooks.remove(id);
   }
   public void showBorrowedBooks(){
    if(borrowedBooks.isEmpty()){
        System.out.println("you have not borrowed any books.");
    }else{
        System.out.println("Borrowed Books:" +borrowedBooks);
    }
   }
}

