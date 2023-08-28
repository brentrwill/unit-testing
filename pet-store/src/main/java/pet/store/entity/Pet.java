package pet.store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.Data;


@Entity
@Data
public class Pet {
	@Id
	@GeneratedValue
	private long id;
	private long petStoreId;

	private String petName;
	private String petType;
	private String pathToImage;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	public String getPathToImage() {
		return pathToImage;
	}

	public void setPathToImage(String pathToImage) {
		this.pathToImage = pathToImage;
	}

	public long getPetStoreId() {
		return petStoreId;
	}

	public void setPetStoreId(long petStoreId) {
		this.petStoreId = petStoreId;
	}
}
