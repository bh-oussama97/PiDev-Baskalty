/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entite.User;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author dell is hell
 */
public class MainVendeur extends Application {
    public static User user = new User(28, "yahya", "123456789");
    @Override
    public void start(Stage primaryStage) throws IOException {
      Parent root = FXMLLoader.load(getClass().getResource("/com/pidev/views/AccueilVendeur.fxml"));
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Baskalty");
         

        primaryStage.setScene(scene);
        primaryStage.show();
       primaryStage.setResizable(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
