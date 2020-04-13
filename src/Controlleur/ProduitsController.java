/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class ProduitsController implements Initializable 
{

    @FXML
    private Label prixmaxlabel;
    @FXML
    private ComboBox<String> cat;
    @FXML
    private Slider prixmax;
    @FXML
    private Slider prixmin;


    @FXML
    private ImageView backToHome;
    @FXML
    private JFXTextField search;
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
    @FXML
    private Label prixminlabel;


    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
       
         ServiceCategorie sc = new ServiceCategorie();
        listecategorie = sc.afficher();
        
        listecategorie.forEach((l) -> {
              cat.getItems().add(l.getNom());
        });
//filtrage catégorie
     cat.setItems(cat.getItems().stream().distinct().collect(Collectors.toCollection(FXCollections::observableArrayList)));
         cat.getSelectionModel().select("");
         
         cat.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                filtrerParCategorie(new ActionEvent());
            }
        });
         
         //filtrage par prix ordre croissant et décroissant
         
        prixmax.setBlockIncrement(1);
        prixmax.setShowTickLabels(true);
        prixmax.setShowTickMarks(true);
        prixmax.setSnapToTicks(true);        
        prixmin.setBlockIncrement(1);
        prixmin.setShowTickLabels(true);
        prixmin.setShowTickMarks(true);
        prixmin.setSnapToTicks(true);
        
      /*   prixmax.setMax(listeproduits.stream().map((produit::getPrix).max(Integer::compare).get());
            
        prixmax.setMin(listeproduits.stream().map(produit::getPrix).min(Float::compare).get());   
        prixmin.setMax(listeproduits.stream().map(produit::getPrix).max(Float::compare).get());
        prixmin.setMin(listeproduits.stream().map(produit::getPrix).min(Float::compare).get());*/
        prixmax.setMax(1000);
        prixmax.setMin(0);
        prixmin.setMax(0);
        prixmin.setMin(1000);
        prixmin.setValue(prixmin.getMin());
        prixmax.setValue(prixmax.getMax());
        
        prixmaxlabel.setText(Double.toString(prixmax.getValue()));
        prixminlabel.setText(Double.toString(prixmin.getValue()));
        
        prixmax.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
               prixmax.setValue(newValue.intValue());
                prixmaxlabel.setText(String.format("%.2f", prixmax.getValue()));
                filtrerParPrixMax(new ActionEvent());

            }
        });
        prixmin.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
               prixmin.setValue(newValue.intValue());
                prixminlabel.setText(String.format("%.2f", prixmin.getValue()));
                filterParPrixMin(new ActionEvent());

            }
        });
        
        search.setStyle("-fx-text-inner-color: #cbcbc3;");
        
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
            }
        }
    }
    
    private void filterParPrixMin(ActionEvent event) 
    {
        ServiceProduit sp = new ServiceProduit();
        listeproduits = sp.FiltrerProduitsParOrdreDecroissant((int)prixmin.getValue());
       
        if (listeproduits.isEmpty()) {
            box1.setVisible(false);
            box3.setVisible(false);
            box2.setVisible(false);
            box4.setVisible(false);
            //ide.setVisible(true);
            paginator.setVisible(false);
        } else {
            paginator.setVisible(true);
            //vide.setVisible(false);
            setNbPages();
            try {
                initAnnoncePage(0);
            } catch (IOException ex) {
                Logger.getLogger(ProduitsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    private void filtrerParPrixMax(ActionEvent event) 
    {
        ServiceProduit sp = new ServiceProduit();
        listeproduits = sp.FiltrerProduitsParOrdreCroissant((int) prixmax.getValue());
       
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
            }
        }

    }

    private void filtrerParCategorie (ActionEvent event) 
    {
        ServiceProduit sp = new ServiceProduit();
        listeproduits = sp.RechercherProduitParCategorie(cat.getSelectionModel().getSelectedItem());
        if (listeproduits.isEmpty()) {
            box1.setVisible(false);
            box2.setVisible(false);
            box3.setVisible(false);
            box4.setVisible(false);
            //ide.setVisible(true);
            paginator.setVisible(false);
        } else {
            paginator.setVisible(true);
         
            setNbPages();
            try {
                initAnnoncePage(0);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
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

   

   /*public void putImageViewer(String path){
            FileInputStream input = null;
      
        try {
            input = new FileInputStream("src/images/"+path);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
            Image imageFile = new Image(input);
            image1.setImage(imageFile);
           
            
        try {
            input.close();
        } catch (IOException ex) {
            Logger.getLogger(ProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        }    */
    
    private void initAnnoncePage(int i) throws FileNotFoundException, IOException 
    {
        ServiceProduit sp = new ServiceProduit();

        paginator.setCurrentPageIndex(i);
        List<produit> TroisAnnonces = getAnnoncesPage(i);

        if (TroisAnnonces.size() >= 1) 
        {
            p1 = TroisAnnonces.get(0);
            box1.setVisible(true);
             FileInputStream input = null;
           input = new FileInputStream("src/images/"+TroisAnnonces.get(0).getImage());
            Image imageFile = new Image(input);
            image1.setImage(imageFile);
             input.close();
           image1.setImage(imageFile);
            categorie1.setText(TroisAnnonces.get(0).getCategorie());
            nom1.setText(TroisAnnonces.get(0).getNom());
            prix1.setText(Float.toString((float) TroisAnnonces.get(0).getPrix()) + "DT");
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
            categorie2.setText(TroisAnnonces.get(1).getCategorie());
            nom2.setText(TroisAnnonces.get(1).getNom());
            prix2.setText(Float.toString((float) TroisAnnonces.get(1).getPrix()) + "DT");
            reference2.setText(TroisAnnonces.get(1).getReference());
          

        } else {
            box2.setVisible(false);
        }

        if (TroisAnnonces.size() >= 3) 
        {
           
            box3.setVisible(true);
           p3 = TroisAnnonces.get(2);
            categorie3.setText(TroisAnnonces.get(2).getCategorie());
             FileInputStream input = null;
           input = new FileInputStream("src/images/"+TroisAnnonces.get(2).getImage());
            Image imageFile = new Image(input);
            image3.setImage(imageFile);
             input.close();
           image3.setImage(imageFile);
            
            nom3.setText(TroisAnnonces.get(2).getNom());
            prix3.setText(Float.toString((float) TroisAnnonces.get(2).getPrix()) + "DT");
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
            categorie4.setText(TroisAnnonces.get(3).getCategorie());
             FileInputStream input = null;
           input = new FileInputStream("src/images/"+TroisAnnonces.get(3).getImage());
            Image imageFile = new Image(input);
            image4.setImage(imageFile);
             input.close();
           image4.setImage(imageFile);
            nom4.setText(TroisAnnonces.get(3).getNom());
            prix4.setText(Float.toString((float) TroisAnnonces.get(3).getPrix()) + "DT");
            reference4.setText(TroisAnnonces.get(3).getReference());
   

        } else 
        {
            box4.setVisible(false);
        }
    }


    @FXML
    private void RetourPageAccueils(MouseEvent event) {
        try {
              
            backToHome.getScene().getWindow().hide();
            Stage produits = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/com/pidev/views/PageAccueilProduits.fxml"));
            Scene scene = new Scene(root);
            produits.setScene(scene);
            produits.show();
            produits.setResizable(false);

        } catch (Exception e) {
            System.out.println(" Error  : " + e);
        }
        
    }
    
    @FXML
     private void recherche(ActionEvent event) {
        listeproduits = new ArrayList<>(produitservice.RechercherProduitParNom(search.getText()));
        setNbPages();
        try {
            initAnnoncePage(0);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

      @FXML
    private void details0(ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("/com/pidev/views/DetailsProduit.fxml"));
        Parent p = Loader.load();
        DetailsProduitController cont = Loader.getController();
        cont.setproduit(p1);
        cont.init();

        AnchorPane pane = (AnchorPane) image1.getParent().getParent().getParent();
        pane.getChildren().clear();
        pane.getChildren().setAll(p);

    }

    @FXML
    private void details1(ActionEvent event)
    {
        try {
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/com/pidev/views/DetailsProduit.fxml"));
            
            
            Parent  par = Loader.load();
            
            
            DetailsProduitController cont = Loader.getController();
            cont.setproduit(p2);
            cont.init();
            
            AnchorPane pane = (AnchorPane) image2.getParent().getParent().getParent();
            pane.getChildren().clear();
            pane.getChildren().setAll(par);
        } catch (IOException ex) {
            Logger.getLogger(ProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void details3(ActionEvent event) {
        
        try {
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/com/pidev/views/DetailsProduit.fxml"));
            
            
            Parent  par = Loader.load();
            
            
            DetailsProduitController cont = Loader.getController();
            cont.setproduit(p3);
            cont.init();
            
            AnchorPane pane = (AnchorPane) image3.getParent().getParent().getParent();
            pane.getChildren().clear();
            pane.getChildren().setAll(par);
        } catch (IOException ex) {
            Logger.getLogger(ProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void details14(ActionEvent event) {
        
         try {
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/com/pidev/views/DetailsProduit.fxml"));
            
            
            Parent  par = Loader.load();
            
            
            DetailsProduitController cont = Loader.getController();
            cont.setproduit(p4);
            cont.init();
            
            AnchorPane pane = (AnchorPane) image4.getParent().getParent().getParent();
            pane.getChildren().clear();
            pane.getChildren().setAll(par);
        } catch (IOException ex) {
            Logger.getLogger(ProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
   

   
}


/*  public void setlabelNom(String nom)
       {
           this.lnom.setText(nom);
       }
      
      public void setlabelCategorie(String categorie)
      {
          this.lcategorie.setText(categorie);
      }
    public void setlabelreference (String reference)
    {
        this.lreference.setText(reference);
    }
    public void setlabelPrix (String prix)
    {
        this.lprix.setText(prix);
    }
         
        
        public void setImageViewer(String image)
        {
          Image img = new Image("C:/Users/benha/OneDrive/Documents/NetBeansProjects/Baskalty/src/images/"+image);
          this.image1.setImage(img);
        }*/
