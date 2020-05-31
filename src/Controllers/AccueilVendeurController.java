/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
import Controllers.LoginController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class AccueilVendeurController implements Initializable {

    @FXML
    private AnchorPane holderPane;
    @FXML
    private JFXButton mesProduits;
    @FXML
    private JFXButton btnajouter;
    @FXML
    private JFXButton gererMesProduits;
    @FXML
    private JFXButton contacteznous;
    @FXML
    private ImageView logout;
    @FXML
    private ImageView user;
    
    private static AccueilVendeurController instance;
    @FXML
    private Label bienvenue;
    
    public AccueilVendeurController()
    {
        instance = this;
    }
    
    public static AccueilVendeurController getinstance()
    {
        return instance;
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            CreatePage(holderPane,"/com/pidev/views/ProduitsVendeur.fxml");
        } catch (IOException ex) {
            Logger.getLogger(AccueilVendeurController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (LoginController.getInstance() == null)
        {
            this.bienvenue.setText("Welcome,username");
        }
        else 
        {
            setUsername(LoginController.getInstance().username());   
        }
     
        
    }    
    
      public void setUsername (String user)
    {
       this.bienvenue.setText("Welcome,"+user);
    }
    
    
    public void CreatePage(AnchorPane anchpane,String Location) throws IOException {
		
   
           AnchorPane Loader = FXMLLoader.load(getClass().getResource(Location));
           Node node = (Node) Loader;
           anchpane.getChildren().clear();
           anchpane.getChildren().add((Node) Loader);

	}
    
    @FXML
    private void MesProduits(ActionEvent event) throws IOException {
        AnchorPane Mesproduits = FXMLLoader.load(getClass().getResource("/com/pidev/views/ProduitsVendeur.fxml"));
           Node node = (Node) Mesproduits;
           holderPane.getChildren().clear();
           holderPane.getChildren().add((Node) Mesproduits);
           FadeTransition ft = new FadeTransition(Duration.millis(1500));
           ft.setNode(Mesproduits);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    @FXML
    private void ajouterProduit(ActionEvent event) throws IOException {
        
         AnchorPane AjouterProduit = FXMLLoader.load(getClass().getResource("/com/pidev/views/AjoutProduit.fxml"));
           Node node = (Node) AjouterProduit;
           holderPane.getChildren().clear();
           holderPane.getChildren().add((Node) AjouterProduit);
           FadeTransition ft = new FadeTransition(Duration.millis(1500));
           ft.setNode(AjouterProduit);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    @FXML
    private void GererProduits(ActionEvent event) throws IOException {
        
          AnchorPane gerermesproduits = FXMLLoader.load(getClass().getResource("/com/pidev/views/GererProduitsVendeur.fxml"));
           Node node = (Node) gerermesproduits;
           holderPane.getChildren().clear();
           holderPane.getChildren().add((Node) gerermesproduits);
           FadeTransition ft = new FadeTransition(Duration.millis(1500));
           ft.setNode(gerermesproduits);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
        
        
    }

    @FXML
    private void contactezNous(ActionEvent event) throws IOException {
           AnchorPane contacteznous = FXMLLoader.load(getClass().getResource("/com/pidev/views/Contact.fxml"));
           Node node = (Node) contacteznous;
           holderPane.getChildren().clear();
           holderPane.getChildren().add((Node) contacteznous);
           FadeTransition ft = new FadeTransition(Duration.millis(1500));
           ft.setNode(contacteznous);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
        
    }

    @FXML
    private void Logout(MouseEvent event) {
         Platform.exit();
    }

    @FXML
    private void ModifierProfile(MouseEvent event) {
    }
    
}
