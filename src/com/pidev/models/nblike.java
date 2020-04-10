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
public class nblike {
     private int id_lik;
     private int user ;

    public int getId_lik() {
        return id_lik;
    }

    public void setId_lik(int id_lik) {
        this.id_lik = id_lik;
    }

    

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public nblike(int id_lik, int user) {
        this.id_lik = id_lik;
        this.user = user;
    }

    @Override
    public String toString() {
        return "nblike{" + "id_lik=" + id_lik + ", user=" + user + '}';
    }

   

    
     
     
}
