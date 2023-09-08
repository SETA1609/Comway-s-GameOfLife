package bussines.cellService;

import dao.Cell;

public class CellService implements CellServiceInterface{
    @Override
    public Cell makeCell() {
        int randomNumber= (int) Math.floor(Math.random()*2);
        boolean isAlive= randomNumber == 1;
        return new Cell(isAlive);
    }
}
