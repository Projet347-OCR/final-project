/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet22;

import Entities.Personne;
import Services.PersonneService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;



public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Label url;
    @FXML
    private TextField nom;
    @FXML
    private Label label1;
    @FXML
    private TextField prenom;
    @FXML
    private Label label2;
    @FXML
    private TextField nation;
    @FXML
    private TextField sexe;
    @FXML
    private Label label21;
    @FXML
    private Label label211;
    @FXML
    private TextField date_naiss;
    @FXML
    private Label label3;
    @FXML
    private TextField lieu;
    @FXML
    private Label label31;
    @FXML
    private TextField document_no;
    @FXML
    private Label label2111;
    @FXML
    private TextField date_dexpir;
    @FXML
    private TextField taille;
    @FXML
    private Label label212;
    @FXML
    private TextField adresse;
    @FXML
    private Label label2121;
    @FXML
    private Label label2112;
    @FXML
    private TextField type_piece;
    @FXML
    private Label label2113;
    @FXML
    private TextField pays;
    @FXML
    private TextField date_deliv;
    @FXML
    private Label label21121;
    @FXML
    private Label label2114;
    @FXML
    private TextField nom_utilisa;
    @FXML
    private Label label2115;
    @FXML
    private TextField mot_passe;
    
    
    PersonneService ps = new PersonneService();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.url.setText("");
    }    

    @FXML
    private void choosefile(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File file;
        file = fc.showOpenDialog(null);
        String path = file.getPath();
        url.setText(path);
    }

    @FXML
    private void importer(ActionEvent event) throws IOException, JSONException {
        String result = "";
        if(this.url.getText()!=""){
             
            String encodedurl = URLEncoder.encode(this.url.getText(),"UTF-8");
            System.out.println("URL:"+encodedurl);
            HttpGet request = new HttpGet("http://127.0.0.1:9000/api?path="+encodedurl);


            try (CloseableHttpClient httpClient = HttpClients.createDefault();
                CloseableHttpResponse response = httpClient.execute(request)) {
                
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    result=EntityUtils.toString(entity);
                    System.out.println(result);
                    JSONObject obj = new JSONObject(result);
          
                    
                    if(obj.has("NOM")){
                        this.nom.setText(obj.getString("NOM"));
                    }
                    if(obj.has("DATE DE NAISS / DATE OF BIRTH")){
                        this.date_naiss.setText(obj.getString("DATE DE NAISS / DATE OF BIRTH"));
                    }
                    if(obj.has("DATE DEXPIR:")){
                        this.date_dexpir.setText(obj.getString("DATE DEXPIR:"));
                    }
                    if(obj.has("LIEU DE NAISSANCE")){
                        this.lieu.setText(obj.getString("LIEU DE NAISSANCE"));
                    }
                    if(obj.has("N DU DOCUMENT / DOCUMENT NO")){
                        this.document_no.setText(obj.getString("N DU DOCUMENT / DOCUMENT NO"));
                    }
                    if(obj.has("NATIONALITÉ")){
                        this.nation.setText(obj.getString("NATIONALITÉ"));
                    }
                    if(obj.has("PRÉNOMS")){
                        this.prenom.setText(obj.getString("PRÉNOMS"));
                    }
                    if(obj.has("SEXE")){
                        this.sexe.setText(obj.getString("SEXE"));
                    }
                    if(obj.has("TYPE DE PIECE")){
                        this.type_piece.setText(obj.getString("TYPE DE PIECE"));
                    }
                    if(obj.has("ADRESSE")){
                        this.adresse.setText(obj.getString("ADRESSE"));
                    }
                    if(obj.has("DATE DE DÉLIVRANCE")){
                        this.date_deliv.setText(obj.getString("DATE DE DÉLIVRANCE"));
                    }
                    if(obj.has("PAYS")){
                        this.pays.setText(obj.getString("PAYS"));
                    }  
                    if(obj.has("TAILLE / HEIGHT")){
                        this.taille.setText(obj.getString("TAILLE / HEIGHT"));
                    } 
                    
                    this.url.setText("");
                }
            }
        }
        else{
            System.out.println("select a file first");
        }
        
        
    }

    @FXML
    private void valider(ActionEvent event) throws SQLException, IOException {
        if(!this.nom_utilisa.getText().equals("") && !this.mot_passe.getText().equals("")){
            Personne p=new Personne(nom.getText(), prenom.getText(), sexe.getText(), nation.getText(), pays.getText(), date_naiss.getText(), lieu.getText(), document_no.getText(), date_deliv.getText(), date_dexpir.getText(), type_piece.getText(), taille.getText(), adresse.getText(), nom_utilisa.getText(), mot_passe.getText());
            ps.add(p);
            
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("Acceuil.fxml"));
            Parent parent = Loader.load();

            AcceuilController c = Loader.getController();
            c.setData(p);
            
            Scene scene = new Scene(parent);
            Stage window = (Stage) nom.getScene().getWindow();
            window.setScene(scene);
            window.show();
        }
    }

    @FXML
    private void annuler(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.close();
                
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Login.fxml")));
                stage.setScene(scene);
                stage.show();
    }

    @FXML
    private void recom(ActionEvent event) {
        nom.clear();
        adresse.clear();
        date_deliv.clear();
        date_dexpir.clear();
        document_no.clear();
        date_naiss.clear();
        lieu.clear();
        mot_passe.clear();
        nation.clear();
        nom.clear();
        nom_utilisa.clear();
        pays.clear();
        prenom.clear();
        sexe.clear();
        taille.clear();
        type_piece.clear();
        
        
    }
    
}
