/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.tests;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author benha
 */
public class Baskalty extends Application {

    @Override
    public void start(Stage stage) throws IOException {

       
            //FXMLLoader loader = new FXMLLoader(getClass().getResource(""));
         Parent root = FXMLLoader.load(getClass().getResource("/com/pidev/views/Produits.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Baskalty");
        stage.setScene(scene);
        stage.show();

    }

  
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
