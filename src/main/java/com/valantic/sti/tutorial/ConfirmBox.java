package com.valantic.sti.tutorial;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean answer;

    public static boolean display(final String title, final String message) {
        final Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL); // blocks any user action
        window.setTitle(title);
        window.setMaxWidth(250);

        final Label label = new Label();
        label.setText(message);

        final Button yesButton = new Button("Yes");
        yesButton.setOnAction(e -> {
            answer = true;
            window.close();

        });
        final Button noButton = new Button("No");
        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        final HBox buttonRow = new HBox(10, yesButton, noButton);
        buttonRow.setAlignment(Pos.CENTER);

        final VBox layout = new VBox(20);
        layout.setPadding(new Insets(30, 30, 30, 30));
        layout.getChildren().addAll(label, buttonRow);
        layout.setAlignment(Pos.CENTER);

        final Scene scene = new Scene(layout, 300, 100);
        window.setScene(scene);
        window.showAndWait(); // !!!

        return answer;
    }
}
