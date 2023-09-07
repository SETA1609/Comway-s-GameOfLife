package dao;

public class Cell {
    private boolean isAlive;

    public Cell() {
    }

    public Cell(boolean isAlive) {
        setAlive(isAlive);
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
