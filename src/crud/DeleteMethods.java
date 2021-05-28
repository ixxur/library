package crud;

import classes.*;
import services.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeleteMethods {
    static Connection con = DatabaseConnection.getConnection();

    public void deleteReader(String cnp)
        throws SQLException{
        String query = "delete from reader where cnp = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,cnp);
        ps.executeUpdate();
    }

    public void deleteAuthor(int id)
        throws SQLException{
        String query = "delete from author where id_author = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,id);
        ps.executeUpdate();
    }

    public void deleteEbook(String title)
        throws  SQLException{
        String query = "delete from ebook where title = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,title);
        ps.executeUpdate();
    }

    public void deleteAudiobook(String title)
            throws  SQLException{
        String query = "delete from audiobook where title = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,title);
        ps.executeUpdate();
    }

    public void deletePublishedEdition(String title)
            throws  SQLException{
        String query = "delete from published_edition where title = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,title);
        ps.executeUpdate();
    }
}
