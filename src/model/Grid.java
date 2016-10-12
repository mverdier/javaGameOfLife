package model;

import java.util.ArrayList;

import static java.lang.Math.random;

/**
 * Represents the grid that contains the cells
 */
public class Grid {

    /**
     * Size of the board. Cannot be lower
     * than 10, for readability purposes
     */
    private int size;

    private ArrayList<ArrayList<Cell>> board;

    public Grid(int size) {
        //As stated, the size will be at least 10
        this.size = size >= 10 ? size : 10;
        this.board = new ArrayList<>(size);

        //Basic initalization to create all
        //of the cells for the given size
        for (int i = 0; i < size; i++) {

            ArrayList<Cell> row = new ArrayList<>(size);

            for (int j = 0; j < size; j++) {

                //Randomly selects the content of the cell
                row.add(new Cell(i, j, random() < 0.1));
            }

            this.board.add(row);
        }
    }

    /**
     * Checks and updates the alive state of each
     * cell on the board for the next generation
     */
    public void update() {
        for (ArrayList<Cell> column : board) {
            for (Cell cell : column) {
                cell.update(getNeighbors(cell));
            }
        }
    }

    /**
     * Displays the whole board according to
     * each cell's status
     */
    public void display() {

        //Printing a ton of blank lines to clear out the display
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }

        for (ArrayList<Cell> row : board) {
            row.forEach(Cell::display);

            //Printing a new line to go to the next row
            System.out.println();
        }
    }

    /**
     * Gets a specific cell from the board, for
     * a cleaner access in other parts of the code.
     * The coordinates are put back on the board if
     * they get outside of it.
     *
     * @param x Horizontal coordinate
     * @param y Vertical coordinate
     * @return Cell at the given coordinates
     */
    private Cell getCell(int x, int y) {
        return board.get(value(y)).get(value(x));
    }

    /**
     * Gets the eight neighbors of a cell
     * @param cell The cell for which we want the neighbors
     * @return A list of the cell's neighbors
     */
    private ArrayList<Cell> getNeighbors(Cell cell) {
        ArrayList<Cell> neighbors = new ArrayList<>();

        int x = cell.getX();
        int y = cell.getY();

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i != 0 || j != 0) {
                    neighbors.add(getCell(value(y + i), value(x + i)));
                }
            }
        }

        return neighbors;
    }

    /**
     * Returns the valid index according to
     * the input and to the board's size
     * @param index Input
     * @return Actual value
     */
    private int value(int index) {
        if (index < 0) {
            return value(index + size);
        } else if (index >= size) {
            return value(index - size);
        }
        return index;
    }
}
