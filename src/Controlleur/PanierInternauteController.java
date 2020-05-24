/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Entite.panier;
import Service.ServicePanier;
import com.jfoenix.controls.JFXButton;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class PanierInternauteController implements Initializable {

    @FXML
    private ImageView image1;
    @FXML
    private ImageView image3;
    @FXML
    private ImageView image2;
 
    @FXML
    private JFXButton btncommander;
    @FXML
    private Label totalpanier;
    
    ServicePanier spanier= new ServicePanier();
    
    ArrayList<panier> panier = new ArrayList<>();
    @FXML
    private Label namelabel;
    @FXML
    private Label prixlabel;
    @FXML
    private Label quantite;
    @FXML
    private Label totalprix;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        try {
            panier = spanier.afficherInfosPanier();
            for (int i=0;i<panier.size();i++)
            {
                afficherImage(panier.get(i).getImage(), image1);
                namelabel.setText(panier.get(i).getName());
                prixlabel.setText(Integer.toString(panier.get(i).getPrix())+" DT");
                quantite.setText(Integer.toString(panier.get(i).getQuantite()));
                totalprix.setText(Integer.toString((int) panier.get(i).getPrix()* panier.get(i).getQuantite())+" DT");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanierInternauteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PanierInternauteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

  public void afficherImage (String path,ImageView img) throws FileNotFoundException, IOException
        {
             
             FileInputStream input = new FileInputStream("src/Images/"+path);
             Image imageFile = new Image(input);
            img.setImage(imageFile);
            input.close();
        
        }    

    @FXML
    private void Retour(MouseEvent event) {
    }

    @FXML
    private void delete1(MouseEvent event) {
    }

    @FXML
    private void delete3(MouseEvent event) {
    }

    @FXML
    private void delete2(MouseEvent event) {
    }

    @FXML
    private void Commander(ActionEvent event) {
    }
    
}
