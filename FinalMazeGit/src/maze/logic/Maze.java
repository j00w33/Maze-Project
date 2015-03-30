package maze.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import socket.Server;

/**
 * @author Josh Bagwell
 * @desc Reads the file and turns it into a 2d array of strings
 */
public class Maze extends Server{

	private String[][] maze;
	private File mazeText;

	// method made by Josh Bagwell
	public Maze(String pathName) {
		super(13000);
		URL url = getClass().getResource(pathName); // Retrieves the file from
													// another package
		maze = new String[3][13];
		try {
			mazeText = new File(url.toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();;
		}
		ReadFile();
	}

	public static void main(String[] args) {
		Maze p = new Maze("/maze/resources/line.path");
		p.printMaze();
	}
	
	public void debug(String message, boolean isDebugging){		
		if (isDebugging) {
			LogFile.write(message);
		}
	}

	/**
	 * Created by Josh Reads the file to interpret the maze
	 */
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
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * Josh
	 * 
	 * @param row
	 * @param col
	 * @return value at [row][col]
	 */
	public String getValueAt(int row, int col) {
		return maze[row][col];
	}

	/**
	 * Josh// getter for the maze
	 */
	public String[][] getMaze() {
		return this.maze;
	}

	public int getNumRow() {
		int count = 0;
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {

			}
			count++;
		}

		return count;
	}

}
