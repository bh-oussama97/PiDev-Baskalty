/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.commande;
import Service.ServiceCommande;
import Service.ServicePayment;
import com.stripe.exception.StripeException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class CommanderProduitController implements Initializable {

    @FXML
    private TextField nom;

    @FXML
    private Button btnvalider;
    @FXML
    private ComboBox<String> ville;
    @FXML
    private TextField adresse;
    @FXML
    private TextField numTelephone;
    @FXML
    private Label labelprixtotal;

    ObservableList<String> listeVille = FXCollections.observableArrayList("Ariana", "Beja", "Benzart", "Ben Arous", "Tatouine", "Touzer", "Tounes", "Jendouba", "Zaghouane", "Siliana", "Sousse", "Sidi Bouzid", "Sfax", "Gabes", "Gbelli", "Gasserine", "Gafsa", "Kairouan", "Kef", "Medenine", "Monastir", "Mannouba", "Mahdia", "Nabeul");

    public int totalApayer;

    private static CommanderProduitController instance;
    @FXML
    private TextField email;
    @FXML
    private AnchorPane order;

    public CommanderProduitController() {
        instance = this;
    }

    public static CommanderProduitController getInstance() {
        return instance;
    }

    public void setTotalApayer(int p) {
        this.totalApayer = p;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ville.setItems(listeVille);

    }

    public void setLabelTotalAPayer() {
        labelprixtotal.setText(totalApayer + " DT");
    }

    @FXML
    private void RetourPanier(MouseEvent event) throws IOException {
        
          AnchorPane panier = FXMLLoader.load(getClass().getResource("/com/pidev/views/PanierInternaute.fxml"));
           Node node = (Node) panier;
           order.getChildren().clear();
           order.getChildren().add((Node) panier);
           FadeTransition ft = new FadeTransition(Duration.millis(1500));
           ft.setNode(panier);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    @FXML
    private void valider(ActionEvent event) throws StripeException, IOException
    {
        if (verifField() && verifyCity() && verifyEmail() &&verifPhoneNumber() && verifName())
        {  
            ServicePayment sp = new ServicePayment();
        String cutomer_id = sp.createCustomer(ville.getValue(), adresse.getText(),nom.getText(), email.getText(),numTelephone.getText());
         
            TrayNotification tray = new TrayNotification("Success !", "Order has been created ! ", NotificationType.SUCCESS);
             tray.showAndDismiss(Duration.seconds(3));
             
             AnchorPane payment = FXMLLoader.load(getClass().getResource(("/com/pidev/views/paymentForm.fxml")));
             order.getChildren().clear();
             order.getChildren().add((Node) payment);
             
             PaymentFormController.getInstance().setCustomerId(cutomer_id);
             PaymentFormController.getInstance().settTotalToPay(totalApayer);
                     
        }
        
      

    }
    
    private void clearFields()
    {
        nom.clear();
        email.clear();
        numTelephone.clear();
        ville.getSelectionModel().clearSelection();
        adresse.clear();
    }
    private boolean verifPhoneNumber()
    {
        Pattern p = Pattern.compile("[9|5|2][0-9]{7}");
        Matcher m = p.matcher(numTelephone.getText());
        if (m.find() && m.group().equals(numTelephone.getText()))
        {
            return true;
        }
        else
        {
           Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Validate Phone Number");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Valid Phone Number");
            alert.showAndWait();
            numTelephone.clear();
            return false;  
        }
    }
    
    
    private boolean verifField()
    {
          if (nom.getText().equals("") || email.getText().equals("") || adresse.getText().equals("") || numTelephone.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error !");
            alert.setHeaderText(null);
            alert.setContentText("Some Fields are empty !");
            alert.showAndWait();
            return false;
        }
          else
          {
              return true;
          }
    }

    private boolean verifyCity() {
        if (ville.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setHeaderText(null);
            alert.setContentText("Choose a city please !");
            alert.showAndWait();
            return false;
        } else {
            return true;
        }
    }

    private boolean verifyEmail() {
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p.matcher(email.getText());
        if (m.find() && m.group().equals(email.getText())) {
            return true;
        } else 
        {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Validate Email");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Valid Email");
            alert.showAndWait();
            return false;
        }
    }
     private boolean verifName() {
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(nom.getText());
        if (m.find() && m.group().equals(nom.getText())) {
            return true;
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Validate Name");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Valid Name");
            alert.showAndWait();
            return false;
        }
    }

}
