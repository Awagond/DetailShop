/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.detailshop;

import com.mycompany.detailshop.db.Product;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author Awagond
 */
public class AdminPanelController {
    
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SalesDB");
    public static EntityManager em = emf.createEntityManager();
    
    @FXML
    private TableView panel;
    
    @FXML
    private Product selectedProduct;
 
    
    @FXML
    private TableColumn<Product, String> idProduct;
    
    @FXML
    private TableColumn<Product, String> detail;
    
    @FXML
    private TableColumn<Product, String> price;
    
    @FXML
    private TextField arcticulTextField;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextField detailTextField;

    @FXML
    private void initialize() {
        
        Query q = em.createNamedQuery("Product.findAll");
        List<Product> productList = q.getResultList();
        
        
          
        idProduct.setCellValueFactory((TableColumn.CellDataFeatures<Product, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getIdProduct().toString());
        });
        
        detail.setCellValueFactory((TableColumn.CellDataFeatures<Product, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getName());
        });
        
        price.setCellValueFactory((TableColumn.CellDataFeatures<Product, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getPrice());
        });
        
        ObservableList<Product> products = FXCollections.observableList(productList);
        panel.setItems(products);
    }    
    @FXML
    private void addProduct() throws IOException{
        String productId = arcticulTextField.getText();
        String productName = detailTextField.getText();
        String productPrice = priceTextField.getText();
        
        Product productIns = new Product();
        productIns.setName(productName);
        productIns.setPrice(productPrice);
        
        em.getTransaction().begin();
        em.persist(productIns);
        em.getTransaction().commit();
        
       arcticulTextField.setText("");
       detailTextField.setText("");
       priceTextField.setText("");
        
     initialize();
        
    }
    
    @FXML
    private void deleteProduct() throws IOException{
        
        Product p = (Product) panel.getSelectionModel().getSelectedItem();
        System.out.println(p);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
   
        initialize();
       
    }
    
     @FXML
    private void onCloseClicked() {
        System.exit(0);
    }
}
