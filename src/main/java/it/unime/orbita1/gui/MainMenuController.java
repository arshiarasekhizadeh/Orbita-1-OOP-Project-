package it.unime.orbita1.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.application.Platform;


/**
 * The MainMenuController class is responsible for handling user interactions with the main menu of the application. It defines event handlers for buttons such as "New Mission", "Settings", and "Quit". When a button is clicked, the corresponding method is called to perform the desired action, such as starting a new mission, opening settings, or exiting the application. This class serves as the controller in the Model-View-Controller (MVC) architecture, managing the logic behind the user interface defined in the MainMenu.fxml file.
 * OOP concepts:
 * - Encapsulation: The MainMenuController class encapsulates the logic for handling user interactions with the main menu, providing a clear separation of concerns between the user interface and the underlying functionality.
 * - Event Handling: The class defines methods that are triggered by user actions (button clicks), demonstrating how to handle events in a JavaFX application.
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)
 */
public class MainMenuController
{
    /**
     * FXML annotations are used to link the UI components defined in the MainMenu.fxml file to the corresponding fields and methods in this controller class. The fx:id attributes in the FXML file must match the field names in this class for the injection to work correctly. The onAction attributes in the FXML file specify which method should be called when a button is clicked, allowing for a clean separation between the UI layout and the event handling logic.
     * The @FXML annotation indicates that the following fields and methods are accessible to the FXML loader, enabling the connection between the UI components and the controller's logic. This allows for a modular design where the UI can be defined separately from the behavior, adhering to the principles of MVC architecture.
     */
    @FXML
    private Button newMissionButton;
    @FXML
    private Button settingsButton;
    @FXML
    private Button quitButton;  
    

    /**
     * Handles the click event for the "New Mission" button.
     */
    @FXML
    private void onNewMissionClicked() {
        SceneManager.switchTo("/it/unime/orbita1/gui/MissionSetup.fxml");
    }

    /**
     * Handles the click event for the "Settings" button.
     */
    @FXML
    private void onSettingsClicked() {
        System.out.println("Settings clicked");
    }

    /**
     * Handles the click event for the "Quit" button.
     */
    @FXML
    private void onQuitClicked() {
        Platform.exit();
    }
}