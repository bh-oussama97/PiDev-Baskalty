/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.tests;

import com.pidev.models.categorie;
import com.pidev.models.mechanicien;
import com.pidev.models.panier;
import com.pidev.models.produit;
import com.pidev.services.ServiceCategorie;
import com.pidev.services.ServiceMaintenance;
import com.pidev.services.ServicePanier;
import com.pidev.services.ServiceProduit;
import java.time.LocalDateTime;

/**
 *
 * @author yaya
 */
public class mechanicienMain {
     public static void main(String[] args) {
        
      
       ServiceProduit sp = new ServiceProduit();
       
       produit pmodif = new produit(12, 5 , LocalDateTime.now(), "vélo", "jzngjzn", 400, "bon vélo","velomodif.jpg", LocalDateTime.now(), 2, "veloscross");
    // sp.ajouter(new produit(6,LocalDateTime.now(),"lunette","RF84984",400, "lunette pour cycler", "lunette.jpg", null,1,"équipements"));
     // sp.ajouter(new produit(5,new Date(2020,3, 20),"znenzel","zjngzkgn",2500, "jezbfkzebfz", "bzejkbzekj.jpg", new Date(2020,3,16),3,"jkzenfzjeknfjkzenf"));
     //sp.afficher().forEach(System.out::println);  
     // sp.afficherParId(2).toString();
     // sp.supprimer(6);
     //sp.modifier(new produit(7,6,new Date(2020,3,20),"vélo","E193JKLMT",500,"bon vélo","vélo.jpg",new Date(2020,3,20),2,"vélos Cross"));
     sp.modifier(pmodif);        
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
      
      sp.RechercherProduitParNom("vélo").forEach(System.out::println);
      
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        
      System.out.println(" Recherche produit par catégorie  : ");
      
      sp.RechercherProduitParCategorie("aznalzndalkdnalkdnakd").forEach(System.out::println);
      
     
      // yahya 
      ServiceMaintenance sm = new ServiceMaintenance();
//      mechanicien m1=new mechanicien("service"," nom"," prenom", "mail"," image", 2500 , 5454540, "description", "experience", "region", "city", 11, "actif");
     //sm.ajouter(m1);
    //mechanicien m2= new mechanicien("service"," cyrinnneee re9da", "prenom", "mail"," image", 125, 55540," description", "experience"," region", "city","aaa", 0, "actif");
      //sm.ajouter(m2);
      //sm.supprimer(6);
      
      sm.afficher().forEach(System.out::println);
      sm.modifier(new mechanicien(11,"service"," cyrinnneee mech  re9da", "fayez deykh", "mail"," image", 125, 55540," description", "experience"," region", "city","aaa", 0, "actif"));
         sm.afficher().forEach(System.out::println);

     }
    
    
    
}
