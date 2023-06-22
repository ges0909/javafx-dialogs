package com.valantic.sti.tutorial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.net.URL;
import java.util.Objects;
import java.util.Optional;

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

        final Button button3 = new Button("FXML Dialog");
        button3.setOnAction(e -> openFxmlDialog());

        final Button button4 = new Button("Alert None");
        button4.setOnAction(e -> {
            final var alert = new Alert(Alert.AlertType.NONE);
            alert.setTitle("I'm an alert title");
            alert.setHeaderText("I'm an alert header");
            alert.setContentText("I'm the main alert context");
            final Optional<ButtonType> result = alert.showAndWait();
        });

        final VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(button1, button2, button3, button4);
        final Scene scene = new Scene(layout, 250, 200);
        final URL styleLocation = getClass().getResource("styles.css");
        scene.getStylesheets().add(Objects.requireNonNull(styleLocation).toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    private void closeWindow() {
        final boolean answer = ConfirmBox.display("Confirmation", "Do you want to close the application?");
        if (answer) {
            window.close();
        }
    }

    @SneakyThrows
    private void openFxmlDialog() {
        final URL location = getClass().getResource("UserEditor.fxml");
        final FXMLLoader loader = new FXMLLoader(location);
        final DialogPane dialogPane = loader.load();

        final UserController controller = loader.getController();
        final var user = new User("Vinz", "Prinz", "vinz.print@mail.de");
        controller.setUser(user);

        final Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("User editor");
        dialog.setX(window.getX() * 1.1);
        dialog.setY(window.getY() * 1.2);
        dialog.setDialogPane(dialogPane);
        dialog.showAndWait()
                .filter(buttonType -> buttonType == ButtonType.OK)
                .ifPresent(buttonType ->
                        log.info("user: {}, {}, {}",
                                user.getFirstNameProperty().get(),
                                user.getLastNameProperty().get(),
                                user.getEmailProperty().get())
                );

//        final Optional<ButtonType> clickedButtonType = dialog.showAndWait();
//        if (clickedButtonType.isPresent() && clickedButtonType.get() == ButtonType.OK) {
//            log.info("user: {}, {}, {}",
//                    user.getFirstNameProperty().get(),
//                    user.getLastNameProperty().get(),
//                    user.getEmailProperty().get());
//        }

//        final Stage window = new Stage();
//        final Scene scene = new Scene(dialogPane);
//        window.setScene(scene);
//        window.showAndWait();
    }
}
