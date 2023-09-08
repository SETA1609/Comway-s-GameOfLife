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
                if (){

                }
            }
        }

        return newGrid;
    }

    @Override
    public void startDefaultSimulation() {

    }

    @Override
    public void startMultigenerationSimulation() {

    }
}
