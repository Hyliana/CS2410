package cs2410.assn8.Control;

import cs2410.assn8.Minesweeperish.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Spencer Lay - A02217251
 * @version 1.0
 *
 * A simple interface to play with settings.
 */
public class GameSettingsWindow extends Settings{

    Game myGame;
    private static final String
            NORMAL_GAME_LABEL = "Normal:\nA traditional game of \nMinesweeper!",
            DEMON_GAME_LABEL = "Speed Demon:\nYou have 10 seconds \nbetween each move!",
            TIMED_GAME_LABEL = "Countdown:\nThe clock is ticking!\nMove quickly!";

    public GameSettingsWindow(Game game){

        myGame = game;

        soundEnabledCheckbox.setOnAction(event ->
        {
            game.setSoundEnabled(soundEnabledCheckbox.isSelected());
        });

        musicEnabledCheckbox.setOnAction(event ->
        {
            game.setMusicEnabled(musicEnabledCheckbox.isSelected());
        });

        volumeSlider.setOnDragDropped(event ->
        {
            game.setMusicVolume(volumeSlider.getValue());
        });

        sizeComboBox.getItems().addAll("S: 10x10", "M: 25x25", "L: 50x25");
        gameDifficultyComboBox.getItems().addAll("Easy", "Normal", "Hard");
        gameModeComboBox.getItems().addAll("Normal", "Speed Demon", "Countdown");

        sizeComboBox.setValue("S: 10x10");
        gameDifficultyComboBox.setValue("Normal");
        gameModeComboBox.setValue("Normal");

        sizeComboBox.setOnAction(event ->
        {
            if(sizeComboBox.getValue().equals("S: 10x10"))
                game.setSize(Game.SIZE_SMALL);

            if(sizeComboBox.getValue().equals("M: 25x25"))
                game.setSize(Game.SIZE_MEDIUM);


            if(sizeComboBox.getValue().equals("L: 50x25"))
                game.setSize(Game.SIZE_LARGE);

        });

        gameDifficultyComboBox.setOnAction(event ->
        {
            if(gameDifficultyComboBox.getValue().equals("Easy"))
            game.setDifficulty(Game.EASY);


            if(gameDifficultyComboBox.getValue().equals("Medium"))
                game.setDifficulty(Game.NORMAL);


            if(gameDifficultyComboBox.getValue().equals("Hard"))
                game.setDifficulty(Game.HARD);
        });

        gameModeComboBox.setOnAction(event ->
        {

            if(gameModeComboBox.getValue().equals("Normal")) {
                game.setMode(Game.NORMAL_MODE);
                gameModeExplainationLabel.setText(NORMAL_GAME_LABEL);
            }

            if(gameModeComboBox.getValue().equals("Speed Demon")) {
                game.setMode(Game.DEMON_MODE);
                gameModeExplainationLabel.setText(DEMON_GAME_LABEL);
            }

            if(gameModeComboBox.getValue().equals("Countdown")) {
                game.setMode(Game.TIMED_MODE);
                gameModeExplainationLabel.setText(TIMED_GAME_LABEL);
            }
        });
    }
}

