package model;

import java.util.List;

/**
 * Represents a basic cell of the grid
 */
public class Cell {

    /**
     * Horizontal coordinate on its board, starts at 0
     */
    private int x;

    /**
     * Vertical coordinate on its board, starts at 0
     */
    private int y;

    /**
     * Represents the current status of the cell
     * true if the cell is alive, false otherwise
     */
    private boolean alive;

    public Cell(int x, int y, boolean alive) {
        this.x = x;
        this.y = y;
        this.alive = alive;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isAlive() {
        return alive;
    }

    /**
     * Displays the cell's state on a board,
     * if it isn't alive it'll print a blank
     * space, otherwise a full space (#)
     */
    public void display() {
        System.out.print(alive ? " " : "#");
    }

    /**
     * Update the cell's state according to
     * its neighbors
     * @param neighbors Eight neighbors of the cell
     */
    public void update(List<Cell> neighbors) {
        int aliveNeighbors = 0;

        for (Cell neighbor : neighbors) {
            if (neighbor.isAlive()) {
                aliveNeighbors++;
            }
        }

        if (this.isAlive()) {
            this.alive = aliveNeighbors == 2 || aliveNeighbors == 3;
        } else {
            this.alive = aliveNeighbors == 3;
        }
    }
}
