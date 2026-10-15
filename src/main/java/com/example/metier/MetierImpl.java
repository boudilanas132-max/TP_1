
package com.example.metier;

import com.example.dao.IDao;

/**
 * Classe qui contient le traitement métier de l'application.
 * Elle utilise un objet DAO pour obtenir la donnée nécessaire
 * au calcul du résultat.
 */
public class MetierImpl implements IMetier {

    // Objet utilisé pour accéder aux données
    private IDao dao;

    /**
     * Définit la source de données à utiliser.
     *
     * @param dao objet chargé de fournir la valeur initiale
     */
    public void setDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {

        // Vérifie que la dépendance a bien été configurée
        if (dao == null) {
            throw new IllegalStateException(
                "Aucune source de données n'est définie."
            );
        }

        // Lecture de la valeur nécessaire au traitement
        double valeur = dao.getValue();

        // Application de la règle de calcul métier
        double resultatFinal = valeur * 2;

        System.out.println(
            "[METIER] Résultat du traitement : " + resultatFinal
        );

        return resultatFinal;
    }
}
