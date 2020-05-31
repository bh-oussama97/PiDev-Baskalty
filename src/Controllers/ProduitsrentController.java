/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import Controllers.ProduitsrentController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import Entite.categorie;
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
import java.util.stream.Collectors;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class ProduitsrentController implements Initializable 
{

    public ListView<produit> listView;
    private Label prixmaxlabel;
    private ComboBox<String> cat;
    private Slider prixmax;
    private Slider prixmin;


    private ImageView backToHome;
    private TextField search;
    private Label lnom;
    private Label lcategorie;
    private Label lreference;
    private Label lprix;
   // private List<produit> all_articles;
    ServiceProduit produitservice = new ServiceProduit();
    List<produit> listeproduits = new ArrayList<>();
    produit p1,p2,p3,p4 = new produit();

    @FXML
    private AnchorPane box2;
    @FXML
    private AnchorPane box3;
    @FXML
    private AnchorPane box4;
    @FXML
    private Pagination paginator;

    @FXML
    private ImageView image2;
    @FXML
    private ImageView image3;
    @FXML
    private ImageView image4;
    //Box 1 :
    @FXML
    private AnchorPane box1;
    @FXML
    private ImageView image1;
    @FXML
    private Label categorie1;
    @FXML
    private Label nom1;
    @FXML
    private Label reference1;
    @FXML
    private Label prix1;
    @FXML
    private AnchorPane details;
    @FXML
    private Label nom2;
    @FXML
    private Label categorie2;
    @FXML
    private Label reference2;
    @FXML
    private Label prix2;
    @FXML
    private Label nom3;
    @FXML
    private Label categorie3;
    @FXML
    private Label reference3;
    @FXML
    private Label prix3;
    @FXML
    private Label nom4;
    @FXML
    private Label categorie4;
    @FXML
    private Label reference4;
    @FXML
    private Label prix4;
    //
      List<categorie> listecategorie = new ArrayList<>();
    private Label prixminlabel;


    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
      
        ServiceProduit sp = new ServiceProduit();

        listeproduits = sp.afficher();
        if (listeproduits.isEmpty()) {
            box1.setVisible(false);
            box2.setVisible(false);
            box3.setVisible(false);
            box4.setVisible(false);
            paginator.setVisible(false);
        } else {
            paginator.setVisible(true);
            //vide.setVisible(false);
            setNbPages();
            try {
                initAnnoncePage(0);

            } catch (IOException ex) {
               System.out.println(ex.getMessage());
            } catch (SQLException ex) {
                 Logger.getLogger(ProduitsrentController.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    }

    private void setNbPages() 
    {

        if (listeproduits.size() % 4 != 0) 
        {
            paginator.setPageCount((listeproduits.size() / 4) + 1);
        } else 
        {
            paginator.setPageCount(listeproduits.size() / 4);
        }

        paginator.currentPageIndexProperty().addListener((obs, oldIndex, newIndex) -> {
            try {
                initAnnoncePage(newIndex.intValue());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } catch (SQLException ex) {
                Logger.getLogger(ProduitsrentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    private List<produit> getAnnoncesPage(int i) 
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

    
    private void initAnnoncePage(int i) throws FileNotFoundException, IOException, SQLException 
    {
        ServiceProduit sp = new ServiceProduit();
        ServiceCategorie sc = new ServiceCategorie();
        paginator.setCurrentPageIndex(i);
        List<produit> TroisAnnonces = getAnnoncesPage(i);
        System.out.println(TroisAnnonces.size());
        if (TroisAnnonces.size() >= 1)
        {
            p1 = TroisAnnonces.get(0);
            System.out.println(p1.getPrix());
            box1.setVisible(true);
             FileInputStream input = null;
           input = new FileInputStream("src/images/"+TroisAnnonces.get(0).getImage());
            Image imageFile = new Image(input);
            image1.setImage(imageFile);
             input.close();
           image1.setImage(imageFile);
            categorie1.setText(sc.getCategorieNameById(TroisAnnonces.get(0).getCategorie()));
            nom1.setText(TroisAnnonces.get(0).getNom());
            prix1.setText(Integer.toString((int) TroisAnnonces.get(0).getPrix()) + "DT");
            reference1.setText(TroisAnnonces.get(0).getReference());
        } 
        else 
        {
            box1.setVisible(false);
        }

        if (TroisAnnonces.size() >= 2)
        {
            box2.setVisible(true);

           p2= TroisAnnonces.get(1);
             FileInputStream input = null;
           input = new FileInputStream("src/images/"+TroisAnnonces.get(1).getImage());
            Image imageFile = new Image(input);
            image2.setImage(imageFile);
             input.close();
           image2.setImage(imageFile);
            categorie2.setText(sc.getCategorieNameById(TroisAnnonces.get(1).getCategorie()));
            nom2.setText(TroisAnnonces.get(1).getNom());
            prix2.setText(Integer.toString((int) TroisAnnonces.get(1).getPrix()) + "DT");
            reference2.setText(TroisAnnonces.get(1).getReference());
          

        } else {
            box2.setVisible(false);
        }

        if (TroisAnnonces.size() >= 3)
        {
           
            box3.setVisible(true);
           p3 = TroisAnnonces.get(2);
            categorie3.setText(sc.getCategorieNameById(TroisAnnonces.get(2).getCategorie()));
             FileInputStream input = null;
           input = new FileInputStream("src/images/"+TroisAnnonces.get(2).getImage());
            Image imageFile = new Image(input);
            image3.setImage(imageFile);
             input.close();
           image3.setImage(imageFile);
            
            nom3.setText(TroisAnnonces.get(2).getNom());
            prix3.setText(Integer.toString((int) TroisAnnonces.get(2).getPrix()) + "DT");
            reference3.setText(TroisAnnonces.get(2).getReference());
          
          
        } 
        else 
        {
            box3.setVisible(false);
        }

        if (TroisAnnonces.size() >= 4)
        {
         
            box4.setVisible(true);
            p4 = TroisAnnonces.get(3);
            categorie4.setText(sc.getCategorieNameById(TroisAnnonces.get(3).getCategorie()));
             FileInputStream input = null;
           input = new FileInputStream("src/images/"+TroisAnnonces.get(3).getImage());
            Image imageFile = new Image(input);
            image4.setImage(imageFile);
             input.close();
           image4.setImage(imageFile);
            nom4.setText(TroisAnnonces.get(3).getNom());
            prix4.setText(Integer.toString((int) TroisAnnonces.get(3).getPrix()) + "DT");
            reference4.setText(TroisAnnonces.get(3).getReference());
   

        } else 
        {
            box4.setVisible(false);
        }
    }


    private void RetourPageAccueils(MouseEvent event) {
        try {
              
            backToHome.getScene().getWindow().hide();
            Stage produits = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/com/pidev/views/PageAccueilProduitsrent.fxml"));
            Scene scene = new Scene(root);
            produits.setScene(scene);
            produits.show();
            produits.setResizable(false);

        } catch (Exception e) {
            System.out.println(" Error  : " + e);
        }
        
    }
    

      @FXML
    private void details0(ActionEvent event) throws IOException, SQLException {
        
           if ( p1.getQuantite() ==0 )
      {
           TrayNotification tray = new TrayNotification("Warning !", "Quantity Not available !", NotificationType.WARNING);
                tray.showAndDismiss(Duration.seconds(3));
      }
           else
           {
                FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/com/pidev/views/DetailsProduitrent.fxml"));
            
            Parent  par = Loader.load();
            
            
            DetailsProduitRentController cont = Loader.getController();
            cont.setproduit(p1);
            cont.init();
              AnchorPane pane = (AnchorPane) details.getParent();
            pane.getChildren().clear();
            pane.getChildren().setAll(par);

           }
        
    }

    @FXML
    private void details1(ActionEvent event) throws SQLException, IOException
    {
            if ( p2.getQuantite() ==0 )
      {
           TrayNotification tray = new TrayNotification("Warning !", "Quantity Not available !", NotificationType.WARNING);
                tray.showAndDismiss(Duration.seconds(3));
      }
        
        else
        {
                FXMLLoader Loader = new FXMLLoader();
                   Loader.setLocation(getClass().getResource("/com/pidev/views/DetailsProduitrent.fxml"));
            
            Parent  par = Loader.load();
            
            
            DetailsProduitRentController cont = Loader.getController();
            cont.setproduit(p2);
            cont.init();
              AnchorPane pane = (AnchorPane) details.getParent();
            pane.getChildren().clear();
            pane.getChildren().setAll(par);
                }
         

    }

    @FXML
    private void details3(ActionEvent event) throws SQLException, IOException {
        
          if ( p3.getQuantite() == 0 )
      {
           TrayNotification tray = new TrayNotification("Warning !", "Quantity Not available !", NotificationType.WARNING);
                tray.showAndDismiss(Duration.seconds(3));
      }
          else
          {
             FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/com/pidev/views/DetailsProduitrent.fxml"));
            
            Parent  par = Loader.load();
            
            
            DetailsProduitRentController cont = Loader.getController();
            cont.setproduit(p3);
            cont.init();
              AnchorPane pane = (AnchorPane) details.getParent();
            pane.getChildren().clear();
            pane.getChildren().setAll(par);   
          }
    

    }

    @FXML
    private void details14(ActionEvent event) throws SQLException, IOException {
        
          if ( p4.getQuantite() ==0 )
      {
           TrayNotification tray = new TrayNotification("Warning !", "Quantity Not available !", NotificationType.WARNING);
                tray.showAndDismiss(Duration.seconds(3));
      }
        
        else
          {
               FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/com/pidev/views/DetailsProduitrent.fxml"));
            
            Parent  par = Loader.load();
            
            
            DetailsProduitRentController cont = Loader.getController();
            cont.setproduit(p4);
            cont.init();
              AnchorPane pane = (AnchorPane) details.getParent();
            pane.getChildren().clear();
            pane.getChildren().setAll(par);
          }
         

    }
     
   

   
}
