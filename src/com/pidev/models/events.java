/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.models;

import java.sql.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author selmi
 */
public class events {

    private int id;
    private int theme;
    private int id_user;
    private int Participernumber;
    private int Interstednumber;
    private int commenternumber;
    private String name;
    private String location;
    private String description;
    private Date start;
    private String image;
    private ImageView imag;

    private Date end;
    private int prix;
    private int quantity;

    public events(String img, String img0, String img1, java.util.Date dd, java.util.Date df, int q, int q0, ImageView imageview) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public events(String text, String text0, String text1, Date date, Date date0, int n, int q, String img) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ImageView getImag() {
        return imag;
    }

    public void setImag(ImageView imag) {
        this.imag = imag;
    }

  

    @Override
    public String toString() {
        return "events{" + "id=" + id + ", theme=" + theme + ", id_user=" + id_user + ", Participernumber=" + Participernumber + ", Interstednumber=" + Interstednumber + ", commenternumber=" + commenternumber + ", name=" + name + ", location=" + location + ", description=" + description + ", start=" + start + ", image=" + image + ", end=" + end + ", prix=" + prix + ", quantity=" + quantity + '}';
    }

    public events(String name, String location, String description, Date start, Date end, int prix, int quantity) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.start = start;
        this.end = end;
        this.prix = prix;
        this.quantity = quantity;
    }

  
    

    public events(int id, int theme, int id_user, String name, String location, String description, Date start, String  image, Date end, int prix, int quantity) {
        this.id = id;
        this.theme = theme;
        this.id_user = id_user;
        this.name = name;
        this.location = location;
        this.description = description;
        this.start = start;
        this.image = image;
        this.end = end;
        this.prix = prix;
        this.quantity = quantity;
    }

    public events() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTheme() {
        return theme;
    }

    public void setTheme(int theme) {
        this.theme = theme;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
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

    public void setInterstedsnumber(int Interstednumber) {
        this.Interstednumber = Interstednumber;
    }

    public int getCommenternumber() {
        return commenternumber;
    }

    public void setCommenternumber(int commenternumber) {
        this.commenternumber = commenternumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public String  getImage() {
        return image;
    }

    public void setImage(String  image) {
        this.image = image;
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

    public events(int theme, int id_user, String name, String location, String description, Date  start, String image, Date end, int prix, int quantity) {
        this.theme = theme;
        this.id_user = id_user;
        this.name = name;
        this.location = location;
        this.description = description;
        this.start = start;
        this.image = image;
        this.end = end;
        this.prix = prix;
        this.quantity = quantity;
    }
     public events( int id_user, String name, String location, String description, Date  start, String image, Date end, int prix, int quantity) {
        this.theme = theme;
        this.id_user = id_user;
        this.name = name;
        this.location = location;
        this.description = description;
        this.start = start;
        
        this.image = image;
        this.end = end;
        this.prix = prix;
        this.quantity = quantity;
    }
     public events(  String name, String location, String description, String image,Date  start , Date end, int prix, int quantity) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.start = start;
        this.image = image;
        this.end = end;
        this.prix = prix;
        this.quantity = quantity;
    }

    public void ajouterEvent1(events ee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

  
    
    
    
    

}
