module it.unime.orbita1 {

    requires javafx.controls;
    requires javafx.fxml;
    exports it.unime.orbita1.app;
    opens it.unime.orbita1.app to javafx.graphics;
    opens it.unime.orbita1.gui to javafx.fxml, javafx.graphics;
    exports it.unime.orbita1.gui;


}