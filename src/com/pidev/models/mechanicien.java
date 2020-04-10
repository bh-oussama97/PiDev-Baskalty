/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.models;

/**
 *
 * @author yaya
 */
public class mechanicien {
     private int id;
    private String service;
    private String nom;
    private String prenom;
    private String mail;
    private String image;
    private float prix;
private int num_tel;
    private String description;
    private String experience ;
    private String region ;
    private String city;
    private String adomicile;
    private int userid;
    private String actif;
    
    public mechanicien() {
    }

    @Override
    public String toString() {
        return "mechanicien1{" + "id=" + id + ", service=" + service + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", image=" + image + ", prix=" + prix + ", num_tel=" + num_tel + ", description=" + description + ", experience=" + experience + ", region=" + region + ", city=" + city + ", adomicile=" + adomicile + ", userid=" + userid + ", actif=" + actif + '}';
    }

    public mechanicien(String service, String nom, String prenom, String mail, String image, float prix, int num_tel, String description, String experience, String region, String city, String adomicile, int userid, String actif) {
        this.service = service;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.image = image;
        this.prix = prix;
        this.num_tel = num_tel;
        this.description = description;
        this.experience = experience;
        this.region = region;
        this.city = city;
        this.adomicile = adomicile;
        this.userid = userid;
        this.actif = actif;
    }

    public mechanicien(int id, String service, String nom, String prenom, String mail, String image, float prix, int num_tel, String description, String experience, String region, String city, String adomicile, int userid, String actif) {
        this.id = id;
        this.service = service;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.image = image;
        this.prix = prix;
        this.num_tel = num_tel;
        this.description = description;
        this.experience = experience;
        this.region = region;
        this.city = city;
        this.adomicile = adomicile;
        this.userid = userid;
        this.actif = actif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdomicile() {
        return adomicile;
    }

    public void setAdomicile(String adomicile) {
        this.adomicile = adomicile;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getActif() {
        return actif;
    }

    public void setActif(String actif) {
        this.actif = actif;
    }
    
    
}
