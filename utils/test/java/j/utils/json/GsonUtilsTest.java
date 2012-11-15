package j.utils.json;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class GsonUtilsTest {
	
	/**
	 * sample execute
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// test 1
		String gsonUtilsToJsonTest = gsonUtilsToJsonTest();
		System.out.println(gsonUtilsToJsonTest);
		
		// test2
		Entity gsonUtilsFromJsonTest = gsonUtilsFromJsonTest();
		System.out.println(gsonUtilsFromJsonTest);
		
		
	}	
	
	/*
	 * test 1
	 */
	public static String gsonUtilsToJsonTest() {
		Entity entity = new Entity();
		String json = GsonUtils.toJson(entity);
		return json;
	}
	
	public static Entity gsonUtilsFromJsonTest() {
		Entity fromJson = GsonUtils.fromJson(entityJson, Entity.class);
		return fromJson;
	}
	
	
	static String entityJson = "{\"e1\":\"aa\",\"e2\":\"bb\"}";
	
	/*
	 * sample entity
	 */
	static class Entity {
		public String e1 = "aa";
		public String e2 = "bb";
		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this);
		}
	}


}
