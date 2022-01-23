/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet22;

import Entities.Personne;
import Services.PersonneService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField pwd;
    
    PersonneService ps = new PersonneService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) throws IOException, SQLException {
        
        
        Personne p=ps.Connect(username.getText(), pwd.getText());
        if(p!=null){
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("Acceuil.fxml"));
            Parent parent = Loader.load();

            AcceuilController c = Loader.getController();
            c.setData(p);

            Scene scene = new Scene(parent);
            Stage window = (Stage) username.getScene().getWindow();
            window.setScene(scene);
            window.show();
        }
        else{
            System.out.println("nom d'utilisateur ou mot de passe incorrect!");
        }
        
    }

    @FXML
    private void creerCompte(ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
            Parent parent = Loader.load();

            Scene scene = new Scene(parent);
            Stage window = (Stage) username.getScene().getWindow();
            window.setScene(scene);
            window.show();
        
    }
    
}
