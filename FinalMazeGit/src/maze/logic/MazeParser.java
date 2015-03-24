package maze.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

/**
 * @author Josh Bagwell
 * @desc Class that takes a file and parses it to make a maze incomplete class.
 *       needs more work
 */
public class MazeParser {

	private String[][] maze;

	private File mazeText;

	// method made by Josh Bagwell
	public MazeParser(String pathName) {
		URL url = getClass().getResource(pathName); // Retrieves the file from
													// another package
		maze = new String[3][11];
		try {
			mazeText = new File(url.toURI());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ReadFile();
	}

	public static void main(String[] args) {
		MazeParser p = new MazeParser("/maze/resources/line.path");
		p.ReadFile();
		p.printMaze();
	}

	// incomplete method needs more work
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
