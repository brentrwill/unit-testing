package pet.store.entity.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import pet.store.controller.PetStoreController;
import pet.store.controller.model.PetStoreData;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class PetStoreControllerTest extends AbstractControllerTest {
	private void init() {
		super.setUp();
	}

	@Test
	public void createPetStore() throws Exception {
		init();
		String uri = "/pet_store";
		PetStoreData petStoreData = new PetStoreData();
		petStoreData.setCustomers(null);
		petStoreData.setEmployees(null);
		petStoreData.setPetStoreAddress("1234 North 5678 West");
		petStoreData.setPetStoreName("Petco");
		petStoreData.setPetStoreCity("Denver");
		petStoreData.setPetStorePhone("1-888-555-4444");
		petStoreData.setPetStoreState("Colorado");
		petStoreData.setPetStoreZip("45457");

		String inputJson = super.mapToJson(petStoreData);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		PetStoreData savedPetStoreData = super.mapFromJson(content, PetStoreData.class);
		assertEquals(petStoreData.getPetStoreAddress(), savedPetStoreData.getPetStoreAddress());
	}
	
	@Test
	public void createMockPetStore() throws Exception {

		PetStoreData petStoreData = new PetStoreData();
		petStoreData.setCustomers(null);
		petStoreData.setEmployees(null);
		petStoreData.setPetStoreAddress("1234 North 5678 West");
		petStoreData.setPetStoreName("Petco");
		petStoreData.setPetStoreCity("Denver");
		petStoreData.setPetStorePhone("1-888-555-4444");
		petStoreData.setPetStoreState("Colorado");
		petStoreData.setPetStoreZip("45457");

		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);

		final ResponseEntity<PetStoreData> responseEntity = new ResponseEntity<>(
			petStoreData,
		    header, 
		    HttpStatus.CREATED
		);
		
		PetStoreController mockController = mock(PetStoreController.class);
		when(mockController.postPetStore(petStoreData)).thenReturn(responseEntity);
		
		ResponseEntity<PetStoreData> response = mockController.postPetStore(petStoreData);
		PetStoreData savedPetStoreData = response.getBody();
		assertEquals(petStoreData.getPetStoreAddress(), savedPetStoreData.getPetStoreAddress());
	}
	
	@Test
	public void updatePetStore() throws Exception {
		init();
		long petStoreId = 12345;
		String uri = "/pet_store?petStoreId=" + petStoreId;
		PetStoreData petStoreData = new PetStoreData();
		petStoreData.setCustomers(null);
		petStoreData.setEmployees(null);
		petStoreData.setPetStoreAddress("1234 North 5678 West");
		petStoreData.setPetStoreName("Petco");
		petStoreData.setPetStoreCity("Denver");
		petStoreData.setPetStorePhone("1-888-555-4444");
		petStoreData.setPetStoreState("Colorado");
		petStoreData.setPetStoreZip("99999");

		String inputJson = super.mapToJson(petStoreData);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
		String content = mvcResult.getResponse().getContentAsString();
		PetStoreData savedPetStoreData = super.mapFromJson(content, PetStoreData.class);
		assertEquals(petStoreData.getPetStoreAddress(), savedPetStoreData.getPetStoreAddress());
	}
	
	@Test
	public void updateMockPetStore() throws Exception {
		long petStoreId = 12345;
		PetStoreData petStoreData = new PetStoreData();
		petStoreData.setCustomers(null);
		petStoreData.setEmployees(null);
		petStoreData.setPetStoreAddress("1234 North 5678 West");
		petStoreData.setPetStoreName("Petco");
		petStoreData.setPetStoreCity("Denver");
		petStoreData.setPetStorePhone("1-888-555-4444");
		petStoreData.setPetStoreState("Colorado");
		petStoreData.setPetStoreZip("99999");

		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);

		final ResponseEntity<PetStoreData> responseEntity = new ResponseEntity<>(
			petStoreData,
		    header, 
		    HttpStatus.ACCEPTED
		);
		
		PetStoreController mockController = mock(PetStoreController.class);
		when(mockController.putPetStore(petStoreId, petStoreData)).thenReturn(responseEntity);
		
		ResponseEntity<PetStoreData> response = mockController.putPetStore(petStoreId, petStoreData);
		PetStoreData savedPetStoreData = response.getBody();
		assertEquals(petStoreData.getPetStoreZip(), savedPetStoreData.getPetStoreZip());
	}
	
	@Test
	public void readPetStore() throws Exception {
		init();
		long petStoreId = 1;
		String uri = "/pet_store?petStoreId=" + petStoreId;
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		PetStoreData savedPetStoreData = super.mapFromJson(content, PetStoreData.class);
		assertEquals(savedPetStoreData.getId(), petStoreId);
	}
	
	@Test
	public void readMockPetStore() throws Exception {

		PetStoreData petStoreData = new PetStoreData();
		long petStoreId = 1;
		petStoreData.setCustomers(null);
		petStoreData.setEmployees(null);
		petStoreData.setPetStoreAddress("1234 North 5678 West");
		petStoreData.setPetStoreName("Petco");
		petStoreData.setPetStoreCity("Denver");
		petStoreData.setPetStorePhone("1-888-555-4444");
		petStoreData.setPetStoreState("Colorado");
		petStoreData.setPetStoreZip("45457");

		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);

		final ResponseEntity<PetStoreData> responseEntity = new ResponseEntity<>(
			petStoreData,
		    header, 
		    HttpStatus.OK
		);
		
		PetStoreController mockController = mock(PetStoreController.class);
		when(mockController.getPetStore(petStoreId)).thenReturn(responseEntity);
		
		ResponseEntity<PetStoreData> response = mockController.getPetStore(petStoreId);
		PetStoreData savedPetStoreData = response.getBody();
		assertEquals(petStoreData.getPetStoreAddress(), savedPetStoreData.getPetStoreAddress());
	}

}
