package com.valantic.sti.tutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
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

        final Button button = new Button("Click me");
        button.setOnAction(e -> closeWindow());

        final StackPane layout = new StackPane();
        layout.getChildren().add(button);
        final Scene scene = new Scene(layout, 600, 250);
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
