package com.zupapp.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.zup.zupapp.Application;
import com.zup.zupapp.domain.Instance;
import com.zup.zupapp.domain.Model;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT, classes = Application.class)
public class InstanceResourceIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void crudInstance() {
		HashMap<String, String> instanceAttributes = new HashMap<String, String>();
		instanceAttributes.put("name", "Wallmount for tvs");
		instanceAttributes.put("description", "Wallmount for tvs maximum 24 inches.");
		instanceAttributes.put("price", "200,00");
		instanceAttributes.put("category", "Accessories");
		Instance instance = new Instance("Product", instanceAttributes);

		// creating one instance of product
		ResponseEntity<Instance> responseEntity = restTemplate.postForEntity("/product", instance, Instance.class);
		Instance newInstance = responseEntity.getBody();
		assertThat(newInstance.getId() != null);

		// retrieve one specific instance of product
		Instance responseToOneProduct = restTemplate.getForObject("/product/" + newInstance.getId(), Instance.class);
		assertThat(responseToOneProduct != null);

		// delete one instance of product
		restTemplate.delete("/product/" + newInstance.getId());
	}
	
	@Test
	public void crudModel() {
		HashMap<String, String> attributes = new HashMap<String, String>();
		attributes.put("Sku", "string");
		attributes.put("Price", "decimal");
		attributes.put("Quantity", "integer");
		Model model = new Model("Itens", attributes);
		model.setName("Test");

		// creating one instance of model
		ResponseEntity<Model> responseEntity = restTemplate.postForEntity("/models", model, Model.class);
		Model newModel = responseEntity.getBody();
		assertThat(newModel.getId() != null);

		// retrieve one specific instance of model
		Model responseToOneProduct = restTemplate.getForObject("/models/" + newModel.getId(), Model.class);
		assertThat(responseToOneProduct != null);

		// delete one instance of Model
		restTemplate.delete("/models/" + newModel.getId());
	}

}
