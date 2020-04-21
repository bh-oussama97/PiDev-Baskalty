/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Entite.categorie;
import Entite.produit;
import Service.ServiceCategorie;
import Service.ServiceProduit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import org.apache.commons.lang.RandomStringUtils;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author benha
 */


public class ModifierProduitController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    produit p = new produit();
    @FXML
    private TextField nom;
    @FXML
    private TextField reference;
    @FXML
    private TextArea description;
    @FXML
    private TextField prix;
    @FXML
    private ComboBox<String> categorie;
    @FXML
    private ImageView imageV;
    @FXML
    private TextField quantite;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnimage;
     List<categorie> liste = new ArrayList<>();
    @FXML
    private AnchorPane ModifierAnchor;
    
  //  produit pmodification = new produit();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ServiceCategorie sc = new ServiceCategorie();
        liste = sc.afficher();
     liste.forEach((l) -> {
              categorie.getItems().add(l.getNom());
        });
     
     ServiceProduit rs = new ServiceProduit();
        produit ps = rs.afficherParId(produit.getId_pModifier());
        p = ps;
        categorie.setValue(ps.getCategorie());
        nom.setText(ps.getNom());
        reference.setText(ps.getReference());
        description.setText(ps.getDescription());
        prix.setText(Float.toString(ps.getPrix()));
        quantite.setText(Integer.toString(ps.getQuantite()));   
        try {
            afficherImage(ps.getImage(), imageV);
        } catch (IOException ex) {
            Logger.getLogger(ModifierProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
      
    
     
    }    
    
    public void afficherImage (String path,ImageView img) throws FileNotFoundException, IOException
        {
             
             FileInputStream input = new FileInputStream("src/Images/"+path);
             Image imageFile = new Image(input);
            img.setImage(imageFile);
            input.close();
        
        }
    
     public void initData(int idProduit) {
        p.setId(idProduit);
        //System.out.println("id produit elli wsel :" + this.idProduit);
    }
 public static String saveToFileImageNormal(Image image) throws SQLException, IOException {

        String ext = "jpg";
        File dir = new File("src/Images");
        String name = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(8), ext);
        File outputFile = new File(dir, name);
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        ImageIO.write(bImage, "png", outputFile);
        return name;
    }
    @FXML
    private void ModifierProduit(ActionEvent event) throws SQLException, IOException {
          if ((nom.getText().trim().equals("")) || (reference.getText().trim().equals(""))
                || (description.getText().trim().equals("")) || (categorie.getValue().isEmpty())
                || (prix.getText().trim().equals("")) || (quantite.getText().trim().equals(""))) {
            Alert fail = new Alert(Alert.AlertType.ERROR);
          
            fail.setHeaderText("Champ(s) Manquant(s)");
            fail.setContentText("Vous avez oublier de remplir un ou plusieurs champs !");
            fail.showAndWait();
        }
          else {
              
               ServiceProduit as = new ServiceProduit();

                if ((Integer.parseInt(quantite.getText()) < 0) || Float.parseFloat(prix.getText()) < 0) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "la quantité doit être un entier positif et le Prix doit être un float positif !", ButtonType.CLOSE);
                    alert.show();
                } else {
                          Image img = imageV.getImage();
            String nameImage1 = saveToFileImageNormal(img);
            produit pmodif = new produit(p.getId(),Integer.parseInt(quantite.getText()), nom.getText(), reference.getText(),Float.parseFloat(prix.getText()), description.getText(), nameImage1, LocalDateTime.now(),categorie.getValue());
                as.modifier(pmodif);
                
               // pmodification=pmodif;
      
                TrayNotification tray = new TrayNotification("Notification !", "Produit modifié avec succés!", NotificationType.SUCCESS);
                tray.showAndDismiss(Duration.seconds(3));
                
                  FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/com/pidev/views/DetailsProduitsVendeur.fxml"));
            
            Parent  par = Loader.load();
            
            
            DetailsProduitsVendeurController cont = Loader.getController();
           
            cont.setproduit(pmodif);
            cont.SetItemsDetails();
            
           
            
              AnchorPane pane = (AnchorPane) ModifierAnchor.getParent();
            pane.getChildren().clear();
            pane.getChildren().setAll(par);
         
             
                }
          }
 
    }

    @FXML
    private void addImage(MouseEvent event) {
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

    @FXML
    private void RetourVersDetails(MouseEvent event) throws IOException {
        // AccueilVendeurController.getinstance().CreatePage(ModifierAnchor,"/com/pidev/views/DetailsProduitsVendeur.fxml");
         
          FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/com/pidev/views/DetailsProduitsVendeur.fxml"));
            
            Parent  par = Loader.load();
            
            
            DetailsProduitsVendeurController cont = Loader.getController();
           
            cont.setproduit(p);
            cont.SetItemsDetails();
            
           
            
              AnchorPane pane = (AnchorPane) ModifierAnchor.getParent();
            pane.getChildren().clear();
            pane.getChildren().setAll(par);
         
         
    }
}
