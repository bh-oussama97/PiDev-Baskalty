/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.events;
import Service.EvenementService;
import Test.MainFX;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import javafx.util.Duration;
import javax.imageio.ImageIO;
import org.apache.commons.lang.RandomStringUtils;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AjouterSujetController implements Initializable {

    @FXML
    private JFXTextField f_titre;

    @FXML
    private JFXButton id_add;
    @FXML
    private JFXTextArea id_description;
   // private JFXComboBox<Categorie> id_categorie;

    @FXML
    private AnchorPane id_page_ajout;
    @FXML
    private Label id_verifier_titre;

    @FXML
    private Label id_verifier_description;

    private Label id_verifier_categorie;
    @FXML
    private JFXTextField f_location;
    @FXML
    private JFXTextField f_prix;
    @FXML
    private JFXTextField f_quantity;
    @FXML
    private DatePicker f_dateDeb;
    @FXML
    private DatePicker f_datefin;
   
    @FXML
    private ImageView imagee;
    @FXML
    private Label id_verifier_adresse;
    @FXML
    private Label id_verifier_start;
    @FXML
    private Label id_verifier_end;
    @FXML
    private Label id_verifier_prix;
    @FXML
    private Label id_verifier_quantity;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
      
          

    }

    public static EvenementService sujetService = new EvenementService();

   

    @FXML
    void add(ActionEvent event) throws SQLException, IOException {

        if (((f_titre.getText().isEmpty()) == false)
                &&  ( (f_location.getText().isEmpty()) == false )
                && (id_description.getText().isEmpty() == false)
                && (sujetService.rechercherparNom(f_titre.getText()) == false)) {

            events sujet = new events();
            sujet.setTitre(f_titre.getText());
            sujet.setContenu(id_description.getText());
            Date dd = java.sql.Date.valueOf(f_dateDeb.getValue().toString());
            Date df = java.sql.Date.valueOf(f_datefin.getValue().toString());
            sujet.setEnd((java.sql.Date) df);
            sujet.setStart((java.sql.Date) dd);
            int n = Integer.parseInt(f_prix.getText());
            int q = Integer.parseInt(f_quantity.getText());
            sujet.setPrix(n);
            sujet.setQuantity(q);
            sujet.setLocation(f_location.getText());

            Image img = imagee.getImage();
            String nameImage1 = saveToFileImageNormal(img);
                        sujet.setImage(nameImage1);

            sujet.setId_User(MainFX.user.getId_User());
            sujetService.ajouterEvent(sujet);
            f_titre.clear();
            id_description.clear();
            try {
                AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/fxml/AjoutSujet.fxml"));

                id_page_ajout.getChildren().clear();
                id_page_ajout.getChildren().add(newLoadedPane);

            } catch (IOException ex) {
                Logger.getLogger(AjouterSujetController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Image img1 = new Image("/aa.png");
            Notifications notificationBuilder = Notifications.create()
                    .title("Demande D'ajout")
                    .text("Merci pour attendre la réponse")
                    .graphic(new ImageView(img1))
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_CENTER);

            notificationBuilder.show();
        } else {
            BoxBlur blur = new BoxBlur(3, 3, 3);
            id_page_ajout.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Repetez svp");
            alert.setHeaderText("champs non validés");
            alert.setContentText("Verifiez vos champs svp!!");
            alert.showAndWait();
            id_page_ajout.setEffect(null);
            System.out.println("nest pas possible");
        }
    }


    @FXML
    void verifier_description(KeyEvent event) {
        if (id_description.getText().isEmpty()) {
            id_verifier_description.setText("champ vide!");
            id_verifier_description.setTextFill(Color.RED);
            id_verifier_description.setVisible(true);
        } else {
            id_verifier_description.setText("description remplie!");
            id_verifier_description.setTextFill(Color.GREEN);
            id_verifier_description.setVisible(true);

        }
    }

    @FXML
    void verifier_titre(KeyEvent event) {
        if (sujetService.rechercherparNom(f_titre.getText())) {
            id_verifier_titre.setText("Titre déja utilisé!");
            id_verifier_titre.setTextFill(Color.RED);
            id_verifier_titre.setVisible(true);
        } else if (f_titre.getText().isEmpty()) {
            id_verifier_titre.setText("champ vide!");
            id_verifier_titre.setTextFill(Color.RED);
            id_verifier_titre.setVisible(true);
        } else {
            id_verifier_titre.setText("Titre possible!");
            id_verifier_titre.setTextFill(Color.GREEN);
            id_verifier_titre.setVisible(true);

        }
    }
    public static String saveToFileImageNormal(Image image) throws SQLException, IOException {

        String ext = "jpg";
        File dir = new File("C:/Users/benha/OneDrive/Documents/NetBeansProjects/Baskalty/src/Images");
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
            imagee.setImage(image);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    void verifier_location(KeyEvent event) {
           if (f_location.getText().isEmpty()) {
            id_verifier_adresse.setText("champ vide!");
            id_verifier_adresse.setTextFill(Color.RED);
            id_verifier_adresse.setVisible(true);
        } else {
            id_verifier_adresse.setText("adresse remplie!");
            id_verifier_adresse.setTextFill(Color.GREEN);
            id_verifier_adresse.setVisible(true);

        }
        
        
    }

    @FXML
    void verifier_prix(KeyEvent event) {
       if (f_prix.getText().isEmpty() ) {
            id_verifier_prix.setText("champ vide!");
            id_verifier_prix.setTextFill(Color.RED);
            id_verifier_prix.setVisible(true);
        } else  if(  Integer.parseInt(f_prix.getText())< 0 ){
                     id_verifier_prix.setText("remplir prix");    
                       id_verifier_prix.setTextFill(Color.RED);
            id_verifier_prix.setVisible(true);
                }else {
            id_verifier_prix.setText(" prix  remplie!");
            id_verifier_prix.setTextFill(Color.GREEN);
            id_verifier_prix.setVisible(true);

        }
    
    
    }
    

    @FXML
  void verifier_quantity(KeyEvent event) {
        if (f_quantity.getText().isEmpty() ) {
            id_verifier_quantity.setText("champ vide!");
            id_verifier_quantity.setTextFill(Color.RED);
            id_verifier_quantity.setVisible(true);
        } else  if(  Integer.parseInt(f_quantity.getText())< 0 ){
                     id_verifier_quantity.setText("remplir  nombre de place");    
                       id_verifier_quantity.setTextFill(Color.RED);
            id_verifier_quantity.setVisible(true);
                }else {
            id_verifier_quantity.setText(" quantite  remplie!");
            id_verifier_quantity.setTextFill(Color.GREEN);
            id_verifier_quantity.setVisible(true);

        }}

    void verifier_datestart(KeyEvent event) {
     }

    void verifier_dateend(KeyEvent event) {
       }

}
