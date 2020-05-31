package Service;

import Entite.RentProd;
import Utils.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author benha
 */
public class ServiceRentProd implements IService<RentProd> {

    private static ServiceProduit instance;
    Connection cnx = DataSource.getInstance().getConnection();
    private Statement st;
    private ResultSet rs;

    public ServiceRentProd() {
        DataSource cs = DataSource.getInstance();
        try {
            st = cs.getConnection().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //CRUD

    
    public void ajouter(RentProd r) {
        try {
            String requete = "INSERT INTO rentprod (model,quantity,marke,localisation,Reference,Price,Rentdays,dispo," +
                    "Description,Image) VALUES"
                    + " (?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement pst = cnx.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, r.getModel());
            pst.setInt(2, r.getQuantity());
            pst.setString(3, "bike");
            pst.setString(4, r.getLocalisation());
            pst.setString(5, r.getReference());
            pst.setDouble(6, r.getPrice());
            pst.setInt(7, r.getRentdays());
            pst.setInt(8, 1);
            pst.setString(9, r.getDescription());
            pst.setString(10, r.getImage());

            //pst.setDate(10,p.getDate_ajout());
            pst.executeUpdate();
            int newId=getLastId();
            r.setRentProd_id(newId);
            r.setMarke("bike");
            System.out.println("rent Prod ajouté !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

   
    public void supprimer(int id) {
        String req = "delete from rentProd where id=" + id;
        try {
            st.executeUpdate(req);
            System.out.println("rentProd bien supprimé ! ");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void modifier(RentProd r) {
        try {
            String requete = "UPDATE rentProd SET quantite='" +
                    r.getQuantity() + "',model='" + r.getModel()
                    + "',mark='" + r.getMarke() + "',Description='" + r.getDescription()
                    + "',localisation='" + r.getLocalisation() + "',image='" + r.getImage() + "',dispo='" + r.getDispo()
                    + "',Rentdays='" + r.getRentdays() + "',Reference='" + r.getReference() + "',Price='" + r.getPrice()
                    + "' WHERE id=" + r.getRentProd_id();
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("produit modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    int getLastId() {
        String req = "select MAX(id) as maximum from rentprod ";
        int maxId = 0;
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                maxId = rs.getInt("maximum");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maxId;
    }

    public ArrayList<RentProd> afficher() {
        ArrayList<RentProd> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM rentprod;";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                RentProd p = new RentProd();
                p.setRentProd_id(rs.getInt("id"));
                p.setModel(rs.getString("model"));
                p.setQuantity(rs.getInt("quantity"));
                p.setMarke(rs.getString("marke"));
                p.setLocalisation(rs.getString("localisation"));
                p.setReference(rs.getString("Reference"));
                p.setPrice(rs.getDouble("Price"));
                p.setRentdays(rs.getInt("Rentdays"));
                p.setDispo(rs.getInt("dispo") == 1);
                p.setDescription(rs.getString("Description"));
                p.setImage(rs.getString("image"));
                p.setStars(rs.getDouble("stars"));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    public void noter(Double stars, int idRentProd) {
        try {
            String requete = "UPDATE rentProd SET stars="+stars + " WHERE id=" + idRentProd;
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("rentProd a ete notee !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }


}