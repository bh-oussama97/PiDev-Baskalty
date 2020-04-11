/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Categorie;
import Entite.events;
import Entite.User;
import Utils.DataSource;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell is hell
 */
public class EvenementService {
 private Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    public EvenementService() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void ajouterEvent(events e) throws SQLException {
       
        try {
            String requete = "INSERT INTO events (association,name,location,"
                    + "description,start,end,prix,quantity,image) VALUES"
                    + " (?,?,?,?,?,?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(requete);
           // pst.setInt(1,e.getCategorie().getId());
            pst.setInt(1, e.getId_User());
            pst.setString(2,e.getTitre());
            pst.setString(3, e.getLocation());
            pst.setString(4, e.getContenu());
            pst.setDate(5, e.getStart());
            pst.setString(9, e.getImage());
            pst.setDate(6, e.getEnd());
            pst.setInt(7, e.getPrix());
            pst.setInt(8, e.getQuantity());
            pst.executeUpdate();
            System.out.println("Nouveau evenement  !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
}
    public void modifierEvent (events e) {
        try {
            String requete = "UPDATE events SET association='"+e.getId_User()
                    + "',name='"+e.getTitre()+ "',description='"+e.getContenu()
                    +"',location='"+e.getLocation() +"',image='"+e.getImage() +"',start='"+ e.getStart()
                    +"',end='"+e.getEnd() + "',prix='"+e.getPrix()+ "',quantity='"+e.getQuantity()
                    + "' WHERE id=" + e.getId_Event();
            Statement st = con.createStatement();
            st.executeUpdate(requete);
            int rowsUpdated = st.executeUpdate(requete);
            if (rowsUpdated > 0) {
                System.out.println("La modification de sujet" + e.getId_Event() + " a été éffectué avec succée ");
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
  public void compterNbreVue(events s) {
        try {
            PreparedStatement ste = con.prepareStatement("update events set interstednumber=interstednumber+1 WHERE events=" + s.getNbre_vues());
            

            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void supprimerEvent(events s) {

        try {
            String req = "DELETE FROM `events` WHERE `events`.`id` =?";
            PreparedStatement ste = con.prepareStatement(req);
            ste.setInt(1, s.getId_Event());
            ste.executeUpdate();
            System.out.println("element supprimer");

        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
    
    public boolean rechercherparNom(String nom) {
        boolean test = false;
        String req = "SELECT * from events where name='" + nom + "'";

        try {

            ResultSet stp = ste.executeQuery(req);
            stp.last();
            if (stp.getRow() != 0) {
                test = true;
                System.out.println(test + "\n events trouver");
            } else {
                test = false;
                System.out.println(test + "\n events non trouver");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return test;
    }
    public List<events> readAllSByCategorie(Categorie caString) throws SQLException {
        List<events> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from events WHERE themeid='" + caString.name()+ "'");
        events com = null;
        while (res.next()) {
            com = new events(res.getInt(3),res.getString(7), res.getString(9), res.getString(8), res.getDate(10), res.getDate(12), res.getInt(13), res.getInt(14));
            list.add(com);
            
        }
        System.out.println(list);
        return list;
    }

    public Vector<events> readAllS() throws SQLException {
        Vector<events> vector = new Vector<>();
        
       
            
            ResultSet res = ste.executeQuery("select * from events");
            events com = null;
            while (res.next()) {
            com = new events(res.getInt(1),res.getInt(3),res.getString(7), res.getString(9), res.getString(8), res.getDate(10), res.getDate(12), res.getInt(13), res.getInt(14),res.getString(11));
            vector.add(com);
            
            
            }
            System.out.println("tous les events:\n"+vector);
         
        return vector;
    }
    
public void supprimerEvent (int id) {
         String req="delete from events where id="+id;
        try {
            ste.executeUpdate(req);
            System.out.println("Eveneemnet bien supprimé ! ");
        } catch (SQLException ex) {
            Logger.getLogger(events.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public List<events> FindSujetByIdUser(int id_user) throws SQLException {
        List<events> list1 = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from events WHERE association='" + id_user + "'");
        events com = null;
        while (res.next()) {
                        com = new events(res.getInt(1),res.getInt(3),res.getString(7), res.getString(9), res.getString(8), res.getDate(10), res.getDate(12), res.getInt(13), res.getInt(14));

            list1.add(com);
            
        }
        System.out.println(list1);
        return list1;
    }

    
    public List<events> TrierParNbreVue() throws SQLException {
        List<events> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from events ORDER BY Participernumber DESC");
        events com = null;
        while (res.next()) {
            com = new events(res.getInt(3),res.getString(7), res.getString(9), res.getString(8), res.getDate(10), res.getDate(12), res.getInt(13), res.getInt(14));
            list.add(com);
            
        }
        System.out.println(list);
        return list;
    }

   
    public String FindNomUserByIdUser_events(int id_user) throws SQLException {
        String req = "SELECT * from fos_user where id='" + id_user + "'";
        ResultSet res = ste.executeQuery(req);
        User com = null;
        String nom = null;
        while (res.next()) {

            nom = res.getString(5);
        }
        return nom;
    }
   public void compterintersted(events s) {
        try {
            PreparedStatement ste = con.prepareStatement("update events set Interstednumber=Interstednumber+1 WHERE id=" + s.getId_Event());
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void compterinterstedpas(events s) {
        try {
            PreparedStatement ste = con.prepareStatement("update events set Interstednumber=Interstednumber-1 WHERE association=" + s.getId_Event());
           
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public int FindNombreIntersById_events(int id_event) throws SQLException{
    String req = "SELECT * from events where association='" + id_event + "'";
    ResultSet res = ste.executeQuery(req);
         User com = null;
          int nbre = 0;
        while (res.next()) {
          
           nbre = res.getInt(5);
        }
        return nbre;
}
}
