module com.mycompany.detailshop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;

    opens com.mycompany.detailshop to javafx.fxml;
    opens com.mycompany.detailshop.db;
    exports com.mycompany.detailshop;
}
