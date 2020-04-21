/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Entite.produit;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.sql.Timestamp;
import java.util.stream.Collectors;
/**
 *
 * @author benha
 */
public class ServiceProduit implements IService<produit>{
   
    private static ServiceProduit instance;
    private Statement st;
    private ResultSet rs;
    Connection cnx = DataSource.getInstance().getConnection();
    
    public ServiceProduit()
    {
           DataSource cs= DataSource.getInstance();
        try {
            st= cs.getConnection().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //CRUD
  
    
    public void ajouter(produit p) {
        try {
            String requete = "INSERT INTO produit (quantite,date_ajout,nom,reference,"
                    + "description,prix,image,categorie,iduser) VALUES"
                    + " (?,?,?,?,?,?,?,?,?);";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1,p.getQuantite());
           java.sql.Timestamp javaSqlDate = Timestamp.valueOf(p.getDate_ajout());
             pst.setTimestamp(2, javaSqlDate);
            pst.setString(3,p.getNom());
            pst.setString(4, p.getReference());
            pst.setString(5, p.getDescription());
            pst.setFloat(6, p.getPrix());
            pst.setString(7, p.getImage());
            pst.setString(8,p.getCategorie());
            pst.setInt(9,3);
           
            //pst.setDate(10,p.getDate_ajout());
            pst.executeUpdate();
            System.out.println("Produit ajouté !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
        
    public void supprimer (int id) {
         String req="delete from produit where id_prod="+id;
        try {
            st.executeUpdate(req);
            System.out.println("produit bien supprimé ! ");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
      public void modifier(produit p) {
        try {
            String requete = "UPDATE produit SET quantite='" + 
                    p.getQuantite() + "',nom='"+p.getNom()
                    + "',reference='"+p.getReference() + "',description='"+p.getDescription()
                    +"',prix='"+p.getPrix() +"',image='"+p.getImage() +"',modifiee_le='"+ p.getModifie_le()
                    +"',categorie='"+p.getCategorie() + "',iduser=3"
                    + " WHERE id_prod=" + p.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("produit modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
   
    
    public List<produit> afficher()
    {
        List<produit> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM produit;";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) 
            {
                  produit p = new produit();
                  p.setId(rs.getInt("id_prod"));
                  p.setQuantite(rs.getInt("quantite"));
                  Timestamp date = rs.getTimestamp("date_ajout");
                  p.setDate_ajout(date.toLocalDateTime());
                  p.setNom(rs.getString("nom"));
                  p.setReference(rs.getString("reference"));
                  p.setDescription( rs.getString("description"));
                  p.setPrix(rs.getFloat("prix"));
                  p.setImage(rs.getString("image"));
                 // Timestamp date_modif = rs.getTimestamp("modifiee_le");
                  //p.setModifie_le(date_modif.toLocalDateTime());
                  p.setId_user(rs.getInt("iduser"));
                  p.setCategorie(rs.getString("categorie"));
                  list.add(p);
            }
        } catch (SQLException ex) 
        {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
      public List<produit> AfficherProduitsVendeurParDateAjout ()
    {
        List<produit> list = new ArrayList<>();

        try {
            String requete = "SELECT nom,prix,image,quantite,categorie FROM produit order by date_ajout desc ;";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) 
            {
                  produit p = new produit();
                  p.setQuantite(rs.getInt("quantite"));
                  p.setNom(rs.getString("nom"));
                  p.setPrix(rs.getFloat("prix"));
                  p.setImage(rs.getString("image"));
                  p.setCategorie(rs.getString("categorie"));
                  list.add(p);
            }
        } catch (SQLException ex) 
        {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
    
    
    
    //affichage par id 
    
   public produit afficherParId(int id) {
        String req="select * from produit where id_prod="+id;
        produit p =new produit();
        try {
            rs = st.executeQuery(req);
            while(rs.next())
            {
                 // p.setId(rs.getInt("id_prod"));
                  p.setQuantite(rs.getInt("quantite"));
                  //Timestamp date = rs.getTimestamp("date_ajout");
                 // p.setDate_ajout(date.toLocalDateTime());
                  p.setNom(rs.getString("nom"));
                  p.setReference(rs.getString("reference"));
                  p.setDescription( rs.getString("description"));
                  p.setPrix(rs.getFloat("prix"));
                  p.setImage(rs.getString("image"));
                 // Timestamp date_modif = rs.getTimestamp("modifiee_le");
                  //p.setModifie_le(date_modif.toLocalDateTime());
                //  p.setId_user(rs.getInt("iduser"));
                  p.setCategorie(rs.getString("categorie"));
      
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
   }
    
    //Métiers 
    
   public List<produit> RechercherProduitParNom (String nom) {
        List<produit> lp = new ArrayList<>();
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
                { produit p = new produit();
                
                p.setQuantite(result.getInt("quantite"));
                 Timestamp date = result.getTimestamp("date_ajout");
                  p.setDate_ajout(date.toLocalDateTime());
                p.setId(result.getInt("id_prod"));
                p.setNom(result.getString("nom"));
                p.setReference(result.getString("reference"));
                p.setDescription(result.getString("description"));
                p.setImage(result.getString("image"));
                 Timestamp date_modif = result.getTimestamp("modifiee_le");
//                  p.setModifie_le(date_modif.toLocalDateTime());
                p.setCategorie(result.getString("categorie"));
                p.setId_user(result.getInt("iduser"));
                p.setPrix(result.getFloat("prix"));
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
   
  
    public List<produit> FiltrerProduitsParOrdreCroissant(int prixmax) {
        List<produit> list = new ArrayList<>();
        ServiceProduit sp = new ServiceProduit()    ;
        list = sp.afficher();
     
        if (prixmax != -1) {
            list = list.stream().filter(e -> e.getPrix() <= prixmax).collect(Collectors.toCollection(ArrayList<produit>::new));
            System.out.println("**3");
        }

        return list;
    }
    
    public List<produit> FiltrerProduitsParOrdreDecroissant(int prixmin) {
        List<produit> list = new ArrayList<>();
        ServiceProduit sp = new ServiceProduit()    ;
        list = sp.afficher();
     
         if (prixmin != -1) {
            list = list.stream().filter(e -> e.getPrix() >= prixmin).collect(Collectors.toCollection(ArrayList<produit>::new));
            System.out.println("**4");
        }
        return list;

    }
    
   /*public List<produit> FiltrerProduitsParOrdreCroissant () {
        List<produit> produits = new ArrayList<>();
        produit produit = new produit();
        try {
            String sql = "SELECT * FROM produit order by prix;";
            PreparedStatement statement = this.cnx.prepareStatement(sql);
            //statement.setString(1,filtre);
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                produit p = new produit();
                p.setQuantite(results.getInt("quantite"));
                 Timestamp date = results.getTimestamp("date_ajout");
                  p.setDate_ajout(date.toLocalDateTime());
                p.setId(results.getInt("id_prod"));
                p.setNom(results.getString("nom"));
                p.setReference(results.getString("reference"));
                p.setDescription(results.getString("description"));
                p.setImage(results.getString("image"));
                Timestamp date_modif = results.getTimestamp("modifiee_le");
                p.setModifie_le(date_modif.toLocalDateTime());
                p.setCategorie(results.getString("categorie"));
                p.setId_user(results.getInt("iduser"));
                p.setPrix(results.getFloat("prix"));
                produits.add(p);
                //  System.out.println(produit.toString());
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produits;
    }*/
   
   
    public List<produit> FiltrerProduitsParOrdreDecroissant () {
        List<produit> produits = new ArrayList<>();
        produit produit = new produit();
        try {
            String sql = "SELECT * FROM produit order by prix desc";
            PreparedStatement statement = this.cnx.prepareStatement(sql);
            //statement.setString(1,filtre);
            ResultSet results = statement.executeQuery();
            while (results.next()) 
            {
                produit p = new produit();
                p.setQuantite(results.getInt("quantite"));
                  Timestamp date = results.getTimestamp("date_ajout");
                  p.setDate_ajout(date.toLocalDateTime());
                p.setId(results.getInt("id_prod"));
                p.setNom(results.getString("nom"));
                p.setReference(results.getString("reference"));
                p.setDescription(results.getString("description"));
                p.setImage(results.getString("image"));
                Timestamp date_modif = results.getTimestamp("modifiee_le");
                  p.setModifie_le(date_modif.toLocalDateTime());
                p.setCategorie(results.getString("categorie"));
                p.setId_user(results.getInt("iduser"));
                p.setPrix(results.getFloat("prix"));     
                produits.add(p);
           
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produits;
    }
    
      public List<produit> RechercherProduitParCategorie (String categorie) {
        List<produit> produits = new ArrayList<>();
        produit produit = new produit();
        try {
            String sql = "SELECT * FROM produit where categorie like '%"+categorie +"%';" ;
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
                produit p = new produit();
                p.setQuantite(results.getInt("quantite"));
                 Timestamp date = results.getTimestamp("date_ajout");
                  p.setDate_ajout(date.toLocalDateTime());
                p.setId(results.getInt("id_prod"));
                p.setNom(results.getString("nom"));
                p.setReference(results.getString("reference"));
                p.setDescription(results.getString("description"));
                p.setImage(results.getString("image"));
            Timestamp date_modif = results.getTimestamp("modifiee_le");
                  //p.setModifie_le(date_modif.toLocalDateTime());
                p.setCategorie(results.getString("categorie"));
                p.setId_user(results.getInt("iduser"));
                p.setPrix(results.getFloat("prix"));     
                produits.add(p);
            }  while (results.next()) ;
    
         }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produits;
    }
}
