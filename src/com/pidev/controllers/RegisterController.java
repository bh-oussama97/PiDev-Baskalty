/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.controllers;

import com.pidev.models.fos_user;
import com.pidev.utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;

/**
 * FXML Controller class
 *
 * @author Cyrine
 */
public class RegisterController implements Initializable {
    
    ObservableList<String> ChoiceBoxlist = FXCollections.
            observableArrayList("Internaute","Vendeur","Locateur", "Mécanicien","Association");

    @FXML
    private TextField username;
 
    @FXML
    private TextField email;
    @FXML
    private PasswordField pass;
    
    @FXML
    private ChoiceBox ChoiceBox;
   
  
   

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ChoiceBox.setItems(ChoiceBoxlist);
        ChoiceBox.setValue("mm");
        username.setStyle("-fx-text-inner-color: #D7D7D7;");
        email.setStyle("-fx-text-inner-color: #D7D7D7;");
        pass.setStyle("-fx-text-inner-color: #D7D7D7;");
    }   
   
   

    @FXML
   
    private void register(ActionEvent event) throws SQLException, IOException {
        Connection conn = DataSource.getInstance().getCnx(); 
         String tnom = username.getText();
            String temail = email.getText();
            String tpass = pass.getText(); 
            boolean valid=true;
            
             if (tnom.equals(""))
        {
             Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setContentText("nom vide!!");
        alert.showAndWait();
           valid = false; 
        }
              if (temail.equals(""))
        {
             Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setContentText("email vide!!");
        alert.showAndWait();
           valid = false; 
        }
               if (tpass.equals(""))
        {
             Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setContentText("pass vide!!");
        alert.showAndWait();
           valid = false; 
        }
                else {
                  fos_user fu = new fos_user(tnom,tpass,temail);
        String req= "INSERT INTO fos_user (username,email,password,phone,roles) VALUES (?,?,?,'0000','a:0:{}')";
        String req1= "SELECT * FROM fos_user WHERE email=?";
        PreparedStatement prs= conn.prepareStatement(req);
        PreparedStatement prs1= conn.prepareStatement(req1);
        prs.setString(1, username.getText());
        prs.setString(2, email.getText());
        String pwd = BCrypt.hashpw(pass.getText(),BCrypt.gensalt(13));
        prs.setString(3, pwd.substring(0,2)+"y"+pwd.substring(3));
               
      
                   prs.executeUpdate();
                   // it should be redirected to accuiel page not admin !eyy 9a3da n5amem ? ki t5amem ta3ml kifi ? 
              Parent root = FXMLLoader.load(getClass().getResource("/com/pidev/views/AcceuilUser.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.hide();
            stage.setScene(scene);
            stage.show();
          }}
          
          
              
    
    
     @FXML
     private void retour(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/interface_connexion1.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show(); 
    
        
    }

    @FXML
    private void resetAll(ActionEvent event) throws IOException {
     Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/interface_register.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show(); 
    
    }
    @FXML
    private void login(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/com/pidev/views/LoginMain.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show(); 
    
    
    }
}
