package com.example.dao;

/**
 * Fournit une source de données simplifiée
 * pour tester le fonctionnement de l'application.
 */
public class DaoImpl2 implements IDao2 {

    private final double valeurInitiale = 150.0;

    @Override
    public double getValue() {
        System.out.println("[DAO] La donnée est prête à être utilisée.");
        return valeurInitiale;
    }
}