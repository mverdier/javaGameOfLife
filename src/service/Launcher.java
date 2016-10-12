package service;

import model.Grid;

import java.util.Scanner;

/**
 * Basic launcher that will initiate a game
 */
public class Launcher {

    /**
     * Main method
     * @param args Unused
     */
    public static void main(String[] args) throws InterruptedException {

        //Initialize and display the grid
        Grid grid = new Grid(15);
        grid.display();

        for (int i = 0; i < 100; i++) {

            //Update the content of the grid
            grid.update();

            //Slight 0.5s pause
            //Thread.sleep(500);

            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();

            //Display the grid
            grid.display();
        }
    }
}
