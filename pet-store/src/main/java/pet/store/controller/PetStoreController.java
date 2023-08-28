package pet.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreData;
import pet.store.service.PetStoreService;



/**
 * Pet Store rest controller, this implements a simple CRUD pattern.
 */
@RestController
@RequestMapping("/pet_store")
@Slf4j
public class PetStoreController {
	
	@Autowired
	private PetStoreService petStoreService;
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PetStoreService.class);

	/**
	 * POST == create, we are creating a PetStore record. 
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PetStoreData> postPetStore(@RequestBody PetStoreData petStoreData) {
		log.info("Processing POST Request.");
		petStoreData = petStoreService.savePetStore(petStoreData);
		return ResponseEntity.status(HttpStatus.CREATED).body(petStoreData);
	}
	
	/**
	 * PUT == update, this will update a PetStore
	 */
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PetStoreData> putPetStore(@RequestParam(name = "petStoreId") Long petStoreId, 
			@RequestBody PetStoreData petStoreData) {
		log.info("Processing PUT Request.");
		petStoreData.setId(petStoreId);
		petStoreData = petStoreService.savePetStore(petStoreData);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(petStoreData);
	}
	
	/**
	 * GET == read, this will read back a PetStore 
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PetStoreData> getPetStore(@RequestParam(name = "petStoreId") Long petStoreId) {
		log.info("Processing GET Request.");
		PetStoreData petStoreData = petStoreService.getPetStore(petStoreId);
		return ResponseEntity.status(HttpStatus.OK).body(petStoreData);
	}
}
