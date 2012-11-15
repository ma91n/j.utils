package j.utils.load;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Config Loader Class
 * 
 * @author j
 *
 */
public class ConfigLoader {

	/**
	 * construct
	 */
	public ConfigLoader() {
		// ignore
	}

	/**
	 * load config file and set propClass
	 * 
	 * @param propClass
	 * @param configFile
	 */
	public <T> void load(Class<T> propClass, String configFile) {
		InputStream inputStream = null;
		try {
			// load config-file
			inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(configFile);
			if (inputStream == null) {
				throw new RuntimeException("Not Found Config File" + configFile);
			}
			Properties propeties = new Properties();
			propeties.load(inputStream);
			
			// set into PropClass
			Field[] fields = propClass.getFields();
			T instance = propClass.newInstance();
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				String name = field.getName();
				String typeName = field.getType().getSimpleName();
				if (typeName.equals("int")) {
					field.setInt(instance, Integer.parseInt((String) propeties.get(name)));
				} else if (typeName.equals("long")) {
					field.setLong(instance, Long.parseLong((String) propeties.get(name)));
				} else {
					field.set(instance, propeties.get(name));
				}
			}
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
	}

//	public static void main(String[] args) {
//		ConfigLoader configLoader = new ConfigLoader();
//		Entity entity = configLoader.new Entity();
//		Field[] fields = entity.getClass().getFields();
//		for (int i = 0; i < fields.length; i++) {
//			Field field = fields[i];
//			Class<?> type = field.getType();
//			System.out.println(type.getSimpleName());
//		}
//	}
//	
//	public class Entity {
//		public String body;
//		public int code;
//	}
	
}
