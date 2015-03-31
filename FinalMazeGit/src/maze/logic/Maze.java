package maze.logic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import mouse.logic.Mouse;
import mouse.logic.Position;
import socket.Server;

/**
 * @author Josh Bagwell
 * @desc Reads the file and turns it into a 2d array of strings
 */
public class Maze extends Server {

	private String[][] maze;
	private File mazeText;
	private Mouse receive;

	// method made by Josh Bagwell
	public Maze(String pathName) {
		// Andrew setting up server socket for maze
		super(PORT);

		URL url = getClass().getResource(pathName); // Retrieves the file from
													// another package *Josh

		maze = new String[13][13];
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

		Maze p = new Maze("/maze/resources/maze.path");
		p.printMaze();
		p.start();
		p.receive();
	}

	public void debug(String message, boolean isDebugging) {
		if (isDebugging) {
			LogFile.write(message);
		}
	}

	public void receive() {
		try {
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			ObjectInputStream ois = new ObjectInputStream(
					socket.getInputStream());
			receive = (Mouse) ois.readObject();
			Position pos = receive.findRat(this);
			receive.solve();
			send(String.valueOf(true));

			// if (receive) {
			//
			// }
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LogFile.write(e.getStackTrace().toString());
		}
	}

	public void send(String s) {

		try {
			DataOutputStream dos = new DataOutputStream(
					this.socket.getOutputStream());
			dos.writeUTF(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public String getValueAt(Position pos) {
		return maze[pos.getRow()][pos.getCol()];
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
