package Service;
import Entite.reservation;
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
public class ServiceReservation implements IService<reservation> {

   private Statement st;
   private ResultSet rs;
   Connection cnx = DataSource.getInstance().getConnection();
    public ServiceReservation() 
    {
    	
    }
    public void ajouter(reservation r) {
        try {
            String requete = "INSERT INTO reseration (document)  VALUES ('" + r.getDocument() + "');";
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
        System.out.println("reservation ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
     public void modifier(reservation r ) {
        try {
            String requete = "UPDATE rentProd SET user ='" + 
            r.getDocument() + " ' where id_reservation= " + r. getId_reservation();
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("reservation modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void supprimer (int id) {
         
        try {
            String req="delete from reservation where id_reservation="+id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("rentProd bien supprimée ! ");
        }catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
	public List<reservation> afficher() {
		// TODO Auto-generated method stub
		return null;
	}
       
     
       }