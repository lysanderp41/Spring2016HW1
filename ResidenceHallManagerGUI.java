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
    BorderPane menu, paneA, paneR, paneS, paneM, paneF, paneC, paneP, paneW;
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

        //creates menu pane
        menu = new BorderPane();
        menuItems = new VBox();
        menuItems.getChildren().addAll(btnA, btnR, btnS, btnM, btnF, btnC, btnP, btnW, btnQ);
        menuItems.setSpacing(4);
        menu.setCenter(menuItems);

        //current scene is initialized to the menu
        scene1 = new Scene(menu);
        stage.setScene(scene1);

        //add student
        paneA = new BorderPane();

        //remove student
        paneR = new BorderPane();

        //swap student
        paneS = new BorderPane();

        //move student
        paneM = new BorderPane();

        //select floor
        paneF = new BorderPane();

        //copy floor
        paneC = new BorderPane();

        //display floor
        paneP = new BorderPane();

        //writeup student
        paneW = new BorderPane();

        //menu button actions

        btnQ.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        btnA.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        btnR.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        btnS.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        btnM.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        btnF.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        btnC.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        btnP.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        btnW.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });


        stage.show();
    }
}
