package mouse.logic;

import java.util.ArrayList;
import java.util.Random;

import maze.logic.Maze;
import socket.Client;

public class Mouse extends Client {

	private Maze maze;

	// private String current ="";
	// private String next = "";
	private Position mousePos;

	// Andrew
	public Mouse() {
		super();

		maze = new Maze("/maze/resources/line.path");
		findRat(maze);

		// Josh
		ArrayList<Position> moves = getAvailableMoves(mousePos);
		solveMaze(moves);

	}
	
	public boolean canMove(ArrayList<Position> moves){
		return !moves.isEmpty();
	}

	public void solveMaze(ArrayList<Position> moves) {
		Random gen = new Random();
		ArrayList<Position> temp = moves;
		if (canMove(moves)) {
			moveMouse(moves.get(gen.nextInt(moves.size())));
			temp = getAvailableMoves(mousePos);
			solveMaze(temp);
		}
//		if (moves.isEmpty()) {
//			temp = getSurroundingSpaces(mousePos);
//			for (Position position : temp) {
//				if (maze.getValueAt(position).equals("x")) {
//					Position prevMouse = mousePos;
//					moveMouse(position);
//					maze.setValue(prevMouse, "X");
//				}
//			}
//			solveMaze(temp);
//		}

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
			if (maze.getValueAt(position).equals("P")) {
				moves.add(position);
			}
		}
		return moves;
	}

	public void moveMouse(Position pos) {
		maze.setValue(mousePos, "x");
		maze.setValue(pos, "R");
		maze.printMaze();
		System.out.println();
		mousePos = pos;
	}

	public static void main(String[] args) {
		new Mouse();

	}
}
