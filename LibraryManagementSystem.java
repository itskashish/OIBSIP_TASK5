import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title, author;
    boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + (available ? "Yes" : "No"));
    }
}

class Library {
    ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    void addBook(Book book) {
        books.add(book);
    }

    void displayAllBooks() {
        for (Book book : books) {
            book.displayInfo();
            System.out.println("--------------");
        }
    }

    Book searchBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    void issueBook(Book book) {
        if (book != null && book.available) {
            book.available = false;
            System.out.println("Book issued successfully!");
        } else {
            System.out.println("Book not available for issuing.");
        }
    }

    void returnBook(Book book) {
        if (book != null && !book.available) {
            book.available = true;
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Invalid return operation.");
        }
    }
}

class User {
    String username, email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
}

class Admin {
    // Admin-related functionalities...
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("Book1", "Author1"));
        library.addBook(new Book("Book2", "Author2"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Display all books");
            System.out.println("2. Search for a book");
            System.out.println("3. Issue a book");
            System.out.println("4. Return a book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.displayAllBooks();
                    break;
                case 2:
                    System.out.print("Enter the title of the book to search: ");
                    scanner.nextLine(); // Consume the newline character
                    String searchTitle = scanner.nextLine();
                    Book foundBook = library.searchBook(searchTitle);
                    if (foundBook != null) {
                        foundBook.displayInfo();
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the title of the book to issue: ");
                    scanner.nextLine(); // Consume the newline character
                    String issueTitle = scanner.nextLine();
                    Book issueBook = library.searchBook(issueTitle);
                    library.issueBook(issueBook);
                    break;
                case 4:
                    System.out.print("Enter the title of the book to return: ");
                    scanner.nextLine(); // Consume the newline character
                    String returnTitle = scanner.nextLine();
                    Book returnBook = library.searchBook(returnTitle);
                    library.returnBook(returnBook);
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
