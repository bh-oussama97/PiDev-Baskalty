/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.time.LocalDateTime;

/**
 *
 * @author benha
 */
public class contact {
    
    private int id_contact;
    private String sujet;
    private String  nom;
    private String email;
    private String message;
    private LocalDateTime date_ajout ;
    private String phonenumber;


    public contact() {
    }
    
    

    public contact(String sujet, String nom, String email, String message, LocalDateTime date_ajout,String phonenumber) {
        this.sujet = sujet;
        this.nom = nom;
        this.email = email;
        this.message = message;
        this.date_ajout = date_ajout;
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "contact{" + "id_contact=" + id_contact + ", sujet=" + sujet + ", nom=" + nom + ", email=" + email + ", message=" + message + ", date_ajout=" + date_ajout + '}';
    }

    public contact(int id_contact, String sujet, String nom, String email, String message, LocalDateTime date_ajout) {
        this.id_contact = id_contact;
        this.sujet = sujet;
        this.nom = nom;
        this.email = email;
        this.message = message;
        this.date_ajout = date_ajout;
    }


    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    public int getId_contact() {
        return id_contact;
    }

    public void setId_contact(int id_contact) {
        this.id_contact = id_contact;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate_ajout() {
        return date_ajout;
    }

    public void setDate_ajout(LocalDateTime date_ajout) {
        this.date_ajout = date_ajout;
    }

    
    
    
    
}
