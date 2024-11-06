import java.util.ArrayList;

abstract class LibraryItem {
    private String title;
    private String author;
    private String itemID;

    // Constructor
    public LibraryItem(String title, String author, String itemID) {
        this.title = title;
        this.author = author;
        this.itemID = itemID;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getItemID() {
        return itemID;
    }

    // Display method to be overridden by subclasses
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Item ID: " + itemID);
    }
}

class Book extends LibraryItem {
    private int numberOfPages;
    private String publisher;

    // Constructor
    public Book(String title, String author, String itemID, int numberOfPages, String publisher) {
        super(title, author, itemID);
        this.numberOfPages = numberOfPages;
        this.publisher = publisher;
    }

    // Overriding display method to include book-specific details
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Pages: " + numberOfPages);
        System.out.println("Publisher: " + publisher);
        System.out.println();
    }
}

class Journal extends LibraryItem {
    private int volumeNumber;
    private String publicationDate;

    // Constructor
    public Journal(String title, String author, String itemID, int volumeNumber, String publicationDate) {
        super(title, author, itemID);
        this.volumeNumber = volumeNumber;
        this.publicationDate = publicationDate;
    }

    // Overriding display method to include journal-specific details
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Volume Number: " + volumeNumber);
        System.out.println("Publication Date: " + publicationDate);
        System.out.println();
    }
}

class Library {
    private ArrayList<LibraryItem> items;

    // Constructor
    public Library() {
        items = new ArrayList<>();
    }

    // Method to add an item to the library
    public void addItem(LibraryItem item) {
        items.add(item);
        System.out.println("Item added: " + item.getTitle());
    }

    // Method to remove an item from the library
    public void removeItem(String itemID) {
        items.removeIf(item -> item.getItemID().equals(itemID));
        System.out.println("Item removed: " + itemID);
    }

    // Method to display all items in the library
    public void displayAllItems() {
        System.out.println("Library Collection:");
        for (LibraryItem item : items) {
            item.displayDetails();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Creating book and journal objects
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "B001", 180, "Scribner");
        Journal journal1 = new Journal("Science Journal", "AAAS", "J001", 34, "2023-04-10");

        // Adding items to the library
        library.addItem(book1);
        library.addItem(journal1);

        // Displaying all items in the library
        library.displayAllItems();

        // Removing an item from the library
        library.removeItem("B001");

        // Displaying all items in the library after removal
        library.displayAllItems();
    }
}
