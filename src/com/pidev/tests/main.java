/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.tests;
import com.pidev.services.ServiceUser;
import com.pidev.services.ServicePublication;        
import com.pidev.models.*;
import com.pidev.services.*;
import com.pidev.models.produit;
import com.pidev.models.publication;
import com.pidev.models.fos_user;
import java.time.LocalDateTime;
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
   
     
 ///cyrineeeee   
    
    
    ServicePublication spb =new ServicePublication() ;
    
    publication publ= new publication ("cyrine", LocalDateTime.now(), "vélo", 1);
    
  // spb.ajouter(new publication ("chuiph",LocalDateTime.now(),"znenzel",2));
   // spb.modifier(publ);        
    //System.out.println(" Liste des publications : ");
   // spb.afficher().forEach(System.out::println);
//spb.supprimer(7);

    ServiceCommentaire  scp = new ServiceCommentaire();
    scp.ajouter( new commentaire ("kjmdwvqfdol"));
    
    
    
    
    ServiceUser suser = new ServiceUser();
   
    //suser.AjouterUser(new fos_user ("cyrine","chebby","cyrine@gmail.com","cyrine@gmail.com",1,"cyrine","NULL","vendeur","iqqqqqqqqqqqqvn")) ;
    
  //suser.AjouterUser(new fos_user("cyrine","chebby","cyrine@gmail.com","cyrine@gmail.com",1,"cyrine","NULL",1,"iqqqqqqqqqqqqvn"));

       // System.out.println(suser.AfficherUser("cyrine").toString());
    
    suser.ModiferUser(3, new fos_user("sadeek", "selmi", "sadek@gmail.com", "sadek", "vendeur", "jldvqjhbv"));
  //suser.getAllUser().forEach(System.out::println);
   //suser.Login("cyrine", "cyrine");
           
    suser.registerUser(new fos_user("cy","ch","cyrine.ch@gmail.com","cyrine.ch@gmail.com",1,"cyrine","mecanicien","ufohvhnouer",LocalDateTime.now()));
           
           
    //String username, String username_canonical, String email, String email_canonical, int enabled, String password, Date last_login, String confirmation_token, Date password_requested_at, String roles, String image_files,LocalDateTime registration_date) {
        
    //username,username_canonical,email,email_canonical,enabled,password,confirmation_token,roles,image_file,registration_date) 

    
}}
