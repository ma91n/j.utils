package j.utils.string;

import j.utils.exception.SystemRuntimeException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * StringUtility Class
 * 
 * @author j
 */
public class JStringUtils {

	/** charset-name */
	private static final String CHARSET = "UTF-8";

	/**
	 * Object convert to String
	 * 
	 * @param obj
	 *            object
	 * @return string
	 */
	public static String toString(Object obj) {
		if (obj == null) {
			return null;

		} else if (obj instanceof byte[]) {
			try {
				return new String((byte[]) obj, CHARSET);
			} catch (UnsupportedEncodingException e) {
				throw new SystemRuntimeException(e);
			}

		} else if (obj instanceof InputStream) {
			try {
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				InputStream inputStream = (InputStream) obj;
				byte[] buff = new byte[512];
				int len = 0;
				while ((len = inputStream.read(buff)) >= 0) {
					byteArrayOutputStream.write(buff, 0, len);
				}
				return byteArrayOutputStream.toString(CHARSET);
			} catch (IOException e) {
				throw new SystemRuntimeException(e);
			}

		} else {
			return String.valueOf(obj);
		}
	}

	/**
	 * encode character-set
	 * 
	 * @param str
	 *            string
	 * @param srcEncode
	 *            original charset
	 * @param destEncode
	 *            convert charset
	 * @return destEncode string
	 */
	public static String encode(String str, String srcEncode, String destEncode) {
		if (str == null) {
			return null;
		} else {
			try {
				return new String(str.getBytes(srcEncode), destEncode);
			} catch (UnsupportedEncodingException e) {
				throw new IllegalArgumentException(srcEncode + " or " + destEncode + " is not supported", e);
			}
		}
	}
//
//	public static void main(String[] args) throws UnsupportedEncodingException {
//		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("��������������������aiueo12345".getBytes(CHARSET));
//		System.out.println(toString(byteArrayInputStream));
//	}

}
