/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import com.pidev.models.mecanicien;
//import com.pidev.models.panier;
//import com.pidev.models.produit;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author yaya
 */
public class ServiceMaintenance implements IService<mecanicien>{
   
    private static ServiceMaintenance instance;
    private Statement st;
    private ResultSet rs;
    Connection cnx = DataSource.getInstance().getConnection();
    
    public ServiceMaintenance()
    {
           DataSource cs= DataSource.getInstance();
        try {
            st= cs.getConnection().createStatement();
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }
    
    //CRUD

    
    public void ajouter(mecanicien m) {
        try {
            String requete = "INSERT INTO mechanicien (service,nom,prenom,mail,image,prix,num_tel,description,adomicile) VALUES"
                    + " (?,?,?,?,?,?,?,?,?);";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1,m.getService());
            pst.setString(2,m.getNom());
            pst.setString(3,m.getPrenom());
            pst.setString(4,m.getMail());
            pst.setString(5,m.getImage());
            pst.setFloat(6,m.getPrix());
            pst.setInt(7,m.getNum_tel());
            pst.setString(8,m.getDescription());
            pst.setString(9,m.getAdomicile());            
            pst.executeUpdate();
            System.out.println("Mecanicienss ajouté !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }}
    public void supprimer (int id) {
        try {
            String req="delete from mechanicien where id="+id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("mecanicien supprimé ! ");
        }  
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void modifier(mecanicien m ) {
        try {
            String requete = "UPDATE mechanicien SET Prix='"
                    + m.getPrix()+ "',Service='"+  m.getService() + "',Nom='" + m.getNom() + "',Prenom='"+m.getPrenom()                    
                    + "',Mail='"+m.getMail()+"',image='"+m.getImage() + "',Num_Tel='"+m.getNum_tel()+"',description='"+m.getDescription()+  
                    "',adomicile='"+m.getAdomicile()
                   + "' WHERE id=" + m.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("mecanicien modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
          
    public List<mecanicien> afficher()
    {
        List<mecanicien> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM mechanicien;";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) 
            {
                  mecanicien p = new mecanicien();
                  p.setId(rs.getInt("id"));
                  p.setNom(rs.getString("nom"));
                  p.setDescription(rs.getString("description"));
                  p.setImage(rs.getString("image"));
                  p.setAdomicile(rs.getString("adomicile"));
                  p.setNum_tel(rs.getInt("num_tel"));
                  p.setMail(rs.getString("mail"));
                  p.setPrenom(rs.getString("prenom"));
                  p.setPrix(rs.getFloat("prix"));
                  p.setService(rs.getString("service"));
                  list.add(p);
            }
        } catch (SQLException ex) 
        {
            System.err.println(ex.getMessage());
        }

        return list;
    }
     public List<mecanicien> RechercherMecanicienParNom (String nom) {
        List<mecanicien> lp = new ArrayList<>();
        try {
            String select = "SELECT  * FROM produit where nom like '%"+nom+"%' ;";

            Statement statement1 = cnx.createStatement();

            ResultSet result = statement1.executeQuery(select);
            
            if (result.next() == false) 
            { 
                System.out.println("Produit non trouvé par nom !!!!!! ");
            }
            else 
            { 
                do 
                { mecanicien p = new mecanicien();
                
                p.setNom(result.getString("nom"));
                p.setPrenom(result.getString("prenon"));
                p.setService(result.getString("service"));
                p.setDescription(result.getString("description"));
                p.setImage(result.getString("image"));
                 Timestamp date_modif = result.getTimestamp("modifiee_le");
//                  p.setModifie_le(date_modif.toLocalDateTime());
                p.setPrix(result.getFloat("prix"));
                p.setMail(result.getString("mail"));
                p.setAdomicile(result.getString("adomicile"));
                p.setNum_tel(result.getInt("num_tel"));
                lp.add(p); 
                } while (result.next());   
            }          
        } 
        
        catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLSTATE: " + ex.getSQLState());
            System.err.println("VnedorError: " + ex.getErrorCode());
        }
        return lp;
    }
    public List<mecanicien> FiltrerMecanicienParOrdreCroissant(int prixmax) {
        List<mecanicien> list = new ArrayList<>();
       // ServiceProduit sp = new ServiceProduit()    ;
       ServiceMaintenance sp = new ServiceMaintenance();
        list = sp.afficher();
     
        if (prixmax != -1) {
            list = list.stream().filter(e -> e.getPrix() <= prixmax).collect(Collectors.toCollection(ArrayList<mecanicien>::new));
            System.out.println("**3");
        }

        return list;
    }
     public List<mecanicien> RechercherMecanicienParService (String categorie) {
        List<mecanicien> mecanicien = new ArrayList<>();
        //produit produit = new produit();
        mecanicien mecaniciens = new mecanicien();
        try {
            String sql = "SELECT * FROM mechanicien where service like '%"+categorie +"%';" ;
            PreparedStatement statement = this.cnx.prepareStatement(sql);
            ResultSet results = statement.executeQuery();
            
            if (results.next() == false) 
            {
                System.out.println("produit non trouvé ! ");
             }    
            else 
            {
           do
            {
                
                mecanicien p = new mecanicien();
                p.setNom(results.getString("nom"));
                p.setPrenom(results.getString("prenon"));
                p.setService(results.getString("service"));
                p.setDescription(results.getString("description"));
                p.setImage(results.getString("image"));
                 Timestamp date_modif = results.getTimestamp("modifiee_le");
//                  p.setModifie_le(date_modif.toLocalDateTime());
                p.setPrix(results.getFloat("prix"));
                p.setMail(results.getString("mail"));
                p.setAdomicile(results.getString("adomicile"));
                p.setNum_tel(results.getInt("num_tel"));
                mecanicien.add(p);
            }  while (results.next()) ;
    
         }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mecanicien;
    }
}