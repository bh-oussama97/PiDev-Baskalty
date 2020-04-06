/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.services;

import com.pidev.models.comment;
import com.pidev.models.events;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.pidev.utils.DataSource;

/**
 *
 * @author selmi
 */
public class ServiceComment {

    private Connection con = DataSource.getInstance().getCnx();
    private Statement ste;
    private ResultSet rs;

    public ServiceComment() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void ajouterCommentaire(comment c) throws SQLException {
        java.util.Date date1 = new java.util.Date();
        String temp_commentaire = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
        c.setTemps_Commentaire(temp_commentaire);
        String req1 = "INSERT INTO `comment` ( `user`, `publishdate`,`content`, `Events`) VALUES ('" + c.getId_User() + "', '" + c.getTemps_Commentaire() + "', '" + c.getContenu_Commentaire() + "', '" + c.getId_event() + "');";
        ste.executeUpdate(req1);
        System.out.println("element inseré");

    }
      public void supprimer (int id) {
         String req="delete from comment where id="+id;
        try {
            ste.executeUpdate(req);
            System.out.println("produit bien supprimé ! ");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void supprimerCommentaire(comment c) {

        try {
            String req = "DELETE FROM `comment` WHERE `comment`.`id` = ?";
            PreparedStatement ste = con.prepareStatement(req);
            ste.setInt(1, c.getId());
            ste.executeUpdate();
            System.out.println("element supprimer");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modifierCommentaire(comment c) {
        String sql = "UPDATE comment SET `user`=?,`publishdate`=?,`content`=?,`events`=? WHERE id=" + c.getId();
        PreparedStatement ste;
        try {
            ste = con.prepareStatement(sql);
            ste.setInt(1, c.getId_User());
            ste.setInt(4, c.getId_event());

            ste.setString(3, c.getContenu_Commentaire());
            ste.setString(2, c.getTemps_Commentaire());

            ste.executeUpdate();
            int rowsUpdated = ste.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("La modification de commenter " + c.getId() + " a été éffectué avec succée ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public List<comment> readAll(int id_event) throws SQLException
    {
    List<comment> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from comment WHERE Events='"+id_event+"'ORDER BY id");
    comment com=null;
    while (res.next()) {            
      com=new comment(res.getInt(1),res.getInt(2),res.getString(3),res.getString(4),res.getInt(5));
      list.add(com);
        }   
    return list;
    }
      
    
     public List<comment> readAllComment() throws SQLException
    {
    List<comment> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from comment ");
    comment com=null;
    while (res.next()) {            
      com=new comment(res.getInt(1),res.getInt(2),res.getString(3),res.getString(4),res.getInt(5));
      list.add(com);
        }   
    return list;
    }

    public void supprimerCommentaire(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  

}
