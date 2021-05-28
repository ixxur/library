package crud;

import classes.*;
import services.DatabaseConnection;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;

public class SelectMethods {
    static Connection con = DatabaseConnection.getConnection();

    public void selectReader(ArrayList<Reader> readerList)
            throws SQLException {
        String query = "select* from reader";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Reader newReader = new Reader(rs.getString("first_name"), rs.getString("last_name"), rs.getString("cnp"), rs.getString("nr_tel"), rs.getString("mail"));
            readerList.add(newReader);
        }
        System.out.println(readerList);
    }

    public void selectAuthor(ArrayList<Author> authorList)
            throws SQLException {
        String query = "select* from author";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Author newAuthor = new Author(rs.getString("first_name"), rs.getString("last_name"), rs.getInt("id_author"), rs.getString("birthday"), rs.getString("deathday"), rs.getString("description"), rs.getDouble("rating"));
            authorList.add(newAuthor);
        }
        System.out.println(authorList);
    }

    public void selectEbook(ArrayList<Ebook> ebookList, ArrayList<Author> authorList)
            throws SQLException {
        String query = "select* from ebook";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Ebook newEbook = new Ebook();
            newEbook.setTitle(rs.getString("title"));
            newEbook.setAvailable(rs.getBoolean("availability"));
            newEbook.setCategory(rs.getString("category"));
            newEbook.setRating(rs.getDouble("rating"));
            newEbook.setUrlAddress(rs.getString("url"));
            newEbook.setPrice(rs.getDouble("price"));
            newEbook.setSizeInMb(rs.getDouble("size_in_mb"));

            int searchForAuthor = rs.getInt("id_author");
            for (Author author : authorList) {
                if (author.getId() == searchForAuthor)
                    newEbook.setAuthor(author);
            }
            ebookList.add(newEbook);
        }
        System.out.println(ebookList);
    }

    public void selectAudioBook(ArrayList<AudioBook> audioBookList, ArrayList<Author> authorList)
            throws SQLException {
        String query = "select* from audiobook";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            AudioBook newAudioBook = new AudioBook();
            newAudioBook.setTitle(rs.getString("title"));
            newAudioBook.setAvailable(rs.getBoolean("availability"));
            newAudioBook.setCategory(rs.getString("category"));
            newAudioBook.setRating(rs.getDouble("rating"));
            newAudioBook.setUrlAddress(rs.getString("url"));
            newAudioBook.setPrice(rs.getDouble("price"));
            newAudioBook.setSizeInMb(rs.getDouble("size_in_mb"));
            newAudioBook.setDurationInHours(rs.getDouble("duration_in_hours"));

            int searchForAuthor = rs.getInt("id_author");
            for (Author author : authorList) {
                if (author.getId() == searchForAuthor)
                    newAudioBook.setAuthor(author);
            }
            audioBookList.add(newAudioBook);
        }
        System.out.println(audioBookList);
    }

    public void selectPublishedEdition(ArrayList<PublishedEdition> publishedList, ArrayList<Author> authorList)
            throws SQLException {
        String query = "select* from published_edition";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            PublishedEdition newPublished = new PublishedEdition();
            newPublished.setTitle(rs.getString("title"));
            newPublished.setAvailable(rs.getBoolean("availability"));
            newPublished.setCategory(rs.getString("category"));
            newPublished.setRating(rs.getDouble("rating"));
            newPublished.setEdition(rs.getString("edition"));
            newPublished.setPagesNumber(rs.getInt("pages_number"));
            newPublished.setPublishingYear(rs.getString("publishing_year"));

            int searchForAuthor = rs.getInt("id_author");
            for (Author author : authorList) {
                if (author.getId() == searchForAuthor)
                    newPublished.setAuthor(author);
            }
            publishedList.add(newPublished);
        }
        System.out.println(publishedList);
    }
}
