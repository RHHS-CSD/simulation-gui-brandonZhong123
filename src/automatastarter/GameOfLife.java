/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package automatastarter;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author brand
 */
public class GameOfLife {

    // Grid Variables
    private int grid[][];
    private int cellNeighbours[][];
    private int diseasedCells[][];
    private int width;
    private int height;
    private int tileSize;
    private int gridX;
    private int gridY;
    private boolean updateWithVirus = false;
    

    /**
     * Constructor initializes the size and position of the grid simulation
     * @param x x position of the grid
     * @param y y position of the grid
     * @param height height of the grid
     * @param width width of the grid
     * @param tileSize size of each tile
     */
    public GameOfLife (int x, int y, int height, int width, int tileSize){
        this.width = width;
        this.height = height;
        this.tileSize = tileSize;
        cellNeighbours = new int[width / tileSize][height / tileSize];
        grid = new int[width / tileSize][height / tileSize];
        diseasedCells = new int[width / tileSize][height / tileSize];
        gridX = x;
        gridY = y;
    }
    
    /**
     * This method updates the grid
     */
    public void update() {
        checkNeighbours();
        updateCell();
    }

    private int determineNeighbours(int row, int col) {
        int neighbours = 0;

        boolean infected = false;
        int virus = 0;
        //If cell has a disease cell is infected
        if (diseasedCells[row][col] != 0) {
            infected = true;
            // Level of virus is the cell
            virus = diseasedCells[row][col];
        }
        // If row index is not on the last one
        if (row != grid.length - 1) {
            // If the neighbour to the right is alive
            if (grid[row + 1][col] == 1) {
                neighbours++;
                 //If cell is infected and neighbour is not infected infect right neighbour
                if (infected && diseasedCells[row + 1][col] == 0) {
                    infectCells(row + 1, col, virus);
                }
            }
        }

        // If row index is not on the first one
        if (row != 0) {
            // If the neighbour to the left is alive
            if (grid[row - 1][col] == 1) {
                neighbours++;
                // If cell is infected and neighbour is not infected infect left neighbour
                if (infected && diseasedCells[row - 1][col] == 0) {
                    infectCells(row - 1, col, virus);
                }
            }
            // If column index is not on the last one
            if (col != grid[0].length - 1) {
                // If the neighbour diagonally left and down is alive
                if (grid[row - 1][col + 1] == 1) {
                    neighbours++;
                    // If cell is infected and neighbour is not infected infect diagonally left and down neighbour
                    if (infected && diseasedCells[row - 1][col + 1] == 0) {
                        infectCells(row - 1, col + 1, virus);
                    }
                }
            }
        }

        // If column index is not on the last one
        if (col != grid[0].length - 1) {
            // If the neighbour below is alive
            if (grid[row][col + 1] == 1) {
                neighbours++;
                // If cell is infected and neighbour is not infected infect neighbour below
                if (infected && diseasedCells[row][col + 1] == 0) {
                    infectCells(row, col + 1, virus);
                }
            }
        }

        // If the column index is not on the first one
        if (col != 0) {
            // If the neighbour above is alive
            if (grid[row][col - 1] == 1) {
                neighbours++;
                // If cell is infected and neighbour is not infected infect neighbour above
                if (infected && diseasedCells[row][col - 1] == 0) {
                    infectCells(row, col - 1, virus);
                }
            }
            // If the row index isn't on the last one
            if (row != grid.length - 1) {
                // If the neighbour diagonally right and above is alive
                if (grid[row + 1][col - 1] == 1) {
                    neighbours++;
                    // If cell is infected and neighbour is not infected infect neighbout right and above
                    if (infected && diseasedCells[row + 1][col - 1] == 0) {
                        infectCells(row + 1, col - 1, virus);
                    }
                }
            }
        }

        // If index is not on the first index for row and col
        if (row != 0 && col != 0) {
            // If the neighbour diagonally left and above is alive
            if (grid[row - 1][col - 1] == 1) {
                neighbours++;
                // If cell is infected and neighbour is not infected infect neighbour left and above
                if (infected && diseasedCells[row - 1][col - 1] == 0) {
                    infectCells(row - 1, col - 1, virus);
                }
            }
        }

        // If index is not on the last one for row and col
        if (row != grid.length - 1 && col != grid[0].length - 1) {
            // If the neighbour diagonally right and below is alive
            if (grid[row + 1][col + 1] == 1) {
                neighbours++;
                // If cell is infected and neighbour is not infected infect neighbour right and below
                if (infected && diseasedCells[row + 1][col + 1] == 0) {
                    infectCells(row + 1, col + 1, virus);
                }
            }
        }

        // Return the number of neighbours a cell has 
        return neighbours;
    }

    // returns true if a cell should die but returns false if a cell should live
    private boolean shouldDie(int neighbours, boolean isDead) {
        // If a dead cell has exactly 3 neighbours, it becomes alive
        if (isDead) {
            return neighbours != 3;
        }
        // If a live cell has fewer than 2 or more than 3 neighbours, it dies
        return neighbours < 2 || neighbours > 3;
    }

    private void checkNeighbours() {

        // Loop through each row
        for (int r = 0; r < cellNeighbours.length; r++) {
            // Loop through each column
            for (int c = 0; c < cellNeighbours[0].length; c++) {
                // Initalize number of neighbours
                int neighbours = determineNeighbours(r, c);
                cellNeighbours[r][c] = neighbours;
            }
        }
    }

    private void updateCell() {

        // For each row
        for (int r = 0; r < cellNeighbours.length; r++) {
            // For each column
            for (int c = 0; c < cellNeighbours[r].length; c++) {
                // Check if a alive cell should die 
                if (shouldDie(cellNeighbours[r][c], false)) {
                    grid[r][c] = 0;
                } // Check if a dead cell should live
                else if (!shouldDie(cellNeighbours[r][c], true)) {
                    grid[r][c] = 1;
                }
            }
        }
        
        killCellWithVirus();
        if (updateWithVirus)
            addVirus();

    }
    
    /**
     * This method creates a grid randomly with 1s and 0s
     */
    public void createGrid() {

        // For each row
        for (int i = 0; i < grid.length; i++) {
            // For each column
            for (int j = 0; j < grid[i].length; j++) {
                // Create a random number 1-0 and input into array
                grid[i][j] = (int) Math.floor(Math.random() * 2);
                // If grid should be created with virus
                if (grid[i][j] == 1 && updateWithVirus)
                    updateVirus(i, j);
            }
        }
    }
    
    /**
     * This method draws the grid lines
     * @param g used to draw to the screen
     */
    public void drawGridLines(Graphics g) {
        
        g.setColor(Color.GRAY);
        for (int i = 0; i <= width ; i += tileSize) {
            g.drawLine(i, 0, i, height);
        }
        
        for (int i = 0; i <= height; i += tileSize) {
            g.drawLine(0, i, width , i);
        }
    }
    
    /**
     * This method draws the individual grid cells
     * @param g used to draw to the screen
     * @param c used to use the color
     */
    public void drawGrid(Graphics g, Color c) {
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    g.setColor(c);
                    g.fillRect(i * tileSize + gridX, j * tileSize + gridY, tileSize, tileSize); 
                }

            }
        }

    }
    
    /**
     * This method draws different colored cells based on the virus a cell might have
     * A level 1 virus is drawn using yellow colred cells
     * A level 2 virus is drawn using orange colored cells
     * A level 3 virus is drawing using red colored cells
     * @param g 
     */
    public void drawVirusGrid(Graphics g) {
        
        // For each row
        for (int i = 0; i < grid.length; i++) {
            // For each col
            for (int j = 0; j < grid[i].length; j++) {
                // If cell is a level 1 virus draw yellow cell
                if (diseasedCells[i][j] == 1) {
                    g.setColor(Color.yellow);
                    g.fillRect(i * tileSize + gridX, j * tileSize + gridY, tileSize, tileSize); 
                }
                // If cell is a level 2 virus draw a orange cell
                if (diseasedCells[i][j] == 2) {
                    g.setColor(Color.orange);
                    g.fillRect(i * tileSize + gridX, j * tileSize + gridY, tileSize, tileSize); 
                }
                // If virus is a level 3 virus draw a red cell
                if (diseasedCells[i][j] == 3) {
                    g.setColor(Color.red);
                    g.fillRect(i * tileSize + gridX, j * tileSize + gridY, tileSize, tileSize); 
                }

            }
        }

    }
    
    /**
     * This method clears all the viruses in each cell
     */
    public void clearVirus() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (diseasedCells[i][j] != 0) {
                    diseasedCells[i][j] = 0;
                }

            }
        }
    }
    /**
     * This method updates an individual cell 
     * @param x x position of cell to be updated
     * @param y y position of cell to be updated
     */
    public void updateIndividualCell(int x, int y) {
        
        // Find coresponding row and col based on x and y position of click
        int r = x / tileSize;
        int c = y / tileSize;
        // If within bounds of grid
        if (!(r < 0 || r > grid.length - 1 || c < 0 || c > grid[0].length - 1)) {
            // Change to opposite cell 
            if (grid[r][c] == 0) {
                grid[r][c] = 1;
            }
            else {
                grid[r][c] = 0;
            }
        }
        
    }
    
    /**
     * This method clears all the cells in the grid
     */
    public void clearGrid () {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++ ){ 
                grid[i][j] = 0;
                cellNeighbours[i][j] = 0;
            }
        }
    }

    private void updateVirus(int r, int c) {

        // Generate a random number 0-99
        int virus = (int) Math.floor(Math.random() * 100);

        // If the number is 0 the type of virus is a level 1 virus
        if (virus == 0) {
            diseasedCells[r][c] = 1;
        }
        // If the number is 1 the type of virus is a level 2 virus
        if (virus == 1) {
            diseasedCells[r][c] = 2;
        }
        // If the number is 2 the type of virus is a level 3 virus
        if (virus == 2) {
            diseasedCells[r][c] = 3;
        }
    }
    
    private void addVirus() {
        for (int r = 0; r < grid.length; r++) {
            // For each column
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    updateVirus(r, c);
                }
            }
        }
    }

    private void infectCells(int r, int c, int virus) {
        // Generate a random 0-9
        int infectChance = (int) Math.floor(Math.random() * 10);

        // If the the random num is between 0-3 (40% chance of infecting) and the virus is level 3
        if (infectChance < 4 && virus == 3) {
            // Determine what type of virus to infect neighbour (50% chance to infect with level 3 or level 2 virus)
            int typeOfVirus = (int) Math.floor(Math.random() * 2);
            if (typeOfVirus == 1) {
                diseasedCells[r][c] = virus;
            } else {
                diseasedCells[r][c] = virus - 1;
            }
        }
        // If the random num is between 0-4 (50% chance of infecting) and the virus is level 2
        if (infectChance < 5 && virus == 2) {
            // Level 2 virus can only infect neighbours with level 1 virus
            diseasedCells[r][c] = virus - 1;

        }

    }

    private void killCellWithVirus() {

        int killChance;
        // For each row
        for (int r = 0; r < grid.length; r++) {
            // For each column
            for (int c = 0; c < grid[0].length; c++) {
                // Skips over iteration if cell is already dead
                if (grid[r][c] == 0) {
                    diseasedCells[r][c] = 0;
                    continue;
                }
                // If virus level is 3
                switch (diseasedCells[r][c]) {
                    case 3:
                        // Generate random num 0-9
                        killChance = (int) Math.floor(Math.random() * 10);
                        // If num is lower than or equal to 4 (50% chance)
                        if (killChance <= 4) {
                            // Kill cell
                            grid[r][c] = 0;
                            diseasedCells[r][c] = 0;
                        } // If num is == 9 (10 % chance)
                        else if (killChance == 9) {
                            // get rid of virus
                            diseasedCells[r][c] = 0;
                        }
                        break;
                    case 2:
                        // Generate random num 0-19
                        killChance = (int) Math.floor(Math.random() * 20);
                        // If num is less than or equal to 8 (40% chance)
                        if (killChance <= 8) {
                            // Kill Cell
                            grid[r][c] = 0;
                            diseasedCells[r][c] = 0;
                        } // If num is greater than 15 (20% chance)
                        else if (killChance > 15) {
                            // Get rid of virus
                            diseasedCells[r][c] = 0;
                        }
                        break;
                    case 1:
                        // Generate a random number 0-39
                        killChance = (int) Math.floor(Math.random() * 10);
                        // If Number is less than or equal to one (30% chance) 
                        if (killChance <= 2) {
                            // Kill cell
                            grid[r][c] = 0;
                            diseasedCells[r][c] = 0;
                        } // If number is greater than 30 (20% chance)
                        else if (killChance >= 8) {
                            // Get rid of virus
                            diseasedCells[r][c] = 0;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }
    
    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public void setCellNeighbours(int[][] cellNeighbours) {
        this.cellNeighbours = cellNeighbours;
    }

    public void setDiseasedCells(int[][] diseasedCells) {
        this.diseasedCells = diseasedCells;
    }

    public int[][] getGrid() {
        return grid;
    }

    public int[][] getCellNeighbours() {
        return cellNeighbours;
    }

    public int[][] getDiseasedCells() {
        return diseasedCells;
    }
    
    public boolean isUpdateWithVirus() {
        return updateWithVirus;
    }

    public void setUpdateWithVirus(boolean updateWithVirus) {
        this.updateWithVirus = updateWithVirus;
    }
}
