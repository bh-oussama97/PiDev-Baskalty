/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.models;

/**
 *
 * @author selmi
 */
public class participer {
    private int id;
    private int id_event ;
      private int id_user ;
      private int Number ; 
      private  int confirmation=0 ; 
      private String champsConfirmation="null" ;

    public participer() {
    }

    public participer(int id, int id_event, int id_user, int Number) {
        this.id = id;
        this.id_event = id_event;
        this.id_user = id_user;
        this.Number = Number;
    }

    public participer(int id, int id_event, int id_user) {
        this.id = id;
        this.id_event = id_event;
        this.id_user = id_user;
    }

    public int getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(int confirmation) {
        this.confirmation = confirmation;
    }

    public String getChampsConfirmation() {
        return champsConfirmation;
    }

    public void setChampsConfirmation(String champsConfirmation) {
        this.champsConfirmation = champsConfirmation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    @Override
    public String toString() {
        return "participer{" + "id=" + id + ", id_event=" + id_event + ", id_user=" + id_user + ", Number=" + Number + '}';
    }


   
}
