package pet.store.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreData;
import pet.store.dao.PetStoreDao;
import pet.store.entity.PetStore;

@Service
@Slf4j
public class PetStoreService {

	@Autowired
	private PetStoreDao petStoreDao;
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PetStoreService.class);

	public PetStoreData savePetStore(PetStoreData petStoreData) {
		PetStore petStore = findOrCreatePetStore(petStoreData);
		if(petStore == null) {
			petStore = copyPetStoreDataFields(petStoreData);
			petStore = petStoreDao.save(petStore);
		} else {
			petStore = copyPetStoreDataFields(petStoreData);
			petStore = petStoreDao.save(petStore);
		}
		petStoreData = copyPetStoreFields(petStore);
		return petStoreData;
	}

	private PetStore findOrCreatePetStore(PetStoreData petStoreData) {
		PetStore petStore = null;
		try {
			petStore = findPetStoreById(petStoreData.getId());
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		return petStore;
	}

	private PetStore findPetStoreById(long petStoreId) {
		Optional<PetStore> results = petStoreDao.findById(petStoreId);
		PetStore petStore = results.orElse(null);
		if (petStore == null) {
			throw new NoSuchElementException("No PetStore exists with the Id : " + petStoreId);
		} else {
			return petStore;
		}
	}
	
	public PetStoreData getPetStore(long petStoreId) {
		PetStoreData petStoreData = null;
		PetStore petStore = findPetStoreById(petStoreId);
		if(petStore != null) {
			petStoreData = copyPetStoreFields(petStore);
		}
		return petStoreData;
	}
	
	private PetStore copyPetStoreDataFields(PetStoreData data) {
		PetStore petStore = new PetStore();
		petStore.setId(data.getId());
		petStore.setPetStoreAddress(data.getPetStoreAddress());
		petStore.setPetStoreCity(data.getPetStoreCity());
		petStore.setPetStoreName(data.getPetStoreName());
		petStore.setPetStorePhone(data.getPetStorePhone());
		petStore.setPetStoreState(data.getPetStoreState());
		petStore.setPetStoreZip(data.getPetStoreZip());
		
		return petStore;
	}
	
	private PetStoreData copyPetStoreFields(PetStore data) {
		PetStoreData petStore = new PetStoreData(data);
		return petStore;
	}
}
