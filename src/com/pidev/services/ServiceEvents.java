/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.services;

import com.pidev.models.events;
import com.pidev.utils.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 *
 * @author selmi
 */
public class ServiceEvents {
      private Connection con = DataSource.getInstance().getCnx();
    private Statement ste;
    private ResultSet rs;

    public ServiceEvents() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public void ajouterEvent1(events e) throws SQLException {
       
            Date dd=new java.sql.Date(e.getStart().getTime());
        Date df=new java.sql.Date(e.getEnd().getTime());
                   String req="INSERT INTO `events` (`name`, `location`, `start`, `end`, `prix`, `quantity`, `image`, `description`) VALUES ('"+e.getName()+"','"+e.getLocation()+"','"+dd+"','"+df+"','"+e.getPrix()+"','"+e.getQuantity()+"','"+e.getImage()+"','"+e.getDescription()+"');";

 try {
            
            ste=con.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvents.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    public void ajouterEvent(events e) throws SQLException {
       
        try {
            String requete = "INSERT INTO events (themeid,association,name,location,"
                    + "description,start,image,end,prix,quantity) VALUES"
                    + " (?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(requete);
            pst.setInt(1,e.getTheme());
            pst.setInt(2, e.getId_user());
            pst.setString(3,e.getName());
            pst.setString(4, e.getLocation());
            pst.setString(5, e.getDescription());
            pst.setDate(6, e.getStart());
            pst.setString(7, e.getImage());
            pst.setDate(8, e.getEnd());
            pst.setInt(9, e.getPrix());
            pst.setInt(10, e.getQuantity());
            pst.executeUpdate();
            System.out.println("Nouveau evenement  !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
}
     public List<events> readAllEvents() throws SQLException
    {
    List<events> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from events ");
    events com=null;
    while (res.next()) {       
        ImageView v=new ImageView();
                   v.setImage(new Image(rs.getString(11)));
                   v.setFitHeight(100);
                   v.setFitWidth(100);
      com=new events(res.getInt(1),res.getInt(2),res.getInt(3),res.getString(7),res.getString(8),res.getString(9),res.getDate(10),res.getString(11),res.getDate(12),res.getInt(13),res.getInt(14));
                         com.setImag(v);

      list.add(com);
        }   
    return list;
    }
      public void supprimerEvent (int id) {
         String req="delete from events where id="+id;
        try {
            ste.executeUpdate(req);
            System.out.println("Eveneemnet bien supprimé ! ");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvents.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void modifierEvent (events e) {
        try {
            String requete = "UPDATE events SET themeid='" + 
                    e.getTheme()+ "',association='"+e.getId_user()
                    + "',name='"+e.getName()+ "',description='"+e.getDescription()
                    +"',location='"+e.getLocation() +"',image='"+e.getImage() +"',start='"+ e.getStart()
                    +"',end='"+e.getEnd() + "',prix='"+e.getPrix()+ "',quantity='"+e.getQuantity()
                    + "' WHERE id=" + e.getId();
            Statement st = con.createStatement();
            st.executeUpdate(requete);
        System.out.println("Evenement modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
      
      
    
    
    
    
    
}
