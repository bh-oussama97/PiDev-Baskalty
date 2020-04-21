/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Entite.produit;
import Service.ServiceProduit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class DetailsProduitsVendeurController implements Initializable {

    @FXML
    private ImageView image;
    @FXML
    private Label nom;
    @FXML
    private Label reference;
    @FXML
    private Label categorie;
    @FXML
    private Label quantite;
    @FXML
    private Label prix;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
    @FXML
    private Label description;
    produit pdetails = new produit();
    @FXML
    private AnchorPane detailsAnchor;
      public void setproduit(produit p) {
        this.pdetails = p;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
      
    }    
    
     public void afficherImage (String path,ImageView img) throws FileNotFoundException, IOException
        {
             
             FileInputStream input = new FileInputStream("src/Images/"+path);
             Image imageFile = new Image(input);
            img.setImage(imageFile);
            input.close();
        
        }
     
     public void SetItemsDetails()
     {
           nom.setText(pdetails.getNom());
        reference.setText(pdetails.getReference());
        categorie.setText(pdetails.getCategorie());
        quantite.setText(Integer.toString(pdetails.getQuantite()));
        prix.setText(pdetails.getPrix()+"DT");
        description.setText(pdetails.getDescription());
        try {
            afficherImage(pdetails.getImage(), image);
        } catch (IOException ex) {
            Logger.getLogger(DetailsProduitsVendeurController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
     }
     
    
    
   @FXML
    private void Modifier(ActionEvent event) throws IOException {
        
            produit.setId_pModifier(pdetails.getId());
      
      FXMLLoader modifier = new FXMLLoader();
            // FXMLLoader modifier = new FXMLLoader(getClass().getResource(("/com/pidev/views/ModifierProduitFXML.fxml")));
               modifier.setLocation(getClass().getResource("/com/pidev/views/ModifierProduit.fxml"));
                
                Parent root =  modifier.load();
                
                ModifierProduitController controller = modifier.getController();
                controller.initData(pdetails.getId());
                
                AnchorPane pane = (AnchorPane) detailsAnchor.getParent();
            pane.getChildren().clear();
            pane.getChildren().setAll(root);
       
     
    }

    @FXML
    private void supprimer(ActionEvent event) throws IOException {
        
          Alert alert = new Alert(AlertType.CONFIRMATION);
          alert.setHeaderText("Êtes vous sûr de supprimer ce produit ?");
          alert.setContentText("Produit numéro :" +pdetails.getId());
             Optional<ButtonType> option = alert.showAndWait();
             
             if (option.get() == ButtonType.OK)
             {
                   ServiceProduit sp = new ServiceProduit();
        System.out.println("*********************\n" + pdetails.getId() + "\n**************");
        sp.supprimer(pdetails.getId());
        
        TrayNotification tray = new TrayNotification("Notification !", "Produit Supprimé !", NotificationType.SUCCESS);
                tray.showAndDismiss(Duration.seconds(3));
                AccueilVendeurController.getinstance().CreatePage(detailsAnchor,"/com/pidev/views/GererProduitsVendeur.fxml");
             }
             else if (option.get() == ButtonType.CANCEL)
             {
                 alert.hide();
             }
    }

    @FXML
    private void retourVersProduitsVendeur(MouseEvent event) throws IOException {
        
        AccueilVendeurController.getinstance().CreatePage(detailsAnchor,"/com/pidev/views/GererProduitsVendeur.fxml");
    }
    
}
