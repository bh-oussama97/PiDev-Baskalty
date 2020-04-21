package Controlleur;

import Entite.RentProd;
import Service.ServiceRentProd;
import javafx.event.ActionEvent;
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RentProdController implements Initializable {
    public ImageView photo;
    public Text descriptionD;
    public Label markId;
    public Label nomD;
    public Label quantiteD;
    public Label prixTotal;
    public Label idRentProd;
    public Label referenceD;
    public Spinner<Integer> note;
    public AnchorPane details;
    private RentProd rentprod;

    public void setRentprod(RentProd rentprod) {
        this.rentprod = rentprod;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void init() {
        idRentProd.setText(Integer.toString(rentprod.getRentProd_id()));
        nomD.setText(rentprod.getModel());
        markId.setText(rentprod.getMarke());
        quantiteD.setText(Integer.toString(rentprod.getQuantity()));
        prixTotal.setText(Double.toString(rentprod.getPrice()));
        descriptionD.setText(rentprod.getDescription());
        referenceD.setText(rentprod.getReference());
        putImageViewer(rentprod.getImage());
        note.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5));
    }


    public void putImageViewer(String path) {
        FileInputStream input = null;
        try {
            input = new FileInputStream("src/images/" + path);
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

    public void noter(ActionEvent actionEvent) throws IOException {
        ServiceRentProd serviceRentProd = new ServiceRentProd();
        serviceRentProd.noter(note.getValue(), rentprod.getRentProd_id());
        Parent loader = FXMLLoader.load(getClass().getResource("/com/pidev/views/PageAccueilProduitsrent.fxml"));
        Scene homePage=new Scene(loader);
        Stage rentProdStage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        rentProdStage.hide();
        rentProdStage.setScene(homePage);
        rentProdStage.show();

    }

}
