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
        Query q = em.createNamedQuery("Users.findByIdUser");

        q.setParameter("idUser", 1);
        Users u = (Users) q.getSingleResult();
        String expResult = "admin";
        
        String result = u.getName();
        assertEquals(expResult, result);
}
      
      @Test
      public void testGetName2() {
        Users user = new Users(1, "", "123");
        user.setName("admin");
        assertEquals("admin", user.getName());
}
      
     @Test
      public void testGetName3() {
        Users user = new Users(1, "", "");
        user.setName("admin");
        user.setPassword("123");
        assertEquals("admin", user.getName());
        assertEquals("123",  user.getPassword());
}
      @Test
      public void testGetProduct() {
        Query q = em.createNamedQuery("Product.findByIdProduct");

        q.setParameter("idProduct", 1);
        Product product = (Product) q.getSingleResult();
        String expResult = "NNVIDIA GTX 1050 TI";
        
        String result = product.getName();
        assertEquals(expResult, result);
      }
}

