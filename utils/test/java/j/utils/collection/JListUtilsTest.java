package j.utils.collection;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class JListUtilsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] array = new String[]{"aa","bb","cc","dd","ee"};
		List<String> list = JListUtils.toList(array, 2, 3);
		System.out.println(ToStringBuilder.reflectionToString(list));
	}

}
