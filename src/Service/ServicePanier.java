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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    
       public void DeleteFromPanier () {
        try {
            String req= "delete from panier";
          
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Tous les produits sont supprimés ");
        }  
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void ajouter(panier p) {
        try {
            String requete = "INSERT INTO panier (quantity,prix,date_p,produit_id,user_id)  VALUES (" 
                    + p.getQuantite()+","+ p.getPrix() +",'" +p.getDate_ajout() +"'," + p.getProduit_id()
                   + "," + p.getUser_id() + ");";
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
        System.out.println("Succés !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void supprimer (int id) {
        try {
            String req="delete from panier where id="+id+";";
            System.out.println("*********" + req + "*********");
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
            String requete = "UPDATE panier SET quantity=" + 
                    p.getQuantite() + ",date_p='" + p.getDate_ajout() + "',produit_id='"+p.getProduit_id()                    
                    + "',Iduser='"+p.getUser_id()+"',prix='"+p.getPrix() 
                    + "' WHERE id=" + p.getId_panier();
            
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("panier modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
          
          
          
    public List<panier> afficher()
    {
        List<panier> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM panier;";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) 
            {
               
          list.add(new panier(rs.getInt("id"),rs.getInt("user_id"),rs.getInt("produit_id"),rs.getInt("quantity"),rs.getInt("prix")));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
    public ObservableList<panier> afficherInfosPanier() throws SQLException
    {
        
    ObservableList<panier> contenuPanier = FXCollections.observableArrayList();
        try
        {
            String req = "select pa.id,pro.image,pro.name,pa.quantity,pa.prix from product pro,panier pa where pa.produit_id = pro.id;";
           st = cnx.createStatement();
           ResultSet resSet = st.executeQuery(req);
            while(resSet.next())
            {
                panier p = new panier();
                int id = resSet.getInt(1);
                String image = resSet.getString(2);
                String name = resSet.getString(3);
                int prix = resSet.getInt(5);
                int quantite = resSet.getInt(4);
                p.setId_panier(id);
                p.setImage(image);
                p.setName(name);
                p.setPrix(prix);
                p.setQuantite(quantite);
                
                contenuPanier.add(p);
              
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return contenuPanier;
    }
}
