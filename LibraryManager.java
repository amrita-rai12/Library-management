package manager;
import java.util.*;
import model.*;

public class LibraryManager {
    private ArrayList<Book> books=new ArrayList<>();
    private ArrayList<User> users=new ArrayList<>();
    public void addBook(Book book){
        books.add(book);
    }
    public void addUser(User u){
        users.add(u);
    }

   
    public Book getBookbyId(int id){
        for(Book b:books){
            if(b.getId()==id){
                return b;
            }
        }
        return null;
    }
    public ArrayList<User>getAllUsers(){
        return users;
    }

    public void searchBookByTitle(String k){
        String keyword=k.toLowerCase();
        boolean found=false;
        for(Book b:books){
         String bTitle=b.getTitle().toLowerCase();
         if(bTitle.contains(keyword)){
            System.out.println(b);
            found=true;
         }
        }
        if(found==false){
            System.out.println("Books not found");
        }
    }

    public void borrowBook(int bookId, int userId){
        Book b = getBookbyId(bookId);
        User u = getUserById(userId);
        if(u!=null && b!=null && b.getCopies() > 0){
          b.decreasecopies();
          u.borrowBook(bookId);
          System.out.println("Book borrowed successful");
        }else{
            System.out.println("Book not found or user not found");
        }
    }

    public void returnBook(int bookId, int userId){
        Book b=getBookbyId(bookId);
        User u=getUserById(userId);
        if(b!=null&&u!=null){
            b.increasecopies();
            u.returnBook(bookId);
            System.out.println("Book returned successfully");
        }    

    
        else{
        System.out.println("Unable to return book");
        }
    }
    
    public User getUserById(int id){
        for(User u: users){
            if(u.getUserId()==id){
                return u;
            }
        }
        return null;
    }
    public void viewAllBooks(){
        if(books.isEmpty()){
            System.out.println("No books in the library");
        }else{
            for(Book b: books){
                System.out.println(b.getTitle());
            }
        }
    }
    public void viewAllUser(){
        if(users.isEmpty()==true){
            System.out.println("No users in the library");
        }else{
            for(User u: users){
                System.out.println(u.getName());
            }
        }

    }   
}
