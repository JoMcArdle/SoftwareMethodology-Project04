module com.example.softwaremethodologyproject04 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.softwaremethodologyproject04 to javafx.fxml;
    exports com.example.softwaremethodologyproject04;
}