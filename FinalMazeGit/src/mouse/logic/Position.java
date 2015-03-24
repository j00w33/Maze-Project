package mouse.logic;

//Position class
/**
 * 
 * @author Josh
 *
 */
public class Position {

	// row and columns
	private int _row;
	private int _col;

	// constructor that takes and sets the row and column
	public Position(int row, int col) {
		this._row = row;
		this._col = col;
	}

	// gets the offset of the rows and columns
	public Position getOffSet(int rows, int cols) {
		int row = getRow() + rows;
		int col = getCol() + cols;
		return new Position(row, col);
	}

	// returns the row
	public int getRow() {
		return this._row;
	}

	// returns the column
	public int getCol() {
		return this._col;
	}

	// generates a hashcode
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + this._col;
		result = prime * result + this._row;
		return result;
	}

	// overridden equals method
	public boolean equals(Object obj) {
		boolean value = true;
		if (this == obj) {
			value = true;
		}
		if (obj == null) {
			value = false;
		}
		if (getClass() != obj.getClass()) {
			value = false;
		}
		Position other = (Position) obj;
		if (this._col != other._col) {
			value = false;
		}
		if (this._row != other._row) {
			value = false;
		}
		return value;
	}

	// overridden toString
	public String toString() {
		String result = String.valueOf((char) (getCol() + 97)
				+ (char) (getRow() + 49));
		return result;
	}
}
