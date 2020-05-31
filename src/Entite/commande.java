/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author benha
 */
public class commande {

    private int id_commande;
  
    private String num_telephone;
    private String ville;
    private String adresse;
 
    private int prix_total;
    
    private String email;
    private String nom;
    
    
    public commande() {
    }

    public commande(String num_telephone, String ville, String adresse, int prix_total, String email, String nom) {
        this.num_telephone = num_telephone;
        this.ville = ville;
        this.adresse = adresse;
        this.prix_total = prix_total;
        this.email = email;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "commande{" + "id_commande=" + id_commande + ", num_telephone=" + num_telephone + ", ville=" + ville + ", adresse=" + adresse + ", prix_total=" + prix_total + ", email=" + email + ", nom=" + nom + '}';
    }

    public commande(int id_commande, String num_telephone, String ville, String adresse, int prix_total, String email, String nom) {
        this.id_commande = id_commande;
        this.num_telephone = num_telephone;
        this.ville = ville;
        this.adresse = adresse;
        this.prix_total = prix_total;
        this.email = email;
        this.nom = nom;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public String getNum_telephone() {
        return num_telephone;
    }

    public void setNum_telephone(String num_telephone) {
        this.num_telephone = num_telephone;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(int prix_total) {
        this.prix_total = prix_total;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    

}
