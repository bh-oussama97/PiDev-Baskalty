/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.services;

import com.pidev.models.mechanicien;
import com.pidev.models.panier;
import com.pidev.models.produit;
import com.pidev.utils.DataSource;
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

/**
 *
 * @author yaya
 */
public class ServiceMaintenance implements IService<mechanicien>{
   
    private static ServiceMaintenance instance;
    private Statement st;
    private ResultSet rs;
    Connection cnx = DataSource.getInstance().getCnx();
    
    public ServiceMaintenance()
    {
           DataSource cs= DataSource.getInstance();
        try {
            st= cs.getCnx().createStatement();
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }
    
    //CRUD

 @Override
    
    public void ajouter(mechanicien m) {
        try {
            String requete = "INSERT INTO mechanicien (service,nom,prenom,mail,image,prix,num_tel,description,experience,region,city,adomicile,userid,actif) VALUES"
                    + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1,m.getService());
            pst.setString(2,m.getNom());
            pst.setString(3,m.getPrenom());
            pst.setString(4,m.getMail());
            pst.setString(5,m.getImage());
            pst.setFloat(6,m.getPrix());
            pst.setInt(7,m.getNum_tel());
            pst.setString(8,m.getDescription());
            pst.setString(9,m.getExperience());
            pst.setString(10,m.getRegion());
            pst.setString(11,m.getCity());
            pst.setString(12,m.getAdomicile());            
            pst.setInt(13,m.getUserid());
            pst.setString(14,m.getActif());
            pst.executeUpdate();
            System.out.println("Mecanicienss ajouté !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }}
    @Override
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
    public void modifier(mechanicien m ) {
        try {
            String requete = "UPDATE mechanicien SET Prix='"
                    + m.getPrix()+ "',Service='"+  m.getService() + "',Nom='" + m.getNom() + "',Prenom='"+m.getPrenom()                    
                    + "',Mail='"+m.getMail()+"',image='"+m.getImage() + "',Num_Tel='"+m.getNum_tel()+"',description='"+m.getDescription() 
                    + "',experience='"+m.getExperience()+"',region='"+m.getRegion() 
                    + "',city='"+m.getCity()+"',adomicile='"+m.getAdomicile()
                    +"',actif='"+m.getActif() 
                   + "' WHERE id=" + m.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("panier modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
          
    @Override
    public List<mechanicien> afficher()
    {
        List<mechanicien> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM mechanicien;";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) 
            {
                  mechanicien p = new mechanicien();
                  p.setId(rs.getInt("id"));
                  p.setNom(rs.getString("nom"));
             
                  list.add(p);
            }
        } catch (SQLException ex) 
        {
            System.err.println(ex.getMessage());
        }

        return list;
    }
}