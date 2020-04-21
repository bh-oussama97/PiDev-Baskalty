package Service;
import Entite.rent;
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
public class ServiceRent implements IService<rent> {

   private Statement st;
   private ResultSet rs;
   Connection cnx = DataSource.getInstance().getConnection();
    public ServiceRent() 
    {
    	
    }
    public void ajouter(rent r) {
        try {
            String requete = "INSERT INTO rent (nom)  VALUES ('" + r.getNom() + "');";
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
        System.out.println("rent ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
     public void modifier(rent r ) {
        try {
            String requete = "UPDATE categorie SET nom ='" + 
                    r.getNom() + " ' where id_rent= " + r.getId_rent();
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("rent modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void supprimer (int id) {
         
        try {
            String req="delete from rent where id_cat="+id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("catégorie bien supprimée ! ");
        }catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
	public List<rent> afficher() {
		// TODO Auto-generated method stub
		return null;
	}
       
     
       }