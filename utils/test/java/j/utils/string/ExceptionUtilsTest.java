package j.utils.string;

public class ExceptionUtilsTest {

	// test
	public static void main(String[] args) {
		try {
			throwDummyException();		
		} catch (Exception e) {
			String stackTrace = ExceptionUtils.getStackTrace(e);
			System.out.println(stackTrace);
		}
	}
	
	// test method
	public static void throwDummyException() {
		throw new RuntimeException("dummy error");
	}
	
}