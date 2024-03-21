import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class App extends Application {
    private Label title;  //makes title for how to use
    private Label unitLabel;     // Label for unit
    private Label amountLabel;     // Label for amount
    private Label resultLabel;      // Label for result
    private TextField unitField;  // Displays choosen unit
    private TextField amountField;  // Displays measurement
    private TextField resultField; // Displays result
    private Button conButton;   // Triggers convertion
   
   @Override
   public void start(Stage applicationStage) {
      Scene scene = null;         // Scene contains all content
      GridPane gridPane = null;   // Positions components within scene
      
      gridPane = new GridPane();   // Create an empty pane
      scene = new Scene(gridPane); // Create scene containing the grid pane
      
      // Set labels
      title = new Label("Here are the available conversions: [1:m to ft , 2:cm to in , 3:kg to lb , 4:mi to km ]");
      unitLabel = new Label("Pick a unit:");
      amountLabel = new Label("Enter your measurement:");
      resultLabel = new Label("Result:");
      
      unitField = new TextField(); 
      unitField.setPrefColumnCount(15);
      unitField.setEditable(true);
      unitField.setText("0");
      
      amountField = new TextField(); 
      amountField.setPrefColumnCount(15);
      amountField.setEditable(true);

        resultField = new TextField(); // Create result field
        resultField.setPrefColumnCount(15);
        resultField.setEditable(false);
      
      // Create a "Convert" button
      conButton = new Button("Convert");
      
      gridPane.setPadding(new Insets(10, 10, 10, 10)); // Padding around  grid
      gridPane.setHgap(10);                            // Spacing between columns
      gridPane.setVgap(5);                            // Spacing between rows
      
      gridPane.add(title, 0, 0); // Add title
      gridPane.add(unitLabel, 0, 1);  // Add unit label
      gridPane.add(unitField, 1, 1);  // Add unit text field
      gridPane.add(amountLabel, 0, 2);   // Add amount label
      gridPane.add(amountField, 1, 2);   // Add amount text field
      gridPane.add(resultLabel, 0, 3);   // Add result label
      gridPane.add(resultField, 1, 3);   // Add result text field 
      gridPane.add(conButton, 0, 4); // Add calculate button
      
      // Set an event handler to handle button presses
      conButton.setOnAction(new EventHandler<ActionEvent>() {
         
         @Override
         public void handle(ActionEvent event) {
            String unitInput; 
            String amountinput;
            int unit;    
            double amount; 
            double result = 0;   

            // Get user's inputs
            unitInput = unitField.getText();            
            unit = Integer.parseInt(unitInput);
            amountinput = amountField.getText();            
            amount = Double.parseDouble(amountinput);

            //"Here are the available conversions: [1:m to ft , 2:cm to in , 3:kg to lb , 4:mi to km ]"
            if (unit == 1){
                result = amount * 3.281;
            }else if (unit == 2){
                result = amount / 2.54;
            }else if (unit == 3){
                result = amount * 2.205;
            }else if (unit == 4){
                result = amount * 1.609;
            }
            

            // Display calculated measurement
            resultField.setText(Double.toString(result));
         } 
      });

      applicationStage.setScene(scene);    // Set window's scene  
      applicationStage.setTitle("Measurement Convertor"); // Set window's title
      applicationStage.show();             // Display window
   }
   
   public static void main(String [] args) {
      launch(args); // Launch application
   }
}
