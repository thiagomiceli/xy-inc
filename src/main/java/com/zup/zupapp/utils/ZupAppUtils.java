package com.zup.zupapp.utils;

import java.util.HashMap;
import java.util.Iterator;

import com.zup.zupapp.exception.UnknownAttributeTypeException;

/**
 * @author thiagomiceli
 * Utility class to validate attribute types and casting to this types
 */
public class ZupAppUtils {

	/**
	 * Verify if the given types are all known
	 * @param attributes - all the attributes and types
	 * @throws UnknownAttributeTypeException - launched when an attribute type is unknown
	 */
	public static void validateAttributeTypes(final HashMap<String, String> attributes)
			throws UnknownAttributeTypeException {
		Iterator<String> iterator = attributes.keySet().iterator();
		while (iterator.hasNext()) {
			String attributeName = iterator.next();

			String attributeType = attributes.get(attributeName).toLowerCase();
			if (!(attributeType.equals(AttributeTypesEnum.INTEGER.getValue())
					|| attributeType.equals(AttributeTypesEnum.STRING.getValue())
					|| attributeType.equals(AttributeTypesEnum.TEXT.getValue())
					|| attributeType.equals(AttributeTypesEnum.DECIMAL.getValue())
					|| attributeType.equals(AttributeTypesEnum.LONG.getValue()))) {
				throw new UnknownAttributeTypeException(attributeName, attributeType);
			}
		}

	}

	/**
	 * Verify if the given values are from a known type
	 * @param attributes - all the attributes and values
	 * @throws UnknownAttributeTypeException - launched when an attribute type is unknown
	 */
	public static void validateAttributeValues(HashMap<String, String> attributesMetadata,
			HashMap<String, String> attributeValues) throws UnknownAttributeTypeException {
		Iterator<String> iterator = attributeValues.keySet().iterator();
		while (iterator.hasNext()) {
			String attributeValueName = iterator.next();
			String attributeValueString = attributeValues.get(attributeValueName);

			String attributeMetadataType = attributesMetadata.get(attributeValueName);
			
			if(attributeMetadataType!= null) {
				try {
					if (attributeMetadataType.equals(AttributeTypesEnum.INTEGER.getValue())) {
						Integer.parseInt(attributeValueString);
					} else if (attributeMetadataType.equals(AttributeTypesEnum.STRING.getValue())
							|| attributeMetadataType.equals(AttributeTypesEnum.TEXT.getValue())) {
						return;
					} else if (attributeMetadataType.equals(AttributeTypesEnum.DECIMAL.getValue())) {
						Double.parseDouble(attributeValueString.replaceAll(",", "."));
					} else if (attributeMetadataType.equals(AttributeTypesEnum.LONG.getValue())) {
						Long.parseLong(attributeValueString);
					}
				} catch (NumberFormatException e) {
					throw new UnknownAttributeTypeException(attributeValueName, attributeValueString);
				}
				
			} else {
				throw new UnknownAttributeTypeException(attributeValueName, attributeValueString);
			}
		}
	}

}
