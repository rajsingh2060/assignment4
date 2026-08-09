package kfa.service;

import kfa.model.LibraryItem;
import kfa.exception.BookNotAvailableException;
import kfa.exception.ItemOverdueException;

public class LibrarySystem {

    public void borrowItem(LibraryItem item) throws BookNotAvailableException {
        if (!item.isAvailable()) {
            throw new BookNotAvailableException("Item already borrowed: " + item.getTitle());
        }
        item.setAvailable(false);
    }

    public void returnItem(LibraryItem item, int daysLate) throws ItemOverdueException {
        if (daysLate > 0) {
            throw new ItemOverdueException(daysLate);
        }
        item.setAvailable(true);
    }
}
