/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;
import org.apache.commons.lang.RandomStringUtils;
import com.pidev.models.*;
import com.pidev.services.ServiceCategorie;
import com.pidev.services.ServiceProduit;
//import static java.awt.SystemColor.window;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class AjoutProduitController implements Initializable {

    
    @FXML
    private TextField nom;
    @FXML
    private TextField reference;
    @FXML
    private TextArea description;
    @FXML
    private TextField prix;
    @FXML
    private TextField quantite;
    @FXML
    private ImageView imageV;
    List<categorie> liste = new ArrayList<>();
   /* public ComboBox<String> role;
    
    ObservableList<String> liste = FXCollections.observableArrayList("alegaeg","zjekngz");*/
    @FXML
    private AnchorPane ajout;
    @FXML
    private Button btnajouter;
    @FXML
    private ComboBox<String> categorie;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ServiceCategorie sc = new ServiceCategorie();
        liste = sc.afficher();
         //cat.getItems().add("");
        // categorie.getItems().add(null);
          liste.forEach((l) -> {
              categorie.getItems().add(l.getNom());
            //cat.getItems().add(l.getCategorie());
            //adresse.getItems().add(l.getLieu());
        });
        
       // role.setItems(liste);
  }
    
       public static String saveToFileImageNormal(Image image) throws SQLException, IOException {

        String ext = "jpg";
        File dir = new File("C:/Users/benha/OneDrive/Documents/NetBeansProjects/Baskalty/src/images");
        String name = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(8), ext);
        File outputFile = new File(dir, name);
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        ImageIO.write(bImage, "png", outputFile);
        return name;
    }
       
    @FXML
    private void addImage(MouseEvent event) throws IOException
            {
        FileChooser fc = new FileChooser();

        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (.png)", "*.PNG");
        fc.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        File selectedFile = fc.showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(selectedFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imageV.setImage(image);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
 private void succesAjout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(null);
        alert.setHeaderText(null);
        alert.setContentText("Produit ajouté  avec succés");

        alert.showAndWait();
    }
    
private void erreurAjout() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(null);
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tout le formulaire !!");

        alert.showAndWait();
    }

    @FXML
    private void ajouterProduit(ActionEvent event) throws SQLException {
        try {
            
            String tfcategorie = categorie.getValue();
            String tfnom = nom.getText();
            String tfdescription = description.getText();
            String tfreference = reference.getText();
            String tprix = prix.getText();
            String tquantite = quantite.getText();
            Image img = imageV.getImage();
            String nameImage1 = saveToFileImageNormal(img);
            
             boolean valid = true;
           if ( tprix.equals(""))
           {
                prix.setText("prix vide !");
                 prix.setStyle("-fx-text-inner-color: red;-fx-font-weight: bold;");
                prix.setVisible(true);
                valid = false; 
           }
           if (tquantite.equals(""))
           {
              quantite.setText("quantité vide !");
               quantite.setStyle("-fx-text-inner-color: red;-fx-font-weight: bold;");
                quantite.setVisible(true);
           valid = false; 
           }
          
        if (tfdescription.equals("")) {
          Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(null);
        alert.setHeaderText(null);
        alert.setContentText("description vide!!");
        alert.showAndWait();
        
        }
        if (tfnom.equals(""))
        {
             Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setContentText("nom vide!!");
        alert.showAndWait();
           valid = false; 
        }
         if (tfreference.equals(""))
        { Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setContentText("reference vide!!");
        alert.showAndWait();
           valid = false; 
        }
          if ( tfcategorie.equals(""))
        { Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setContentText("catégorie non sélectionnée !");
        alert.showAndWait();
           valid = false; 
        }
           if (nameImage1.equals(""))
        { Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setContentText("Aucune image n'a été sélectionnée!");
        alert.showAndWait();
           valid = false; 
        }
          
           
       if (valid == false)
        {
            erreurAjout();
            quantite.clear();
            prix.clear();
            
        }
        else {
           
            float tfprix = Float.parseFloat(tprix);
            int tfquantite = Integer.parseInt(tquantite);
            produit p = new produit(tfquantite, LocalDateTime.now(), tfnom, tfreference, tfprix, tfdescription, nameImage1, tfcategorie);
                
           // produit pro = new produit(q, LocalDateTime.now(), n, r, p, d, nameImage1, LocalDateTime.now());
           // pro.setImage(nameImage1);
            ServiceProduit spro = new ServiceProduit();

            spro.ajouter(p);
            succesAjout();
            
           /* FXMLLoader loader=new FXMLLoader(getClass().getResource(("../views/Produits.fxml")));
            loader.load();
            AnchorPane parentContent = loader.getRoot();
                AnchorPane window = (AnchorPane) description.getParent().getParent();
            ProduitsController cont=loader.getController();
  
            window.getChildren().setAll(parentContent);*/
      
              //FXMLLoader loader = new FXMLLoader(getClass().getResource("));
       /*   FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/Produits.fxml"));
        
       Parent root = loader.load();
        nom.getScene().setRoot(root);
        
        ProduitsController pc = loader.getController();
        pc.setlabelNom(nom.getText());
        pc.setlabelCategorie(description.getText());
        pc.setlabelreference(reference.getText());
        pc.setlabelPrix(tprix);
        pc.setImageViewer(nameImage1);*/
        }
        }
        catch (IOException ex) {
            Logger.getLogger(AjoutProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
   

    

}
