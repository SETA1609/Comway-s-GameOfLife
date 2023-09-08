package bussines.gridService;

import dao.Grid;

public interface GridServiceInterface {

    // default 5 generations
    void getGrid();
    // with input
    void getGridForANumberOfGenerations();

}
