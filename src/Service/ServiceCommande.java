/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.commande;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author benha
 */
public class ServiceCommande implements IService<commande>{
    
   
    
    private Statement st;
      private ResultSet rs;
      Connection cnx = DataSource.getInstance().getConnection();
      
      

    public ServiceCommande() {
           DataSource cs= DataSource.getInstance();
        try {
            st= cs.getConnection().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
      
    public void ajouter(commande c) {
        try {
            String requete = "INSERT INTO orders (phonenumber,email,city,adresse,total,nom)  VALUES ('" 
                    + c.getNum_telephone()+"','"+ c.getEmail()+"','" +c.getVille()+"','" +c.getAdresse() + "'," +c.getPrix_total() +",'"
                   +c.getNom() + "');";
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
        System.out.println("Succés !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void supprimer(int id) {
     try {
            String req="delete from orders where id ="+id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("commande supprimée ! ");
        }  
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void modifier(commande c) {
          try {
            String requete = "UPDATE orders SET phonenumber=?,email=?,city=?,adresse=?,total=?,nom=? WHERE id=?";
            
            PreparedStatement st = cnx.prepareStatement(requete);
            st.setString(1,c.getNum_telephone());
            st.setString(2,c.getEmail());
            st.setString(3,c.getVille());
            st.setString(4, c.getAdresse());
            st.setInt(5, c.getPrix_total());
            st.setString(6, c.getNom());
            st.setInt(7,c.getId_commande());
         
            st.executeUpdate(requete);
            System.out.println("commande modifiéé !");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<commande> afficher()
    {
          List<commande> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM orders;";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) 
            {
          list.add(new commande(rs.getString("phonenumber"),rs.getString("ville"), rs.getString("adresse"),rs.getInt("total"), rs.getString("email"), rs.getString("nom")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    }
    
