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
            String requete = "INSERT INTO commande (Idproduit,Iduser,num_telephone,ville,adresse,instructions_livraison,prix_total)  VALUES (" 
                    + c.getId_produit()+","+ c.getId_user()+",'" +c.getNum_telephone()+"','" +c.getVille() + "','" +c.getAdresse() +"','"
                   +c.getInstructions_livraisons() +"'," +c.getPrix_total()+ ");";
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
        System.out.println("Succés !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void supprimer(int id) {
     try {
            String req="delete from commande where id_commande ="+id;
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
            String requete = "UPDATE commande SET Idproduit=?,Iduser=?,num_telephone=?,ville=?,adresse=?,instructions_livraison=?,prix_total=? WHERE id_commande=?";
            
            PreparedStatement st = cnx.prepareStatement(requete);
            st.setInt(1,c.getId_produit());
            st.setInt(2,c.getId_user());
            st.setString(3,c.getNum_telephone());
            st.setString(4, c.getVille());
            st.setString(5, c.getAdresse());
            st.setString(6, c.getInstructions_livraisons());
            st.setFloat(7,c.getPrix_total());
            st.setInt(8,c.getId_commande());
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
            String requete = "SELECT * FROM commande;";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) 
            {
          list.add(new commande(rs.getInt(1), rs.getInt(2),rs.getInt(3), rs.getString(4),  rs.getString(5),  rs.getString(6),  rs.getString(7),rs.getFloat(8)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    }
    
