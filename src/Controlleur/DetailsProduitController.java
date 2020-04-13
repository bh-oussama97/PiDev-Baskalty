/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import com.jfoenix.controls.JFXButton;
import Entite.produit;
import Service.ServiceProduit;
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

/**
 * FXML Controller class
 *
 * @author benha
 */
public class DetailsProduitController implements Initializable {

    @FXML
    private AnchorPane details;
    @FXML
    private ImageView photo;
    @FXML
    private Text descriptionD;
    @FXML
    private Label categorieD;
    @FXML
    private Label nomD;
    @FXML
    private Label quantiteD;
    @FXML
    private Label prixD;
    @FXML
    private Label idp1;
    @FXML
    private Label referenceD;
    produit pdetails = new produit();
    @FXML
    private JFXButton btnRMagasin;
    @FXML
    private JFXButton commander;
      public void setproduit(produit p) {
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
      
        ServiceProduit sp =new ServiceProduit();
        idp1.setText(Integer.toString(pdetails.getId()));
        nomD.setText(pdetails.getNom());
        categorieD.setText(pdetails.getCategorie());
        quantiteD.setText(Integer.toString(pdetails.getQuantite()));
        prixD.setText(Float.toString(pdetails.getPrix()));
        descriptionD.setText(pdetails.getDescription());
        referenceD.setText(pdetails.getReference());
         putImageViewer(pdetails.getImage());
     
    }
     
     public void putImageViewer(String path){
            FileInputStream input = null;
      
        try {
            input = new FileInputStream("src/images/"+path);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
            Image imageFile = new Image(input);
            photo.setImage(imageFile);
           
            
        try {
            input.close();
        } catch (IOException ex) {
            Logger.getLogger(ProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        } 



    @FXML
    private void RetourAumagasin(ActionEvent event) {
        
          try {
              
            btnRMagasin.getScene().getWindow().hide();
            Stage produits = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/com/pidev/views/Produits.fxml"));
            Scene scene = new Scene(root);
            produits.setScene(scene);
            produits.show();
            produits.setResizable(false);

        } catch (Exception e) {
            System.out.println(" Error  : " + e);
        }
    }

    @FXML
    private void ModifierProduit (ActionEvent event)
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
    private void supprimerProduit(ActionEvent event) {
    }

    @FXML
    private void CommanderProduit(ActionEvent event) {
    }
    
}
