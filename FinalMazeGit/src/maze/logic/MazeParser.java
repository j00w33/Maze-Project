package maze.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

/**
 * @author Josh Bagwell
 * @desc Class that takes a file and parses it to make a maze
 * incomplete class. needs more work
 */
public class MazeParser {

	File mazeText;

	//method made by Josh Bagwell
	public MazeParser() {
		URL url = getClass().getResource("/maze/resources/maze.path");
		try {
			mazeText = new File(url.toURI());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MazeParser p = new MazeParser();
		p.ReadFile();
	}
	
	//incomplete method needs more work
	public void ReadFile(){
		try {
			Scanner scan = new Scanner(mazeText);
			while (scan.hasNextLine()) {
				System.out.print(scan.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
