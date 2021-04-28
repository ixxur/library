package classes;

public class BorrowedBook {
    private Book book;
    private String borrowingDay;
    private String backDay;

    public BorrowedBook(Book book, String borrowingDay, String backDay) {
        this.book = book;
        this.borrowingDay = borrowingDay;
        this.backDay = backDay;
    }

    public String getTitle(){
        return book.getTitle();
    }

    public int getIdBook() {
        return book.getIdBook();
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getBorrowingDay() {
        return borrowingDay;
    }

    public void setBorrowingDay(String borrowingDay) {
        this.borrowingDay = borrowingDay;
    }

    public String getBackDay() {
        return backDay;
    }

    public void setBackDay(String backDay) {
        this.backDay = backDay;
    }

    @Override
    public String toString() {
        if(backDay == null)
          return "-> Book " + this.getIdBook() + " " + book.getTitle() + " by " + book.getAuthor() + " was borrowed on " + borrowingDay ;
        else return "-> Book " + this.getIdBook() + " " + book.getTitle() + " by " + book.getAuthor() + " was borrowed on " + borrowingDay + " and returned on " + backDay ;
    }
}
