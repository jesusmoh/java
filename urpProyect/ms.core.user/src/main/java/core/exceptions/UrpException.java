package core.exceptions;

public class UrpException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String message;
	private final boolean error;

	public UrpException(String message, boolean error) {
		this.message = message;
		this.error = error;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public boolean isError() {
		return error;
	}

}
