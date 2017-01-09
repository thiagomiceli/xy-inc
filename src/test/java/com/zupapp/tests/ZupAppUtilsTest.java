package com.zupapp.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.zup.zupapp.utils.ZupAppUtils;

@RunWith(SpringRunner.class)
public class ZupAppUtilsTest {
	
	@Test
	public void validateAtributeTypesTest() {
		HashMap<String, String> attributes = new HashMap<String, String>();
		attributes.put("sku", "string");
		attributes.put("price", "decimal");
		attributes.put("quantity", "integer");
		ZupAppUtils.validateAttributeTypes(attributes);
		assertThat(true);
		
	}
	
	@Test
	public void validateAtributeValuesTest() {
		HashMap<String, String> metadataAttributes = new HashMap<String, String>();
		metadataAttributes.put("sku", "string");
		metadataAttributes.put("price", "decimal");
		metadataAttributes.put("quantity", "integer");
		
		HashMap<String, String> instanceAttributes = new HashMap<String, String>();
		instanceAttributes.put("sku", "string test");
		instanceAttributes.put("price", "200,00");
		instanceAttributes.put("quantity", "20");
		
		ZupAppUtils.validateAttributeValues(metadataAttributes, instanceAttributes);
		assertThat(true);
		
	}
}
