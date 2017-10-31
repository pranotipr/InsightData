public interface InputValidator {
	/**
	 * Checks if input is in valid format
	 * @param token the string array of containing relevant parameters
	 */
	boolean isValid(String[] token);
}
