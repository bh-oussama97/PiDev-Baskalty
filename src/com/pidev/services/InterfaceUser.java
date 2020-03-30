/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.services;

import com.pidev.models.fos_user;
import java.util.List;

/**
 *
 * @author WSI
 */
public interface InterfaceUser {
    public void AjouterUser(fos_user u);
    public void ModiferUser(int id,fos_user u);
    public void SupprimerUser(int id);
    public Boolean Login(String username,String password);
    public fos_user AfficherUser(String username);
    public List<fos_user> getAllUser();
    public boolean verifAdmin(String username);
     
}
