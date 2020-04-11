/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.*;
import javafx.scene.image.ImageView;

/**
 *
 * @author 
 */
public class events {
    
     private int Id_Event;
    private int Id_User;
    private String Titre;
    private String Contenu;
    private int nbre_vues;
    private int Participernumber;
    private int Interstednumber;
    private int commenternumber;
    private String location;

    private Date start;
    private String image;
    private ImageView imag;

    private Date end;
    private int prix;
    private int quantity;
    private theme categorie;

    public events() {
    }

    public events(int Id_Event, int Id_User, String Titre, String Contenu, String location, Date start, Date end, int prix, int quantity) {
        this.Id_Event = Id_Event;
        this.Id_User = Id_User;
        this.Titre = Titre;
        this.Contenu = Contenu;
        this.location = location;
        this.start = start;
        this.end = end;
        this.prix = prix;
        this.quantity = quantity;
    }
 
    public events(int Id_Event,int Id_User, String Titre, String Contenu, String location, Date start, Date end, int prix, int quantity,String image) {
               this.Id_Event = Id_Event;

        this.Id_User = Id_User;
        this.Titre = Titre;
        this.Contenu = Contenu;
        this.location = location;
        this.start = start;
        this.end = end;
        this.prix = prix;
        this.quantity = quantity;
                this.image = image;

    }
public events(int Id_User, String Titre, String Contenu, String location, Date start, Date end, int prix, int quantity) {
        this.Id_User = Id_User;
        this.Titre = Titre;
        this.Contenu = Contenu;
        this.location = location;
        this.start = start;
        this.end = end;
        this.prix = prix;
        this.quantity = quantity;

    }
    public events(String Titre, String Contenu, String location, Date start, String image, Date end, int prix, int quantity, theme categorie) {
        this.Titre = Titre;
        this.Contenu = Contenu;
        this.location = location;
        this.start = start;
        this.image = image;
        this.end = end;
        this.prix = prix;
        this.quantity = quantity;
        this.categorie = categorie;
    }
  
    public events(int Id_Event, int Id_User, String Titre, String Contenu, String location, Date start, String image, Date end, int prix, int quantity, theme categorie) {
        this.Id_Event = Id_Event;
        this.Id_User = Id_User;
        this.Titre = Titre;
        this.Contenu = Contenu;
        this.location = location;
        this.start = start;
        this.image = image;
        this.end = end;
        this.prix = prix;
        this.quantity = quantity;
        this.categorie = categorie;
    }

    public events(int Id_Event, int Id_User, String Titre, String Contenu, int nbre_vues, int Participernumber, int Interstednumber, int commenternumber, String location, Date start, String image, ImageView imag, Date end, int prix, int quantity, theme categorie) {
        this.Id_Event = Id_Event;
        this.Id_User = Id_User;
        this.Titre = Titre;
        this.Contenu = Contenu;
        this.nbre_vues = nbre_vues;
        this.Participernumber = Participernumber;
        this.Interstednumber = Interstednumber;
        this.commenternumber = commenternumber;
        this.location = location;
        this.start = start;
        this.image = image;
        this.imag = imag;
        this.end = end;
        this.prix = prix;
        this.quantity = quantity;
        this.categorie = categorie;
    }

    

    public int getId_Event() {
        return Id_Event;
    }

    public void setId_Event(int Id_Event) {
        this.Id_Event = Id_Event;
    }

    public int getId_User() {
        return Id_User;
    }

    public void setId_User(int Id_User) {
        this.Id_User = Id_User;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String Contenu) {
        this.Contenu = Contenu;
    }

    public int getNbre_vues() {
        return nbre_vues;
    }

    public void setNbre_vues(int nbre_vues) {
        this.nbre_vues = nbre_vues;
    }

    public int getParticipernumber() {
        return Participernumber;
    }

    public void setParticipernumber(int Participernumber) {
        this.Participernumber = Participernumber;
    }

    public int getInterstednumber() {
        return Interstednumber;
    }

    public void setInterstednumber(int Interstednumber) {
        this.Interstednumber = Interstednumber;
    }

    public int getCommenternumber() {
        return commenternumber;
    }

    public void setCommenternumber(int commenternumber) {
        this.commenternumber = commenternumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ImageView getImag() {
        return imag;
    }

    public void setImag(ImageView imag) {
        this.imag = imag;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public theme getCategorie() {
        return categorie;
    }

    public void setCategorie(theme categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "events{" + "Id_Event=" + Id_Event + ", Id_User=" + Id_User + ", Titre=" + Titre + ", Contenu=" + Contenu + ", nbre_vues=" + nbre_vues + ", Participernumber=" + Participernumber + ", Interstednumber=" + Interstednumber + ", commenternumber=" + commenternumber + ", location=" + location + ", start=" + start + ", image=" + image + ", end=" + end + ", prix=" + prix + ", quantity=" + quantity + '}';
    }

   

    
    

}
