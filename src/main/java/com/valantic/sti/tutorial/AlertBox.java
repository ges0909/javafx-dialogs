package com.valantic.sti.tutorial;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    public static void display(final String title, final String message) {
        final Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL); // blocks any user action
        window.setTitle(title);
        window.setMaxWidth(250);

        final Label label = new Label();
        label.setText(message);

        final Button closeButton = new Button("Close the window");
        closeButton.setOnAction(e -> window.close());

        final VBox layout = new VBox(20);
        layout.setPadding(new Insets(30, 30, 30, 30));
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        final Scene scene = new Scene(layout, 250, 100);
        window.setScene(scene);
        window.showAndWait(); // !!!
    }
}
