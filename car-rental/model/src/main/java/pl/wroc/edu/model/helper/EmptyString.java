package pl.wroc.edu.model.helper;

public class EmptyString {

	/**
	 * Helps to avoid NullPointerExceptions when referring to not initialized strings
	 * @param string
	 * @return Empty string if the reffering <b>string</b> value is null.
	 */
	public static String safeValue(String string) {
		return string == null ? "" : string;
	}
	
	public static boolean nullOrEmpty(String string) {
		return string==null || string.isEmpty();
	}
}
