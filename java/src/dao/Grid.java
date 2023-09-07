package dao;

public class Grid {

    private int cols;
    private int rows;
    private Cell[][] cellGrid;

    public Grid() {
        setCols(0);
        setRows(0);
        setCellGrid(new Cell[cols][rows]);
    }

    public Grid(int cols, int rows) {
        setCols(cols);
        setRows(rows);
        setCellGrid(new Cell[this.cols][this.rows]);
    }

    public Grid(Cell[][] cellGrid) {
        setCellGrid(cellGrid);
        setRows(cellGrid.length);
        setCols(cellGrid[1].length);
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public Cell[][] getCellGrid() {
        return cellGrid;
    }

    public void setCellGrid(Cell[][] cellGrid) {
        this.cellGrid = cellGrid;
    }
}
