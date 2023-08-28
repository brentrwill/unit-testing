package pet.store.controller.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.Customer;
import pet.store.entity.PetStore;

@Data
@NoArgsConstructor
public class CustomerData {
	private long id;
	private Set<PetStoreData> petStores = new HashSet<PetStoreData>();
	private String customerFirstName;
	private String customerLastName;
	private String customerEmail;

	public CustomerData(Customer customer) {
		this.id = customer.getId();
		this.customerFirstName = customer.getCustomerFirstName();
		this.customerLastName = customer.getCustomerLastName();
		this.customerEmail = customer.getCustomerEmail();
		if (customer.getPetStores() != null && customer.getPetStores().size() > 0) {
			for (PetStore petStore : customer.getPetStores()) {
				petStores.add(new PetStoreData(petStore));
			}
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Set<PetStoreData> getPetStores() {
		return petStores;
	}

	public void setPetStores(Set<PetStoreData> petStores) {
		this.petStores = petStores;
	}
}
