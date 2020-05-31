/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.categorie;
import Entite.produit;
import Service.ServiceCategorie;
import Service.ServiceProduit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import org.apache.commons.lang.RandomStringUtils;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class RentProductController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField reference;
    @FXML
    private TextArea description;
    @FXML
    private TextField prix;
    @FXML
    private TextField quantite;
    @FXML
    private ImageView imageV;
    List<categorie> liste = new ArrayList<>();
    /* public ComboBox<String> role;
    
    ObservableList<String> liste = FXCollections.observableArrayList("alegaeg","zjekngz");*/
    @FXML
    private AnchorPane ajout;
    @FXML
    private ComboBox<String> categorie;
    @FXML
    private Button btnimage;

    ServiceCategorie scat = new ServiceCategorie();

    ServiceProduit spro = new ServiceProduit();
    @FXML
    private Button btnmodifier;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ServiceCategorie sc = new ServiceCategorie();
        liste = sc.afficher();

        liste.forEach((l) -> {
            categorie.getItems().add(l.getNom());

        });

    }

    public static String saveToFileImageNormal(Image image) throws SQLException, IOException {

        String ext = "jpg";
        File dir = new File("src/Images");
        String name = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(8), ext);
        File outputFile = new File(dir, name);
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        ImageIO.write(bImage, "png", outputFile);
        return name;
    }

    
    
    @FXML
    private void addImage(ActionEvent event) {
        {
            FileChooser fc = new FileChooser();

            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (.png)", "*.PNG");
            fc.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
            File selectedFile = fc.showOpenDialog(null);
            try {
                BufferedImage bufferedImage = ImageIO.read(selectedFile);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                btnimage.setVisible(false);
                imageV.setImage(image);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @FXML
    private void ajouterProduit(ActionEvent event) throws SQLException {
        try {

            Image img = imageV.getImage();
            String nameImage1 = saveToFileImageNormal(img);

            if ( verifyFields() && verifCategory() && verifyNumber(quantite) && verifyNumber(prix)  ) {
                produit p = new produit(Integer.parseInt(quantite.getText()), LocalDateTime.now(), nom.getText(), reference.getText(), Integer.parseInt(prix.getText()), description.getText(), nameImage1, scat.getCategorieIdByNom(categorie.getValue()));
                spro.ajouter(p);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("Product successfully added !");
                alert.showAndWait();
                AnchorPane produitsvendeur = FXMLLoader.load(getClass().getResource("/com/pidev/views/Produitsrent.fxml"));
                Node node = (Node) produitsvendeur;
                ajout.getChildren().clear();
                ajout.getChildren().add((Node) produitsvendeur);
            }

        } catch (IOException ex) {
            Logger.getLogger(AjoutProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

   /* private boolean verifQuantityAndPrice() {
        if (Integer.parseInt(quantite.getText())< 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error !");
            alert.setHeaderText(null);
            alert.setContentText("quantity must be positive!");
            alert.showAndWait();
            quantite.clear();
            return false;
        } else if (Integer.parseInt(prix.getText()) < 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error !");
            alert.setHeaderText(null);
            alert.setContentText("Price must be positive !");
            alert.showAndWait();
            prix.clear();
            return false;
        } else {
            return true;
        }
    }*/

    private boolean verifyNumber(TextField textfieldNumber) {
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(textfieldNumber.getText());
        if (m.find() && m.group().equals(textfieldNumber.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Number");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter a Valid Number");
            alert.showAndWait();
            textfieldNumber.clear();
            return false;
        }
    }

    public boolean verifCategory() {
        if (categorie.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setHeaderText(null);
            alert.setContentText("Choose a category please !");
            alert.showAndWait();
            return false;
        } else {
            return true;
        }
    }

    public boolean verifyFields() {
        if (nom.getText().equals("") || reference.getText().equals("") || description.getText().equals("") || quantite.getText().equals("") || prix.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error !");
            alert.setHeaderText(null);
            alert.setContentText("Some Fields are empty !");
            alert.showAndWait();
            return false;
        } else {
            return true;
        }
    }

    private void RetourVersProduitsVendeur(MouseEvent event) throws IOException {

        AccueilVendeurController.getinstance().CreatePage(ajout, "/com/pidev/views/Produitsrent.fxml");
    }


    
}
