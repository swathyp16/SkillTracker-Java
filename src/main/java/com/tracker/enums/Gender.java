package com.tracker.enums;

// TODO: Auto-generated Javadoc
/**
 * The Enum Gender.
 */
public enum Gender {

	/** The male. */
	MALE("M"),
	
	/** The female. */
	FEMALE("F");
	
	/** The value. */
	private String value;

	/**
	 * Instantiates a new gender.
	 *
	 * @param value the value
	 */
	private Gender(String value) {
		this.value = value;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
}
