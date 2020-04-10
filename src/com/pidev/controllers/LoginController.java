/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.controllers;
import com.esprit.Core.Controller;
import com.pidev.models.Personne;
import com.pidev.services.LoginService;
import com.pidev.services.ServicePersonne;
import com.pidev.utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;
import static org.omg.CORBA.ORB.init;

/**
 * FXML Controller class
 *
 * @author Cyrine
 */
public class LoginController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private Label msg;
    @FXML
    private PasswordField password;
    @FXML
    private CheckBox remember;
    // file will save in it info in default package
    private final String path="src\\LoginData.ini";
    LoginService loginService = new LoginService();
    int x;
    Stage stage= new Stage();
    ServicePersonne ser = new ServicePersonne();
    private Hyperlink forgot_pass;
    Scene scene;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       loginService.readinifile(path,email,password,remember);
    }    

    @FXML
    private void Connecter(ActionEvent event) throws SQLException, IOException {
              
          
        
           if(ser.getUserByuserName(email.getText()).getRoles().equals("a:1:{i:0;s:10:\"ROLE_ADMIN\";}"))
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/pidev/views/Admin.fxml"));   
            Scene scene = new Scene(root);
             Node node =(Node)event.getSource();
                stage = (Stage)node.getScene().getWindow();
                stage.close();
     
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
            return;
        }
       
        
        Connection conn = DataSource.getInstance().getCnx();
        String req= "Select * from fos_user where (username=? or email=?)";
        PreparedStatement prs= conn.prepareStatement(req);
        prs.setString(1, email.getText());
        prs.setString(2, email.getText());
        ResultSet rs = prs.executeQuery();
        if (!rs.next()){
            msg.setText("Username incorrect");
        } 
        
        else {
            if(BCrypt.checkpw(password.getText(),rs.getString("password").substring(0,2)+"a"+rs.getString("password").substring(3)))
            {
       if (!remember.isSelected()){
                String req1= "Select id from fos_user where username=? ";
                PreparedStatement prs1= conn.prepareStatement(req1);
                prs.setString(1, email.getText());
                ResultSet res= prs.executeQuery();
                while (res.next()){
                 x= res.getInt("id");       
                }
                Personne user= new Personne();
                user.setId(x);
                Controller.setUserId(x);
              
                init();
                Node node =(Node)event.getSource();
                stage = (Stage)node.getScene().getWindow();
                stage.close();
                Parent root = FXMLLoader.load(getClass().getResource("/com/pidev/views/PageAccueilProduits.fxml"));   
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                stage.setResizable(false);          

            }
            else {
               
                loginService.createiniFile(path,email.getText(),password.getText());
                System.out.println("success");           
                String req1= "Select id from fos_user where username=? ";
                PreparedStatement prs1= conn.prepareStatement(req1);
                prs.setString(1, email.getText());
                ResultSet res= prs.executeQuery();
                while (res.next()){
                    x= res.getInt("id");
                } 
                Personne user= new Personne();
                Controller.setUserId(x);
            
                init();
                Node node =(Node)event.getSource();
                stage = (Stage)node.getScene().getWindow();
                stage.close();
                
                Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/Interface_Accueil2.fxml"));  
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                stage.setResizable(false);
                
            }
            }
            else
            {
                msg.setText("Mot de passe incorrecte!");
            }
        }   }  
    
        
        
        
        // once u click in register this will happen 
    
     @FXML
    private void Register(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/com/pidev/views/SginUp.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.hide();
                    stage.setScene(scene);
                    stage.show();
        
        
        
        
    }
       
    
}
