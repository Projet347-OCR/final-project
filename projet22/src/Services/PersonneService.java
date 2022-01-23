/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Tools.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Entities.Personne;

public class PersonneService {
    private Connection con;
    private Statement ste;

    public PersonneService() {
        con = Database.getInstance().getConnection();
    }
    
    public void add(Personne t) throws SQLException {
        String requeteInsert;
        requeteInsert = "INSERT INTO `projet22`.`personne` (`nom`,`prenom`,`sexe`,`nationalite`,`pays`,`date_naiss`,`lieu_naiss`,`doc_no`,`date_deliv`,`date_dexpir`,`type_piece`,`taille`,`adresse`,`nom_utilisa`,`mot_passe`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
          
        PreparedStatement PS = con.prepareStatement(requeteInsert);
        PS.setString(1, t.getNom());
        PS.setString(2, t.getPrenom());
        PS.setString(3,t.getSexe());
        PS.setString(4, t.getNationalite());
        PS.setString(5,String.valueOf(t.getPays()));
        PS.setString(6,String.valueOf(t.getDate_naiss()));
        PS.setString(7,String.valueOf(t.getLieu_naiss()));
        PS.setString(8,String.valueOf(t.getDoc_no()));
        PS.setString(9,String.valueOf(t.getDate_deliv()));
        PS.setString(10,String.valueOf(t.getDate_dexpir()));
        PS.setString(11,String.valueOf(t.getType_piece()));
        PS.setString(12,String.valueOf(t.getTaille()));
        PS.setString(13,String.valueOf(t.getAdresse()));
        PS.setString(14,String.valueOf(t.getNom_utilisa()));
        PS.setString(15,String.valueOf(t.getMot_passe()));
        
       
        PS.executeUpdate();
    }

  
    public Personne Connect(String nom_utilisa,String mot_passe) throws SQLException {
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from personne where nom_utilisa='"+nom_utilisa+"' and mot_passe='"+mot_passe+"'");
        while (rs.next()) {  
            Personne p=new Personne(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("sexe"), rs.getString("nationalite"), rs.getString("pays"), rs.getString("date_naiss"), rs.getString("lieu_naiss"), rs.getString("doc_no"), rs.getString("date_deliv"), rs.getString("date_dexpir"), rs.getString("type_piece"), rs.getString("taille"), rs.getString("adresse"),rs.getString("nom_utilisa"), rs.getString("mot_passe"));
            return p;
        }
        return null; 
    }
    
}
