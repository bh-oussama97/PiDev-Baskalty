/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Cyrine
 */
public class AdminController implements Initializable {

 
    
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    



   
    @FXML
    private void users(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/com/pidev/views/AdminUsers.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show(); 
    
    
    }

 @FXML
    private void contact(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/com/pidev/views/Contact.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show(); 
    
    
    } 
    @FXML
    private void mouselogout(MouseEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/com/pidev/views/LoginMain.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show(); 
    
    
    }  
 
    @FXML
    private void modiferuser(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/com/pidev/views/ModifierUser.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show(); 
    
    
    }
}
    

