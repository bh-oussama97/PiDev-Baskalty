/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.controllers;

import com.jfoenix.controls.JFXDatePicker;
import Entite.fos_user;
import Utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
            //observableArrayList("Internaute","Vendeur","Locateur", "Mécanicien","Association");
observableArrayList("Internaute");
    @FXML
    private TextField username;
 
    @FXML
    private TextField email;
    @FXML
    private PasswordField pass;
    
    @FXML
    private ChoiceBox ChoiceBox;
    
    private JFXDatePicker last_login;
   
  
   

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ChoiceBox.setItems(ChoiceBoxlist);
        username.setStyle("-fx-text-inner-color: #D7D7D7;");
        email.setStyle("-fx-text-inner-color: #D7D7D7;");
        pass.setStyle("-fx-text-inner-color: #D7D7D7;");
    }   
   
   

    @FXML
   
    private void register(ActionEvent event) throws SQLException, IOException {
        Connection conn = DataSource.getInstance().getConnection(); 
         String tnom = username.getText();
            String temail = email.getText();
            String tpass = pass.getText(); 
            Object trole = ChoiceBox.getValue();
            boolean valid=true;
            
             if (tnom.equals(""))
        {
             Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setContentText("nom vide!!");
        alert.showAndWait();
           valid = false; 
        }
        
               if (tpass.equals("") )
        {
             Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setContentText("Pass vide!!");
        alert.showAndWait();
           valid = false; 
        }
                      if (tpass.length() < 6 )
        {
             Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setContentText("Pass too short");
        alert.showAndWait();
           valid = false; 
        }
                     if (validateEmaill() == false)
        {
             Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setContentText("Email Not Valide!!");
        alert.showAndWait();
           valid = false; 
        }
                else {
                  fos_user fu = new fos_user(tnom,tpass,temail);
        String req= "INSERT INTO fos_user (username,email,password,roles ) VALUES (?,?,?,?)";
        String req1= "SELECT * FROM fos_user WHERE email=?";
        PreparedStatement prs= conn.prepareStatement(req);
        PreparedStatement prs1= conn.prepareStatement(req1);
        prs.setString(1, username.getText());
        prs.setString(2, email.getText());

        String pwd = BCrypt.hashpw(pass.getText(),BCrypt.gensalt(13));
        prs.setString(3, pwd.substring(0,2)+"y"+pwd.substring(3));
        prs.setString(4, (String) ChoiceBox.getValue());
         //last_login.setValue(LocalDate.now());
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
    
    //validate email Advanced Function
    
    private boolean validateEmaill(){
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p.matcher(email.getText());
        if(m.find() && m.group().equals(email.getText())){
            return true;
        }else{
            
            return false;            
        }
    }
}
