package cs2410.assn8.Minesweeperish;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Paint;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Spencer Lay - A02217251
 * @version 1.0
 *
 * A minesweeperish cell, an extention of button.
 */
public class Cell extends Button implements GamePart {
    private CellGrid myGrid;
    private int liveNeighborCount = 0;
    private int displayState = 0;
    private int x, y;
    public static final int EMPTY = 0, FLAG = 1, QUESTIONED = 2, EXPOSED = 3;
    private boolean bomb, exposed;
    private ImageView flagGraphic, bombGraphic, questionGraphic;

    /**
     * Creates a cell of displayType EMPTY with the parameters set to the values passed in.
     *
     *      contains information about what the current displayState, whether it's a bomb for real ornah,
     *      and simplifies the method
     */
    public Cell(boolean isBomb, CellGrid grid)
    {
        //Set private data members through constructor
        myGrid = grid;
        this.x = x;
        this.y = y;
        bomb = isBomb;
        exposed = false;

        //Set Defaults
        initSize();
        try{initImages();} catch(MalformedURLException m){};
        displayState = EMPTY;
        this.setStyle("-fx-background-color: #999999; -fx-text-fill: #FFFFFF");

        this.addEventFilter(MouseEvent.ANY, event->
        {

            if(myGrid.getGame().isLive())
            {
                if(event.getEventType() == MouseEvent.MOUSE_CLICKED) {
                    if (!exposed)
                    {
                        if (event.getButton() == MouseButton.PRIMARY) {
                            expose();
                        } else if (event.getButton() == MouseButton.SECONDARY) {
                            cycleState();
                        }
                    }
                }

                if(event.getEventType() == MouseEvent.MOUSE_ENTERED)
                {
                    if(!isExposed())
                    {
                        this.setStyle("-fx-background-color: #BBBBBB; -fx-text-fill: #FFFFFF");
                    }
                }

                if(event.getEventType() == MouseEvent.MOUSE_EXITED)
                {
                    if(!isExposed())
                    {
                        this.setStyle("-fx-background-color: #999999; -fx-text-fill: #FFFFFF");
                    }
                }
            }

            else
            {
                if(event.getEventType() == MouseEvent.MOUSE_CLICKED && event.getButton() == MouseButton.PRIMARY)
                {
                    myGrid.getGame().start();
                    expose();
                }

                if(event.getEventType() == MouseEvent.MOUSE_ENTERED)
                {
                    if(!isExposed())
                    {
                        this.setStyle("-fx-background-color: #BBBBBB; -fx-text-fill: #FFFFFF");
                    }
                }

                if(event.getEventType() == MouseEvent.MOUSE_EXITED)
                {
                    if(!isExposed())
                    {
                        this.setStyle("-fx-background-color: #999999; -fx-text-fill: #FFFFFF");
                    }
                }
            }


        });
    }

    /**
     * Returns whether the cell is a bomb or not.
     */
    public boolean isBomb()
    {
        return bomb;
    }

    /**
     * Changes the current state of the cell.
     *      EMPTY to FLAG to QUESTIONED to EMPTY
     *
     */
    public void cycleState()
    {
        if(displayState == EMPTY){ displayState = FLAG; }
        else if(displayState == FLAG){ displayState = QUESTIONED; }
        else if(displayState == QUESTIONED){ displayState = EMPTY; }

        switch(displayState)
        {
            case EMPTY:
                this.setGraphic(null);
                break;
            case FLAG:
                this.setGraphic(flagGraphic);
                myGrid.decrementRemainingBombs();
                myGrid.check();
                break;
            case QUESTIONED:
                this.setGraphic(questionGraphic);
                myGrid.incrememntRemainingBombs();
                break;
        }
    }

    public boolean isExposed() {
        return exposed;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void expose()
    {
        if(!isBomb()) {
            displayState = EXPOSED;
            exposed = true;
            this.setStyle("-fx-background-color: #DDDDDD");
            this.setGraphic(null);
            countLiveNeighbors();
            if (getLiveNeighbors() > 0)
                this.setText(String.valueOf(getLiveNeighbors()));

            // Recursive Calling
            if(getLiveNeighbors() == 0)
            {
                if (y > 0 && x > 0)
                    if (!myGrid.at(x - 1, y - 1).isBomb() && !myGrid.at(x - 1, y - 1).isExposed()) {
                        myGrid.at(x - 1, y - 1).expose();
                    }
                if (y > 0)
                    if (!myGrid.at(x, y - 1).isBomb() && !myGrid.at(x, y - 1).isExposed()) {
                        myGrid.at(x, y - 1).expose();
                    }
                if (y > 0 && x < myGrid.getGridWidth() - 1)
                    if (!myGrid.at(x + 1, y - 1).isBomb() && !myGrid.at(x + 1, y - 1).isExposed()) {
                        myGrid.at(x + 1, y - 1).expose();
                    }
                if (x > 0)
                    if (!myGrid.at(x - 1, y).isBomb() && !myGrid.at(x - 1, y).isExposed()) {
                        myGrid.at(x - 1, y).expose();
                    }

                if (x < myGrid.getGridWidth() - 1)
                    if (!myGrid.at(x + 1, y).isBomb() && !myGrid.at(x + 1, y).isExposed()) {
                        myGrid.at(x + 1, y).expose();
                    }

                if (y < myGrid.getGridHeight() - 1 && x > 0)
                    if (!myGrid.at(x - 1, y + 1).isBomb() && !myGrid.at(x - 1, y + 1).isExposed()) {
                        myGrid.at(x - 1, y + 1).expose();
                    }
                if (y < myGrid.getGridHeight() - 1)
                    if (!myGrid.at(x, y + 1).isBomb() && !myGrid.at(x, y + 1).isExposed()) {
                        myGrid.at(x, y + 1).expose();
                    }
                if (y < myGrid.getGridHeight() - 1 && x < myGrid.getGridWidth() - 1)
                    if (!myGrid.at(x + 1, y + 1).isBomb() && !myGrid.at(x + 1, y + 1).isExposed()) {
                        myGrid.at(x + 1, y + 1).expose();
                    }

            }
        }
        if(isBomb())
        {
            this.setStyle("-fx-background-color: #FF2222; -fx-text-fill: #FFFFFF");
            this.setGraphic(bombGraphic);
            myGrid.getGame().end();
            this.setDisable(true);
        }

    }

    public void hide()
    {
        displayState = EMPTY;
        this.setStyle("-fx-background-color: #999999; -fx-text-fill: #FFFFFF");
    }

    public int getDisplayState() {
        return displayState;
    }

    public int getLiveNeighbors()
    {
        return liveNeighborCount;
    }

    private void countLiveNeighbors()
    {
        liveNeighborCount = 0;
        if(y>0 && x>0)
            if(myGrid.at(x-1, y-1).isBomb())
            {
                liveNeighborCount++;
            }
        if(y>0)
            if(myGrid.at(x, y-1).isBomb())
            {
                liveNeighborCount++;
            }
        if(y>0 && x<myGrid.getGridWidth()-1)
            if(myGrid.at(x+1, y-1).isBomb())
            {
                liveNeighborCount++;
            }
        if(x>0)
            if(myGrid.at(x-1, y).isBomb())
            {
                liveNeighborCount++;
            }

        if(x<myGrid.getGridWidth()-1)
            if(myGrid.at(x+1, y).isBomb())
            {
                liveNeighborCount++;
            }

        if(y<myGrid.getGridHeight()-1 && x>0)
            if(myGrid.at(x-1, y+1).isBomb())
            {
                liveNeighborCount++;
            }
        if(y<myGrid.getGridHeight()-1)
            if(myGrid.at(x, y+1).isBomb())
            {
                liveNeighborCount++;
            }
        if(y<myGrid.getGridHeight()-1 && x<myGrid.getGridWidth()-1)
            if(myGrid.at(x+1, y+1).isBomb())
            {
                liveNeighborCount++;
            }
    }

    private void initImages() throws MalformedURLException
    {
        flagGraphic = new ImageView("cs2410/assn8/media/redflag.png");
            flagGraphic.setFitHeight(getPrefHeight()*0.4);
            flagGraphic.setFitWidth(getPrefWidth()*0.4);
        questionGraphic = new ImageView("cs2410/assn8/media/question.png");
            questionGraphic.setFitHeight(getPrefHeight()*0.4);
            questionGraphic.setFitWidth(getPrefWidth()*0.4);
        bombGraphic = new ImageView("cs2410/assn8/media/bomb.png");
            bombGraphic.setFitHeight(getPrefHeight()*0.4);
            bombGraphic.setFitWidth(getPrefWidth()*0.4);
    }

    private void initSize(){
//        this.setMinWidth((myGrid.getGame().getStage().getWidth())/(double)(myGrid.getGridWidth()));
//        this.setMinHeight((myGrid.getGame().getStage().getHeight())/(double)(myGrid.getGridHeight()));
        this.setPrefWidth((myGrid.getGame().getStage().getMaxWidth())/(double)(myGrid.getGridWidth()));
        this.setPrefHeight((myGrid.getGame().getStage().getMaxHeight())/(double)(myGrid.getGridHeight()));
    }

    @Override
    public void reset() {
        // No need to implement - CellGrid takes care of resetting;
    }

    @Override
    public void start() {
        countLiveNeighbors();
        hide();
    }

    @Override
    public void end() {
        if(isBomb())
        {
            this.setGraphic(bombGraphic);
            if(displayState == FLAG)
            {
                this.setStyle("-fx-background-color: #22AA77; -fx-text-fill: #FFFFFF");
            }
            else
                this.setStyle("-fx-background-color: #FF2222; -fx-text-fill: #FFFFFF");
        }

        else
        {
            this.setGraphic(null);
            if(displayState == QUESTIONED || displayState == EMPTY)
            {
                if(getLiveNeighbors() > 0)
                    this.setText(String.valueOf(getLiveNeighbors()));
            }
        }

        this.setDisable(true);
        this.exposed = true;
    }

}
