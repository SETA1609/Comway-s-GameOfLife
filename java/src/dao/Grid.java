package dao;

public class Grid {

    private int rows;
    private int cols;
    private Cell[][] cellGrid;

    public Grid() {
        setRows(0);
        setCols(0);
        setCellGrid(new Cell[rows][cols]);
    }

    public Grid(int rows, int cols) {
        setRows(rows);
        setCols(cols);
        setCellGrid(new Cell[this.rows][this.cols]);
    }

    public Grid(Cell[][] cellGrid) {
        setCellGrid(cellGrid);
        setCols(cellGrid.length);
        setRows(cellGrid[1].length);
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public Cell[][] getCellGrid() {
        return cellGrid;
    }

    public void setCellGrid(Cell[][] cellGrid) {
        this.cellGrid = cellGrid;
    }



}
