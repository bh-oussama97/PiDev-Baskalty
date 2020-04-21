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
import Service.ServiceCategorie;
import Service.ServiceProduit;
//import static java.awt.SystemColor.window;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Service.ServiceMaintenance;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class AjoutMecanicienController implements Initializable {

    
    @FXML
    private TextField nom;
    @FXML
    private TextArea description;
    @FXML
    private TextField prix;
    @FXML
    private ImageView imageV;
   // List<categorie> liste = new ArrayList<>();
   /* public ComboBox<String> role;
    
    ObservableList<String> liste = FXCollections.observableArrayList("alegaeg","zjekngz");*/
    @FXML
    private AnchorPane ajout;
    @FXML
    private Button btnajouter;
    @FXML
    private ComboBox<String> categorie;
    ObservableList<String> liste_categorie = FXCollections.observableArrayList("3ajeel","elctricien");
    @FXML
    private TextField Mail;
    @FXML
    private TextField prenom;
    @FXML
    private TextField num_tel;
    @FXML
    private CheckBox box_oui;
    private CheckBox box_non;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      categorie.setItems(liste_categorie);
        
        
       // role.setItems(liste);
  }
    
       public static String saveToFileImageNormal(Image image) throws SQLException, IOException {

        String ext = "jpg";
        File dir = new File("C:/Users/benha/OneDrive/Documents/NetBeansProjects/PiDev-Baskalty-Yahya/src/Images");
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
        alert.setContentText("Mecanicien ajouté  avec succés");

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
    private void ajouterMecanicien(ActionEvent event) throws SQLException {
        try {
            
            String tfcategorie = categorie.getValue();
            String tfnom = nom.getText();
            String tfMail = Mail.getText();
            String tfnum_tel = num_tel.getText();
            String tfdescription = description.getText();
           String tfprenom = prenom.getText();
           // String tfreference = reference.getText();
            String tprix = prix.getText();
           // String tquantite = quantite.getText();
           String adomicile ;
            Image img = imageV.getImage();
            String nameImage1 = saveToFileImageNormal(img);
            if (box_oui.isSelected()){
               adomicile = box_oui.getText();
            }else {
                        adomicile = box_non.getText();
                        }
           
            
             boolean valid = true;
           if ( tprix.equals(""))
           {
                prix.setText("prix vide !");
                 prix.setStyle("-fx-text-inner-color: red;-fx-font-weight: bold;");
                prix.setVisible(true);
                valid = false; 
           }
           if (Mail.equals(""))
           {
              Mail.setText("quantité vide !");
               Mail.setStyle("-fx-text-inner-color: red;-fx-font-weight: bold;");
                Mail.setVisible(true);
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
         if (tfMail.equals(""))
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
            
            prix.clear();
            
        }
        else {
           
            float tfprix = Float.parseFloat(tprix);
            int tfnum_tell = Integer.parseInt(tfnum_tel);
            mecanicien m = new mecanicien(tfcategorie, tfnom, tfprenom, tfMail,nameImage1, tfprix, tfnum_tell, tfdescription, adomicile);
                
           // produit pro = new produit(q, LocalDateTime.now(), n, r, p, d, nameImage1, LocalDateTime.now());
           // pro.setImage(nameImage1);
            ServiceMaintenance sm = new ServiceMaintenance();

            sm.ajouter(m);
            succesAjout();
            
            nom.clear();
           
            prix.clear();
            description.clear();
            imageV.setImage(null);
           
        }
        }
        catch (IOException ex) {
            Logger.getLogger(AjoutMecanicienController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
   

    

}
