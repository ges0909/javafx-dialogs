package com.valantic.sti.tutorial;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class Main extends Application {

    private Stage window;

    public static void main(final String... args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) {
        window = stage;
        window.setTitle("JavaFX Dialogs");
        window.setOnCloseRequest(e -> {
            e.consume();
            closeWindow();
        });

        final Button button1 = new Button("Custom Alert");
        button1.setOnAction(e -> AlertBox.display("Custom Alert", "Wow this alert box is awesome!"));

        final Button button2 = new Button("Custom Confirmation");
        button2.setOnAction(e -> closeWindow());

        final VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(button1, button2);
        final Scene scene = new Scene(layout, 250, 150);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    private void closeWindow() {
        final boolean answer = ConfirmBox.display("Confirmation", "Do you want to close the application?");
        if (answer) {
            window.close();
        }
    }
}
