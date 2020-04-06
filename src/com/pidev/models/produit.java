/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.models;

import java.sql.Date;
import java.time.LocalDateTime;
//import java.util.Date;
import javafx.scene.image.Image;


/**
 *
 * @author benha
 */
public class produit {
    
    private int id;
    private int quantite;
    private LocalDateTime  date_ajout;
    private String nom;
    private String reference;
    private float prix;
    private String description;
    private String image;
    private LocalDateTime modifie_le;
    private int id_user;
    private int categorie;


    public LocalDateTime getDate_ajout() {
        return date_ajout;
    }

    public void setDate_ajout(LocalDateTime date_ajout) {
        this.date_ajout = date_ajout;
    }
 
    public produit() {
    }

    public produit(int quantite, LocalDateTime date_ajout, String nom, String reference, float prix, String description, String image, LocalDateTime modifie_le) {
        this.quantite = quantite;
        this.date_ajout = date_ajout;
        this.nom = nom;
        this.reference = reference;
        this.prix = prix;
        this.description = description;
        this.image = image;
        this.modifie_le = modifie_le;
    }

    
    
  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public produit(int id, int quantite, LocalDateTime date_ajout, String nom, String reference, float prix, String description, String image, LocalDateTime modifie_le, int id_user, int categorie) {
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

    public produit(int quantite, LocalDateTime date_ajout, String nom, String reference, float prix, String description, String image, LocalDateTime modifie_le, int id_user, int categorie) {
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

    public LocalDateTime getModifie_le() {
        return modifie_le;
    }

    public void setModifie_le(LocalDateTime modifie_le) {
        this.modifie_le = modifie_le;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }
 
}
