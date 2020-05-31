    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.panier;
import com.jfoenix.controls.JFXButton;
import Entite.produit;
import Service.ServiceCategorie;
import Service.ServicePanier;
import Service.ServiceProduit;
import static java.awt.SystemColor.window;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
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
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class DetailsProduitController implements Initializable {

    @FXML
    private ImageView photo;
    @FXML
    private Label descriptionD;
    @FXML
    private Label categorieD;
    @FXML
    private Label nomD;
    @FXML
    private Spinner<Integer> quantiteD;
    @FXML
    private Label prixD;
    private Label idp1;
    @FXML
    private Label referenceD;
    produit pdetails = new produit();
    @FXML
    private JFXButton btnRMagasin;
    
    
    private static DetailsProduitController instance;
    @FXML
    private AnchorPane details;
    
    public DetailsProduitController()
    {
       instance = this ;
    }
    
    public static DetailsProduitController getInstance()
    {
        return instance;
    }
    
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
    
    
     public void init() throws SQLException {
      
        ServiceProduit sp =new ServiceProduit();
        ServiceCategorie sc = new ServiceCategorie();
//        idp1.setText(Integer.toString(pdetails.getId()));
        nomD.setText(pdetails.getNom());
        categorieD.setText(sc.getCategorieNameById(pdetails.getCategorie()));
      
      
        prixD.setText(Integer.toString(pdetails.getPrix()));
        descriptionD.setText(pdetails.getDescription());
        referenceD.setText(pdetails.getReference());
         putImageViewer(pdetails.getImage());
         
         quantiteD.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, pdetails.getQuantite()));
     
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
    private void RetourAumagasin(ActionEvent event) throws IOException {
      
    btnRMagasin.getScene().getWindow().hide();
            Stage produits = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/com/pidev/views/PageAccueilProduits.fxml"));
            Scene scene = new Scene(root,810,585);
            produits.setScene(scene);
            produits.show();
            produits.setResizable(true);
    }

    
    @FXML
    private void addToCart(ActionEvent event) throws IOException {
        
        ServicePanier sp = new ServicePanier();
        
        if (quantiteD.getValue() == 0 )
        {
             TrayNotification tray = new TrayNotification("Warning !", "Stock empty!", NotificationType.WARNING);
                tray.showAndDismiss(Duration.seconds(3));
        }
        else
        {
            int quantiteRestante = pdetails.getQuantite() - quantiteD.getValue();
            
           sp.ajouter(new panier(pdetails.getId_user(),pdetails.getId(),quantiteD.getValue(),pdetails.getPrix(),LocalDateTime.now()));
           ServiceProduit sprod = new ServiceProduit();
             sprod.updateProductByQuantityAdded(quantiteRestante,pdetails.getId());
             TrayNotification tray = new TrayNotification("Success !", "Product added to cart ", NotificationType.SUCCESS);
             tray.showAndDismiss(Duration.seconds(3));
             
          //  AccueilVendeurController.getinstance().CreatePage(details,"/com/pidev/views/PanierInternaute.fxml");
                AnchorPane contacteznous = FXMLLoader.load(getClass().getResource("/com/pidev/views/PanierInternaute.fxml"));
           Node node = (Node) contacteznous;
           details.getChildren().clear();
           details.getChildren().add((Node) contacteznous);
           FadeTransition ft = new FadeTransition(Duration.millis(1500));
           ft.setNode(contacteznous);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
        }
    }
    
    

  

}
