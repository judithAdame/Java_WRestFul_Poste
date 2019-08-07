package com.latino.modele;

//import javax.xml.bind.annotation.XmlRootElement;
//
//@XmlRootElement
//public class Poste implements Serializable {
public class Poste {
    private int id;
    private String nom;
    private String langages;
    private String courriel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom.trim();
    }

    public void setNom(String nom) {
        this.nom = nom.trim();
    }

    public String getLangages() {
        return langages.trim();
    }

    public void setLangages(String langages) {
        this.langages = langages.trim();
    }

    public String getCourriel() {
        return courriel.trim();
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel.trim();
    }

    @Override
    public String toString() {
        return "Poste{" + "id=" + id + ", nom=" + nom + ", langages=" + langages + ", courriel=" + courriel + '}';
    }
}
