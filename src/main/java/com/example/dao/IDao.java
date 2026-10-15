
package com.example.dao;

/**
 * Contrat de la couche d'accès aux données (DAO).
 * Cette interface permet de standardiser la récupération
 * d'une donnée numérique, quelle que soit son origine.
 *
 * Chaque classe qui implémente IDao doit préciser
 * comment la valeur demandée sera obtenue.
 *
 * Exemple d'appel :
 * IDao source = new DaoImpl();
 * double valeurObtenue = source.getValue();
 * System.out.println("Valeur : " + valeurObtenue);
 *
 * @author Etudiant
 * @version 1.0
 */
public interface IDao {

    /**
     * Déclare l'opération de lecture d'une valeur numérique.
     *
     * @return un nombre de type double.
     */
    double getValue();
}

