/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class PageAccueilProduitsrentController implements Initializable {

    public AnchorPane holderPane2;
//    public ListView listView;
    @FXML
    private JFXButton magasin;
    @FXML
    private JFXButton btnajouter;
  
    
  
    @FXML
    private AnchorPane holderPane;
    AnchorPane ajouter;
    private JFXButton retour;
    @FXML
    private ImageView logout;
    @FXML
    private ImageView user;
    @FXML
    private Label bienvenue;
    @FXML
    private AnchorPane middle;
    @FXML
    private JFXButton contactus;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          try {
            CreatePage(middle,"/com/pidev/views/Produitsrent.fxml");
        } catch (IOException ex) {
            Logger.getLogger(AccueilVendeurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
   private void setNode (Node node)
   {
       FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
   }
	 public void CreatePage(AnchorPane anchpane,String Location) throws IOException {
		
   
           AnchorPane Loader = FXMLLoader.load(getClass().getResource(Location));
           Node node = (Node) Loader;
           anchpane.getChildren().clear();
           anchpane.getChildren().add((Node) Loader);

	}
    @FXML
    private void ListeProduits(ActionEvent event) {
     
        try {
            AnchorPane shop = FXMLLoader.load(getClass().getResource("/com/pidev/views/Produitsrent.fxml"));
            Node node = (Node) shop;
            middle.getChildren().clear();
            middle.getChildren().add((Node) node);
            setNode(middle);
        } catch (IOException ex) {
            Logger.getLogger(PageAccueilProduitsrentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ajouterProduit(ActionEvent event) {
         try {
            AnchorPane add = FXMLLoader.load(getClass().getResource("/com/pidev/views/RentProduct.fxml"));
            Node node = (Node) add;
            middle.getChildren().clear();
            middle.getChildren().add((Node) node);
            setNode(middle);
        } catch (IOException ex) {
            Logger.getLogger(PageAccueilProduitsrentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
    private void modiferuser(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/pidev/views/ModifierUser.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show(); 
    
    }

    private void retour(ActionEvent event)  throws IOException {
          retour.getScene().getWindow().hide();
            Stage produits = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/com/pidev/views/AccueilUser.fxml"));
            Scene scene = new Scene(root);
            produits.setScene(scene);
            produits.show();
            produits.setResizable(false);
    }

    @FXML
    private void rateProducts(ActionEvent event) throws IOException {
        
          AnchorPane rate = FXMLLoader.load(getClass().getResource("/com/pidev/views/ProductsRate.fxml"));
            Node node = (Node) rate;
            middle.getChildren().clear();
            middle.getChildren().add((Node) node);
            setNode(middle);
    }

    @FXML
    private void contactus(ActionEvent event) throws IOException {
          AnchorPane rate = FXMLLoader.load(getClass().getResource("/com/pidev/views/Contact.fxml"));
            Node node = (Node) rate;
            middle.getChildren().clear();
            middle.getChildren().add((Node) node);
            setNode(middle);
    }

    }
    

