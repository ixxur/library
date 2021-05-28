package classes;

public class AudioBook extends Ebook {
    private double durationInHours;
    private static int countAudioBooks =  0;

    public AudioBook(String title, Author author, String category, double rating, boolean availability, String urlAddress, double price, double sizeInMb, double durationInHours) {
        super(title, author, category, rating, availability, urlAddress, price, sizeInMb);
        this.durationInHours = durationInHours;
        countAudioBooks++;
    }

    public AudioBook(){
        super();
    }
    public double getDurationInHours() {
        return durationInHours;
    }

    public void setDurationInHours(double durationInHours) {
        this.durationInHours = durationInHours;
    }

    public static int getCountAudioBooks() {
        return countAudioBooks;
    }

    @Override
    public String toString() {
        return super.toString() + ", runtime: " + durationInHours;
    }
}
