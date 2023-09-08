package bussines.gridService;

import dao.Grid;

public interface GridServiceInterface {

    Grid makeGrid(int cols, int rows);
    void getGridForANumberOfGenerations(int generations);

}
