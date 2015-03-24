package mouse.logic;

public class Move {

	protected Position _start;
	protected Position _end;

	public Move(Position start, Position end) {
		this._start = start;
		this._end = end;
	}

	public Position getStart() {
		return this._start;
	}

	public Position getEnd() {
		return this._end;
	}
	
	

}
