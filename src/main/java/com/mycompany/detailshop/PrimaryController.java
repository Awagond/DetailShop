package com.mycompany.detailshop;


import com.mycompany.detailshop.db.Users;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.persistence.*;

public class PrimaryController {

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SalesDB");
    public static EntityManager em = emf.createEntityManager();

    @FXML
    private void switchToSecondary() throws IOException {
        Node n1 = App.getRoot().lookup("#usernameTextField");
        TextField usernameField = (TextField) n1;

        Node n2 = App.getRoot().lookup("#passwordTextField");
        TextField passwordField = (TextField) n2;

        System.out.println("Username: " + usernameField.getText());
        System.out.println("Password: " + passwordField.getText());

        // Получаем значения полей из интерфейса.
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Формируем запрос в БД.
        Query q = em.createNamedQuery("Users.findByLogin");
        q.setParameter("login", username);

        Label messageArea = (Label) App.getRoot().lookup("#messageArea");

        // Выполняем запрос к БД.
        try {
            Users user = (Users) q.getSingleResult();

            System.out.println("DEBUG: user: " + user);

            if (user.getPassword().equals(password)) {
                messageArea.setText("");
                App.setRoot("secondary");
            } else {
                messageArea.setText("Неверный логин или пароль");
            }

        } catch (NoResultException e) {
            messageArea.setText("Неверный логин или пароль");
        }
    }
    @FXML
    private void switchToReg() throws IOException {
        App.setRoot("register");
    }
    
}
