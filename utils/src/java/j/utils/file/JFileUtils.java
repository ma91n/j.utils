package j.utils.file;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * File Utility Class
 * 
 * @author j
 */
public class JFileUtils {

	/**
	 * get files where there are under the specific folder
	 * 
	 * @param folder
	 * @return files except folder
	 */
	//TODO test
	public static File[] getFile(File folder) {
		if (folder == null) {
			throw new IllegalArgumentException("folder is null");
		}
		// filename filter
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File arg0, String arg1) {
				return arg0.isFile();
			}
		};
		File[] list = folder.listFiles(filter);
		return list;
	}

	/**
	 * get file input as binary data
	 * 
	 * @param file
	 * @param readBuff read file buffer size
	 * @param fileSize expected file size[byte]
	 * @return file data
	 */
	public static byte[] getBytes(File file, int readBuff, int fileSize) {
		if (file == null) {
			throw new IllegalArgumentException("file is null");
		}
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(fileSize);
		BufferedInputStream bi = null;
		try {
			bi = new BufferedInputStream(new FileInputStream(file), readBuff);
			byte[] bytes = new byte[readBuff];
			int size = 0;
			while ((size = bi.read(bytes)) >= 0) {
				byteArrayOutputStream.write(bytes, 0, size);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (bi != null) {
				try {
					bi.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
		return byteArrayOutputStream.toByteArray();
	}
	
	/**
	 * get file text 
	 * 
	 * @param file
	 * @param readBuff read byffer size
	 * @param fileSize expected file size
	 * @return text
	 */
	public static String getText(File file, int readBuff, int fileSize) {
		try {
			return new String(getBytes(file, readBuff, fileSize), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("utf8 is not supported?", e);
		}
	}
	
}
