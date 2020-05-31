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
import static java.sql.Types.TIMESTAMP;
import java.time.LocalDateTime;
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
            String requete = "INSERT INTO product (quantite,date,name,reference,"
                    + "description,price,image,category,iduser) VALUES"
                    + " (?,?,?,?,?,?,?,?,?);";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1,p.getQuantite());
           java.sql.Timestamp javaSqlDate = Timestamp.valueOf(p.getDate_ajout());
             pst.setTimestamp(2, javaSqlDate);
            pst.setString(3,p.getNom());
            pst.setString(4, p.getReference());
            pst.setString(5, p.getDescription());
            pst.setInt(6, p.getPrix());
            pst.setString(7, p.getImage());
            pst.setInt(8,p.getCategorie());
           // pst.setTimestamp(9, Timestamp.valueOf(""));
           // pst.setNull(9,LocalDateTime.);
            pst.setInt(9,27);
           
            pst.executeUpdate();
            System.out.println("Produit ajouté !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
        
    public void supprimer (int id) {
         String req="delete from product where id="+id;
        try {
            st.executeUpdate(req);
            System.out.println("produit bien supprimé ! ");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void updateProductByQuantityAdded( int quant,int idd_prod)
    {
        try
        {
            String request = "update product set quantite="+quant+" where id="+idd_prod+";" ;
           
            st.executeUpdate(request);
           System.out.println("quantity of product " +idd_prod +"has been updated successfully ");
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
    
      public void modifier(produit p) {
        try {
            String requete = "UPDATE product SET quantite='" + 
                    p.getQuantite() + "',name='"+p.getNom()
                    + "',reference='"+p.getReference() + "',description='"+p.getDescription()
                    +"',price='"+p.getPrix() +"',image='"+p.getImage() +"',updated_at='"+ p.getModifie_le()
                    +"',category='"+p.getCategorie()+"'"
                    + " WHERE id=" + p.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("produit modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
   
    
    public ArrayList<produit> afficher()
    {
        ArrayList<produit> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM product;";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) 
            {
                  produit p = new produit();
                  p.setId(rs.getInt("id"));
                  p.setQuantite(rs.getInt("quantite"));
                  Timestamp date = rs.getTimestamp("date");
                  p.setDate_ajout(date.toLocalDateTime());
                  p.setNom(rs.getString("name"));
                  p.setReference(rs.getString("reference"));
                  p.setDescription( rs.getString("description"));
                  p.setPrix(rs.getInt("price"));
                  p.setImage(rs.getString("image"));
                 // Timestamp date_modif = rs.getTimestamp("modifiee_le");
                  //p.setModifie_le(date_modif.toLocalDateTime());
                  p.setId_user(rs.getInt("iduser"));
                  p.setCategorie(rs.getInt("category"));
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
            String requete = "SELECT name,price,image,quantite,category FROM product order by date desc ;";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) 
            {
                  produit p = new produit();
                  p.setQuantite(rs.getInt("quantite"));
                  p.setNom(rs.getString("name"));
                  p.setPrix(rs.getInt("price"));
                  p.setImage(rs.getString("image"));
                  p.setCategorie(rs.getInt("category"));
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
        String req="select * from product where id="+id;
        produit p =new produit();
        try {
            rs = st.executeQuery(req);
            while(rs.next())
            {
                 // p.setId(rs.getInt("id_prod"));
                  p.setQuantite(rs.getInt("quantite"));
                  //Timestamp date = rs.getTimestamp("date_ajout");
                 // p.setDate_ajout(date.toLocalDateTime());
                  p.setNom(rs.getString("name"));
                  p.setReference(rs.getString("reference"));
                  p.setDescription( rs.getString("description"));
                  p.setPrix(rs.getInt("price"));
                  p.setImage(rs.getString("image"));
                 // Timestamp date_modif = rs.getTimestamp("modifiee_le");
                  //p.setModifie_le(date_modif.toLocalDateTime());
                //  p.setId_user(rs.getInt("iduser"));
                  p.setCategorie(rs.getInt("category"));
      
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
            String select = "SELECT  * FROM product where name like '%"+nom+"%' ;";

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
                 Timestamp date = result.getTimestamp("date");
                  p.setDate_ajout(date.toLocalDateTime());
                p.setId(result.getInt("id"));
                p.setNom(result.getString("name"));
                p.setReference(result.getString("reference"));
                p.setDescription(result.getString("description"));
                p.setImage(result.getString("image"));
                 Timestamp date_modif = result.getTimestamp("updated_at");
//                  p.setModifie_le(date_modif.toLocalDateTime());
                p.setCategorie(result.getInt("category"));
                p.setId_user(result.getInt("iduser"));
                p.setPrix(result.getInt("price"));
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
   
  
    public ArrayList<produit> FiltrerProduitsParOrdreCroissant(int prixmax) {
        ArrayList<produit> list = new ArrayList<>();
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
            String sql = "SELECT * FROM product order by price desc";
            PreparedStatement statement = this.cnx.prepareStatement(sql);
            //statement.setString(1,filtre);
            ResultSet results = statement.executeQuery();
            while (results.next()) 
            {
                produit p = new produit();
                p.setQuantite(results.getInt("quantite"));
                  Timestamp date = results.getTimestamp("date");
                  p.setDate_ajout(date.toLocalDateTime());
                p.setId(results.getInt("id"));
                p.setNom(results.getString("name"));
                p.setReference(results.getString("reference"));
                p.setDescription(results.getString("description"));
                p.setImage(results.getString("image"));
                Timestamp date_modif = results.getTimestamp("updated_at");
                  p.setModifie_le(date_modif.toLocalDateTime());
                p.setCategorie(results.getInt("category"));
                p.setId_user(results.getInt("iduser"));
                p.setPrix(results.getInt("price"));     
                produits.add(p);
           
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produits;
    }
    
      public ArrayList<produit> RechercherProduitParCategorie (int categorie) {
        ArrayList<produit> produits = new ArrayList<>();
        produit produit = new produit();
        try {
            String sql = "SELECT * FROM product where product.category="+categorie ;
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
                 Timestamp date = results.getTimestamp("date");
                  p.setDate_ajout(date.toLocalDateTime());
                p.setId(results.getInt("id"));
                p.setNom(results.getString("name"));
                p.setReference(results.getString("reference"));
                p.setDescription(results.getString("description"));
                p.setImage(results.getString("image"));
            Timestamp date_modif = results.getTimestamp("updated_at");
                  //p.setModifie_le(date_modif.toLocalDateTime());
                p.setCategorie(results.getInt("category"));
                p.setId_user(results.getInt("iduser"));
                p.setPrix(results.getInt("price"));     
                produits.add(p);
            }  while (results.next()) ;
    
         }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produits;
    }
}
