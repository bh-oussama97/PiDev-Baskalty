/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.models;

import java.sql.Date;
//import java.util.Date;
import javafx.scene.image.Image;


/**
 *
 * @author benha
 */
public class produit {
    
    private int id;
    private int quantite;
    private Date date_ajout;
    private String nom;
    private String reference;
    private float prix;
    private String description;
    private String image;
    private Date modifie_le;
    private int id_user;
    private String categorie;

    public produit() {
    }

    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

 
    public produit(int id, int quantite, Date date_ajout, String nom, String reference, float prix, String description, String image, Date modifie_le, int id_user, String categorie) {
        this.id = id;
        this.quantite = quantite;
        this.date_ajout = date_ajout;
        this.nom = nom;
        this.reference = reference;
        this.prix = prix;
        this.description = description;
        this.image = image;
        this.modifie_le = modifie_le;
        this.id_user = id_user;
        this.categorie = categorie;
    }

    public produit(int quantite, Date date_ajout, String nom, String reference, float prix, String description, String image, Date modifie_le, int id_user, String categorie) {
        this.quantite = quantite;
        this.date_ajout = date_ajout;
        this.nom = nom;
        this.reference = reference;
        this.prix = prix;
        this.description = description;
        this.image = image;
        this.modifie_le = modifie_le;
        this.id_user = id_user;
        this.categorie = categorie;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "produit{" + "id=" + id + ", quantite=" + quantite + ", date_ajout=" + date_ajout + ", nom=" + nom + ", reference=" + reference + ", prix=" + prix + ", description=" + description + ", image=" + image + ", modifie_le=" + modifie_le + ", id_user=" + id_user + ", categorie=" + categorie + '}';
    }

    public Date getDate_ajout() {
        return date_ajout;
    }

    public void setDate_ajout(Date date_ajout) {
        this.date_ajout = date_ajout;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getModifie_le() {
        return modifie_le;
    }

    public void setModifie_le(Date modifie_le) {
        this.modifie_le = modifie_le;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
 
}
