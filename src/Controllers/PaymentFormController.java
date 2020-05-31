/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Service.ServicePayment;
import com.stripe.exception.StripeException;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class PaymentFormController implements Initializable {

    @FXML
    private AnchorPane paymentAnchor;
    @FXML
    private TextField tfCardNumber;
    @FXML
    private PasswordField cvc;
    @FXML
    private TextField month;
    @FXML
    private TextField year;

    public int totalTopay;

    public String customer_id;

    public static PaymentFormController instance;
    @FXML
    private Button payment;

    public PaymentFormController() {
        instance = this;
    }

    public static PaymentFormController getInstance() {
        return instance;
    }

    public void settTotalToPay(int total) {
        this.totalTopay = total;
    }

    public void setCustomerId(String cus) {
        this.customer_id = cus;
    }

    ServicePayment sp = new ServicePayment();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void confirmpayment(ActionEvent event) throws IOException {

        if (verifLengthFiels() && verifFields() && verifCardNumber() && verifyNumber(month) && verifyNumber(year) && verifyNumber(cvc)) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Payment Confirmation");
            alert.setContentText("Are you sure for Paying this contract ? ");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                try {
                    sp.AttachCardToCustomer(tfCardNumber.getText(), Integer.parseInt(month.getText()), Integer.parseInt(year.getText()), cvc.getText(), customer_id);
                    sp.chargeCreditCard(String.valueOf(totalTopay), customer_id);
                    TrayNotification tray = new TrayNotification("", "Payment Succeeded!", NotificationType.SUCCESS);
                    tray.showAndDismiss(Duration.seconds(3));
                    FXMLLoader Loader = new FXMLLoader();

                  
                      payment.getScene().getWindow().hide();
            Stage produits = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/com/pidev/views/PageAccueilProduits.fxml"));
            Scene scene = new Scene(root,810,585);
            produits.setScene(scene);
            produits.show();
            produits.setResizable(true);

                } catch (StripeException ex) {
                    Alert alert2 = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle(ex.getLocalizedMessage());
                    alert2.setHeaderText(null);
                    alert2.setContentText(ex.getMessage());
                    alert2.showAndWait();
                }

            }
        }
    }

    private boolean verifLengthFiels() {
        if (month.getText().length() > 2) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Length is Wrong");
            alert.setHeaderText(null);
            alert.setContentText("Please Verify Month Length");
            alert.showAndWait();
            month.clear();
            return false;
        } else if (year.getText().length() > 2) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Length is Wrong");
            alert.setHeaderText(null);
            alert.setContentText("Please Verify Year Length");
            alert.showAndWait();
            year.clear();
            return false;
        } else if (cvc.getText().length() > 3) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Length is Wrong");
            alert.setHeaderText(null);
            alert.setContentText("Please Verify CVC Length");
            alert.showAndWait();
            cvc.clear();
            return false;
        } else {
            return true;
        }
    }

    private boolean verifyNumber(TextField textfieldNumber) {
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(textfieldNumber.getText());
        if (m.find() && m.group().equals(textfieldNumber.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Number");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter a Valid Number");
            alert.showAndWait();
            textfieldNumber.clear();
            return false;
        }
    }

    private boolean verifCardNumber() {
        Pattern p = Pattern.compile("[4,5][0-9]{15}");
        Matcher m = p.matcher(tfCardNumber.getText());
        if (m.find() && m.group().equals(tfCardNumber.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Card Number");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Valid Card Number");
            alert.showAndWait();
            tfCardNumber.clear();
            return false;
        }
    }

    private boolean verifFields() {
        if (tfCardNumber.getText().equals("") || cvc.getText().equals("") || month.getText().equals("") || year.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText(null);
            alert.setContentText("Some fields are empty !");
            alert.showAndWait();
            return false;
        } else {
            return true;
        }
    }
}
