package cs2410.assn8.Control;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class ControllerBase extends BorderPane {

    protected final FlowPane flowPane;
    protected final HBox ControlBox;
    protected final VBox vBox;
    protected final Label label;
    protected final Label bombsRemainingLabel;
    protected final Button startButton;
    protected final VBox vBox0;
    protected final Label label0;
    protected final Label timerLabel;
    protected final FlowPane flowPane0;
    protected final Button optionsButton;
    protected final FlowPane flowPane1;
    protected final Label label1;

    public ControllerBase() {

        flowPane = new FlowPane();
        ControlBox = new HBox();
        vBox = new VBox();
        label = new Label();
        bombsRemainingLabel = new Label();
        startButton = new Button();
        vBox0 = new VBox();
        label0 = new Label();
        timerLabel = new Label();
        flowPane0 = new FlowPane();
        optionsButton = new Button();
        flowPane1 = new FlowPane();
        label1 = new Label();

        setPrefHeight(64.0);
        setPrefWidth(600);
        setStyle("-fx-background-color: #3b4759;");

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setAlignment(javafx.geometry.Pos.CENTER);
        flowPane.setColumnHalignment(javafx.geometry.HPos.CENTER);
        flowPane.setPrefHeight(64.0);

        ControlBox.setAlignment(javafx.geometry.Pos.CENTER);
        ControlBox.setPrefHeight(64.0);
        ControlBox.setSpacing(64.0);

        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);

        label.setText("Bombs Remaining");
        label.setTextFill(javafx.scene.paint.Color.WHITE);

        bombsRemainingLabel.setText("--");
        bombsRemainingLabel.setTextFill(javafx.scene.paint.Color.WHITE);

        startButton.setMnemonicParsing(false);
        startButton.setPrefHeight(48.0);
        startButton.setPrefWidth(48.0);
        startButton.setText("Start");

        vBox0.setAlignment(javafx.geometry.Pos.CENTER);
        vBox0.setPrefHeight(200.0);
        vBox0.setPrefWidth(100.0);

        label0.setText("Time");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);

        timerLabel.setText("--");
        timerLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        FlowPane.setMargin(ControlBox, new Insets(0.0));
        BorderPane.setMargin(flowPane, new Insets(0.0));
        setCenter(flowPane);

        BorderPane.setAlignment(flowPane0, javafx.geometry.Pos.CENTER);
        flowPane0.setAlignment(javafx.geometry.Pos.CENTER);
        flowPane0.setPrefHeight(200.0);
        flowPane0.setPrefWrapLength(0.0);

        optionsButton.setAlignment(javafx.geometry.Pos.CENTER);
        optionsButton.setMnemonicParsing(false);
        optionsButton.setText("Options");
        FlowPane.setMargin(optionsButton, new Insets(0.0, 16.0, 0.0, 16.0));
        setRight(flowPane0);

        BorderPane.setAlignment(flowPane1, javafx.geometry.Pos.CENTER);
        flowPane1.setAlignment(javafx.geometry.Pos.CENTER);
        flowPane1.setColumnHalignment(javafx.geometry.HPos.CENTER);
        flowPane1.setPrefHeight(200.0);
        flowPane1.setPrefWrapLength(0.0);

        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label1.setText("By Spencer Lay");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#909090"));
        FlowPane.setMargin(label1, new Insets(0.0, 16.0, 0.0, 16.0));
        setLeft(flowPane1);

        vBox.getChildren().add(label);
        vBox.getChildren().add(bombsRemainingLabel);
        ControlBox.getChildren().add(vBox);
        ControlBox.getChildren().add(startButton);
        vBox0.getChildren().add(label0);
        vBox0.getChildren().add(timerLabel);
        ControlBox.getChildren().add(vBox0);
        flowPane.getChildren().add(ControlBox);
        flowPane0.getChildren().add(optionsButton);
        flowPane1.getChildren().add(label1);

    }

    public Button getStartButton() {
        return startButton;
    }

    public Button getOptionsButton() {
        return optionsButton;
    }

    public Label getTimerLabel() {
        return timerLabel;
    }

    public Label getBombsRemainingLabel() {
        return bombsRemainingLabel;
    }
}


