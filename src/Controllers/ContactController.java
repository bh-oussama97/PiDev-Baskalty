/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.contact;
import Service.ServiceContact;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class ContactController implements Initializable {

    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField sujet;
    @FXML
    private TextField message;
    @FXML
    private Button btnEnvoyer;
    @FXML
    private JFXTextField phonenumber;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    

    @FXML
    private void Envoyer(ActionEvent event) {
        
    if (verifyEmail() && verifFields() && verifPhoneNumber() )
    {
       ServiceContact sc = new ServiceContact();
            
            String tfemail = email.getText();
            String tfnom = nom.getText();
            String tfsujet = sujet.getText();
            String tfmessage = message.getText();
            String tfphonenumber = phonenumber.getText();
            
            sc.ajouterContact(new contact(tfsujet, tfnom, tfemail, tfmessage, LocalDateTime.now(),tfphonenumber));
            
             TrayNotification tray = new TrayNotification("Success !", "Your message has been sent", NotificationType.SUCCESS);
                tray.showAndDismiss(Duration.seconds(3));  
                
                clearAllFields();
    }
   
    }
    
     public void clearAllFields()
     {
         nom.clear();
         sujet.clear();
         message.clear();
         phonenumber.clear();
         email.clear();
     }
    
       private boolean verifPhoneNumber()
    {
        Pattern p = Pattern.compile("[9|5|2][0-9]{7}");
        Matcher m = p.matcher(phonenumber.getText());
        if (m.find() && m.group().equals(phonenumber.getText()))
        {
            return true;
        }
        else
        {
           Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Phone Number");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Valid Phone Number");
            alert.showAndWait();
            phonenumber.clear();
            return false;  
        }
    }
    
    
      private boolean verifyEmail() {
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p.matcher(email.getText());
        if (m.find() && m.group().equals(email.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Email");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Valid Email");
            alert.showAndWait();
            email.clear();
            return false;
        }
    }
      
      private boolean verifFields()
      {
           if (email.getText().trim().equals("") || nom.getText().trim().equals("") || sujet.getText().trim().equals("")
               || message.getText().trim().equals(""))
        {
                Alert fail = new Alert(Alert.AlertType.ERROR);
          
            fail.setHeaderText("Missing Field (s)");
            fail.setContentText("You forgot to fill in one or more fields!");
            fail.showAndWait();
            return false;
        }
          
           else
           {
               return true;
           }
      }
    
}
