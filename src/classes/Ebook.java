package classes;

public class Ebook extends Book {
    protected String urlAddress;
    protected double price;
    protected double sizeInMb;
    protected static int countEbooks = 0;

    public Ebook(String title, Author author, String category, double rating, boolean availability, String urlAddress, double price, double sizeInMb) {
        super(title, author, category, rating, availability);
        super.availability = true;
        this.urlAddress = urlAddress;
        this.price = price;
        this.sizeInMb = sizeInMb;
        countEbooks++;
    }

    public String getUrlAddress() {
        return urlAddress;
    }

    public void setUrlAddress(String urlAddress) {
        this.urlAddress = urlAddress;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSizeInMb() {
        return sizeInMb;
    }

    public void setSizeInMb(double sizeInMb) {
        this.sizeInMb = sizeInMb;
    }

    public static int getCountEbooks() {
        return countEbooks;
    }

    @Override
    public String toString() {
        return super.toString() +
                " @URL: " + urlAddress + " " +
                ", price: " + price +
                ", sizeInMb: " + sizeInMb;
    }
}
