package kfa.model;

public abstract class LibraryItem {
    private String title;
    private String isbn;
    private double price;
    private boolean available;

    public LibraryItem(String title, String isbn, double price) {
        this.title = title;
        this.isbn = isbn;
        this.price = price > 0 ? price : 0;
        this.available = true;
    }

    public String getTitle() { return title; }
    public String getIsbn() { return isbn; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return available; }

    public void setPrice(double price) {
        if (price >= 0) this.price = price;
    }

    public void setAvailable(boolean available) { this.available = available; }

    public abstract int getLendingPeriodDays();

    @Override
    public String toString() {
        return "[" + isbn + "] " + title + " - Rs " + price + " (" + (available ? "Available" : "Not Available") + ")";
    }
}
