package pl.venustus;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;

public class HelloFX extends Application {


    // launch the application
    public void start(Stage s) {
        MrRobot bot = new MrRobot();

        // set title for the stage
        s.setTitle("creating buttons");

        // create a button
        Button b = new Button("button");

        // create a stack pane
        TilePane r = new TilePane();

        // create a label
        Label l = new Label("button not selected");
        Label l1 = new Label(String.valueOf(LocalDateTime.now()));
        Label l2 = new Label("Loop value: ");
        TextField textField = new TextField();
        // action event
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Integer loopValue;
                l.setText("   button   selected    ");
                try {
                    System.out.println(" get text:" + textField.getText() + "end.");
                    if (textField.getText() == null) {
                        loopValue = 1;
                        textField.setText("1");
                    } else {
                        loopValue = Integer.valueOf(textField.getText());
                    }
                    bot.mouseMoveWithLabel(l2, loopValue);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (AWTException e) {
                    e.printStackTrace();
                }
            }

        };

        // when button is pressed
        b.setOnAction(event);

        // add button
        r.getChildren().add(b);
        r.getChildren().add(l);
        r.getChildren().add(l1);
        r.getChildren().add(l2);


        HBox hbox = new HBox(textField);
        r.getChildren().add(hbox);
        // create a scene
        Scene sc = new Scene(r, 200, 200);

        // set the scene
        s.setScene(sc);

        s.show();
    }

    public static void main(String args[]) {
        // launch the application
        launch(args);
    }
}