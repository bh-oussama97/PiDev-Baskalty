package Controllers;

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
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import org.controlsfx.control.Rating;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class RentProdController implements Initializable {
    public ImageView photo;
 
    public Label markId;
    public Label nomD;
    public Label quantiteD;
    public Label prixTotal;
    public Label idRentProd;
    public Label referenceD;
    public Rating note;
    public AnchorPane details;
    private RentProd rentprod;
    @FXML
    private AnchorPane rateAnchor;
    @FXML
    private Label DescriptionD;

    public void setRentprod(RentProd rentprod) {
        this.rentprod = rentprod;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void init() throws IOException {
       
        nomD.setText(rentprod.getModel());
        markId.setText(rentprod.getMarke());
        quantiteD.setText(Integer.toString(rentprod.getQuantity()));
        prixTotal.setText(Double.toString(rentprod.getPrice())+" DT");
        DescriptionD.setText(rentprod.getDescription());
        referenceD.setText(rentprod.getReference());
        putImageViewer(rentprod.getImage());
    
    }


    public void putImageViewer(String path) throws FileNotFoundException, IOException {
        FileInputStream input = null;
      
            input = new FileInputStream("src/images/" + path);
       
        Image imageFile = new Image(input);
        photo.setImage(imageFile);

            input.close();
    
    }

    @FXML
    public void noter(ActionEvent actionEvent) throws IOException {
        ServiceRentProd serviceRentProd = new ServiceRentProd();
        serviceRentProd.noter(note.getRating(), rentprod.getRentProd_id());
        TrayNotification tray = new TrayNotification("", "Rate Submitted !", NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.seconds(3));
        AnchorPane rate = FXMLLoader.load(getClass().getResource("/com/pidev/views/ProductsRate.fxml"));
        Node node = (Node) rate;
        rateAnchor.getChildren().clear();
        rateAnchor.getChildren().add((Node)rate);

    }

    @FXML
    private void RetourAumagasin(MouseEvent event) throws IOException {
         AnchorPane contactus = FXMLLoader.load(getClass().getResource("/com/pidev/views/ProductsRate.fxml"));
           Node node = (Node) contactus;
           rateAnchor.getChildren().clear();
           rateAnchor.getChildren().add((Node) contactus);
    }

}
