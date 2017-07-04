package me.snikit.eatfull.exception;

public class ReadDataException extends Exception {
	private static final long serialVersionUID = 386353751289376875L;

	public ReadDataException(Exception e) {
		super(e);
	}

	public ReadDataException() {
	}

}
