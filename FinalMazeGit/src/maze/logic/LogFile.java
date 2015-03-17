package maze.logic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

/**
 * 
 * @author Joshua Bagwell
 * @desc This class and its entirety was written by the author
 */

public class LogFile {

	private static final String DEFAULT_FILE_NAME = "./maze.log";

	// creating a writer to write to the file
	private static FileOutputStream outStream;
	private static PrintWriter writer;

	private final static boolean APPENDING = true;

	private static boolean debugging = true;

	// constructor for LogFile
	public LogFile() {
		File file = new File(DEFAULT_FILE_NAME);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.err.println("Can't access file Location");
			}
		}

	}

	// writes to the file
	public static void write(String message) {
		try {
			outStream = new FileOutputStream(DEFAULT_FILE_NAME, APPENDING);
			writer = new PrintWriter(outStream, true);
			writer.println("LOG DATE: " + getDate());
			writer.println("LOG MESSAGE: " + message);
			writer.println("END MESSAGE");
		} catch (IOException e) {
			System.err.println("Can't access file");
		} finally {
			writer.close();
		}
	}

	public static String getDate() {
		GregorianCalendar calendar = new GregorianCalendar();
		return calendar.getTime().toString();
	}

	public static boolean isDebugging() {
		return debugging;
	}

	public static void setDebugging(boolean arg0) {
		debugging = arg0;
	}

}