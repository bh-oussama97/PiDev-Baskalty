/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;
import org.apache.commons.lang.RandomStringUtils;
import com.pidev.models.*;
import com.pidev.services.ServiceProduit;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class AjoutProduitController implements Initializable {

    
    
    @FXML
    private TextField nom;
    @FXML
    private TextField reference;
    @FXML
    private TextField description;
    @FXML
    private TextField prix;
    @FXML
    private TextField quantite;
    @FXML
    private ImageView imageV;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
  }
    
       public static String saveToFileImageNormal(Image image) throws SQLException, IOException {

        String ext = "jpg";
        File dir = new File("C:/Users/benha/OneDrive/Documents/NetBeansProjects/Baskalty/src/images");
        String name = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(8), ext);
        File outputFile = new File(dir, name);
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        ImageIO.write(bImage, "png", outputFile);
        return name;
    }
       
    @FXML
    private void addImage(MouseEvent event) throws IOException
            {
        FileChooser fc = new FileChooser();

        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (.png)", "*.PNG");
        fc.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        File selectedFile = fc.showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(selectedFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imageV.setImage(image);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    


    @FXML
    private void ajouterProduit(ActionEvent event) throws SQLException {
        try {
            String n = nom.getText();
            String d = description.getText();
            String r = reference.getText();
            float p = Float.parseFloat(prix.getText());
            int q = Integer.parseInt(quantite.getText());
            Image img = imageV.getImage();
            String nameImage1 = saveToFileImageNormal(img);

            produit pro = new produit(q, LocalDateTime.now(), n, r, p, d, nameImage1, LocalDateTime.now());
            pro.setImage(nameImage1);
            ServiceProduit spro = new ServiceProduit();

            spro.ajouter(pro);
        } 
        catch (IOException ex) {
            Logger.getLogger(AjoutProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
   

    

}
