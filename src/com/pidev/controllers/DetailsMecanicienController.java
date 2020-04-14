/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.controllers;

import com.jfoenix.controls.JFXButton;
import com.pidev.models.mecanicien;
import com.pidev.models.produit;
import com.pidev.services.ServiceProduit;
import static java.awt.SystemColor.window;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import com.pidev.services.ServiceMaintenance;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class DetailsMecanicienController implements Initializable {

    @FXML
    private AnchorPane details;
    @FXML
    private ImageView photo;
    private Text descriptionD;
    private Label categorieD;
    private Label nomD;
    private Label quantiteD;
    private Label prixD;
    private Label idp1;
    private Label referenceD;
    mecanicien pdetails = new mecanicien();
    @FXML
    private JFXButton btnRMagasin;
    @FXML
    private Text descriptionDt1;
    @FXML
    private Label MailDt1;
    @FXML
    private Label prenomDt1;
    @FXML
    private Label adomicileDt1;
    @FXML
    private Label prixDt1;
    @FXML
    private Label servicesDt1;
    @FXML
    private JFXButton contacteDt1;
    @FXML
    private Label nomD1;
    @FXML
    private Label num_telDt11;
      public void setmecanicien(mecanicien p) {
        this.pdetails = p;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
     public void init() {
      
        //ServiceProduit sp =new ServiceProduit();
       ServiceMaintenance sp = new ServiceMaintenance();
        servicesDt1.setText(pdetails.getService());
        nomD1.setText(pdetails.getNom());
      prenomDt1.setText(pdetails.getPrenom());
      MailDt1.setText(pdetails.getMail());
        num_telDt11.setText(Integer.toString(pdetails.getNum_tel()));
        prixDt1.setText(Float.toString(pdetails.getPrix()));
        descriptionDt1.setText(pdetails.getDescription());
        adomicileDt1.setText(pdetails.getAdomicile());
         putImageViewer(pdetails.getImage());
     
    }
     
     public void putImageViewer(String path){
            FileInputStream input = null;
      
        try {
            input = new FileInputStream("src/images/"+path);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MecanicienController.class.getName()).log(Level.SEVERE, null, ex);
        }
            Image imageFile = new Image(input);
            photo.setImage(imageFile);
           
            
        try {
            input.close();
        } catch (IOException ex) {
            Logger.getLogger(MecanicienController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        } 



    @FXML
    private void RetourAumagasin(ActionEvent event) {
        
          try {
              
            btnRMagasin.getScene().getWindow().hide();
            Stage produits = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../views/Produits.fxml"));
            Scene scene = new Scene(root);
            produits.setScene(scene);
            produits.show();
            produits.setResizable(false);

        } catch (Exception e) {
            System.out.println(" Error  : " + e);
        }
    }

    @FXML
    private void CommanderProduit (ActionEvent event)
    {
        
    }
   
   /* private void ModifierProduit(ActionEvent event) {
        
         Produit.setId_pModifier(p.getIdProduit());
        System.out.println("wsel lahné");
        sendidproduit();
             FXMLLoader loader = new FXMLLoader(getClass().getResource(("UpdateProduitFXML.fxml")));

        loader.load();
        AnchorPane parentContent = loader.getRoot();
        window = (AnchorPane) photo.getParent().getParent();
        UpdateProduitFXMLController cont = loader.getController();

        window.getChildren().setAll(parentContent);

    }*/

    @FXML
    private void ModifierProduit(ActionEvent event) {
    }

    @FXML
    private void supprimerProduit(ActionEvent event) {
    }
    
}
