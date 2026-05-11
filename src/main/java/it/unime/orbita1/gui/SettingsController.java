package it.unime.orbita1.gui;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import java.util.Map;
import it.unime.orbita1.io.KeyBindings;

/**
 * The SettingsController class is responsible for handling user interactions with the settings screen of the application. It defines event handlers for buttons such as "Back" and "Save Settings", as well as initializing any necessary UI components for the settings screen. When a button is clicked, the corresponding method is called to perform the desired action, such as navigating back to the main menu or saving the current settings. This class serves as the controller in the Model-View-Controller (MVC) architecture, managing the logic behind the user interface defined in the Settings.fxml file.
 * OOP concepts:
 * - Encapsulation: The SettingsController class encapsulates the logic for handling user interactions with the settings screen, providing a clear separation of concerns between the user interface and the underlying functionality.
 * - Event Handling: The class defines methods that are triggered by user actions (button clicks), demonstrating how to handle events in a JavaFX application.
 * @author Arshia Rasekhizadeh (574414)
 * @author Reza Jahangiri (555986)
 */
public class SettingsController{

    /** The keyBindings variable is an instance of the KeyBindings class, which manages the key bindings for the application. This variable is used to access and modify the key bindings as needed within the settings screen. By creating an instance of KeyBindings, the SettingsController can interact with the key binding data, allowing users to view and update their key bindings through the settings interface. This promotes encapsulation by keeping the key binding logic separate from the user interface logic, while still allowing for interaction between the two components. 
     * OOP concepts:
     * - Encapsulation: The keyBindings variable encapsulates the functionality related to managing key bindings, allowing the SettingsController to interact with it without needing to know the internal details of how key bindings are stored or managed.
     * - Object Composition: The SettingsController class uses composition by including an instance of the KeyBindings class. This allows the SettingsController to utilize the functionality of KeyBindings without inheriting from it, promoting a modular design where each class has a specific responsibility.
     * - Separation of Concerns: By using a separate KeyBindings class, the SettingsController can focus on handling user interactions and managing the settings screen, while the KeyBindings class is responsible for managing the key binding data. This separation of concerns leads to cleaner and more maintainable code.
     */
    private KeyBindings keyBindings = new KeyBindings();

    /** The backButton variable is an instance of the Button class, which represents the "Back" button on the settings screen. This variable is used to handle user interactions with the back button, such as navigating back to the main menu when clicked.
     * OOP concepts:
     * - Encapsulation: The backButton variable encapsulates the functionality related to the "Back" button, allowing the SettingsController to interact with it without needing to know the internal details of how the button is implemented.
     * - Object Composition: The SettingsController class uses composition by including an instance of the Button class. This allows the SettingsController to utilize the functionality of the Button class without inheriting from it, promoting a modular design where each class has a specific responsibility.
     */
    @FXML
    private Button backButton;

    /** The saveButton variable is an instance of the Button class, which represents the "Save Settings" button on the settings screen. This variable is used to handle user interactions with the save button, such as saving the current settings when clicked.
     * OOP concepts:
     * - Encapsulation: The saveButton variable encapsulates the functionality related to the "Save Settings" button, allowing the SettingsController to interact with it without needing to know the internal details of how the button is implemented.
     * - Object Composition: The SettingsController class uses composition by including an instance of the Button class. This allows the SettingsController to utilize the functionality of the Button class without inheriting from it, promoting a modular design where each class has a specific responsibility.
     */
    @FXML
    private Button saveButton;

    /** The keybindingsTable variable is an instance of the TableView class, which represents a table view on the settings screen that displays the current key bindings. This variable is used to populate the table with key binding data and allow users to view their current key bindings in a structured format.
     * OOP concepts:
     * - Encapsulation: The keybindingsTable variable encapsulates the functionality related to the table view for key bindings, allowing the SettingsController to interact with it without needing to know the internal details of how the table view is implemented.
     * - Object Composition: The SettingsController class uses composition by including an instance of the TableView class. This allows the SettingsController to utilize the functionality of the TableView class without inheriting from it, promoting a modular design where each class has a specific responsibility.
     */
    @FXML
    private TableView<Map.Entry<String, String>> keybindingsTable;


    /** The actionColumn variable is an instance of the TableColumn class, which represents a column in the key bindings table that displays the actions associated with each key binding. This variable is used to define how the action data is displayed in the table and to populate the column with the appropriate data from the key bindings.
     * OOP concepts:
     * - Encapsulation: The actionColumn variable encapsulates the functionality related to the "Action" column in the key bindings table, allowing the SettingsController to interact with it without needing to know the internal details of how the column is implemented.
     * - Object Composition: The SettingsController class uses composition by including an instance of the TableColumn class. This allows the SettingsController to utilize the functionality of the TableColumn class without inheriting from it, promoting a modular design where each class has a specific responsibility.
     */
    @FXML
    private TableColumn<Map.Entry<String, String>, String> actionColumn;


    /** The keyColumn variable is an instance of the TableColumn class, which represents a column in the key bindings table that displays the keys associated with each action. This variable is used to define how the key data is displayed in the table and to populate the column with the appropriate data from the key bindings.
     * OOP concepts:
     * - Encapsulation: The keyColumn variable encapsulates the functionality related to the "Key" column in the key bindings table, allowing the SettingsController to interact with it without needing to know the internal details of how the column is implemented.
     * - Object Composition: The SettingsController class uses composition by including an instance of the TableColumn class. This allows the SettingsController to utilize the functionality of the TableColumn class without inheriting from it, promoting a modular design where each class has a specific responsibility.
     */
    @FXML
    private TableColumn<Map.Entry<String, String>, String> keyColumn;


    /** Initializes the controller by populating the key bindings table with data from the KeyBindings instance. This method is called automatically by the FXML loader after the fields have been injected. It creates an observable list of key binding entries and sets up the cell value factories for the action and key columns to display the appropriate data from the key bindings. This allows users to view their current key bindings in a structured format within the settings screen.
     * OOP concepts:
     * - Initialization: The initialize method is used to set up the initial state of the UI components, demonstrating how to prepare the user interface for interaction.
     * - User Interface Management: By populating the key bindings table and setting up the cell value factories, this method helps manage the user interface and ensures that it is ready for user input when the settings screen is displayed.
     */
    @FXML
    private void initialize() {
        ObservableList<Map.Entry<String, String>> items = FXCollections.observableArrayList(keyBindings.getBindings().entrySet());
        actionColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getKey()));
        keyColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getValue()));
        keybindingsTable.setItems(items);
    }


    /** Handles the click event for the "Back" button, allowing the user to navigate back to the main menu. This method can be implemented to change the scene or perform any necessary cleanup before returning to the main menu or previous screen.
     */
    @FXML
    private void onBackClicked() {
        SceneManager.switchTo("/it/unime/orbita1/gui/MainMenu.fxml");
    }


    /** Handles the click event for the "Save Settings" button, saving the current settings. This method can be implemented to gather the current settings from the UI components and save them using the KeyBindings instance or any other relevant classes. It may also include functionality to provide feedback to the user that their settings have been saved successfully.
     */
    @FXML
    private void onSaveSettingsClicked() {
        keyBindings.saveToFile("keybindings.txt");   
    }

}