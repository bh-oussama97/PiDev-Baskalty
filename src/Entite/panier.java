/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Date;
import java.time.LocalDateTime;
   
/**
 *
 * @author benha
 */
public class panier {
    
    private int id_panier;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    private int user_id;
    private int produit_id;
    private int quantite;
    private int prix;
    private LocalDateTime date_ajout;
    private String name;
    private String image;

    public panier(int quantite, int prix, String name, String image) {
      
        this.quantite = quantite;
        this.prix = prix;
        this.name = name;
        this.image = image;
    }
    public panier(int id_panier, int user_id, int produit_id, int quantite, int prix, LocalDateTime date_ajout) {
        this.id_panier = id_panier;
        this.user_id = user_id;
        this.produit_id = produit_id;
        this.quantite = quantite;
        this.prix = prix;
        this.date_ajout = date_ajout;
    }

    public panier(int id_panier, int user_id, int produit_id, int quantite, int prix) {
        this.id_panier = id_panier;
        this.user_id = user_id;
        this.produit_id = produit_id;
        this.quantite = quantite;
        this.prix = prix;
    }

    public panier(int user_id, int produit_id, int quantite, int prix) {
        this.user_id = user_id;
        this.produit_id = produit_id;
        this.quantite = quantite;
        this.prix = prix;
    }

    public panier() 
    {
    }

    public panier(int user_id, int produit_id, int quantite, int prix, LocalDateTime date_ajout) {
        this.user_id = user_id;
        this.produit_id = produit_id;
        this.quantite = quantite;
        this.prix = prix;
        this.date_ajout = date_ajout;
    }

    @Override
    public String toString() {
        return "panier{" + "id_panier=" + id_panier + ", user_id=" + user_id + ", produit_id=" + produit_id + ", quantite=" + quantite + ", prix=" + prix + ", date_ajout=" + date_ajout + '}';
    }
    
    

    public int getId_panier() {
        return id_panier;
    }

    public void setId_panier(int id_panier) {
        this.id_panier = id_panier;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public LocalDateTime getDate_ajout() {
        return date_ajout;
    }

    public void setDate_ajout(LocalDateTime date_ajout) {
        this.date_ajout = date_ajout;
    }
    
    

   
}
