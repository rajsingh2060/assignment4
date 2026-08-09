package kfa.model;

public class Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(String title, String isbn, double price, int issueNumber) {
        super(title, isbn, price);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() { return issueNumber; }

    @Override
    public int getLendingPeriodDays() { return 7; }

    @Override
    public String toString() {
        return "[Magazine] " + super.toString() + " Issue: " + issueNumber;
    }
    // Magazines cannot be renewed as per library policy
}
