package maze.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
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
