/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.services;

import com.pidev.models.fos_user;
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
 * @author WSI
 */
public class ServiceUser implements InterfaceUser {
    private Statement st;
    private ResultSet rs;
    Connection cnx = DataSource.getInstance().getCnx();
    
    public ServiceUser()
    {
           DataSource cs= DataSource.getInstance();
        try {
            st= cs.getCnx().createStatement();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    @Override
public void AjouterUser(fos_user u) {
        try {
            String req = "INSERT INTO fos_user (username,username_canonical,email,email_canonical,enabled,password,confirmation_token,roles,image_file) VALUES (?,?,?,?,?,?,?,?,?)";

            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, u.getUsername());
            st.setString(2,u.getUsername_canonical());
            st.setString(3, u.getEmail());
            st.setString(4, u.getEmail_canonical());
            st.setInt(5, 1);
            //st.setString(6, u.getSalt());
            st.setString(6, u.getPassword());
            //st.setDate(8, u.getLast_login());
            st.setString(7, u.getConfirmation_token());
            //st.setDate(10, u.getPassword_requested_at());
            st.setString(8, u.getRoles());
            st.setString(9, u.getImage_files());
            st.executeUpdate();
            System.out.println("user ajoutée !!");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ModiferUser(int id, fos_user u) {
        try {
            System.out.println("-------"+u.getUsername());
            String req = "UPDATE fos_user SET username = ?,username_canonical=?, email= ?, password=?, roles=? , image_file=? " 
                    + " WHERE id = " + id + ";";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, u.getUsername());
            st.setString(2, u.getUsername_canonical());
            st.setString(3, u.getEmail());
            st.setString(4, u.getPassword()+"{"+u.getUsername()+"}");
            st.setString(5, u.getRoles());
            st.setString(6, u.getImage_files());
           

            st.executeUpdate();
            System.out.println("user modilfer !!");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
public void UpdateEnabledUser(int id, int enabled) {
        try {
            //System.out.println("-------"+u.getNom());
            String req = "UPDATE fos_user SET `enabled` = ?"
                    + " WHERE id = '" + id + "'";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, enabled);
            

            st.executeUpdate();
            System.out.println("user modilfer !!");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
 public void SupprimerUser(int id) {
        try {
            String req = "DELETE FROM fos_user WHERE fos_user.`id` = ? ";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("user supprimé !!");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
  public Boolean Login(String username, String password) {

        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery("Select * from fos_user WHERE fos_user.`username` = '" + username + "'and  fos_user.`password` like '"+password+"%'");
            
            if (rs.next()) {
                System.out.println("login success");
                return true;
            }
            

            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

  
   public void registerUser(fos_user u) {
        try {
            String req = "INSERT INTO fos_user (username,username_canonical,email,email_canonical,enabled,password,confirmation_token,roles,image_file,registration_date) VALUES (?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, u.getUsername());
            st.setString(2,u.getUsername_canonical());
            st.setString(3, u.getEmail());
            st.setString(4, u.getEmail_canonical());
            st.setInt(5, 1);
            st.setString(6, u.getPassword());
            st.setString(7, u.getConfirmation_token());
            st.setString(8, u.getRoles());
            st.setString(9, u.getImage_files());
             java.sql.Timestamp javaSqlDate = Timestamp.valueOf(u.getRegistration_date());
            st.setTimestamp(10, javaSqlDate);
            st.executeUpdate();
            System.out.println("User Ajouté !!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
  
  
  
   
   public fos_user AfficherUserId(int id) {
 ArrayList<fos_user> listN = new ArrayList<fos_user>();
 fos_user u = new fos_user();
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery("Select * from fos_user where fos_user.`id`='"+id+"'");
            while (rs.next()) {
               
                        u.setId(rs.getInt("id"));
                        u.setUsername(rs.getString("username"));
                        u.setUsername_canonical(rs.getString("username_canonical"));
                        u.setEmail(rs.getString("email"));
                        u.setEmail_canonical(rs.getString("email_canonical"));
                        u.setEnabled(rs.getInt("enabled"));
                        u.setPassword(rs.getString("password"));
                        u.setLast_login(rs.getDate("last_login"));
                        u.setConfirmation_token(rs.getString("Confirmation_token"));
                        u.setPassword_requested_at(rs.getDate("password_requested_at"));
                        u.setRoles(rs.getString("rôle"));
                        u.setImage_files(rs.getString("image"));
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(fos_user.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
   
   
    @Override
   public List<fos_user> getAllUser() {
        ArrayList<fos_user> listN = new ArrayList<fos_user>();
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery("Select * from fos_user");
            while (rs.next()) {
                System.out.println("id " + rs.getString(1) + "contenu  " + rs.getString(4));
                listN.add(new fos_user(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("username_canonical"),
                        rs.getString("email"),
                        rs.getString("email_canonical"),
                        rs.getInt("enabled"),
                        rs.getString("password"),
                        rs.getDate("last_login"),
                        rs.getString("Confirmation_token"),
                        rs.getDate("password_requested_at"),
                        rs.getString("roles"),
                        rs.getString("image_file")
                ));
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(fos_user.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listN;
    }
   
    
    @Override
    public boolean verifAdmin(String username) {
        ArrayList<fos_user> listN = new ArrayList<fos_user>();
 fos_user u = new fos_user();
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery("Select * from fos_user where fos_user.`username`='"+username+"' and fos_user.`roles` like '%ROLE_AGENT%' ");
            if(rs.next())
                return true;
            
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(fos_user.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }

    public fos_user AfficherUser(String username) {
        List<fos_user> list = new ArrayList<>();
fos_user u = new fos_user(); 
        try {
            String requete = "Select * from fos_user where fos_user.`username`='"+username+"'";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) 
            {
                 //fos_user u = new fos_user(); 
                        u.setUsername(rs.getString("username"));
                        u.setUsername_canonical(rs.getString("username_canonical"));
                        u.setEmail(rs.getString("email"));
                        u.setEmail_canonical(rs.getString("email_canonical"));
                        u.setEnabled(rs.getInt("enabled"));
                        u.setPassword(rs.getString("password"));
                        u.setLast_login(rs.getDate("last_login"));
                        u.setConfirmation_token(rs.getString("Confirmation_token"));
                        u.setPassword_requested_at(rs.getDate("password_requested_at"));
                        u.setRoles(rs.getString("roles"));
                        u.setImage_files(rs.getString("image_file"));
            }
        } catch (SQLException ex) 
        {
            System.err.println(ex.getMessage());
        }

        return u;
    }

   
   
}
