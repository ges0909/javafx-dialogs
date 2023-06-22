package com.valantic.sti.tutorial;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main extends Application {

    private Stage window;

    public static void main(final String... args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) {
        window = stage;
        window.setTitle("Communicating between Windows");
        window.setOnCloseRequest(e -> {
            e.consume();
            closeWindow();
        });

        final Button button1 = new Button("Test Alert");
        button1.setOnAction(e -> AlertBox.display("Alert", "Wow this alert box is awesome!"));

        final Button button2 = new Button("Test Confirmation");
        button2.setOnAction(e -> closeWindow());

        final VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(button1, button2);
        final Scene scene = new Scene(layout, 200, 150);
        stage.setScene(scene);
        stage.show();
    }

    private void closeWindow() {
        final boolean answer = ConfirmBox.display("Dialog", "Are you sure?");
        if (answer) {
            window.close();
        }
    }
}
