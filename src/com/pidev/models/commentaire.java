/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.models;

/**
 *
 * @author WSI
 */
public class commentaire {
      private int id_com;
      private String contenu;
      private int user ;
      private int pub;

    public int getPub() {
        return pub;
    }

    public void setPub(int pub) {
        this.pub = pub;
    }

    public int getId_com() {
        return id_com;
    }

    public void setId_com(int id_com) {
        this.id_com = id_com;
    }

  
    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public commentaire(int id_com, String contenu, int user) {
        this.id_com = id_com;
        this.contenu = contenu;
        this.user = user;
    }

    @Override
    public String toString() {
        return "commentaire{" + "id_com=" + id_com + ", contenu=" + contenu + ", user=" + user + '}';
    }

    public commentaire(String contenu) {
        this.contenu = contenu;
    }

    public commentaire(int id_com, String contenu) {
        this.id_com = id_com;
        this.contenu = contenu;
    }
      
   

    
}
