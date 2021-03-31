package classes;

public class BorrowedBook {
    private Book book;
    private Date borrowingDay;
    private Date backDay;

    public BorrowedBook(Book book, String startDay, String startMonth, String startYear, String returnDay, String returnMonth, String returnYear) {
        this.book = book;
        this.borrowingDay = new Date(startDay, startMonth, startYear);
        this.backDay = new Date(returnDay, returnMonth, returnYear);
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

    public Date getBorrowingDay() {
        return borrowingDay;
    }

    public void setBorrowingDay(Date borrowingDay) {
        this.borrowingDay = borrowingDay;
    }

    public Date getBackDay() {
        return backDay;
    }

    public void setBackDay(Date backDay) {
        this.backDay = backDay;
    }

    @Override
    public String toString() {
        if(backDay == null)
          return "-> Book " + this.getIdBook() + " " + book.getTitle() + " by " + book.getAuthor() + " was borrowed on " + borrowingDay ;
        else return "-> Book " + this.getIdBook() + " " + book.getTitle() + " by " + book.getAuthor() + " was borrowed on " + borrowingDay + " and returned on " + backDay ;
    }
}
