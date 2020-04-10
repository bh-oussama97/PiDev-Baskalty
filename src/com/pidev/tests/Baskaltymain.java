/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.tests;

import com.pidev.models.*;
import com.pidev.services.*;

/**
 *
 * @author benha
 */
public class Baskaltymain {

    public static void main(String[] args) {
        ServiceProduit sp = new ServiceProduit();
        System.out.println(" Liste des produits : ");
        sp.afficher().forEach(System.out::println);

        System.out.println("----------------------------------------------------------------------");

        ServiceCategorie sc = new ServiceCategorie();

        categorie c = new categorie("velooooooos");
        System.out.println(" Liste des catégories  : ");
        sc.afficher().forEach(System.out::println);

        System.out.println("----------------------------------------------------------------------");

        panier pa = new panier(2, 1, 3, 2600, "22/03/2020");

        ServicePanier spanier = new ServicePanier();
        
       // spanier.ajouter(pa);
        System.out.println("Contenu du panier  :");

        spanier.afficher().forEach(System.out::println);

        System.out.println("----------------------------------------------------------------------");

        ServiceCommande scom = new ServiceCommande();
        commande c1 = new commande(1, 2, "97321220", "monastir", "rue abdallah ayed 5015", "instructions livraisons balalal ", 600000);
        commande c2 = new commande(1, 3, "94813880", "SOUSSE", "rue hamda loued 5025 ", "lovjzenfajef ", 5000);
        //scom.ajouter(c1);
        // scom.ajouter(c2);
        scom.modifier(new commande(2, 1, 2, "96258500", "ariana", "cite elghazela", "hadheka houwa", 8000));
        //scom.supprimer(2);
      

        System.out.println(" Filtrage des produits par odre décroissant  : ");

        sp.FiltrerProduitsParOrdreDecroissant().forEach(System.out::println);

        System.out.println("----------------------------------------------------------------------");
        System.out.println(" Recherche produit par nom   : ");

        sp.RechercherProduitParNom("vélo").forEach(System.out::println);

        System.out.println("----------------------------------------------------------------------");
        System.out.println(" Recherche produit par catégorie  : ");

        sp.RechercherProduitParCategorie("aznalzndalkdnalkdnakd").forEach(System.out::println);
        System.out.println("----------------------------------------------------------------------");
    }
}
