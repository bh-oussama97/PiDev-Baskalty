/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.services;
import com.pidev.models.events;
import com.pidev.models.participer;
import com.pidev.utils.DataSource;
import java.sql.Connection;
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
/**
 *
 * @author selmi
 */
public class Serviceparticiper {
    
    
     private Connection con = DataSource.getInstance().getCnx();
    private Statement ste;
    private ResultSet rs;
    public Serviceparticiper() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public void ajouterParticiper(participer p) throws SQLException {
   
  
        String req1 = "INSERT INTO `participer` (`events_id`, `user_id`,`Number`) "
                + "VALUES ('" + p.getId_event()+ "', '" + p.getId_user()+ "', '" + p.getNumber()+ "');"; 
               
        ste.executeUpdate(req1);
        System.out.println("elment inseré");

    }
    
    
    
    public int FindValeurparticiperByIdUserAndevent(int id_event,int id_user) throws SQLException{
    String req = "SELECT * from participer WHERE events_id='" + id_event +"'AND user_id='"+id_user+ "'";
    ResultSet res = ste.executeQuery(req);
        participer participe=null;
        int Numberr = 0;
        while (res.next()) {
          
           Numberr = res.getInt(4);
           System.out.println(Numberr);
           
        }
        return Numberr;
}
       public void incrementerparticiper(int id_user,int id_event) {
        try {
            PreparedStatement ste = con.prepareStatement("update participer set Number=Number+1  WHERE user_id='" +id_user +"'AND events_id='"+id_event+ "'");
            ste.executeUpdate();
        } 
        catch (SQLException ex) {
            Logger.getLogger(Serviceparticiper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void decrementerparticiper(int id_user,int id_event) {
        try {
            PreparedStatement ste = con.prepareStatement("update participer set Number=Number-1  WHERE user_id='" +id_user +"'AND events_id='"+id_event+ "'");
            

            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Serviceparticiper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
