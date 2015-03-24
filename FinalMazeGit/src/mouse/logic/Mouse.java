package mouse.logic;

import maze.logic.MazeParser;

public class Mouse {

	private MazeParser parser;
	
	private String current ="";
	private String next = "";
	private String[][] maze;

	public Mouse() {
		parser = new MazeParser("/maze/resources/line.path");
		maze = parser.getMaze();
	}

	public void moveMouse(){
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				current = maze[i][j];
			}
		}
	}

	public static void main(String[] args) {
		new Mouse().moveMouse();
	}
}
