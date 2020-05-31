    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Entite.categorie;
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
public class ServiceCategorie implements IService<categorie>

{    private Statement st;
      private ResultSet rs;
      Connection cnx = DataSource.getInstance().getConnection();
    public ServiceCategorie() 
    {
    }
    public void ajouter(categorie c) {
        try {
            String requete = "INSERT INTO category (nom)  VALUES ('" + c.getNom() + "');";
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
        System.out.println("catégorie ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
       public int getCategorieIdByNom(String nom) throws SQLException
    {
        int val=0;
        
        String requete = "select id from category where nom='"+nom+"';";
     
            PreparedStatement pst = cnx.prepareStatement(requete);
           rs = pst.executeQuery();
           
           while (rs.next())
           {
               val =  rs.getInt("id");
           }
                   
           
           return val;
    }
    
       
         public String getCategorieNameById (int id) throws SQLException
    {
        String name_cat ="";
        String requete = "select nom from category where id="+id;
     
            PreparedStatement pst = cnx.prepareStatement(requete);
           rs = pst.executeQuery();
           
           while (rs.next())
           {
              name_cat =  rs.getString("nom");
           }
                   
           
           return name_cat;
    }
       
       
    
     public void modifier(categorie c ) {
        try {
            String requete = "UPDATE category SET nom ='" + 
                    c.getNom() + " ' where id= " + c.getId_categorie();
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("catégorie modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void supprimer (int id) {
         
        try {
            String req="delete from category where id="+id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("catégorie bien supprimée ! ");
        }catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<categorie> afficher()
    {
        List<categorie> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM category;";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) 
            {
           list.add(new categorie(rs.getInt("id"),rs.getString("nom")));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
   
    public categorie afficherParId(int id) 
    {
        String req="select * from category where id="+id;
        categorie c = new categorie();
        try {
         
            rs = st.executeQuery(req);
            
          while(rs.next())
          {
            c = new categorie(rs.getInt("id"),rs.getString("nom"));
              System.out.println(c.toString());
        } 
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return c;
    }
    
    
}
