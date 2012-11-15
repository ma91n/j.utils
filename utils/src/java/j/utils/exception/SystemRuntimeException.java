package j.utils.exception;

/**
 * System Exception Class
 * 
 * @author j
 *
 */
public class SystemRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -7732974647469481417L;

	public SystemRuntimeException() {
		super();
	}

	public SystemRuntimeException(String arg0) {
		super(arg0);
	}

	public SystemRuntimeException(Throwable arg0) {
		super(arg0);
	}

	public SystemRuntimeException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
