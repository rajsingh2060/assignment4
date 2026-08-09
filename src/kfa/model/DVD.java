package kfa.model;

public class DVD extends LibraryItem implements Renewable {
    private int durationMinutes;

    public DVD(String title, String isbn, double price, int durationMinutes) {
        super(title, isbn, price);
        this.durationMinutes = durationMinutes;
    }

    public int getDurationMinutes() { return durationMinutes; }

    @Override
    public int getLendingPeriodDays() { return 5; }

    @Override
    public void renew(int extraDays) {
        System.out.println("DVD renewed for " + extraDays + " extra days.");
    }

    @Override
    public String toString() {
        return "[DVD] " + super.toString() + " Duration: " + durationMinutes + " mins";
    }
}
