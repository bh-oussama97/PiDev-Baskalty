/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import Entite.contact;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author benha
 */
public class ServiceContact {
    
    private Statement st;
      private ResultSet rs;
      Connection cnx = DataSource.getInstance().getConnection();

    public ServiceContact() {
    }
      
        public void ajouterContact (contact c) {
        try {
            String requete = "INSERT INTO contact(name,date,email,subject,message,phone) VALUES"
                    + " (?,?,?,?,?,?);";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1,c.getNom());
           java.sql.Timestamp javaSqlDate = Timestamp.valueOf(c.getDate_ajout());
             pst.setTimestamp(2, javaSqlDate);
            pst.setString(3,c.getEmail());
            pst.setString(4, c.getSujet());
            pst.setString(5, c.getMessage());
            pst.setString(6,c.getPhonenumber());
            pst.executeUpdate();
            System.out.println("Contact ajouté !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
        
         public List<contact> afficherContacts()
    {
        List<contact> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM contact;";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) 
            {
                  contact p = new contact();
                  p.setId_contact(rs.getInt("id"));
                  p.setNom(rs.getString("name"));
                  Timestamp date = rs.getTimestamp("date");
                  p.setDate_ajout(date.toLocalDateTime());
                  p.setEmail(rs.getString("email"));
                  p.setSujet(rs.getString("subject"));
                  p.setMessage(rs.getString("message"));
                 
                  list.add(p);
            }
        } catch (SQLException ex) 
        {
            System.err.println(ex.getMessage());
        }

        return list;
    }
        
        
    
    
}
