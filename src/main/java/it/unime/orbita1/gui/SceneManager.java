package it.unime.orbita1.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


/**
 * The SceneManager class is a utility class responsible for managing scene transitions in the application. It provides methods to initialize the primary stage and switch between different scenes defined by FXML files. The initialize method sets the primary stage that will be used for scene transitions, while the switchTo method loads the specified FXML file, creates a new scene, and sets it on the primary stage. This class centralizes the logic for scene management, making it easier to maintain and update the user interface as needed.
 * OOP concepts:
 * - Encapsulation: The SceneManager class encapsulates the logic for managing scene transitions, providing a clear interface for switching scenes without exposing the underlying implementation details.
 * - Static Methods: The use of static methods allows for easy access to scene management functionality without needing to instantiate the SceneManager class, making it a convenient utility for handling scene transitions throughout the application.
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)
 */
public final class SceneManager
{

    /**
     * The primaryStage variable holds a reference to the main stage of the application, which is initialized through the initialize method. This stage is used for all scene transitions managed by the switchTo method. By keeping a static reference to the primary stage, the SceneManager class can easily switch scenes from anywhere in the application without needing to pass around stage references, thus simplifying scene management and improving code organization.
     */
    private static Stage primaryStage;


    /**
     * Initializes the SceneManager with the primary stage of the application. This method must be called before any scene transitions can occur, as it sets the stage that will be used for all subsequent scene changes. The primary stage is typically passed from the main application class when the application starts, allowing the SceneManager to manage scene transitions effectively throughout the application's lifecycle.
     * OOP concepts:
     * - Initialization: The initialize method is responsible for setting up the necessary state (the primary stage) for the SceneManager to function correctly, demonstrating how to prepare a utility class for use in an application.
     * - Static State Management: By storing the primary stage in a static variable, this method allows for centralized management of the application's main stage, enabling easy access and modification from anywhere in the codebase.
     */
    public static void initialize(Stage stage)
    {
        primaryStage = stage;
    }


    /**
     * Switches the current scene to the one defined by the specified FXML file. This method loads the FXML file, creates a new scene from it, and sets it on the primary stage. If there is an issue loading the FXML file, such as a missing file or a syntax error, an IOException will be caught and printed to the console. This method allows for dynamic scene transitions based on user interactions or application logic, making it a key component of the application's user interface management.
     * OOP concepts:
     * - Exception Handling: The try-catch block is used to handle potential IOExceptions that may occur when loading the FXML file, demonstrating how to manage exceptions in Java.
     * - Dynamic Scene Management: By allowing scenes to be switched based on FXML files, this method provides flexibility in how the user interface can be structured and updated throughout the application.
     */
    public static void switchTo(String fxmlFile)
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(fxmlFile));
            Scene scene = new Scene(loader.load());
            primaryStage.setScene(scene);
            primaryStage.setMinWidth(1280);
            primaryStage.setMinHeight(720);
            primaryStage.show();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
} 