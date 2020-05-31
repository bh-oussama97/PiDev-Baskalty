/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.produit;
import Service.ServiceCategorie;
import Service.ServiceProduit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class GererProduitsVendeurController implements Initializable {

    @FXML
    private AnchorPane box1;
    @FXML
    private ImageView image1;
    @FXML
    private Label nom1;
    @FXML
    private Label categorie1;
    @FXML
    private Label reference1;
    @FXML
    private Label prix1;
    @FXML
    private Pagination pagination;
    @FXML
    private AnchorPane box2;
    @FXML
    private ImageView image2;
    @FXML
    private Label nom2;
    @FXML
    private Label categorie2;
    @FXML
    private Label reference2;
    @FXML
    private Label prix2;
    @FXML
    private AnchorPane box3;
    @FXML
    private ImageView image3;
    @FXML
    private Label nom3;
    @FXML
    private Label categorie3;
    @FXML
    private Label reference3;
    @FXML
    private Label prix3;
    @FXML
    private AnchorPane box4;
    @FXML
    private ImageView image4;
    @FXML
    private Label nom4;
    @FXML
    private Label categorie4;
    @FXML
    private Label reference4;
    
    @FXML
    private Label prix4;
     List<produit> listeproduits = new ArrayList<>();
    ServiceProduit sp = new ServiceProduit();
    ServiceCategorie scat = new ServiceCategorie();
    produit p1,p2,p3,p4 = new produit();
    @FXML
    private AnchorPane GererProduits;
    
    private static GererProduitsVendeurController instance;
    
    public GererProduitsVendeurController()
    {
        instance = this;
    }
    
     public static GererProduitsVendeurController getinstance()
    {
        return instance;
    }
     
     public Pagination pagination()
     {
         return pagination;
     }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        listeproduits = sp.afficher();
        if (listeproduits.isEmpty()) {
            box1.setVisible(false);
            box2.setVisible(false);
            box3.setVisible(false);
            box4.setVisible(false);
            pagination.setVisible(false);
        } else {
            pagination.setVisible(true);
            //vide.setVisible(false);
            SetNombresDePages();
            try {
                ContenuChaquePage(0);
            } catch (IOException ex) {
                Logger.getLogger(ProduitsVendeurController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(GererProduitsVendeurController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    
     private void SetNombresDePages() 
    {

        if (listeproduits.size() % 4 != 0) 
        {
            pagination.setPageCount((listeproduits.size() / 4) + 1);
        } else 
        {
            pagination.setPageCount(listeproduits.size() / 4);
        }

        pagination.currentPageIndexProperty().addListener((obs, oldIndex, newIndex) -> {
            try {
                ContenuChaquePage(newIndex.intValue());
            } catch (IOException ex) {
                Logger.getLogger(ProduitsVendeurController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(GererProduitsVendeurController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        
    } 
     
       private List<produit> getNombreDePages (int i) 
    {
        int start = 4* i;
        int fin = start + 4;
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
        
        
          private void ContenuChaquePage(int i) throws IOException, SQLException 
    {
        ServiceProduit sp = new ServiceProduit();

        pagination.setCurrentPageIndex(i);
        List<produit> TroisProduitsParPage = getNombreDePages(i);

        if (TroisProduitsParPage.size() >= 1) 
        {
            p1 = TroisProduitsParPage.get(0);
            box1.setVisible(true);
            afficherImage(TroisProduitsParPage.get(0).getImage(), image1);
            categorie1.setText(scat.getCategorieNameById(TroisProduitsParPage.get(0).getCategorie()));
            
            System.out.println("*****************"+TroisProduitsParPage.get(0).getCategorie()+"*********");
            nom1.setText(TroisProduitsParPage.get(0).getNom());
            prix1.setText(Integer.toString((int) TroisProduitsParPage.get(0).getPrix()) + "DT");
            reference1.setText(TroisProduitsParPage.get(0).getReference());
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
            categorie2.setText(scat.getCategorieNameById(TroisProduitsParPage.get(1).getCategorie()));
            nom2.setText(TroisProduitsParPage.get(1).getNom());
            prix2.setText(Integer.toString((int) TroisProduitsParPage.get(1).getPrix()) + "DT");
             reference2.setText(TroisProduitsParPage.get(1).getReference());
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
            categorie3.setText(scat.getCategorieNameById(TroisProduitsParPage.get(2).getCategorie()));
            nom3.setText(TroisProduitsParPage.get(2).getNom());
            prix3.setText(Integer.toString((int) TroisProduitsParPage.get(2).getPrix()) + "DT");
             reference3.setText(TroisProduitsParPage.get(2).getReference());
        } 
        else 
        {
            box3.setVisible(false);
        }
         
         if (TroisProduitsParPage.size() >= 4)
        {
            p4 = TroisProduitsParPage.get(3);
            box4.setVisible(true);
            afficherImage(TroisProduitsParPage.get(3).getImage(), image4);
            nom4.setText(TroisProduitsParPage.get(3).getNom());
            categorie4.setText(scat.getCategorieNameById(TroisProduitsParPage.get(3).getCategorie()));
            reference4.setText(TroisProduitsParPage.get(3).getReference());
            prix4.setText(Integer.toString(TroisProduitsParPage.get(3).getPrix())+"DT");
        }
        else 
        {
            box4.setVisible(false);
        }
        
    }
      
    @FXML
    public void details1(ActionEvent event) throws IOException, SQLException
    {

          FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/com/pidev/views/DetailsProduitsVendeur.fxml"));
            
            Parent  par = Loader.load();
            
            
            DetailsProduitsVendeurController cont = Loader.getController();
            cont.setproduit(p1);
            cont.SetItemsDetails();
              AnchorPane pane = (AnchorPane) GererProduits.getParent();
            pane.getChildren().clear();
            pane.getChildren().setAll(par);
              
    }

    @FXML
    private void details2(ActionEvent event) throws IOException, SQLException {
        FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/com/pidev/views/DetailsProduitsVendeur.fxml"));
            
            Parent  par = Loader.load();
            
            
            DetailsProduitsVendeurController cont = Loader.getController();
            cont.setproduit(p2);
            cont.SetItemsDetails();
              AnchorPane pane = (AnchorPane) GererProduits.getParent();
            pane.getChildren().clear();
            pane.getChildren().setAll(par);
    }

    @FXML
    private void details3(ActionEvent event) throws IOException, SQLException {
        FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/com/pidev/views/DetailsProduitsVendeur.fxml"));
            
            Parent  par = Loader.load();
            
            
            DetailsProduitsVendeurController cont = Loader.getController();
            cont.setproduit(p3);
            cont.SetItemsDetails();
              AnchorPane pane = (AnchorPane) GererProduits.getParent();
            pane.getChildren().clear();
            pane.getChildren().setAll(par);
    }

    @FXML
    private void details4(ActionEvent event) throws IOException, SQLException {
        FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/com/pidev/views/DetailsProduitsVendeur.fxml"));
            
            Parent  par = Loader.load();
            
            
            DetailsProduitsVendeurController cont = Loader.getController();
            cont.setproduit(p4);
            cont.SetItemsDetails();
              AnchorPane pane = (AnchorPane) GererProduits.getParent();
            pane.getChildren().clear();
            pane.getChildren().setAll(par);
    }
    
}
