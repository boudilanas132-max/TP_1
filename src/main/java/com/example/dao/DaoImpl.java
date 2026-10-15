
package com.example.dao;

/**
 * Classe chargée de fournir une valeur à partir d'une source de données.
 * Elle représente une implémentation de l'interface IDao.
 */
public class DaoImpl implements IDao {

    @Override
    public double getValue() {
        // Simulation de la lecture d'une donnée externe
        System.out.println("[DAO] Lecture des données en cours...");

        double valeur = 100.0;
        return valeur;
    }
}
