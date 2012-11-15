package j.utils.string;

import java.io.StringWriter;

/**
 * Exception Utilty class
 * 
 * @author j
 */
public class ExceptionUtils {

	/** LINE FEED CODE:LF */
	private static final String LINE_FEED_CODE = "\n";

	/**
	 * get StackTrace Text
	 * 
	 * @param e
	 *            exception
	 * @return StackTrace Text
	 */
	public static String getStackTrace(Exception e) {
		StringWriter writer = new StringWriter();
		StackTraceElement[] stackTrace = e.getStackTrace();
		for (StackTraceElement element : stackTrace) {
			writer.write(element.toString());
			writer.write(LINE_FEED_CODE);
		}
		return writer.toString();
	}
	
	/******************************************************************************
	 * TODO 
	 ******************************************************************************/
	// test
	public static void main(String[] args) {
		try {
			throwDummyException();		
		} catch (Exception e) {
			String stackTrace = getStackTrace(e);
			System.out.println(stackTrace);
		}
	}
	
	// test method
	public static void throwDummyException() {
		throw new RuntimeException("dummy error");
	}

}
