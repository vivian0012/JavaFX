module com.programming.new_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;

    opens com.programming.new_javafx to javafx.fxml;
    exports com.programming.new_javafx;
}