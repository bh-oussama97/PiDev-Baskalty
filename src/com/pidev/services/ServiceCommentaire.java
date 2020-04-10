/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.services;

import com.pidev.models.commentaire;
import com.pidev.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WSI
 */
public class ServiceCommentaire {
       private static ServiceCommentaire instance;
    private Statement st;
    private ResultSet rs;
    Connection cnx = DataSource.getInstance().getCnx();
    
    public ServiceCommentaire()
    {
           DataSource cs= DataSource.getInstance();
        try {
            st= cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommentaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void ajouter(commentaire c) {
       
        try {
            String requete = "INSERT INTO commentaire (contenu) VALUES  (?) "; 
                   //where commentaire.pub=publication.id_pub;
     
            PreparedStatement pst = cnx.prepareStatement(requete);
            //pst.setInt(1,c.getPub());
            pst.setString(1,c.getContenu());
            
            pst.executeUpdate();
            System.out.println("Commentaire ajouté !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
       }
}
