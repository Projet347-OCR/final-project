/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet22;

import Entities.Personne;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;


public class ProfileController implements Initializable {

    @FXML
    private Text nom;
    @FXML
    private Text prenom;
    
    Personne p=new Personne();
    @FXML
    private Text dateN;
    @FXML
    private Text sexe;
    @FXML
    private Text date1;
    @FXML
    private Text nation;
    @FXML
    private Text lieudenai;
    @FXML
    private Text numdoc;
    @FXML
    private Text dateDeliv;
    @FXML
    private Text expir;
    @FXML
    private Text typeDeP;
    @FXML
    private Text taille;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
    public void setData(Personne pers) {
        p= pers;
        this.nom.setText(p.getNom());
        this.prenom.setText(p.getPrenom());
        this.dateN.setText(p.getDate_naiss());
        this.sexe.setText(p.getSexe());
        this.date1.setText(p.getPays());
        this.dateDeliv.setText(p.getDate_deliv());
        this.nation.setText(p.getNationalite());
        this.lieudenai.setText(p.getLieu_naiss());
        this.numdoc.setText(p.getDoc_no());
        this.expir.setText(p.getDate_dexpir());
        this.typeDeP.setText(p.getType_piece());
        this.taille.setText(p.getTaille());
    }
    
}
