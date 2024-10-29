module com.example.tp02ex1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.tp02ex1 to javafx.fxml;
    exports com.example.tp02ex1;
}