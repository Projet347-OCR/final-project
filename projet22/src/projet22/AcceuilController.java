/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet22;

import Entities.Personne;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class AcceuilController implements Initializable {

    @FXML
    private AnchorPane affichage;

    
    Personne p=new Personne();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void profile(ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("Profile.fxml"));
        Parent parent = Loader.load();
        AnchorPane root = (AnchorPane) parent;
        
        ProfileController c = Loader.getController();
        c.setData(p);
        affichage.getChildren().setAll(root);
    }

    
    public void setData(Personne pers) {
        p= pers;
    }

    @FXML
    private void deconnecter(ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("Login.fxml"));
            Parent parent = Loader.load();

            Scene scene = new Scene(parent);
            Stage window = (Stage) affichage.getScene().getWindow();
            window.setScene(scene);
            window.show();
    }
    
}
