/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_simulacion;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.net.URL;
import static javafx.application.ConditionalFeature.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 *
 * @author Usuario
 */
public class FXM_tp1Simulacion extends Application {
    
    
    
    @Override
    public void start(Stage stage) throws Exception {
        URL urlEscena1 = getClass().getResource("FX_tp1Simulacion.fxml");
        Parent root = FXMLLoader.load(urlEscena1);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Trabajo Practico 1 - Simulación");
        stage.show();
        
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
