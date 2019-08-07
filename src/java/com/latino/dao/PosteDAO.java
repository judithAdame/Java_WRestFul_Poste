package com.latino.dao;

import com.latino.modele.Poste;
import com.latino.utilitarie.DataManagerMySQL;
//import com.latino.utilitarie.DataManagerOracle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PosteDAO {
        public static int add(Poste poste) {
        int res =0;
        try {
            String requete =  "INSERT INTO poste (nom, courriel, langages) VALUES (?,?,?)";
            PreparedStatement stm = DataManagerMySQL.getConnexion().prepareStatement(requete);
            stm.setString(1, poste.getNom());
            stm.setString(2, poste.getCourriel());
            stm.setString(3, poste.getLangages());
            res = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PosteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return res;
    }
            
    public static int update(int id, Poste poste) {
        int res =0;
        if (isPoste(id)) {
            try {
                String requete = "UPDATE poste SET Nom=?,Courriel=?, Langages=? WHERE Id=?";
                PreparedStatement stm = DataManagerMySQL.getConnexion().prepareStatement(requete);
                stm.setString(1, poste.getNom());
                stm.setString(2, poste.getCourriel());
                stm.setString(3, poste.getLangages());
                stm.setInt(4, id);
                res = stm.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(PosteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return res;    
    }

    public static int delete(int id) {
        int res =0;
        if (isPoste(id)) {
            try {
                String requete = "DELETE FROM poste WHERE id=?";
                PreparedStatement stm = DataManagerMySQL.getConnexion().prepareStatement(requete);
                stm.setInt(1, id);
                res = stm.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(PosteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }        
        }        
        return res;    
    }

    public static List<Poste> getAll(){
        List<Poste> postes = new ArrayList();
        try {
            String requete =  "SELECT id, nom, courriel, langages FROM POSTE";
            Statement stm = DataManagerMySQL.getConnexion().createStatement();
            ResultSet resultats = stm.executeQuery(requete);
            Poste p;
            while (resultats.next()) {
                p=new Poste();
                p.setId(resultats.getInt("id"));
                p.setNom(resultats.getString("nom"));
                p.setCourriel(resultats.getString("courriel"));
                p.setLangages(resultats.getString("langages"));
                postes.add(p);
            }
        }catch (SQLException ex) {
            Logger.getLogger(PosteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return postes;
    }

    public static Poste getById(int id){
        Poste poste =null;
        if (isPoste(id)) {
            try {
                String requete = "SELECT ID, NOM, COURRIEL, LANGAGES FROM poste WHERE ID=?";
                PreparedStatement stm = DataManagerMySQL.getConnexion().prepareStatement(requete);
                stm.setInt(1, id);
                ResultSet resultats = stm.executeQuery();
                if (resultats.next()) {
                    poste = new Poste();
                    poste.setId(resultats.getInt("ID"));
                    poste.setNom(resultats.getString("NOM"));
                    poste.setCourriel(resultats.getString("COURRIEL"));
                    poste.setLangages(resultats.getString("LANGAGES"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(PosteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
        return poste;
    }

    private static boolean isPoste(int id){
        try {
            String requete = "SELECT ID, NOM, COURRIEL, LANGAGES FROM poste WHERE ID=?";
            PreparedStatement stm = DataManagerMySQL.getConnexion().prepareStatement(requete);
            stm.setInt(1, id);
            ResultSet resultats = stm.executeQuery();
            if (resultats.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PosteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return false;
    }

    public static List<Poste> getByLangages(int nbMath, String lPostulants){
        List<Poste> postes = new ArrayList();
        try {
            String requete =  "SELECT ID, NOM, COURRIEL, LANGAGES FROM POSTE";
            Statement stm = DataManagerMySQL.getConnexion().createStatement();
            ResultSet resultats = stm.executeQuery(requete);
            Poste p;
            while (resultats.next()) {
                p=new Poste();
                p.setId(resultats.getInt("ID"));
                p.setNom(resultats.getString("NOM"));
                p.setCourriel(resultats.getString("COURRIEL"));
                p.setLangages(resultats.getString("LANGAGES"));
                if ((isMatch(nbMath, lPostulants,p))) {
                    postes.add(p);
                }
            }
        }catch (SQLException ex) {
            Logger.getLogger(PosteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return postes;
    }
        public static boolean isMatch(int nbMath, String postulants, Poste p) {
        int i=0;
        List<String> lPostulants = Arrays.asList(postulants.split(","));
        List<String> lPostes = Arrays.asList(p.getLangages().split(","));
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
    
    private static int validerNbMatch(int nb, int nbPostulants, int nbPoste){
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
