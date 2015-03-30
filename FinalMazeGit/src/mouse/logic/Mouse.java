package mouse.logic;

import socket.Client;
import maze.logic.MazeParser;

public class Mouse extends Client {

	private MazeParser parser;

	// private String current ="";
	// private String next = "";
	private String[][] maze;
	private Position pos;

	public Mouse() {
		super();
		parser = new MazeParser("/maze/resources/line.path");
		maze = parser.getMaze();
	}

	// josh start
	/**
	 * finds the position of the rat in the maze and returns it
	 */
	public Position findRat(String[][] m) {
		// sets a new position to 0,0
		Position pos = new Position(0, 0);
		// iterate through the maze
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				// is the value = to "R"?
				if (m[i][j].equals("R")) {
					// yes?: return the position of R
					pos = new Position(j, i);
				}
			}
		}
		return pos;
	}

	// josh end

	public void moveMouse() {

	}

	public static void main(String[] args) {
		Mouse m = new Mouse();
	}
}
