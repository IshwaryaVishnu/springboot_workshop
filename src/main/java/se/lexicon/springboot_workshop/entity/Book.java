package se.lexicon.springboot_workshop.entity;
import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    @Column(nullable = false, length = 100)
    private  String isbn;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false, length = 100)
    private  int maxLoanDays;

    @ManyToMany(mappedBy = "bookFinders")
    private Set<Author> Authors;

    public Book() {
    }

    public Book(int bookId, int maxLoanDays) {
        this.bookId = bookId;
        this.maxLoanDays = maxLoanDays;
    }

    public Book(int bookId, String isbn, String title, int maxLoanDays) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.maxLoanDays = maxLoanDays;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMaxLoanDays() {
        return maxLoanDays;
    }

    public void setMaxLoanDays(int maxLoanDays) {
        this.maxLoanDays = maxLoanDays;
    }

    public Set<Author> getAuthors() {
        return Authors;
    }

    public void setAuthors(Set<Author> authors) {
        Authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId && maxLoanDays == book.maxLoanDays && Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, isbn, title, maxLoanDays);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", maxLoanDays=" + maxLoanDays +
                '}';
    }
}
