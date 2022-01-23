/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


public class Personne {
   private int id;
   private String nom;
   private String prenom;
   private String sexe;
   private String nationalite;
   private String pays;
   private String date_naiss;
   private String lieu_naiss;
   private String doc_no;
   private String date_deliv;
   private String date_dexpir;
   private String type_piece;
   private String taille;
   private String adresse;
   private String nom_utilisa;
   private String mot_passe;

    public Personne() {
    }

    public Personne(String nom, String prenom, String sexe, String nationalite, String pays, String date_naiss, String lieu_naiss, String doc_no, String date_deliv, String date_dexpir, String type_piece, String taille, String adresse, String nom_utilisa, String mot_passe) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.nationalite = nationalite;
        this.pays = pays;
        this.date_naiss = date_naiss;
        this.lieu_naiss = lieu_naiss;
        this.doc_no = doc_no;
        this.date_deliv = date_deliv;
        this.date_dexpir = date_dexpir;
        this.type_piece = type_piece;
        this.taille = taille;
        this.adresse = adresse;
        this.nom_utilisa = nom_utilisa;
        this.mot_passe = mot_passe;
    }

    public Personne(int id, String nom, String prenom, String sexe, String nationalite, String pays, String date_naiss, String lieu_naiss, String doc_no, String date_deliv, String date_dexpir, String type_piece, String taille, String adresse, String nom_utilisa, String mot_passe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.nationalite = nationalite;
        this.pays = pays;
        this.date_naiss = date_naiss;
        this.lieu_naiss = lieu_naiss;
        this.doc_no = doc_no;
        this.date_deliv = date_deliv;
        this.date_dexpir = date_dexpir;
        this.type_piece = type_piece;
        this.taille = taille;
        this.adresse = adresse;
        this.nom_utilisa = nom_utilisa;
        this.mot_passe = mot_passe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(String date_naiss) {
        this.date_naiss = date_naiss;
    }

    public String getLieu_naiss() {
        return lieu_naiss;
    }

    public void setLieu_naiss(String lieu_naiss) {
        this.lieu_naiss = lieu_naiss;
    }

    public String getDoc_no() {
        return doc_no;
    }

    public void setDoc_no(String doc_no) {
        this.doc_no = doc_no;
    }

    public String getDate_deliv() {
        return date_deliv;
    }

    public void setDate_deliv(String date_deliv) {
        this.date_deliv = date_deliv;
    }

    public String getDate_dexpir() {
        return date_dexpir;
    }

    public void setDate_dexpir(String date_dexpir) {
        this.date_dexpir = date_dexpir;
    }

    public String getType_piece() {
        return type_piece;
    }

    public void setType_piece(String type_piece) {
        this.type_piece = type_piece;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNom_utilisa() {
        return nom_utilisa;
    }

    public void setNom_utilisa(String nom_utilisa) {
        this.nom_utilisa = nom_utilisa;
    }

    public String getMot_passe() {
        return mot_passe;
    }

    public void setMot_passe(String mot_passe) {
        this.mot_passe = mot_passe;
    }
   
   
   
}
