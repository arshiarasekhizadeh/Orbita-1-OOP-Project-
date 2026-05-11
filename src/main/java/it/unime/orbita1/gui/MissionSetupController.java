package it.unime.orbita1.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;


/**
 * The MissionSetupController class is responsible for handling user interactions with the mission setup screen of the application. It defines event handlers for buttons such as "Back" and "Start Mission", as well as initializing choice boxes for mission duration and difficulty, and a slider for resource allocation. When a button is clicked, the corresponding method is called to perform the desired action, such as navigating back to the previous screen or starting a new mission with the selected parameters. This class serves as the controller in the Model-View-Controller (MVC) architecture, managing the logic behind the user interface defined in the MissionSetup.fxml file.
 * OOP concepts:
 * - Encapsulation: The MissionSetupController class encapsulates the logic for handling user interactions with the mission setup screen, providing a clear separation of concerns between the user interface and the underlying functionality.
 * - Event Handling: The class defines methods that are triggered by user actions (button clicks), demonstrating how to handle events in a JavaFX application.
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)
 */
public class MissionSetupController
{
    /**
     * FXML annotations are used to link the UI components defined in the MissionSetup.fxml file to the corresponding fields and methods in this controller class. The fx:id attributes in the FXML file must match the field names in this class for the injection to work correctly. The onAction attributes in the FXML file specify which method should be called when a button is clicked, allowing for a clean separation between the UI layout and the event handling logic.
     * The @FXML annotation indicates that the following fields and methods are accessible to the FXML loader, enabling the connection between the UI components and the controller's logic. This allows for a modular design where the UI can be defined separately from the behavior, adhering to the principles of MVC architecture.
     */
    @FXML
    private Button backButton;
    @FXML
    private Button startMissionButton;
    @FXML
    private ChoiceBox<String> missionDurationChoiceBox;
    @FXML
    private ChoiceBox<String> difficultyChoiceBox;
    @FXML
    private Slider crewSizeSlider;



    /**
     * Initializes the controller by populating the choice boxes with options for mission duration and difficulty, and setting default values. This method is called automatically by the FXML loader after the fields have been injected. It demonstrates how to set up the initial state of the user interface components before the user interacts with them. The choice boxes allow users to select from predefined options, while the slider provides a way to adjust resource allocation for the mission.
     * OOP concepts:
     * - Initialization: The initialize method is used to set up the initial state of the UI components, demonstrating how to prepare the user interface for interaction.
     * - User Interface Management: By populating the choice boxes and setting default values, this method helps manage the user interface and ensures that it is ready for user input when the mission setup screen is displayed.
     */
    @FXML
    private void initialize() {
        missionDurationChoiceBox.getItems().addAll("Short (500 ticks)", "Medium (1000 ticks)", "Long (2000 ticks)");
        difficultyChoiceBox.getItems().addAll("Easy", "Medium", "Hard");
        missionDurationChoiceBox.setValue("Medium (1000 ticks)");
        difficultyChoiceBox.setValue("Medium");
    }
    
    /**
     * Handles the click event for the "Back" button, allowing the user to navigate back to the previous screen. This method can be implemented to change the scene or perform any necessary cleanup before returning to the main menu or previous screen.
     */
    @FXML
    private void onBackClicked() {
        SceneManager.switchTo("/it/unime/orbita1/gui/MainMenu.fxml");;
    }

    /**
     * Handles the click event for the "Start Mission" button, initiating the mission with the selected parameters. This method can be implemented to gather the selected options from the choice boxes and slider, and then start the mission based on those parameters.
     */
    @FXML
    private void onStartMissionClicked() {
        System.out.println("Start Mission clicked");
    }

    
}