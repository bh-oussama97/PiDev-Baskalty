/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.RentProd;
import Entite.rent;
import Service.ServiceRent;
import Service.ServiceRentProd;
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
public class ProductsRateController implements Initializable {

    @FXML
    private Pagination pagination;
    @FXML
    private AnchorPane box1;
    @FXML
    private ImageView image1;
    @FXML
    private Label name1;
    @FXML
    private Label mark1;
    @FXML
    private Label model1;
    @FXML
    private Label rating1;
    @FXML
    private AnchorPane box2;
    @FXML
    private ImageView image2;
    @FXML
    private Label name2;
    @FXML
    private Label mark2;
    @FXML
    private Label model2;
    @FXML
    private Label rating2;
    @FXML
    private AnchorPane box3;
    @FXML
    private ImageView image3;
    @FXML
    private Label name3;
    @FXML
    private Label mark3;
    @FXML
    private Label model3;
    @FXML
    private Label rating3;
    @FXML
    private AnchorPane box4;
    @FXML
    private ImageView image4;
    @FXML
    private Label name4;
    @FXML
    private Label mark4;
    @FXML
    private Label model4;
    @FXML
    private Label rating4;
    
    List<RentProd> listeproduits = new ArrayList<>();
    ServiceRentProd sr = new ServiceRentProd();
    RentProd p1,p2,p3,p4 =new RentProd();
    @FXML
    private AnchorPane rateProducts;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        listeproduits = sr.afficher();
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
                Logger.getLogger(ProductsRateController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ProductsRateController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ProductsRateController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ProductsRateController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        });
 
    }
  
         private List<RentProd> getNombreDePages (int i) 
    {
        int start = 4* i;
        int fin = start + 4;
        if (listeproduits.size() > start) 
        {
            if (listeproduits.size() > fin) 
            {
                return  listeproduits.subList(start, fin);
            } else 
            {
                return listeproduits.subList(start, listeproduits.size());
            }
        }
        return listeproduits.subList(0, 2);
    }
         
           private void ContenuChaquePage(int i) throws IOException, SQLException 
    {
        ServiceRentProd sp = new ServiceRentProd();

        pagination.setCurrentPageIndex(i);
        List<RentProd> TroisProduitsParPage = getNombreDePages(i);

        if (TroisProduitsParPage.size() >= 1) 
        {
            p1 = TroisProduitsParPage.get(0);
            box1.setVisible(true);
            afficherImage(TroisProduitsParPage.get(0).getImage(), image1);
            name1.setText(TroisProduitsParPage.get(0).getModel());
            mark1.setText(TroisProduitsParPage.get(0).getReference());
            model1.setText(String.valueOf(TroisProduitsParPage.get(0).getRentdays()));
            rating1.setText(String.valueOf(TroisProduitsParPage.get(0).getStars()+"/5"));
         
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
            name2.setText(TroisProduitsParPage.get(1).getModel());
            mark2.setText(TroisProduitsParPage.get(1).getReference());
            model2.setText(String.valueOf(TroisProduitsParPage.get(1).getRentdays()));
            rating2.setText(String.valueOf(TroisProduitsParPage.get(1).getStars()+"/5"));
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
            name3.setText(TroisProduitsParPage.get(2).getModel());
            mark3.setText(TroisProduitsParPage.get(2).getReference());
            model3.setText(String.valueOf(TroisProduitsParPage.get(2).getRentdays()));
            rating3.setText(String.valueOf(TroisProduitsParPage.get(2).getStars()+"/5"));
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
            name4.setText(TroisProduitsParPage.get(3).getModel());
            mark4.setText(TroisProduitsParPage.get(3).getReference());
            model4.setText(String.valueOf(TroisProduitsParPage.get(3).getRentdays()));
            rating4.setText(String.valueOf(TroisProduitsParPage.get(3).getStars()+"/5"));
        }
        else 
        {
            box4.setVisible(false);
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
    private void details1(ActionEvent event) throws IOException {
        
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("/com/pidev/views/RentProd.fxml"));
        Parent p = Loader.load();
        RentProdController cont = Loader.getController();
        cont.setRentprod(p1);
        cont.init();

        rateProducts.getChildren().clear();
        rateProducts.getChildren().setAll(p);
    }

    @FXML
    private void details2(ActionEvent event) throws IOException {
          FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("/com/pidev/views/RentProd.fxml"));
        Parent p = Loader.load();
        RentProdController cont = Loader.getController();
        cont.setRentprod(p2);
        cont.init();

        rateProducts.getChildren().clear();
        rateProducts.getChildren().setAll(p);
    }

    @FXML
    private void details3(ActionEvent event) throws IOException {
          FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("/com/pidev/views/RentProd.fxml"));
        Parent p = Loader.load();
        RentProdController cont = Loader.getController();
        cont.setRentprod(p3);
        cont.init();

        rateProducts.getChildren().clear();
        rateProducts.getChildren().setAll(p);
    }

    @FXML
    private void details4(ActionEvent event) throws IOException {
          FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("/com/pidev/views/RentProd.fxml"));
        Parent p = Loader.load();
        RentProdController cont = Loader.getController();
        cont.setRentprod(p4);
        cont.init();

        rateProducts.getChildren().clear();
        rateProducts.getChildren().setAll(p);
    }
    
}
