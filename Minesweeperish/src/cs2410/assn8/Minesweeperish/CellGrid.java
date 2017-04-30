package cs2410.assn8.Minesweeperish;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Collections;

import static cs2410.assn8.Minesweeperish.Game.SIZE_LARGE;
import static cs2410.assn8.Minesweeperish.Game.SIZE_MEDIUM;
import static cs2410.assn8.Minesweeperish.Game.SIZE_SMALL;

/**
 * Created by spenc on 4/28/2017.
 */
public class CellGrid extends GridPane implements GamePart{
    private Game myGame;
    private int w,  //Width
                h,  // Height
                a;  // Area
    private int bombCount; // The number of bombs found on this instance of the grid.

    private Cell[][] cells;

    /**
     *  CellGrid is a class that simplifies the manipulation and checking of cells in a 2D Array.
     * @param width - the width of the grid
     * @param height - the height of the grid
     * @param ratio - a value greater than 0 and less than one that represents the percent of the board that is bombs
     */
    public CellGrid(int width, int height, float ratio, Game game)
    {
        myGame = game;
        w = width;
        h = height;
        a = w*h;
        bombCount = (int)(a*ratio); // Truancates the float result to get the number of bombs on the board.
        cells = new Cell[w][h];
        this.setAlignment(Pos.CENTER);

        setMaxHeight(Double.MAX_VALUE);
        setMaxWidth(Double.MAX_VALUE);

        loadBombs();
        generateLayout();
    }

    public Cell at(int xpos, int ypos)
    {
        return cells[xpos][ypos];
    }

    public int getGridWidth()
    {
        return w;
    }

    public int getGridHeight()
    {
        return h;
    }

    private void loadBombs()
    {
        int bombsLoaded = 0;

        // Create an ArrayList of Bombs with size a so we can shuffle them...
        ArrayList<Cell> linearBombList = new ArrayList<>();

        for(int x = 0; x < w; x++)
        {
            for(int y = 0; y < h; y++)
            {
                {
                    if(bombsLoaded <= bombCount) {
                        linearBombList.add(new Cell(true, this));
                        bombsLoaded++;
                    }
                    else
                        linearBombList.add(new Cell(false, this));
                }
            }
        }

        Collections.shuffle(linearBombList);

        int iteration = 0;
        for(int x = 0; x < w; x++)
        {
            for(int y = 0; y < h; y++)
            {
                {
                    cells[x][y] = linearBombList.get(iteration);
                    cells[x][y].setX(x);
                    cells[x][y].setY(y);
                    iteration++;
                }
            }
        }
    }



    public Game getGame()
    {
        return myGame;
    }

    private void generateLayout()
    {
        for(int x  = 0; x < w; x++)
        {
            for(int y = 0; y < h; y++)
            {
                GridPane.setConstraints(cells[x][y], x, y);
                this.getChildren().add(cells[x][y]);
            }
        }
    }

    @Override
    public void reset() {
        if(myGame.getSizeMode() == SIZE_SMALL)
        {
            w = 10;
            h = 10;
        }
        if(myGame.getSizeMode() == SIZE_MEDIUM)
        {
            w = 25;
            h = 25;
        }
        if(myGame.getSizeMode() == SIZE_LARGE)
        {
            w = 50;
            h = 25;
        }

        loadBombs();
        generateLayout();
    }

    @Override
    public void start() {
        // Call sub-part start() methods
        for(int x = 0; x < w; x++)
        {
            for(int y = 0; y < h; y++)
            {
                cells[x][y].start();
            }
        }
    }

    @Override
    public void end() {
        // Call sub-part end() methods
        for(int x = 0; x < w; x++)
        {
            for(int y = 0; y < h; y++)
            {
                cells[x][y].end();
            }
        }
    }
}
