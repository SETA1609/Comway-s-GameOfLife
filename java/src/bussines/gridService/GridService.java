package bussines.gridService;

import bussines.cellService.CellService;
import bussines.cellService.CellServiceInterface;
import dao.Cell;
import dao.Grid;

public class GridService implements GridServiceInterface {

    private Grid currentGrid;
    private CellServiceInterface cellServiceInterface;

    public GridService() {
        cellServiceInterface = new CellService();
        currentGrid = new Grid(10, 10);
        populateGrid();
    }

    private void populateGrid() {
        for (int i = 0; i < currentGrid.getCols(); i++) {
            for (int j = 0; j < currentGrid.getRows(); j++) {
                currentGrid.getCellGrid()[i][j] = cellServiceInterface.makeCell();
            }
        }
    }

    private void getNextGeneration(){

    }

    private Grid getNewGeneration(){
        Grid oldGrid = new Grid(currentGrid.getCellGrid());
        Grid newGrid = new Grid(currentGrid.getCols(), currentGrid.getRows());
        int checkSum=0;

        for (int i = 0; i < oldGrid.getCols(); i++) {
            for (int j = 0; j < oldGrid.getRows(); j++) {

                if (i==0||i== oldGrid.getCols()-1|| j==0 ||j== oldGrid.getRows()-1){
                    newGrid.getCellGrid()[i][j]=oldGrid.getCellGrid()[i][j];
                }else {
                    checkSum= countNeighbours(oldGrid.getCellGrid(),i,j);

                    if (!oldGrid.getCellGrid()[i][j].isAlive() && checkSum==3){
                        newGrid.getCellGrid()[i][j]=new Cell(true);
                    } else if (oldGrid.getCellGrid()[i][j].isAlive()&&(checkSum<2||checkSum>3)) {
                        newGrid.getCellGrid()[i][j]=new Cell(false);
                    }else {
                        newGrid.getCellGrid()[i][j]=oldGrid.getCellGrid()[i][j];
                    }
                }

            }
        }

        return newGrid;
    }

    private int countNeighbours(Cell[][] cellGrid, int col, int row) {
        int checkSum=0;

        for (int i = -1; i < 2 ; i++) {
            for (int j = -1; j < 2 ; j++) {
                checkSum+= cellGrid[i+col][j+row].isAlive()?1:0;
            }
        }
        checkSum-=cellGrid[col][row].isAlive()?1:0;
        return checkSum;
    }


    @Override
    public void startDefaultSimulation() {

    }

    @Override
    public void startMultigenerationSimulation() {

    }
}
