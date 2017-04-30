package cs2410.assn8;

import cs2410.assn8.Control.Controller;
import cs2410.assn8.Minesweeperish.CellGrid;
import cs2410.assn8.Minesweeperish.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {
    BorderPane scenePanel = new BorderPane();
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setMinWidth(600);
        primaryStage.setMaxWidth(600);
        primaryStage.setMinHeight(664);
        primaryStage.setMaxHeight(664);

        scenePanel.setMaxWidth(primaryStage.getWidth()-12);
        scenePanel.setMaxHeight(primaryStage.getHeight()-64-12);

        Game game = new Game(primaryStage);
        Controller ctrl = new Controller(game, primaryStage);
        game.setController(ctrl);


        CellGrid initGrid = new CellGrid(20, 20, 0.25f, game);
        initGrid.setMinWidth(scenePanel.getWidth());
        game.setGameGrid(initGrid);

        scenePanel.setTop(ctrl);
        scenePanel.setCenter(initGrid);

        ctrl.setStageDimensions(600, 664);

        Scene myScene = new Scene(scenePanel);
        primaryStage.setScene(myScene);
        primaryStage.setTitle("Minesweeperish");
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}