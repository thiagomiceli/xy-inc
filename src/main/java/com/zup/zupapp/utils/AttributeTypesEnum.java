package com.zup.zupapp.utils;

/**
 * @author thiagomiceli
 * Enum to define Attribute types
 */
public enum AttributeTypesEnum {

	INTEGER("integer"), STRING("string"), TEXT("text"), DECIMAL("decimal"), LONG("long");

	private String attributeType;

	private AttributeTypesEnum(String attributeType) {
		this.attributeType = attributeType;
	}

	public String getValue() {
		return attributeType;
	}
}
