package j.utils.json;

import com.google.gson.Gson;

/**
 * Gson library utils
 * 
 * @author j
 */
public class GsonUtils {

	/**
	 * object convert to json
	 * 
	 * @param obj object
	 * @return json
	 */
	public static <T> String toJson(T obj) {
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		return json;
	}
	
	/**
	 * JSON convert specified to class
	 * 
	 * @param json JSON
	 * @param clazz class name
	 * @return specified class
	 */
	public static <T> T fromJson(String json, Class<T> clazz) {
		Gson gson = new Gson();
		T fromJson = gson.fromJson(json, clazz);
		return fromJson;
	}
	

}
