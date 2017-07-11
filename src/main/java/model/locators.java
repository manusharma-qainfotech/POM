package model;

public class locators {
	String element;
	String locatorType;
	String locatorValue;

	public locators(String element, String locatorType, String locatorValue) {
		this.element = element;
		this.locatorType = locatorType;
		this.locatorValue = locatorValue;

	}

	public String getElement() {
		return element;
	}

	public String getLocatorType() {
		return locatorType;
	}

	public String getLocatorValue() {
		return locatorValue;
	}
}