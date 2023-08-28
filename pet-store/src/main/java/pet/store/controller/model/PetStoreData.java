package pet.store.controller.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.Customer;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;

@Data
public class PetStoreData {
	private long id;
	/**
	 * We initialize these Object to empty sets.
	 */
	private Set<CustomerData> customers = new HashSet<CustomerData>();
	private Set<EmployeeData> employees = new HashSet<EmployeeData>();
	
	private String petStoreName;
	private String petStoreAddress;
	private String petStoreCity;
	private String petStoreState;
	private String petStoreZip;
	private String petStorePhone;

	public PetStoreData(PetStore petStore) {
		this.id = petStore.getId();
		this.petStoreName = petStore.getPetStoreName();
		this.petStoreAddress = petStore.getPetStoreAddress();
		this.petStoreCity = petStore.getPetStoreCity();
		this.petStoreState = petStore.getPetStoreState();
		this.petStoreZip = petStore.getPetStoreZip();
		this.petStorePhone = petStore.getPetStorePhone();
		/**
		 * Copy the list of employees and customers into the data object.
		 */
		if(petStore.getEmployees() != null && petStore.getEmployees().size() > 0) {
			for(Employee employee : petStore.getEmployees()) {
				employees.add(new EmployeeData(employee));
			}
		}
		if(petStore.getCustomers() != null && petStore.getCustomers().size() > 0) {
			for(Customer customer : petStore.getCustomers()) {
				customers.add(new CustomerData(customer));
			}
		}
	}

	/**
	 * For unit testing
	 */
	public PetStoreData() {
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPetStoreName() {
		return petStoreName;
	}

	public void setPetStoreName(String petStoreName) {
		this.petStoreName = petStoreName;
	}

	public String getPetStoreAddress() {
		return petStoreAddress;
	}

	public void setPetStoreAddress(String petStoreAddress) {
		this.petStoreAddress = petStoreAddress;
	}

	public String getPetStoreCity() {
		return petStoreCity;
	}

	public void setPetStoreCity(String petStoreCity) {
		this.petStoreCity = petStoreCity;
	}

	public String getPetStoreState() {
		return petStoreState;
	}

	public void setPetStoreState(String petStoreState) {
		this.petStoreState = petStoreState;
	}

	public String getPetStoreZip() {
		return petStoreZip;
	}

	public void setPetStoreZip(String petStoreZip) {
		this.petStoreZip = petStoreZip;
	}

	public String getPetStorePhone() {
		return petStorePhone;
	}

	public void setPetStorePhone(String petStorePhone) {
		this.petStorePhone = petStorePhone;
	}

	public Set<CustomerData> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<CustomerData> customers) {
		this.customers = customers;
	}

	public Set<EmployeeData> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeeData> employees) {
		this.employees = employees;
	}
}
