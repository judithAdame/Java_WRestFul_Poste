package com.latino.modele;

//import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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

    public boolean isMatch(int nbMath, String postulants) {
        int i=0;
        List<String> lPostulants = Arrays.asList(postulants.split(","));
        List<String> lPostes = Arrays.asList(this.getLangages().split(","));
        nbMath = validerNbMatch(nbMath, lPostulants.size(), lPostes.size());
        if (nbMath == -1) 
                return false;
        for (String lposte: lPostes) {
            lposte = lposte.toUpperCase().trim();
            for (String lpostulant: lPostulants) {
                lpostulant = lpostulant.toUpperCase().trim();
                if (lposte.equals(lpostulant)) {
                    i++;
                }
            }
        }        
        return ((i>=nbMath));
    }
    
    private int validerNbMatch(int nb, int nbPostulants, int nbPoste){
        int nbValide = -1;
        if (nb<0) {
            nbValide = -1;
        }
        else if (nb>nbPostulants){
            nbValide =nbPostulants;
        }
        else if (nb>nbPoste){
            nbValide = -1;
        }
        else 
            nbValide = nb;
        return nbValide;
    }
}
