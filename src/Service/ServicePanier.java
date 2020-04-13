/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Entite.panier;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author benha
 */
public class ServicePanier implements IService<panier> {
    
     private Statement st;
      private ResultSet rs;
      Connection cnx = DataSource.getInstance().getConnection();

    public ServicePanier() {
    }
   @Override
    public void ajouter(panier p) {
        try {
            String requete = "INSERT INTO panier (quantite,prix,date_panier,Idproduit,Iduser)  VALUES (" 
                    + p.getQuantite()+","+ p.getPrix() +",'" +p.getDate_ajout() +"'," + p.getProduit_id()
                   + "," + p.getUser_id() + ");";
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
        System.out.println("Succés !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
     @Override
    public void supprimer (int id) {
        try {
            String req="delete from panier where id_panier="+id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("produit supprimé du panier ! ");
        }  
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
          public void modifier(panier p ) {
        try {
            String requete = "UPDATE panier SET quantite='" + 
                    p.getQuantite() + "',date_panier='" + p.getDate_ajout() + "',Idproduit='"+p.getProduit_id()                    
                    + "',Iduser='"+p.getUser_id()+"',prix='"+p.getPrix() 
                    + "' WHERE id_panier=" + p.getId_panier();
            
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("panier modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
          
           @Override
    public List<panier> afficher()
    {
        List<panier> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM panier;";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) 
            {
          list.add(new panier(rs.getInt("id_panier"),rs.getInt("Iduser"),rs.getInt("Idproduit"),rs.getFloat("prix"), rs.getString("date_panier")));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
}
