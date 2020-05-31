/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.panier;
import Service.ServicePanier;

import com.jfoenix.controls.JFXButton;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.util.Callback;
import org.apache.commons.lang.BooleanUtils;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class PanierInternauteController implements Initializable {

    @FXML
    private JFXButton btncommander;
    @FXML
    Label totalpanier;

    @FXML
    private TableColumn<panier, String> Name;
    @FXML
    private TableColumn<panier, Integer> Quantity;
    @FXML
    private TableColumn<panier, String> price;
    @FXML
    private TableColumn<panier, String> total;

    @FXML
    private TableView<panier> tablePanier;
    @FXML
    private ImageView image;

    ServicePanier sp;
      int totalprixpanier = 0;
      int total_panier_after_delete =0;
  
    panier p = new panier();
    @FXML
    private AnchorPane panierAnchor;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            ServicePanier spanier = new ServicePanier();
            ObservableList<panier> imagepanier = FXCollections.observableArrayList();

            tablePanier.setEditable(false);
            tablePanier.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    
            Name.setCellValueFactory(new PropertyValueFactory<>("name"));
            Quantity.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        
            total.setCellValueFactory(new Callback<CellDataFeatures<panier, String>, ObservableValue<String>>() {
                public ObservableValue<String> call(CellDataFeatures<panier, String> p) {
                    int total = p.getValue().getQuantite() * p.getValue().getPrix();
                    String totalDt = total + " DT";
                    ObservableValue<String> obsInt = new ReadOnlyObjectWrapper<>(totalDt);
                    return obsInt;
                }
            });

            price.setCellValueFactory(new Callback<CellDataFeatures<panier, String>, ObservableValue<String>>() {
                public ObservableValue<String> call(CellDataFeatures<panier, String> p) {

                    String prix = p.getValue().getPrix() + " DT";
                    ObservableValue<String> obsInt = new ReadOnlyObjectWrapper<>(prix);
                    return obsInt;
                }
            });

            PropertyValueFactory<panier, Integer> quant = new PropertyValueFactory<>("quantite");

            //  price.call(param)
            // total.setCellFactory(new PropertyValueFactory<>(quant.* price));
            tablePanier.setItems(spanier.afficherInfosPanier());

      
            ObservableList<panier> selectedRows = tablePanier.getItems();
            ArrayList<panier> rows = new ArrayList<>(selectedRows);
            for (int i = 0; i < rows.size(); i++) {
                totalprixpanier = totalprixpanier + (rows.get(i).getTotal(rows.get(i).getPrix(), rows.get(i).getQuantite()));
            }

            this.totalpanier.setText(Integer.toString(totalprixpanier));
        } catch (SQLException ex) {
            Logger.getLogger(PanierInternauteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    @FXML
    private void Retour(MouseEvent event) {
    }

    @FXML
    private void Commander(ActionEvent event) throws IOException 
    {
       
        ServicePanier spanier = new ServicePanier();
        spanier.DeleteFromPanier();
        
            AnchorPane panier = FXMLLoader.load(getClass().getResource("/com/pidev/views/CommanderProduit.fxml"));
            panierAnchor.getChildren().clear();
            panierAnchor.getChildren().add((Node) panier);
       
        CommanderProduitController.getInstance().setTotalApayer(Integer.parseInt(totalpanier.getText()));
        CommanderProduitController.getInstance().setLabelTotalAPayer();
        
    }

    @FXML
    private void delete(ActionEvent event) {

        
        sp = new ServicePanier();
        if (tablePanier.getSelectionModel().getSelectedIndex() == -1) 
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error !");
            alert.setHeaderText(null);
            alert.setContentText("No row selected");
            alert.showAndWait();
        } else 
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Confirmation");
            alert.setHeaderText("Do you want to remove the following product ?");
            alert.setContentText("Are you sure? ");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {

                ObservableList<panier> selectedRows = tablePanier.getSelectionModel().getSelectedItems();
                ArrayList<panier> rows = new ArrayList<>(selectedRows);
                rows.forEach((row) -> {
                    sp.supprimer((row.getId_panier()));
                    tablePanier.getItems().remove(row);
                });

            }
             ObservableList<panier> selectedRows = tablePanier.getItems();
        ArrayList<panier> rows = new ArrayList<>(selectedRows);
        for (int i = 0; i < rows.size(); i++) {
            total_panier_after_delete = total_panier_after_delete + (rows.get(i).getTotal(rows.get(i).getPrix(), rows.get(i).getQuantite()));
        }
        totalpanier.setText(Integer.toString(total_panier_after_delete));
    }
            

        }

}
