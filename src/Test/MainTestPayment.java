/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Service.ServicePayment;
import com.stripe.exception.StripeException;



/**
 *
 * @author benha
 */
public class MainTestPayment {
    
    public static void main(String[] args) throws StripeException {
        
        ServicePayment sp  = new ServicePayment();
        
    
       sp.AttachCardToCustomer("4242424242424242", 05, 23,"123", "cus_HM5jTKJ1oiIxHC");
}
    
    
}
