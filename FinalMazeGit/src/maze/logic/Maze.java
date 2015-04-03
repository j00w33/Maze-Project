package maze.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import mouse.logic.Position;
import socket.Server;

/**
 * @author Josh Bagwell
 * @desc Reads the file and turns it into a 2d array of strings
 */
public class Maze extends Server {

	private String[][] maze;
	private File mazeText;
	private Position mousePos;

	// method made by Josh Bagwell
	public Maze(String pathName) {
		// Andrew setting up server socket for maze
		super(PORT);

		URL url = getClass().getResource(pathName); // Retrieves the file from
													// another package *Josh
		maze = new String[3][13];
		try {
			mazeText = new File(url.toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
			;
		}
		ReadFile();
	}

	public boolean canMove(ArrayList<Position> moves) {
		return !moves.isEmpty();
	}

	// josh start
	/**
	 * finds the position of the rat in the maze and returns it
	 */
	public Position findRat() {
		// sets a new position to 0,0
		Position pos = new Position(0, 0);
		// iterate through the maze
		for (int i = 0; i < getMaze().length; i++) {
			for (int j = 0; j < getMaze()[i].length; j++) {
				// is the value = to "R"?
				if (getMaze()[i][j].equals("R")) {
					// yes?: return the position of R
					pos = new Position(i, j);
					mousePos = pos;
				}
			}
		}
		return pos;
	}

	public ArrayList<Position> getSurroundingSpaces(Position pos) {
		// new arraylist to store all of the AVALIABLE moves
		ArrayList<Position> spaces = new ArrayList<Position>();
		// up move
		spaces.add(pos.getOffSet(-1, 0));
		// down move
		spaces.add(pos.getOffSet(1, 0));
		// move left
		spaces.add(pos.getOffSet(0, -1));
		// move right
		spaces.add(pos.getOffSet(0, 1));

		return spaces;

	}

	// josh start
	public ArrayList<Position> getAvailableMoves(Position pos) {
		// arraylist to store all of the adjacent spaces
		ArrayList<Position> spaces = getSurroundingSpaces(pos);
		ArrayList<Position> moves = new ArrayList<Position>();
		for (Position position : spaces) {
			if (getValueAt(position).equals("P")) {
				moves.add(position);
			}
		}
		return moves;
	}

	// Andrew
	public static void main(String[] args) {

		Maze p = new Maze("/maze/resources/line.path");
		p.printMaze();
		p.start();
	}

	public void debug(String message, boolean isDebugging) {
		if (isDebugging) {
			LogFile.write(message);
		}
	}

	/**
	 * Created by Josh Reads the file to interpret the maze
	 */
	@SuppressWarnings("resource")
	public void ReadFile() {
		try {
			Scanner scan = new Scanner(mazeText);
			int rowCount = 0;
			while (scan.hasNext()) {
				String line = scan.nextLine();
				String[] splitLine = line.split(" ");
				for (int i = 0; i < splitLine.length; i++) {
					maze[rowCount][i] = splitLine[i];
				}
				rowCount++;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Josh Prints a visual representation of the maze
	 */
	public void printMaze() {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				System.out.print(" | " + maze[i][j]);
			}
			System.out.println(" |");
		}
	}

	/**
	 * Josh
	 * 
	 * @param row
	 * @param col
	 * @return value at [row][col]
	 */
	public String getValueAt(Position pos) {
		return maze[pos.getRow()][pos.getCol()];
	}

	public void setValue(Position pos, String val) {
		maze[pos.getRow()][pos.getCol()] = val;

	}

	/**
	 * Josh// getter for the maze
	 */
	public String[][] getMaze() {
		return this.maze;
	}

	public int getNumCol() {
		int count = 0;

		for (int i = 0; i < maze.length; i++) {
			count = maze[i].length;
		}

		return count;
	}

	public int getNumRow() {
		int count = 0;
		for (int i = 0; i < maze.length; i++) {
			count++;
		}

		return count;
	}

}
