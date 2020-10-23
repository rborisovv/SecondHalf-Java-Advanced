package IteratorsAndComparators;

import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Library(Book...books) {
        this.books = books;
    }

    private class libIterator implements Iterator<Book> {
        private int index;

        @Override
        public boolean hasNext() {
            return this.index < books.length;
        }

        @Override
        public Book next() {
            return books[this.index++];
        }
    }

    @Override
    public Iterator<Book> iterator() {
        return new libIterator();
    }
}
