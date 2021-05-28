package crud;

import classes.*;
import services.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertMethods {
    static Connection con = DatabaseConnection.getConnection();

    public int addReader (Reader reader)
            throws SQLException {
        String query = "insert into Reader (cnp,first_name,last_name,nr_tel,mail) values (?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, reader.getCNP());
        ps.setString(2,reader.getFirstName());
        ps.setString(3, reader.getLastName());
        ps.setString(4, reader.getNrTel());
        ps.setString(5,reader.getMail());
        int n = ps.executeUpdate();
        return n;
    }

    public int addAuthor (Author author)
        throws SQLException{
        String query = "insert into Author (first_name,last_name,id_author,birthday,deathday,rating,description) values (?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, author.getFirstName());
        ps.setString(2, author.getLastName());
        ps.setInt(3,author.getId());
        ps.setString(4, author.getBirthDay() );
        ps.setString(5, author.getDeathDay() );
        ps.setDouble(6, author.getRating());
        ps.setString(7, author.getDescription());
        int n = ps.executeUpdate();
        return n;
    }

    public int addEbook (Ebook ebook)
        throws SQLException{
        String query = "insert into ebook (title,id_author,category,rating,availability,url,price,size_in_mb) values (?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,ebook.getTitle());
        ps.setInt(2,ebook.getIdAuthor());
        ps.setString(3,ebook.getCategory());
        ps.setDouble(4,ebook.getRating());
        ps.setBoolean(5,true);
        ps.setString(6,ebook.getUrlAddress());
        ps.setDouble(7,ebook.getPrice());
        ps.setDouble(8,ebook.getSizeInMb());
        int n = ps.executeUpdate();
        return n;
    }

    public int addAudiobook (AudioBook audioBook)
            throws SQLException{
        String query = "insert into audiobook (title,id_author,category,rating,availability,url,price,size_in_mb,duration_in_hours) values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,audioBook.getTitle());
        ps.setInt(2,audioBook.getIdAuthor());
        ps.setString(3,audioBook.getCategory());
        ps.setDouble(4,audioBook.getRating());
        ps.setBoolean(5,true);
        ps.setString(6,audioBook.getUrlAddress());
        ps.setDouble(7,audioBook.getPrice());
        ps.setDouble(8,audioBook.getSizeInMb());
        ps.setDouble(9,audioBook.getDurationInHours());
        int n = ps.executeUpdate();
        return n;
    }

    public int addPublishedEdition (PublishedEdition publishedEdition)
            throws SQLException{
        String query = "insert into published_edition (title,id_author,category,rating,availability,edition,pages_number,publishing_year) values (?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,publishedEdition.getTitle());
        ps.setInt(2,publishedEdition.getIdAuthor());
        ps.setString(3,publishedEdition.getCategory());
        ps.setDouble(4,publishedEdition.getRating());
        ps.setBoolean(5,true);
        ps.setString(6,publishedEdition.getEdition());
        ps.setInt(7,publishedEdition.getPagesNumber());
        ps.setString(8,publishedEdition.getPublishingYear());
        int n = ps.executeUpdate();
        return n;
    }
}
