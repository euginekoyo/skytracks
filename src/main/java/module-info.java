module com.skytracks.skytracks {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires itextpdf;
    requires org.apache.pdfbox;
    requires javafx.web;
    requires java.desktop;
    requires javafx.swing;

    opens com.skytracks.skytracks to javafx.fxml;
    exports com.skytracks.skytracks;

}