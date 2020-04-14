/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.controllers;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class PageAccueilProduitsController implements Initializable {

    @FXML
    private JFXButton magasin;
    @FXML
    private JFXButton btnajouter;
  
    
  
    @FXML
    private AnchorPane holderPane;
    AnchorPane ajouter;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        createPage();
    }   
    
   private void setNode (Node node)
   {
       holderPane.getChildren().clear();
       holderPane.getChildren().add((Node) node);
       FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
   }
	public void createPage() {
		
        try {
            ajouter = FXMLLoader.load(getClass().getResource("../views/AjoutMecanicien.fxml"));
            setNode(ajouter);
        } catch (IOException ex) {
            Logger.getLogger(PageAccueilProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

    @FXML
    private void ListeProduits(ActionEvent event) {
        
          try {
              
            magasin.getScene().getWindow().hide();
            Stage produits = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../views/ListeMecaniciens.fxml"));
            Scene scene = new Scene(root);
            produits.setScene(scene);
            produits.show();
            produits.setResizable(false);

        } catch (Exception e) {
            System.out.println(" Error  : " + e);
        }
    }

    @FXML
    private void ajouterProduit(ActionEvent event) {
         try {
            ajouter = FXMLLoader.load(getClass().getResource("../views/AjoutMecanicien.fxml"));
            setNode(ajouter);
        } catch (IOException ex) {
            Logger.getLogger(PageAccueilProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    }
    

