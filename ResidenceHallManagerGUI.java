/**
 * Created by Lysander on 3/8/17.
 */
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;


public class ResidenceHallManagerGUI extends Application {
    public static Floor[] floors = new Floor[3];
    //menu scene objects
    Button btnA, btnR, btnS, btnM, btnF, btnC, btnP, btnW, btnQ;
    FlowPane pane1, pane2;
    Scene menu, scene2;
    Stage stage;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {

    }
}
