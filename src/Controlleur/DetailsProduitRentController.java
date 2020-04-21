/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import com.jfoenix.controls.JFXButton;
import Entite.RentProd;
import Entite.produit;
import Controlleur.RentProdController;
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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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

        ServiceProduit sp = new ServiceProduit();
        idp1.setText(Integer.toString(pdetails.getId()));
        nomD.setText(pdetails.getNom());
        categorieD.setText(pdetails.getCategorie());
        quantiteD.setText(Integer.toString(pdetails.getQuantite()));
        prixD.setText(Float.toString(pdetails.getPrix()));
        descriptionD.setText(pdetails.getDescription());
        referenceD.setText(pdetails.getReference());
        putImageViewer(pdetails.getImage());
        prixTotal.setText(String.valueOf((1 * pdetails.getPrix())));
        quantitRes.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, pdetails.getQuantite()));
        rentDays.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,15));
        quantitRes.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                prixTotal.setText(String.valueOf((newValue * pdetails.getPrix())));
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


    @FXML
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
    private void ModifierProduit(ActionEvent event) {

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
    private void CommanderProduit(ActionEvent event) throws IOException {
        ServiceRentProd serviceRentProd =new ServiceRentProd();
        RentProd rentprod=new RentProd();
        rentprod.setModel(pdetails.getNom());
        rentprod.setQuantity(quantitRes.getValue());
        rentprod.setMarke(pdetails.getCategorie());
        rentprod.setLocalisation("sfax");
        rentprod.setReference(pdetails.getReference());
        rentprod.setRentdays(rentDays.getValue());
        rentprod.setDispo(true);
        rentprod.setDescription(pdetails.getDescription());
        rentprod.setImage(pdetails.getImage());
        serviceRentProd.ajouter(rentprod);
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("/com/pidev/views/RentProd.fxml"));
        Parent p = Loader.load();
        RentProdController cont = Loader.getController();
        cont.setRentprod(rentprod);
        cont.init();

        details.getChildren().clear();
        details.getChildren().setAll(p);
    }

}
