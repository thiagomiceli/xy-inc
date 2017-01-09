package com.zup.zupapp;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zup.zupapp.domain.Instance;
import com.zup.zupapp.domain.Model;
import com.zup.zupapp.repository.InstanceRepository;
import com.zup.zupapp.repository.ModelRepository;

/**
 * @author thiagomiceli
 * Main class of the application using Spring Boot
 *
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

	/**
	 * injected reference to access methods from ModelRepository
	 */
	@Autowired
	private ModelRepository modelRepository;
	
	/**
	 * injected reference to access methods from InstanceRepository
	 */
	@Autowired
	private InstanceRepository instanceRepository;

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		// save a Model
		HashMap<String, String> attributes = new HashMap<String, String>();
		attributes.put("name", "string");
		attributes.put("description", "text");
		attributes.put("price", "decimal");
		attributes.put("category", "string");
		Model model = new Model("Product", attributes);

		this.modelRepository.save(model);

		//save an instance
		HashMap<String, String> instanceAttributes = new HashMap<String, String>();
		instanceAttributes.put("name", "Wallmount for tvs");
		instanceAttributes.put("description", "Wallmount for tvs maximum 24 inches.");
		instanceAttributes.put("price", "200,00");
		instanceAttributes.put("category", "Accessories");
		Instance instancia = new Instance(model.getName(), instanceAttributes);

		this.instanceRepository.save(instancia);
		
		//find all models

		System.out.println("Models found with findAll():");
		System.out.println("-------------------------------");
		for (Model retrievedModel : this.modelRepository.findAll()) {
			System.out.println(retrievedModel);
		}
		System.out.println();

		//find all instances
		System.out.println("Instances found with findAll():");
		System.out.println("-------------------------------");
		for (Instance retrievedInstance : this.instanceRepository.findAll()) {
			System.out.println(retrievedInstance);
		}
		System.out.println();

	}

}
