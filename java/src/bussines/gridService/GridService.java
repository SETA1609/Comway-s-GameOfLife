package bussines.gridService;

import bussines.cellService.CellService;
import bussines.cellService.CellServiceInterface;
import dao.Cell;
import dao.Grid;

public class GridService implements GridServiceInterface {

    private Grid currentGrid;
    private final CellServiceInterface cellServiceInterface;

    public GridService() {
        cellServiceInterface = new CellService();
        currentGrid = new Grid(10, 40);
        populateGrid();
    }

    private void populateGrid() {
        for (int i = 0; i < currentGrid.getRows(); i++) {
            for (int j = 0; j < currentGrid.getCols(); j++) {
                currentGrid.getCellGrid()[i][j] = cellServiceInterface.makeCell();
            }
        }
    }

    private void getNextGeneration(){

        currentGrid=getNewGeneration();

    }

    private Grid getNewGeneration(){
        Grid oldGrid = new Grid(currentGrid.getCellGrid());
        Grid newGrid = new Grid(currentGrid.getRows(), currentGrid.getCols());
        int checkSum=0;

        for (int i = 0; i < oldGrid.getCols(); i++) {
            for (int j = 0; j < oldGrid.getRows(); j++) {


                    checkSum= countNeighbours(oldGrid,i,j);

                    if (!oldGrid.getCellGrid()[i][j].isAlive() && checkSum==3){
                        newGrid.getCellGrid()[i][j]=new Cell(true);
                    } else if (oldGrid.getCellGrid()[i][j].isAlive()&&(checkSum<2||checkSum>3)) {
                        newGrid.getCellGrid()[i][j]=new Cell(false);
                    }else {
                        newGrid.getCellGrid()[i][j]=oldGrid.getCellGrid()[i][j];
                    }


            }
        }

        return newGrid;
    }



    private int countNeighbours(Grid grid, int col, int row) {
        int checkSum = 0;
        Cell[][] cellGrid = grid.getCellGrid();
        int numRows = grid.getRows();
        int numCols = grid.getCols();

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int currentCol = (i + row + numRows) % numRows;
                int currentRow = (j + col + numCols) % numCols;
                checkSum += cellGrid[currentRow][currentCol].isAlive() ? 1 : 0;
            }
        }
        return checkSum;
    }


    @Override
    public void startDefaultSimulation() {
        print(currentGrid);
        for (int i = 0; i < 5 ; i++) {
            getNextGeneration();
            print(currentGrid);
        }
    }

    @Override
    public void startMultigenerationSimulation() {

    }


    private void print(Grid grid) {
        System.out.println("------- Start of this Generation -------");

        for (int i = 0; i < grid.getRows() ; i++) {
            for (int j = 0; j < grid.getCols() ; j++) {
                char characterToPrint=grid.getCellGrid()[i][j].isAlive()?'o':' ';
                System.out.print(characterToPrint);
            }
            System.out.println();
        }
        System.out.println("-------- End of this Generation --------");
        System.out.println();
    }
}
