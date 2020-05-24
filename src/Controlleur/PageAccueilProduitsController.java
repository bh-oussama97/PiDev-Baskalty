/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Entite.categorie;
import Entite.produit;
import Service.ServiceCategorie;
import Service.ServiceProduit;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
import javafx.animation.FadeTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class PageAccueilProduitsController implements Initializable {

    @FXML
    private JFXButton magasin;
 
   
    @FXML
    private ImageView logout;
    @FXML
    private ImageView user;
    @FXML
    private Label bienvenue;
    @FXML
    public AnchorPane middle;
    @FXML
    private ComboBox<String> cat;
    @FXML
    private Label prixmaxlabel;
    @FXML
    private Slider prixmax;
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
    @FXML
    private Pagination paginator;
    @FXML
    private JFXTextField search;
    
    private static PageAccueilProduitsController instance;
    
      public PageAccueilProduitsController()
    {
       instance = this ;
    }
    
        public static PageAccueilProduitsController getInstance()
    {
        return instance;
    }
      
    List<categorie> liste = new ArrayList<>();
    ArrayList<produit> listeproduits = new ArrayList<>();
       produit p1,p2,p3,p4 = new produit();
    ServiceProduit produitservice = new ServiceProduit();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
           ServiceCategorie sc = new ServiceCategorie();
        liste = sc.afficher();
        
        liste.forEach((l) -> 
        {
              cat.getItems().add(l.getNom());
        });
        
        search.setStyle("-fx-text-inner-color: #cbcbc3;-fx-prompt-text-fill: #cbcbc3;");
        
          cat.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try 
                {
                    filtrerParCategorie(new ActionEvent());
                } 
                catch (SQLException ex) {
                    Logger.getLogger(ProduitsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
              //filtrage par prix ordre croissant et décroissant
         
        prixmax.setBlockIncrement(1);
        prixmax.setShowTickLabels(true);
        prixmax.setShowTickMarks(true);
        prixmax.setSnapToTicks(true);
        prixmax.setMax(1000);
        prixmax.setValue(prixmax.getMax());
        prixmaxlabel.setText(Double.toString(prixmax.getValue()));
        prixmax.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
               prixmax.setValue(newValue.intValue());
               prixmaxlabel.setText(Double.toString(prixmax.getValue()));
                try {
                    filtrerParPrixMax(new ActionEvent());
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ProduitsController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ProduitsController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        
        listeproduits = produitservice.afficher();
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
                 Logger.getLogger(ProduitsController.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
     
    }   
    
    
     private void filtrerParPrixMax(ActionEvent event) throws FileNotFoundException, SQLException 
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
    
    
     public void CreatePage(AnchorPane anchpane,String Location) throws IOException {
		
   
           AnchorPane Loader = FXMLLoader.load(getClass().getResource(Location));
           Node node = (Node) Loader;
           anchpane.getChildren().clear();
           anchpane.getChildren().add((Node) Loader);

	}
    
  /* private void setNode (Node node)
   {
       holderPane.getChildren().clear();
       holderPane.getChildren().add((Node) node);
       FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
   }
	public void createPage() {
		
        try {
            ajouter = FXMLLoader.load(getClass().getResource("/com/pidev/views/AjoutProduit.fxml"));
            setNode(ajouter);
        } catch (IOException ex) {
            Logger.getLogger(PageAccueilProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
	}*/

    @FXML
    private void ListeProduits(ActionEvent event) throws IOException {
        
            magasin.getScene().getWindow().hide();
            Stage produits = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/com/pidev/views/PageAccueilProduits.fxml"));
            Scene scene = new Scene(root,810,585);
            produits.setScene(scene);
            produits.show();
            produits.setResizable(true);

    }
    
     private void filtrerParCategorie (ActionEvent event) throws SQLException 
    {
        ServiceCategorie sc = new ServiceCategorie();
        ServiceProduit sp = new ServiceProduit();
        listeproduits = sp.RechercherProduitParCategorie(sc.getCategorieIdByNom(cat.getSelectionModel().getSelectedItem()));
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
            } catch (SQLException ex) {
                Logger.getLogger(ProduitsController.class.getName()).log(Level.SEVERE, null, ex);
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

        if (TroisAnnonces.size() >= 1) 
        {
            p1 = TroisAnnonces.get(0);
            box1.setVisible(true);
             FileInputStream input = null;
           input = new FileInputStream("src/Images/"+TroisAnnonces.get(0).getImage());
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
           input = new FileInputStream("src/Images/"+TroisAnnonces.get(1).getImage());
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

    
    @FXML
    private void mouselogout(MouseEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("/com/pidev/views/LoginMain.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show(); 
    }

    @FXML
    private void modiferuser(MouseEvent event) throws IOException {
        
       Parent root = FXMLLoader.load(getClass().getResource("/com/pidev/views/ModifierUser.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show(); 
    
    }

 

    @FXML
    private void monpanier(ActionEvent event) throws IOException {
        
         
         AnchorPane AjouterProduit = FXMLLoader.load(getClass().getResource("/com/pidev/views/PanierInternaute.fxml"));
           Node node = (Node) AjouterProduit;
           middle.getChildren().clear();
           middle.getChildren().add((Node) AjouterProduit);
           FadeTransition ft = new FadeTransition(Duration.millis(1500));
           ft.setNode(AjouterProduit);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    @FXML
    private void Commander(ActionEvent event) throws IOException {
        
         AnchorPane commander = FXMLLoader.load(getClass().getResource("/com/pidev/views/CommanderProduit.fxml"));
           Node node = (Node) commander;
           middle.getChildren().clear();
           middle.getChildren().add((Node) commander);
           
           FadeTransition ft = new FadeTransition(Duration.millis(1500));
           ft.setNode(commander);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    @FXML
    private void details0(ActionEvent event) throws SQLException, IOException {
        
        AnchorPane details = FXMLLoader.load(getClass().getResource("/com/pidev/views/DetailsProduit.fxml"));
        middle.getChildren().clear();
        middle.getChildren().add((Node) details);
        
        
        DetailsProduitController.getInstance().setproduit(p1);
        DetailsProduitController.getInstance().init();
        
       
    }

    @FXML
    private void details1(ActionEvent event) throws IOException, SQLException {
         AnchorPane details = FXMLLoader.load(getClass().getResource("/com/pidev/views/DetailsProduit.fxml"));
        middle.getChildren().clear();
        middle.getChildren().add((Node) details);
        
        
        DetailsProduitController.getInstance().setproduit(p2);
        DetailsProduitController.getInstance().init();
    }

    @FXML
    private void details3(ActionEvent event) throws IOException, SQLException {
         AnchorPane details = FXMLLoader.load(getClass().getResource("/com/pidev/views/DetailsProduit.fxml"));
        middle.getChildren().clear();
        middle.getChildren().add((Node) details);
        
        
        DetailsProduitController.getInstance().setproduit(p3);
        DetailsProduitController.getInstance().init();
    }

    @FXML
    private void details14(ActionEvent event) throws IOException, SQLException {
         AnchorPane details = FXMLLoader.load(getClass().getResource("/com/pidev/views/DetailsProduit.fxml"));
        middle.getChildren().clear();
        middle.getChildren().add((Node) details);
        
        
        DetailsProduitController.getInstance().setproduit(p4);
        DetailsProduitController.getInstance().init();
    }

    @FXML
    private void recherche(ActionEvent event) throws FileNotFoundException, SQLException {
          listeproduits = new ArrayList<>(produitservice.RechercherProduitParNom(search.getText()));
        setNbPages();
        try {
            initAnnoncePage(0);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

   

    }
    

