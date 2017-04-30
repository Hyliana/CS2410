package cs2410.assn8.Control;

import cs2410.assn8.Minesweeperish.Game;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Spencer Lay - A02217251
 * @version 1.0
 *
 * A simple interface to initialize from the JavaFX Scences built in SceneBuilder
 */

public class Controller extends ControllerBase
{
    Game myGame;
    Stage myStage;

    public Controller(Game game, Stage primaryStage) {
        myGame = game;
        myStage = primaryStage;

        setPrefWidth(myStage.getWidth());
        setMinHeight(64);


        optionsButton.setOnAction(event ->
        {
            GameSettingsWindow gsw = new GameSettingsWindow(myGame);
            Scene settingsScene = new Scene(gsw);
            Stage settingsWindow = new Stage();
            settingsWindow.setScene(settingsScene);
            settingsWindow.setTitle("Settings");
            settingsWindow.show();
        });

        startButton.setOnAction(event ->
        {
            if(!game.startButtonIsRestartButton()) {
                if (!myGame.isLive()) {
                    myGame.start();
                    startButton.setDisable(true);
                }
            }
            else
            {
                    myGame.reset();
                    startButton.setDisable(true);
            }
        });

    }

    public void setStageDimensions(int w, int h)
    {
        myStage.setMaxHeight(h);
        myStage.setMinHeight(h);
        myStage.setMaxWidth(w);
        myStage.setMinWidth(w);
    }
}
