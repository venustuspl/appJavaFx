package pl.venustus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class HelloFX extends Application {


    // launch the application
    public void start(Stage s)
    {
        // set title for the stage
        s.setTitle("creating buttons");

        // create a button
        Button b = new Button("button");

        // create a stack pane
        TilePane r = new TilePane();

        // create a label
        Label l = new Label("button not selected");
        Label l1 = new Label(String.valueOf(LocalDateTime.now()));

        // action event
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                l.setText("   button   selected    ");
            }

        };

        // when button is pressed
        b.setOnAction(event);

        // add button
        r.getChildren().add(b);
        r.getChildren().add(l);
        r.getChildren().add(l1);

        // create a scene
        Scene sc = new Scene(r, 200, 200);

        // set the scene
        s.setScene(sc);

        s.show();
    }


    public static void main(String args[])
    {
        // launch the application
        launch(args);
    }
}