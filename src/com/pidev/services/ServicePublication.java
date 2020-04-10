/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.services;


import com.pidev.models.publication;
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
 * @author Cyrine
 */
public class ServicePublication implements IService<publication>

{    private static ServicePublication instance;
    private Statement st;
    private ResultSet rs;
    Connection cnx = DataSource.getInstance().getCnx();
    
    public ServicePublication()
    {
           DataSource cs= DataSource.getInstance();
        try {
            st= cs.getCnx().createStatement();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void ajouter(publication p) {
       
        try {
            String requete = "INSERT INTO publication (contenu,"
                    + "datecreation,image,user)  VALUES "
                    + " (?,?,?,?);";
                   
            PreparedStatement pst = cnx.prepareStatement(requete);
             pst.setString(1,p.getContenu());
           java.sql.Timestamp javaSqlDate = Timestamp.valueOf(p.getDatecreation());
            pst.setTimestamp(2, javaSqlDate);           
            pst.setString(3,p.getImage());
            pst.setInt(4, p.getUser());
            pst.executeUpdate();
            System.out.println("Publication ajouté !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
       }
       
 @Override
         public  void supprimer (int id_pub) {
         String req="delete from publication where id_pub="+id_pub ;
        try {
            st.executeUpdate(req);
            System.out.println("publication bien supprimé ! ");
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(publication p) {
        try {
            String requete = "UPDATE publication SET contenu='" + 
                    p.getContenu() + "',image='"+p.getImage()  + "',user='"+p.getUser()
                    + "' WHERE id_pub=" + p.getId_pub();
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("publication modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<publication> afficher()  {
            List<publication> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM publication ;";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) 
            {
                  publication p = new publication();
                  p.setId_pub(rs.getInt("id_pub"));
                  p.setContenu(rs.getString("contenu"));
                  Timestamp date = rs.getTimestamp("datecreation");
                  p.setDatecreation(date.toLocalDateTime());
                  p.setImage(rs.getString("image"));
                
                  p.setUser(rs.getInt("user"));
                  list.add(p);
            }
        } catch (SQLException ex) 
        {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
       
       
    }

   


    

