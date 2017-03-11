/**
 * Created by Lysander on 3/8/17.
 */
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;

import java.awt.event.MouseEvent;


public class ResidenceHallManagerGUI extends Application {
    public static Floor[] floors = new Floor[3];
    //menu scene objects
    Button btnA, btnR, btnS, btnM, btnF, btnC, btnP, btnW, btnQ;
    BorderPane menu, pane2;
    VBox menuItems;
    Scene scene1, scene2;
    Stage stage;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        btnA = new Button("Add a student");
        btnR = new Button("Remove a student");
        btnS = new Button("Swap students");
        btnM = new Button("Move a student");
        btnF = new Button("Select floor");
        btnC = new Button("Copy floor");
        btnP = new Button("Display floor");
        btnW = new Button("Writeup student");
        btnQ = new Button("Quit");

        menu = new BorderPane();
        menuItems = new VBox();
        menuItems.getChildren().addAll(btnA, btnR, btnS, btnM, btnF, btnC, btnP, btnW, btnQ);
        menuItems.setSpacing(4);
        menu.setCenter(menuItems);
        scene1 = new Scene(menu);
        stage.setScene(scene1);

        //menu button actions

        btnQ.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        stage.show();
    }
}
