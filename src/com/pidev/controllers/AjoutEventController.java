/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.controllers;

import com.pidev.models.events;
import com.pidev.services.ServiceEvents;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author selmi
 */
public class AjoutEventController implements Initializable {

   
    @FXML
    private AnchorPane pane;

    @FXML
    private TextField nom;

    @FXML
    private TextField location;

    @FXML
    private TextField prix;

    @FXML
    private TextField qte;

    @FXML
    private TextArea description;

    @FXML
    private DatePicker start;

    @FXML
    private DatePicker fin;

    @FXML
    private ImageView imageee;
    
    String img="";
    List<String> type;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         type =new ArrayList();
        type.add("*.jpg");
         type.add("*.png");
          afficher();
          
          
    }    

    
    
    
    
    
    
    @FXML
    private void Ajout(ActionEvent event) throws SQLException {
        int n = Integer.parseInt(prix.getText());
      int q= Integer.parseInt(qte.getText());
        Date dd = java.sql.Date.valueOf(start.getValue().toString());
                Date df = java.sql.Date.valueOf(fin.getValue().toString());
                

        events ee =new events(nom.getText(),location.getText(), description.getText(),img, (java.sql.Date)dd, (java.sql.Date)df , n, q);
        ee.ajouterEvent1(ee);
    }

    @FXML
    private void importer(ActionEvent event) {
        FileChooser f=new FileChooser();
        f.getExtensionFilters().add(new FileChooser.ExtensionFilter("jpeg,png",type));
        File fc=f.showOpenDialog(null);
        if(f!= null)
        {
            System.out.println(fc.getName());
            img=fc.getAbsoluteFile().toURI().toString();
            Image i = new Image(img);
            imageee.setImage(i);
        }
    
        
    }
    
    
    

    private void afficher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
