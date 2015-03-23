package mouse.logic;

import maze.logic.MazeParser;

public class Mouse {

	private MazeParser parser;

	public Mouse() {
		parser = new MazeParser("/maze/resources/line.path");

	}

	// Josh
	// public void moveMouse(){
	// String s = "";
	// for (int i = 0; i < .length; i++) {
	//
	// }
	// }

	public static void main(String[] args) {
		System.out.println(new Mouse().parser.getNumRow());
	}

}
