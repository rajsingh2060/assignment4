import kfa.model.LibraryItem;
import java.util.Random;

public class LibraryUtils {

    public static String generateMemberId(String fullName) {
        String[] parts = fullName.trim().split(" ");
        String first = parts[0].substring(0, Math.min(3, parts[0].length())).toUpperCase();
        String last = (parts.length > 1) ? parts[1].substring(0, Math.min(2, parts[1].length())).toUpperCase() : "XX";
        int randomNum = new Random().nextInt(900) + 100;
        return first + last + randomNum;
    }

    public static boolean isValidIsbn(String isbn) {
        if (isbn.length() != 13) return false;
        if (isbn.charAt(0) == '0') return false;
        for (int i = 0; i < isbn.length(); i++) {
            if (!Character.isDigit(isbn.charAt(i))) return false;
        }
        return true;
    }

    public static String buildCatalogueReport(LibraryItem[] items, String keyword) {
        StringBuilder sb = new StringBuilder("Catalogue Report:\n");
        for (LibraryItem item : items) {
            if (item.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                sb.append(item.getTitle()).append(" - ").append(item.isAvailable() ? "Available" : "Not Available").append("\n");
            }
        }
        return sb.toString();
    }
}
