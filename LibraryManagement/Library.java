import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void issueBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId && !book.isIssued()) {
                book.issue();
                System.out.println("Book issued: " + book);
                return;
            }
        }
        System.out.println("Book not available or already issued.");
    }

    public void returnBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId && book.isIssued()) {
                book.returnBook();
                System.out.println("Book returned: " + book);
                return;
            }
        }
        System.out.println("Invalid return operation.");
    }
}