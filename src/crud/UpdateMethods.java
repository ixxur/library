package crud;

import classes.Reader;
import services.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateMethods {
        static Connection con = DatabaseConnection.getConnection();

        public void updateLastNameReader(String cnp,String last_name) throws SQLException{
            String query = "update reader set last_name = ? where cnp = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,last_name);
            ps.setString(2,cnp);
            ps.executeUpdate();
        }

        public void updateDeathDayAuthor(int id, String deathday) throws SQLException{
            String query = "update author set deathday = ? where id_author = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,deathday);
            ps.setInt(2,id);
            ps.executeUpdate();
        }

        public void updatePriceEbook(int id, double price) throws SQLException{
            String query = "update ebook set price = ? where id_book = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDouble(1,price);
            ps.setInt(2,id);
            ps.executeUpdate();
        }

    public void updatePublishedEdition(String title, String edition, String publishingYear) throws SQLException{
        String query = "update published_edition set edition = ?, publishing_year = ? where title = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,edition);
        ps.setString(2,publishingYear);
        ps.setString(3,title);
        ps.executeUpdate();
    }


}
