/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Entite.produit;
import Service.ServiceProduit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class ProduitsVendeurController implements Initializable {

    @FXML
    private AnchorPane holderPane;
    @FXML
    private AnchorPane box1;
    @FXML
    private ImageView image1;
    @FXML
    private Label quantite1;
    private Text quantite;
    @FXML
    private Label nom1;
    @FXML
    private Label categorie1;
    @FXML
    private Label prix1;
    @FXML
    private ImageView image2;
    @FXML
    private Label quantite2;
    @FXML
    private Label nom2;
    @FXML
    private Label categorie2;
    @FXML
    private Label prix2;
    @FXML
    private ImageView image3;
    @FXML
    private Label quantite3;
    @FXML
    private Label nom3;
    @FXML
    private Label categorie3;
    @FXML
    private Label prix3;
    @FXML
    private Pagination pagination;
    
    List<produit> listeproduits = new ArrayList<>();
    ServiceProduit sp = new ServiceProduit();
    produit p1,p2,p3 = new produit();
    @FXML
    private AnchorPane box2;
    @FXML
    private AnchorPane box3;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
        listeproduits = sp.AfficherProduitsVendeurParDateAjout();
        if (listeproduits.isEmpty()) {
            box1.setVisible(false);
            box2.setVisible(false);
            box3.setVisible(false);
            pagination.setVisible(false);
        } else {
            pagination.setVisible(true);
            //vide.setVisible(false);
            SetNombresDePages();
            try {
                ContenuChaquePage(0);
            } catch (IOException ex) {
                Logger.getLogger(ProduitsVendeurController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
       private void SetNombresDePages() 
    {

        if (listeproduits.size() % 3 != 0) 
        {
            pagination.setPageCount((listeproduits.size() / 3) + 1);
        } else 
        {
            pagination.setPageCount(listeproduits.size() / 3);
        }

        pagination.currentPageIndexProperty().addListener((obs, oldIndex, newIndex) -> {
            try {
                ContenuChaquePage(newIndex.intValue());
            } catch (IOException ex) {
                Logger.getLogger(ProduitsVendeurController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    } 
       
        private List<produit> getNombreDePages (int i) 
    {
        int start = 3* i;
        int fin = start + 3;
        if (listeproduits.size() > start) 
        {
            if (listeproduits.size() > fin) 
            {
                return listeproduits.subList(start, fin);
            } else 
            {
                return listeproduits.subList(start, listeproduits.size());
            }
        }
        return listeproduits.subList(0, 2);
    }
        
        public void afficherImage (String path,ImageView img) throws FileNotFoundException, IOException
        {
             
             FileInputStream input = new FileInputStream("src/Images/"+path);
             Image imageFile = new Image(input);
            img.setImage(imageFile);
            input.close();
        
        }  

       
        private void ContenuChaquePage(int i) throws IOException 
    {
        ServiceProduit sp = new ServiceProduit();

        pagination.setCurrentPageIndex(i);
        List<produit> TroisProduitsParPage = getNombreDePages(i);

        if (TroisProduitsParPage.size() >= 1) 
        {
            p1 = TroisProduitsParPage.get(0);
            box1.setVisible(true);
            afficherImage(TroisProduitsParPage.get(0).getImage(), image1);
            categorie1.setText(TroisProduitsParPage.get(0).getCategorie());
            nom1.setText(TroisProduitsParPage.get(0).getNom());
            prix1.setText(Float.toString((float) TroisProduitsParPage.get(0).getPrix()) + "DT");
            quantite1.setText(Integer.toString(TroisProduitsParPage.get(0).getQuantite()));
        } 
        else 
        {
            box1.setVisible(false);
        }
        if (TroisProduitsParPage.size() >= 2) 
        {
            p2 = TroisProduitsParPage.get(1);
            box2.setVisible(true);
            afficherImage(TroisProduitsParPage.get(1).getImage(), image2);
            categorie2.setText(TroisProduitsParPage.get(1).getCategorie());
            nom2.setText(TroisProduitsParPage.get(1).getNom());
            prix2.setText(Float.toString((float) TroisProduitsParPage.get(1).getPrix()) + "DT");
            quantite2.setText(Integer.toString(TroisProduitsParPage.get(1).getQuantite()));
        } 
        else 
        {
            box2.setVisible(false);
        }
         if (TroisProduitsParPage.size() >= 3) 
        {
            p3 = TroisProduitsParPage.get(2);
            box3.setVisible(true);
            afficherImage(TroisProduitsParPage.get(2).getImage(), image3);
            categorie3.setText(TroisProduitsParPage.get(2).getCategorie());
            nom3.setText(TroisProduitsParPage.get(2).getNom());
            prix3.setText(Float.toString((float) TroisProduitsParPage.get(2).getPrix()) + "DT");
            quantite3.setText(Integer.toString(TroisProduitsParPage.get(2).getQuantite()));
        } 
        else 
        {
            box3.setVisible(false);
        }
        
        
    }
        
        
    }    
    

