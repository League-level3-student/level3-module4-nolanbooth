package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeMaker {

	private static int rows;
	private static int cols;

	private static Maze maze;
	static Cell[][] cells;

	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();

	public static Maze generateMaze(int r, int c) {
		rows = r;
		cols = c;
		maze = new Maze(rows, cols);
		
		// 1. Pick a random cell along the border and remove its exterior wall.
		// This will be the starting point. Then select a random cell along
		// the opposite wall and remove its exterior wall. This will be the
		// finish line.

		// 2. select a random cell in the maze to start
		// startCell = cells[0][randGen.nextInt(4)] -> something like this
//        Cell startCell = cells[0][randGen.nextInt(4)];
//       
//        System.out.println(startCell.getRow() +  ", " + startCell.getCol());
		
		//change numbers to variables if want to fix
		int random = randGen.nextInt(4);
		Cell startCell = maze.cells[0][0];
		Cell endCell = maze.cells[0][0];

		if (random == 0) {
			startCell = maze.cells[0][randGen.nextInt(r)];
			endCell = maze.cells[4][randGen.nextInt(r)];
			startCell.setNorthWall(false);
			endCell.setSouthWall(false);
			
			
		}
		if (random == 1) {
			startCell = maze.cells[randGen.nextInt(r)][0];
			endCell = maze.cells[randGen.nextInt(r)][4];
			startCell.setWestWall(false);
			endCell.setEastWall(false);
			
		}
		if (random == 2) {
			startCell = maze.cells[4][randGen.nextInt(r)];
			endCell = maze.cells[0][randGen.nextInt(r)];
			startCell.setSouthWall(false);
			endCell.setNorthWall(false);
			
		} if(random == 4) {
			startCell = maze.cells[randGen.nextInt(r)][4];
			endCell = maze.cells[randGen.nextInt(r)][0];
			startCell.setEastWall(false);
			endCell.setWestWall(false);
			
			
		}
		
		//startcell is now an edge cell
		//end cell is now a cell on the opposite
		
		
		// row is 0, so it must be a north border
		System.out.println(startCell.getRow() + ", " + startCell.getCol());
		
		selectNextPath(startCell);
		// 3. call the selectNextPath method with the randomly selected cell
		//selectNextPath(startCell);
		return maze;
	}

	// 4. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		// A. SET currentCell as visited
		currentCell.setBeenVisited(true);
		// B. check for unvisited neighbors using the cell
		
		ArrayList<Cell> neybers = getUnvisitedNeighbors(currentCell);
		
		if(neybers.size() == 0 && uncheckedCells.size() != 0) {
			currentCell = uncheckedCells.pop();
			selectNextPath(currentCell);
		}if(neybers.size() != 0) {
		Cell nextCell = neybers.get(randGen.nextInt(neybers.size()));
		
		uncheckedCells.push(nextCell);
		
		removeWalls(currentCell, nextCell);
		currentCell = maze.cells[nextCell.getRow()][nextCell.getCol()];
		selectNextPath(currentCell);
		}
		// C. if has unvisited neighbors,

		// C1. select one at random.

		// C2. push it to the stack

		// C3. remove the wall between the two cells

		// C4. make the new cell the current cell and SET it as visited

		// C5. call the selectNextPath method with the current cell

		// D. if all neighbors are visited

		// D1. if the stack is not empty

		// D1a. pop a cell from the stack

		// D1b. make that the current cell

		// D1c. call the selectNextPath method with the current cell

	}

	// This method will check if c1 and c2 are adjacent.
	// If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		if (c1.getRow() == c2.getRow()) {
			if (c1.getCol() > c2.getCol()) {
				c1.setWestWall(false);
				c2.setEastWall(false);
			} else {
				c1.setEastWall(false);
				c2.setWestWall(false);
			}
		} else {
			if (c1.getRow() > c2.getRow()) {
				c1.setNorthWall(false);
				c2.setSouthWall(false);
			} else {
				c1.setSouthWall(false);
				c2.setNorthWall(false);
			}
		}
	}

	// This method returns a list of all the neighbors around the specified
	// cell that have not been visited. There are up to 4 neighbors per cell.
	// 1
	// 2 cell 3
	// 4
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		int row = c.getRow();
		int col = c.getCol();

		ArrayList<Cell> unvisitedNeighbors = new ArrayList<Cell>();

		if (row > 0 && !maze.getCell(row - 1, col).hasBeenVisited()) {
			unvisitedNeighbors.add(maze.getCell(row - 1, col));
		}

		if (col > 0 && !maze.getCell(row, col - 1).hasBeenVisited()) {
			unvisitedNeighbors.add(maze.getCell(row, col - 1));
		}

		if (row < rows - 1 && !maze.getCell(row + 1, col).hasBeenVisited()) {
			unvisitedNeighbors.add(maze.getCell(row + 1, col));
		}

		if (col < cols - 1 && !maze.getCell(row, col + 1).hasBeenVisited()) {
			unvisitedNeighbors.add(maze.getCell(row, col + 1));
		}

		return unvisitedNeighbors;
	}
}
