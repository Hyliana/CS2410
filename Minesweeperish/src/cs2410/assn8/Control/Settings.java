package cs2410.assn8.Control;

import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public abstract class Settings extends TabPane {

    protected final Tab tab;
    protected final AnchorPane anchorPane;
    protected final BorderPane borderPane;
    protected final VBox vBox;
    protected final CheckBox soundEnabledCheckbox;
    protected final CheckBox musicEnabledCheckbox;
    protected final VBox vBox0;
    protected final Separator separator;
    protected final Label label;
    protected final Slider volumeSlider;
    protected final Tab tab0;
    protected final AnchorPane anchorPane0;
    protected final HBox hBox;
    protected final VBox vBox1;
    protected final Label label0;
    protected final ChoiceBox<String> sizeComboBox;
    protected final Label label1;
    protected final ChoiceBox<String> gameModeComboBox;
    protected final VBox vBox2;
    protected final Label label2;
    protected final ChoiceBox<String> gameDifficultyComboBox;
    protected final Label gameModeExplainationLabel;

    public Settings() {

        tab = new Tab();
        anchorPane = new AnchorPane();
        borderPane = new BorderPane();
        vBox = new VBox();
        soundEnabledCheckbox = new CheckBox();
        musicEnabledCheckbox = new CheckBox();
        vBox0 = new VBox();
        separator = new Separator();
        label = new Label();
        volumeSlider = new Slider();
        tab0 = new Tab();
        anchorPane0 = new AnchorPane();
        hBox = new HBox();
        vBox1 = new VBox();
        label0 = new Label();
        sizeComboBox = new ChoiceBox();
        label1 = new Label();
        gameModeComboBox = new ChoiceBox();
        vBox2 = new VBox();
        label2 = new Label();
        gameDifficultyComboBox = new ChoiceBox();
        gameModeExplainationLabel = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(240.0);
        setPrefWidth(320.0);
        setTabClosingPolicy(javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE);

        tab.setText("Settings");

        anchorPane.setMinHeight(0.0);
        anchorPane.setMinWidth(0.0);
        anchorPane.setPrefHeight(180.0);
        anchorPane.setPrefWidth(200.0);

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        vBox.setPrefWidth(320.0);
        vBox.setOpaqueInsets(new Insets(0.0, 0.0, 0.0, 32.0));

        soundEnabledCheckbox.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        soundEnabledCheckbox.setMnemonicParsing(false);
        soundEnabledCheckbox.setText("Sound Enabled");
        soundEnabledCheckbox.setOpaqueInsets(new Insets(0.0));
        VBox.setMargin(soundEnabledCheckbox, new Insets(38.0, 0.0, 0.0, 32.0));
        soundEnabledCheckbox.setPadding(new Insets(8.0));

        musicEnabledCheckbox.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        musicEnabledCheckbox.setLayoutX(42.0);
        musicEnabledCheckbox.setLayoutY(187.0);
        musicEnabledCheckbox.setMnemonicParsing(false);
        musicEnabledCheckbox.setText("Music Enabled");
        musicEnabledCheckbox.setOpaqueInsets(new Insets(0.0));
        VBox.setMargin(musicEnabledCheckbox, new Insets(0.0, 0.0, 0.0, 32.0));
        musicEnabledCheckbox.setPadding(new Insets(8.0));
        BorderPane.setMargin(vBox, new Insets(0.0, 0.0, 32.0, 0.0));
        borderPane.setTop(vBox);

        BorderPane.setAlignment(vBox0, javafx.geometry.Pos.CENTER);
        vBox0.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        vBox0.setOpaqueInsets(new Insets(0.0, 0.0, 0.0, 32.0));

        separator.setPrefWidth(200.0);
        VBox.setMargin(separator, new Insets(0.0, 0.0, 12.0, 0.0));

        label.setText("Music Volume");
        VBox.setMargin(label, new Insets(0.0, 0.0, 0.0, 80.0));

        volumeSlider.setShowTickMarks(true);
        volumeSlider.setValue(80.0);
        VBox.setMargin(volumeSlider, new Insets(0.0));
        volumeSlider.setPadding(new Insets(8.0, 48.0, 8.0, 48.0));
        borderPane.setBottom(vBox0);
        tab.setContent(anchorPane);

        tab0.setText("Game Options");

        anchorPane0.setMinHeight(0.0);
        anchorPane0.setMinWidth(0.0);
        anchorPane0.setPrefHeight(180.0);
        anchorPane0.setPrefWidth(200.0);

        hBox.setPrefHeight(213.0);
        hBox.setPrefWidth(320.0);

        vBox1.setPrefHeight(196.0);
        vBox1.setPrefWidth(160.0);

        label0.setText("Board Size");
        label0.setPadding(new Insets(8.0));
        VBox.setMargin(label0, new Insets(24.0, 0.0, 0.0, 0.0));

        sizeComboBox.setPrefWidth(150.0);
        VBox.setMargin(sizeComboBox, new Insets(0.0, 0.0, 0.0, 4.0));

        label1.setText("Game Mode");
        label1.setPadding(new Insets(8.0));
        VBox.setMargin(label1, new Insets(32.0, 0.0, 0.0, 0.0));

        gameModeComboBox.setPrefWidth(150.0);
        VBox.setMargin(gameModeComboBox, new Insets(0.0, 0.0, 0.0, 4.0));

        vBox2.setPrefHeight(196.0);
        vBox2.setPrefWidth(160.0);

        label2.setText("Game Difficulty");
        label2.setPadding(new Insets(8.0));
        VBox.setMargin(label2, new Insets(24.0, 0.0, 0.0, 0.0));

        gameDifficultyComboBox.setPrefWidth(150.0);
        VBox.setMargin(gameDifficultyComboBox, new Insets(0.0, 0.0, 0.0, 4.0));

        gameModeExplainationLabel.setMaxWidth(120.0);
        gameModeExplainationLabel.setText("Explanation:");
        VBox.setMargin(gameModeExplainationLabel, new Insets(32.0, 0.0, 0.0, 16.0));
        tab0.setContent(anchorPane0);

        vBox.getChildren().add(soundEnabledCheckbox);
        vBox.getChildren().add(musicEnabledCheckbox);
        vBox0.getChildren().add(separator);
        vBox0.getChildren().add(label);
        vBox0.getChildren().add(volumeSlider);
        anchorPane.getChildren().add(borderPane);
        getTabs().add(tab);
        vBox1.getChildren().add(label0);
        vBox1.getChildren().add(sizeComboBox);
        vBox1.getChildren().add(label1);
        vBox1.getChildren().add(gameModeComboBox);
        hBox.getChildren().add(vBox1);
        vBox2.getChildren().add(label2);
        vBox2.getChildren().add(gameDifficultyComboBox);
        vBox2.getChildren().add(gameModeExplainationLabel);
        hBox.getChildren().add(vBox2);
        anchorPane0.getChildren().add(hBox);
        getTabs().add(tab0);

    }
}
