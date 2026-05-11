package it.unime.orbita1.app;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The Orbita1App class serves as the entry point for the Orbita1 application, which is a JavaFX application. It extends the Application class from the JavaFX framework and overrides the start method to set up the primary stage (window) of the application. The main method is used to launch the application, which initializes the JavaFX runtime and calls the start method to display the user interface. This class is responsible for initializing and displaying the main window of the application, and it can be further expanded to include additional functionality such as setting up scenes, handling user input, and managing application state.
 * OOP concepts:
 * - Inheritance: The Orbita1App class inherits from the Application class, allowing it
 *  to utilize the functionality provided by the JavaFX framework for creating and managing the application lifecycle.
 * - Polymorphism: The Orbita1App class overrides the start method from the Application class, providing a specific implementation for setting up the primary stage of the application. This allows the Orb
 * ita1App class to define its own behavior while still adhering to the contract defined by the Application class, demonstrating polymorphism in object-oriented programming.
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)
 */
public class Orbita1App extends Application {
    /** The main method serves as the entry point for the application. It calls the launch method, which initializes the JavaFX runtime and starts the application by invoking the start method. This method is essential for launching a JavaFX application and is typically included in the main class that extends Application. 
     * @param args command-line arguments passed to the application; not used in this implementation
    */
    public static void main(String[] args) {
        launch(args);
    }

    /** The start method is called by the JavaFX runtime when the application is launched. It sets up the primary stage (window) of the application by setting its title and making it visible. This method can be further expanded to include additional setup for the user interface, such as creating scenes, adding controls, and configuring event handlers. 
     * @param primaryStage the primary stage (window) provided by the JavaFX runtime; used to set up and display the main window of the application
    */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Orbita-1");
        primaryStage.setMinWidth(1280);
        primaryStage.setMinHeight(720);     
        primaryStage.show();
    }



}