package j.utils.collection;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


/**
 * Listユーテリティークラス
 * 
 * @author j
 */
public class JListUtils {

	/**
	 * 配列のリスト変換
	 * array={"aa","bb","cc","dd","ee"},offset=2, length=3
	 * → {"cc","dd","ee"}
	 * 
	 * @param array 配列
	 * @param offset 開始位置
	 * @param length 長さ
	 * @return リスト
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> toList(T[] array, int offset, int length) {
		Object newArray = Array.newInstance(array.getClass().getComponentType(), length);
		System.arraycopy(array, offset, newArray, 0, length);
		List<T> asList = (List<T>) Arrays.asList(newArray);
		return asList;
	}
	
	
}
