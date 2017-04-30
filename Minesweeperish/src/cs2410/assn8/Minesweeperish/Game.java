package cs2410.assn8.Minesweeperish;

import cs2410.assn8.Control.Controller;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Timer;

/**
 * @author Spencer Lay - A02217251
 * @version 1.0
 *
 * A generic "Game" class.
 *  Specialized for Minesweeper.
 */
public class Game implements GamePart
{
    private boolean soundEnabled, musicEnabled, gameIsLive;
    private double musicVolume;
    private long time;
    private boolean startButtonIsRestartButton;

    private int gameMode, sizeMode;
    private float currentDifficultyBombRatio;
    public static final int SIZE_SMALL = 0, SIZE_MEDIUM = 1, SIZE_LARGE = 2;
    public static final int NORMAL_MODE = 0, DEMON_MODE = 1, TIMED_MODE = 2;
    public static final int EASY = 0, NORMAL = 1, HARD = 2;

    private Timer timer;
    private long score;
    CellGrid gameGrid;
    Controller controller;
    BorderPane gameBorderPane;
    Stage myStage;

    public Game(Stage myStage){
        this.myStage = myStage;
        score = 0;
        gameIsLive = false;
        setDifficulty(NORMAL);
        setMode(NORMAL_MODE);
        setSize(SIZE_SMALL);
    }

    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public long getScore() { return score; }
    public boolean isLive() { return gameIsLive; }

    public void setSoundEnabled(boolean value)
    {
        soundEnabled = value;
    }

    public void setMusicEnabled(boolean value)
    {
        musicEnabled = value;
    }

    public void setMusicVolume(double value)
    {
        musicVolume = value;
    }

    public void setSize(int size)
    {
        sizeMode = size;
    }

    public void setMode(int mode){
        gameMode = mode;
    }

    public void setDifficulty(int difficulty){
        switch (difficulty)
        {
            case EASY:
                currentDifficultyBombRatio = 0.25f;
                break;
            case NORMAL:
                currentDifficultyBombRatio = 0.45f;
                break;
            case HARD:
                currentDifficultyBombRatio = 0.655f;
                break;
        }
    }

    public void setGameGrid(CellGrid gameGrid) {
        this.gameGrid = gameGrid;
    }

    public Stage getStage() {
        return myStage;
    }

    public CellGrid getGameGrid()
    {
        return gameGrid;
    }

    public void setStartButtonIsRestartButton(boolean startButtonIsRestartButton) {
        this.startButtonIsRestartButton = startButtonIsRestartButton;
    }

    public boolean startButtonIsRestartButton()
    {
        return startButtonIsRestartButton;
    }

    public int getSizeMode() {
        return sizeMode;
    }

    @Override
    public void reset() {

        gameGrid.reset();
        gameBorderPane.setCenter((gameGrid));

        score = 0;
        gameIsLive = false;
        controller.getStartButton().setDisable(true);
    }

    @Override
    public void start() {
        gameIsLive = true;
        gameGrid.start();
        controller.getStartButton().setDisable(true);
    }

    @Override
    public void end() {
        gameIsLive = false;
        setStartButtonIsRestartButton(true);
        controller.getStartButton().setDisable(false);
        gameGrid.end();
    }

}
