package com.mycompany.detailshop;

import com.mycompany.detailshop.db.Product;
import java.io.IOException;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SecondaryController {

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
    public void initialize() {
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
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    

}