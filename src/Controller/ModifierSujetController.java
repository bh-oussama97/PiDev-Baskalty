/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Service.EvenementService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ModifierSujetController implements Initializable {

    @FXML
    private JFXTextField f_titre;
    @FXML
    private JFXButton id_modifier;
    @FXML
    private JFXTextArea id_description;
         @FXML
    private AnchorPane id_page_modifé;


    /**
     * Initializes the controller class.
     */
    public static EvenementService sujetService = new EvenementService();
    @FXML
    private JFXTextField f_prix;
    @FXML
    private JFXTextField f_quantity;
    @FXML
    private JFXTextField f_location;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         f_titre.setText(MesSujetsController.getSujet_modifié().getTitre());
         id_description.setText(MesSujetsController.getSujet_modifié().getContenu());
                  f_location.setText(MesSujetsController.getSujet_modifié().getLocation());
                           f_prix.setText(Integer.toString(MesSujetsController.getSujet_modifié().getPrix()));
                                    f_quantity.setText( Integer.toString(MesSujetsController.getSujet_modifié().getQuantity()));
      
    }    

        
    @FXML
    private void modifer(ActionEvent event) {
                    int n = Integer.parseInt(f_prix.getText());
                    int q = Integer.parseInt(f_quantity.getText());

        MesSujetsController.getSujet_modifié().setTitre(f_titre.getText());
        MesSujetsController.getSujet_modifié().setContenu(id_description.getText());
                MesSujetsController.getSujet_modifié().setPrix(n);
                MesSujetsController.getSujet_modifié().setQuantity(q);
        MesSujetsController.getSujet_modifié().setLocation(f_location.getText());

       sujetService.modifierEvent(MesSujetsController.getSujet_modifié());
        try {
                        
                       AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/fxml/MesSujets.fxml"));
                        id_page_modifé.getChildren().clear();
			id_page_modifé.getChildren().add(newLoadedPane);
                    } catch (IOException ex) {
                        Logger.getLogger(ModifierSujetController.class.getName()).log(Level.SEVERE, null, ex);
                    }
        
        Image img = new Image("/aa.png");
         Notifications notificationBuilder = Notifications.create()
                 .title("Sujet Modifié")
                 .text("Vous avez modifé le sujet")
                 .graphic(new ImageView(img))
                 .hideAfter(Duration.seconds(5))
                 .position(Pos.TOP_RIGHT);
         
         notificationBuilder.show();
       
    }

    
}
