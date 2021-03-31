package classes;

public class PublishedEdition extends Book{
    private String edition;
    private int pagesNumber;
    private String publishingYear;

    public PublishedEdition(String title, Author author, String category, double rating, boolean availability, String edition, int pagesNumber, String publishingYear) {
        super(title, author, category, rating, availability);
        this.edition = edition;
        this.pagesNumber = pagesNumber;
        this.publishingYear = publishingYear;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    public String getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(String publishingYear) {
        this.publishingYear = publishingYear;
    }

    @Override
    public String toString() {
        return super.toString() + ", edition: " + edition +
                ", number of pages: " + pagesNumber +
                ", publishing year: " + publishingYear;
    }
}
