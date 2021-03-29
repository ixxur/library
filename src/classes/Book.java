package classes;

public class Book {
    protected int idBook;
    protected String title;
    protected Author author;
    protected String category;
    protected double rating;
    protected boolean availability;
    protected static int countBooks = 1;

    public Book(String title, Author author, String category, double rating, boolean availability) {
        this.idBook = countBooks;
        this.title = title;
        this.author = author;
        this.category = category;
        this.rating = rating;
        this.availability = availability;
        countBooks++;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailable(boolean available) {
        this.availability = availability;
    }

    public static int getCountBooks() {
        return countBooks;
    }

    @Override
    public String toString() {
        if (this.availability == true)
             return "Book " + idBook +
                " is " + title + " " +
                ", written by " + author.firstName + " " + author.lastName +
                ", category " + category +
                ", rating " + rating +
                ", is available";
        else return "Book " + idBook +
                " is " + title + " " +
                ", written by " + author.firstName + " " + author.lastName +
                ", category " + category +
                ", rating " + rating +
                ", is unavailable";
    }
}
