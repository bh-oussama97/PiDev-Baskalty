/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
import Entite.RentProd;
import Entite.produit;
import Controllers.RentProdController;
import Service.ServiceCategorie;
import Service.ServiceProduit;
import Service.ServiceRentProd;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class DetailsProduitRentController implements Initializable {


    @FXML
    public Spinner<Integer> quantitRes;
    public Label prixTotal;
    public Spinner<Integer> rentDays;
    produit pdetails = new produit();
    @FXML
    private AnchorPane details;
    @FXML
    private ImageView photo;
    @FXML
    private Label descriptionD;
    @FXML
    private Label categorieD;
    @FXML
    private Label nomD;
    private Label quantiteD;
    @FXML
    private Label prixD;
    private Label idp1;
    private Label referenceD;
    private JFXButton btnRMagasin;
    @FXML
    private JFXButton commander;

    public void setproduit(produit p) {
        this.pdetails = p;
    }
    int total;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


    public void init() throws SQLException {

        ServiceProduit sp = new ServiceProduit();
        ServiceCategorie sc = new ServiceCategorie();
    
        nomD.setText(pdetails.getNom());
        categorieD.setText(sc.getCategorieNameById(pdetails.getCategorie()));

        prixD.setText(Integer.toString(pdetails.getPrix())+" DT");
        descriptionD.setText(pdetails.getDescription());
        putImageViewer(pdetails.getImage());
        prixTotal.setText(String.valueOf((1 * pdetails.getPrix())+" DT"));
        quantitRes.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, pdetails.getQuantite()));
        rentDays.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,15));
        quantitRes.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                
                total = newValue * pdetails.getPrix();
                prixTotal.setText(String.valueOf((total)+" DT"));
            }
        });
    }

    public void putImageViewer(String path) {
        FileInputStream input = null;
        try {
            input = new FileInputStream("src/images/" + path);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProduitsrentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image imageFile = new Image(input);
        photo.setImage(imageFile);

        try {
            input.close();
        } catch (IOException ex) {
            Logger.getLogger(ProduitsrentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    private void RetourAumagasin(ActionEvent event) {

        try {

            btnRMagasin.getScene().getWindow().hide();
            Stage produits = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../views/Produitsrent.fxml"));
            Scene scene = new Scene(root);
            produits.setScene(scene);
            produits.show();
            produits.setResizable(false);

        } catch (Exception e) {
            System.out.println(" Error  : " + e);
        }
    }


    @FXML
    private void CommanderProduit(ActionEvent event) throws IOException, SQLException {
        ServiceCategorie scat = new ServiceCategorie();
        ServiceRentProd serviceRentProd =new ServiceRentProd();
        RentProd rentprod=new RentProd();
        rentprod.setModel(pdetails.getNom());
        rentprod.setQuantity(quantitRes.getValue());
        rentprod.setMarke(scat.getCategorieNameById(pdetails.getCategorie()));
        rentprod.setLocalisation("sfax");
        rentprod.setReference(pdetails.getReference());
        rentprod.setRentdays(rentDays.getValue());
        rentprod.setDispo(true);
        rentprod.setDescription(pdetails.getDescription());
        rentprod.setImage(pdetails.getImage());
        rentprod.setPrice(total);
        serviceRentProd.ajouter(rentprod);
        TrayNotification tray = new TrayNotification("", "Product rented successfully!", NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.seconds(3));
        AnchorPane rate = FXMLLoader.load(getClass().getResource("/com/pidev/views/Produitsrent.fxml"));
        Node node = (Node) rate;
        details.getChildren().clear();
        details.getChildren().add((Node)rate);
  
    }

    @FXML
    private void RetourAumagasin(MouseEvent event) throws IOException {
        AnchorPane magasin = FXMLLoader.load(getClass().getResource("/com/pidev/views/Produitsrent.fxml"));
        Node node = (Node) magasin;
        details.getChildren().clear();
        details.getChildren().add((Node)node);
        
    }

}
