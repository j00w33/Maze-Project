package mouse.logic;

import java.util.ArrayList;

import maze.logic.Maze;
import socket.Client;

public class Mouse extends Client {

	private Maze maze;

	// private String current ="";
	// private String next = "";
	private Position MousePos;

	public Mouse() {
		super();
		maze = new Maze("/maze/resources/line.path");
		findRat(maze);
		getAvailableMoves(MousePos);

	}

	// josh start
	/**
	 * finds the position of the rat in the maze and returns it
	 */
	public Position findRat(Maze m) {
		// sets a new position to 0,0
		Position pos = new Position(0, 0);
		// iterate through the maze
		for (int i = 0; i < m.getMaze().length; i++) {
			for (int j = 0; j < m.getMaze()[i].length; j++) {
				// is the value = to "R"?
				if (m.getMaze()[i][j].equals("R")) {
					// yes?: return the position of R
					pos = new Position(i, j);
					MousePos = pos;
				}
			}
		}
		return pos;
	}

	// josh end

	public ArrayList<Position> getAvailableMoves(Position pos) {
		ArrayList<Position> moves = new ArrayList<Position>();
		// up move
		moves.add(pos.getOffSet(-1, 0));
		// down move
		moves.add(pos.getOffSet(1, 0));
		// move left
		moves.add(pos.getOffSet(0, -1));
		// move right
		moves.add(pos.getOffSet(0, 1));

		return moves;
	}

	public static void main(String[] args) {
		Mouse m = new Mouse();
	}
}
