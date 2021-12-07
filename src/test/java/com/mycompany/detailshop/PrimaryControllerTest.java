/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.detailshop;

import com.mycompany.detailshop.db.Users;
import com.mycompany.detailshop.db.Product;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Awagond
 */
public class PrimaryControllerTest {
    
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SalesDB");
    public static EntityManager em = emf.createEntityManager();
    
    public PrimaryControllerTest() {
    }
    
    @Test
      public void testGetName() {
      System.out.println("getName");
        Query q = em.createNamedQuery("User.findByIdUser");

        q.setParameter("idUser", 1);
        User u = (User) q.getSingleResult();
        String expResult = "Илья";
        
        String result = u.getName();
        assertEquals(expResult, result);
}
      @Test
      public void FailedTestGetName() {
      System.out.println("getName");
        Query q = em.createNamedQuery("User.findByIdUser");

        q.setParameter("idUser", 1);
        Users u = (Users) q.getSingleResult();
        String expResult = "Кирилл";
        
        String result = u.getName();
        assertEquals(expResult, result);
}
      @Test
      public void testGetProduct() {
            System.out.println("getProduct");
        Query q = em.createNamedQuery("Product.findByIdProduct");

        q.setParameter("idProduct", 1);
        Product p = (Product) q.getSingleResult();
        String expResult = "Гантель";
        
        String result = p.getName();
        assertEquals(expResult, result);
      }
      @Test
      public void FailedTestGetProduct() {
            System.out.println("getProduct");
        Query q = em.createNamedQuery("Product.findByIdProduct");

        q.setParameter("idProduct", 1);
        Product p = (Product) q.getSingleResult();
        String expResult = "Эспандер";
        
        String result = p.getName();
        assertEquals(expResult, result);
      }
      
    

}
