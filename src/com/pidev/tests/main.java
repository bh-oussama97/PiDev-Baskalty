/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.tests;
//import com.pidev.services.ServiceProduit;
import com.pidev.models.*;
import com.pidev.services.*;
import com.pidev.models.produit;
import java.sql.Date;

/**
 *
 * @author benha
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      
       ServiceProduit sp = new ServiceProduit();
     //sp.ajouter(new produit(5,new Date(2020,3, 20),"znenzel","zjngzkgn",2500, "jezbfkzebfz", "bzejkbzekj.jpg", new Date(2020,3,16),1,"Vélos Cross"));
     // sp.ajouter(new produit(5,new Date(2020,3, 20),"znenzel","zjngzkgn",2500, "jezbfkzebfz", "bzejkbzekj.jpg", new Date(2020,3,16),3,"jkzenfzjeknfjkzenf"));
     //sp.afficher().forEach(System.out::println);  
     // sp.afficherParId(2).toString();
     // sp.supprimer(6);
     //sp.modifier(new produit(7,6,new Date(2020,3,20),"vélo","E193JKLMT",500,"bon vélo","vélo.jpg",new Date(2020,3,20),2,"vélos Cross"));
     
        System.out.println(" Liste des produits : ");
     sp.afficher().forEach(System.out::println);
     
          System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        
       ServiceCategorie sc = new ServiceCategorie();
       
        categorie c = new categorie("velooooooos");
        
       // sc.ajouter(c);
       // sc.modifier(new categorie(8,"accessoires"));
       
      // sc.supprimer(9);
      System.out.println(" Liste des catégories  : ");
        sc.afficher().forEach(System.out::println);
        
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        
       panier pa = new panier(2,1, 3,2600,"22/03/2020");
        
        ServicePanier spanier = new ServicePanier();
        
        
        System.out.println("Contenu du panier  :");
        
        spanier.afficher().forEach(System.out::println);
        
          System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        
      // spanier.ajouter(pa);
       
       //spanier.ajouter(new panier(3,3, 25,2600,"23/03/2020"));
       
      // spanier.modifier(new panier(2,5, 6,2900,6, "24/03/2020"));
      
     // spanier.supprimer(1);
        
     //  spanier.afficher().forEach(System.out::println);
       
       //sp.RechercherProduitParNom("ve").forEach(System.out::println);
         // sc.supprimer(9);
      System.out.println(" Filtrage des produits par odre croissant  : ");
       
       sp.FiltrerProduitsParOrdreCroissant().forEach(System.out::println);
       
          System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        
      System.out.println(" Filtrage des produits par odre décroissant  : ");
      
      sp.FiltrerProduitsParOrdreDecroissant().forEach(System.out::println);
      
      
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        
      System.out.println(" Recherche produit par nom   : ");
      
      sp.RechercherProduitParNom("kjzebfjefbkjzeb").forEach(System.out::println);
      
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        
      System.out.println(" Recherche produit par catégorie  : ");
      
      sp.RechercherProduitParCategorie("aznalzndalkdnalkdnakd").forEach(System.out::println);
    }
    
}
