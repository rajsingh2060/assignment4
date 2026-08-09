import kfa.model.*;
import kfa.service.LibrarySystem;
import kfa.exception.*;

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("Clean Code", "Robert Martin", "B001", 850);
        Book b2 = new Book("Effective Java", "Joshua Bloch", "B002", 950);
        Magazine m1 = new Magazine("Tech Monthly", "M001", 200, 45);
        DVD d1 = new DVD("Inception", "D001", 500, 148);

        LibraryItem[] items = { b1, b2, m1, d1 };

        for (LibraryItem item : items) {
            System.out.println(item);
            System.out.println("Lending Period: " + item.getLendingPeriodDays() + " days");
        }

        System.out.println("Total Books: " + Book.getTotalBooks());

        LibrarySystem system = new LibrarySystem();
        try {
            system.borrowItem(b1);
            system.returnItem(b1, 0);
        } catch (BookNotAvailableException | ItemOverdueException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Transaction processed for: " + b1.getTitle());
        }
    }
}
