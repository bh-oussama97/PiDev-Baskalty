/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.controllers;

import com.jfoenix.controls.JFXButton;
import Utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;
import Entite.fos_user;
import Service.LoginService;

/**
 *
 * @author WSI
 */
public class ModifierUserController implements Initializable {
    
    ObservableList<String> ChoiceBoxlist = FXCollections.
            observableArrayList("Internaute","Vendeur","Locateur", "Mécanicien","Association");

    @FXML
    private TextField username;
 
    @FXML
    private PasswordField pass;
    @FXML
    private ChoiceBox ChoiceBox;
    
    private JFXButton btnRetour;
    
      private static fos_user sujet_modifié = new fos_user();
    public static LoginService sujetService = new LoginService();

    public static fos_user getSujet_modifié() {
        return sujet_modifié;
    }

    public static void setSujet_modifié(fos_user sujet_modifié) {
        ModifierUserController.sujet_modifié = sujet_modifié;
    }
    @FXML
    private JFXButton retour;
     

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       // TODO
        ChoiceBox.setItems(ChoiceBoxlist);
        username.setStyle("-fx-text-inner-color: #D7D7D7;");
        pass.setStyle("-fx-text-inner-color: #D7D7D7;");
          username.setText(ModifierUserController.getSujet_modifié().getUsername());
                  pass.setText(ModifierUserController.getSujet_modifié().getPassword());

      
    }
   /* private void handleMouseEvenet(MouseEvent event) throws IOException{
        if (event.getSource() == btnRetour){
             Parent root = FXMLLoader.load(getClass().getResource("/com/pidev/views/Admin.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show(); 
        }
                
    }*/

    @FXML
   
    private void register(ActionEvent event) throws SQLException, IOException {
         
        ModifierUserController.getSujet_modifié().setUsername(username.getText());
        
        ModifierUserController.getSujet_modifié().setPassword(pass.getText());
        
        ModifierUserController.getSujet_modifié().setRoles((String) ChoiceBox.getValue());
           if(ChoiceBox.getValue().equals("Association")){
        ModifierUserController.getSujet_modifié().setEnabled(5);}
        if(ChoiceBox.getValue().equals("Mécanicien")){
        ModifierUserController.getSujet_modifié().setEnabled(4);}
        if(ChoiceBox.getValue().equals("Vendeur")){
        ModifierUserController.getSujet_modifié().setEnabled(3);}
        if(ChoiceBox.getValue().equals("Locateur")){
        ModifierUserController.getSujet_modifié().setEnabled(2);
        }
          if(ChoiceBox.getValue().equals("Internaute")){
        ModifierUserController.getSujet_modifié().setEnabled(1);
        }
           
        sujetService.ModiferUser( ModifierUserController.getSujet_modifié());

          }
          
   
    
        @FXML
     private void retour(ActionEvent event) throws IOException {
        retour.getScene().getWindow().hide();
            Stage produits = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/com/pidev/views/AccueilUser.fxml"));
            Scene scene = new Scene(root);
            produits.setScene(scene);
            produits.show();
            produits.setResizable(false);
        
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
    
    
    
}
   