package com.example.metier;

import com.example.dao.IDao;

/**
 * Effectue le traitement métier à partir
 * d'une valeur fournie par la couche DAO.
 */
public class MetierImpl2 implements IMetier2 {

    private IDao dao;

    /**
     * Initialise la dépendance nécessaire au calcul.
     *
     * @param source objet qui fournit les données
     */
    public void setDao(IDao source) {
        this.dao = source;
    }

    @Override
    public double calcul() {
        if (dao == null) {
            throw new IllegalStateException(
                "Impossible de calculer : aucune source n'est configurée."
            );
        }

        double valeurRecue = dao.getValue();
        double resultat = valeurRecue * 3;

        System.out.println(
            "[METIER] Valeur calculée après traitement : " + resultat
        );

        return resultat;
    }
}