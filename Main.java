import java.util.*;
import manager.*;
import model.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryManager library = new LibraryManager();
        LoginManger login = new LoginManger();

        User currentUser = null;
        while (currentUser == null) {
            System.out.println("1.Login");
            System.out.println("2.Register");
            System.out.println("3.Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.print("Username:");
                String username = sc.next();
                System.out.print("password:");
                String password = sc.next();
                currentUser = login.login(username, password, library.getAllUsers());
                if (currentUser == null) {
                    System.out.println("Invalid user or passwor,Try again");
                }
            } else if (choice == 2) {
                System.out.println("Name:");
                String name = sc.nextLine();
                System.out.println("Username:");
                String username = sc.next();
                System.out.println("Password:");
                String password = sc.next();
                int userId = 1000 + new Random().nextInt(9000);
                User newUser = new User(userId, name, username, password, false);
                library.addUser(newUser);
                System.out.println("User register seccessful,Now you can Login");
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                return;
            } else {
                System.out.println("Invalid Choice,Try again");
            }
        }

        System.out.println("Welcome" + currentUser.getName());

        do {
            int choice;
            System.out.println("=====Menu=====");
            if (currentUser.getIsAdmin()) {
                System.out.println("1. Add Book");
                System.out.println("2. View Book");
                System.out.println("3. View User");
                System.out.println("4. Logout");
                choice = sc.nextInt();
                if (choice == 1) {
                    System.out.print("Book Title:");
                    String title = sc.nextLine();
                    System.out.print("Book Author:");
                    String author = sc.nextLine();
                    System.out.print("Book Publisher:");
                    String publisher = sc.nextLine();
                    System.out.print("Book Year:");
                    int year = sc.nextInt();
                    System.out.print("Copies");
                    int copies = sc.nextInt();
                    int bookId = 1000 + new Random().nextInt(9000);
                    Book newBook = new Book(bookId, title, author, publisher, year, copies);
                    library.addBook(newBook);
                    System.out.println();
                    System.out.println("Book Added Successfully");
                } else if (choice == 2) {
                    System.out.println("=====Book List=====");
                    library.viewAllBooks();
                } else if (choice == 3) {
                    System.out.println("=====User List=====");
                    ArrayList<User> users = library.getAllUsers();
                    for (User u : users) {
                        String role;
                        if (u.getIsAdmin()) {
                            role = "Admin";
                        } else {
                            role = "Users";
                        }
                        System.out.println(u.getUserId() + ":" + u.getName() + " |Role" + role);
                    }

                } else if (choice == 4) {
                    System.out.println("Logged out");
                } else {
                    System.out.println("Invalid choice Try again");
                }
            } else {
                System.out.println("1.View Book");
                System.out.println("2.Search Book");
                System.out.println("3.Borrow Book");
                System.out.println("4.Return Book");
                System.out.println("5.MyBorrowed Book");
                System.out.println("6.Logout");
                choice = sc.nextInt();
                if (choice == 1) {
                    System.out.println("=====Book List=====");
                    library.viewAllBooks();
                } else if (choice == 2) {
                    System.out.println("Keyword");
                    String keyword = sc.nextLine();
                    library.searchBookByTitle(keyword);
                } else if (choice == 3) {
                    System.out.println("Book ID:");
                    int bookId = sc.nextInt();
                    library.borrowBook(bookId, currentUser.getUserId());
                } else if (choice == 4) {
                    System.out.println("Book ID:");
                    int bookId = sc.nextInt();
                    library.returnBook(bookId, currentUser.getUserId());
                } else if (choice == 5) {
                    currentUser.showBorrowedBooks();
                } else if (choice == 6) {
                    System.out.println("=====Logged Out=====");
                    return;
                } else {
                    System.out.println("Invalid Choice,Try again");
                }
            }
        } while (true);
    }
}
