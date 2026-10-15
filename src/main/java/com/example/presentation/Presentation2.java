
package com.example.presentation;

import com.example.dao.IDao;
import com.example.metier.IMetier;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Presentation2 {

    public static void main(String[] args) {
        try {
            // Lecture des classes déclarées dans la configuration
            String[] composants = lireConfiguration("config.txt");

            // Création dynamique de la source de données
            IDao source = (IDao) creerInstance(composants[0]);
            System.out.println("[CONTAINER] Source chargée : "
                    + source.getClass().getSimpleName());

            // Création de la couche métier
            IMetier service = (IMetier) creerInstance(composants[1]);
            System.out.println("[CONTAINER] Service chargé : "
                    + service.getClass().getSimpleName());

            // Association de la source de données au service métier
            connecter(source, service);

            // Lancement du traitement demandé
            double valeurFinale = service.calcul();
            System.out.println("Résultat du traitement = " + valeurFinale);

        } catch (Exception exception) {
            System.err.println(
                    "[ERREUR] Impossible de lancer l'application : "
                            + exception.getMessage()
            );
            exception.printStackTrace();
        }
    }

    /**
     * Récupère les deux noms de classes dans le fichier de configuration.
     */
    private static String[] lireConfiguration(String fichier)
            throws IOException {

        String[] classes = new String[2];

        try (BufferedReader lecteur =
                     new BufferedReader(new FileReader(fichier))) {

            for (int i = 0; i < classes.length; i++) {
                String ligne = lecteur.readLine();

                if (ligne == null || ligne.trim().isEmpty()) {
                    throw new IOException(
                            "Configuration incomplète dans " + fichier
                    );
                }

                classes[i] = ligne.trim();
            }
        }

        return classes;
    }

    /**
     * Crée un objet en utilisant le nom complet de sa classe.
     */
    private static Object creerInstance(String nomClasse)
            throws Exception {

        Class<?> type = Class.forName(nomClasse);
        Constructor<?> constructeur = type.getDeclaredConstructor();

        return constructeur.newInstance();
    }

    /**
     * Transmet le DAO à la couche métier par réflexion.
     */
    private static void connecter(IDao source, IMetier service)
            throws Exception {

        Method methode = service.getClass().getMethod(
                "setDao", IDao.class
        );

        methode.invoke(service, source);
    }
}
