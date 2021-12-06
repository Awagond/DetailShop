package com.mycompany.detailshop;

import com.mycompany.detailshop.db.Users;
import com.mycompany.detailshop.db.Role;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Awagond
 */
public class RegisterController {
    
    @FXML
    private TextField loginTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField nameTextField;
    
    
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SalesDB");
    public static EntityManager em = emf.createEntityManager();
    
    
   @FXML
    private void switchToLogin() throws IOException {
        
        String login = loginTextField.getText();
        String password = passwordTextField.getText();
        String name = nameTextField.getText();
        
        Query r = em.createNamedQuery("Role.findByName");
        r.setParameter("name","Users");
        Role role = (Role) r.getSingleResult();
        em.getTransaction().begin();
        
        Users user = new Users();  
        user.setLogin(login);
        user.setPassword(password);
        user.setName(name);
        user.setIdrole(role);
        
        em.persist(user);
        em.getTransaction().commit();
        
      
        System.out.println("Registration was successful: " + login);
        System.out.println("Password: " + password);
        
        App.setRoot("primary");
            
    }
    
}
