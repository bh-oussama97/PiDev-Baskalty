/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.models;


import java.time.LocalDateTime;

/**
 *
 * @author WSI
 */
public class publication {
    private int id_pub;
    private String contenu;
    private LocalDateTime datecreation ;
    private String image;
    private int user ;

    public publication() {
       
    }

    public int getId_pub() {
        return id_pub;
    }

    public void setId_pub(int id_pub) {
        this.id_pub = id_pub;
    }

    

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public LocalDateTime getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(LocalDateTime datecreation) {
        this.datecreation = datecreation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    
    
    public publication(int id_pub, String contenu, LocalDateTime datecreation, String image, int user) {
        this.id_pub = id_pub;
        this.contenu = contenu;
        this.datecreation = datecreation;
        this.image = image;
        this.user = user;
    }

    public publication(String contenu, LocalDateTime datecreation, String image, int user) {
        this.contenu = contenu;
        this.datecreation = datecreation;
        this.image = image;
        this.user = user;
    }

    @Override
    public String toString() {
        return "publication{" + "id_pub=" + id_pub + ", contenu=" + contenu + ", datecreation=" + datecreation + ", image=" + image + ", user=" + user + '}';
    }

    public void setModifie_le(LocalDateTime toLocalDateTime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
    
}
