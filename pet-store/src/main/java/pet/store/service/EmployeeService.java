package pet.store.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;


import pet.store.controller.model.EmployeeData; // Data that we can pass around.
import pet.store.dao.EmployeeDao; // Entity, JPA and Table in the DB

import pet.store.entity.Employee;

@Service
@Slf4j
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao; // Database Executor of stuff.
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PetStoreService.class);

	public EmployeeData saveEmployee(EmployeeData employeeData) {
		Employee employee = findOrCreateEmployee(employeeData);
		if(employee == null) {
			employee = copyFromEmployeeData(employeeData);
			employee = employeeDao.save(employee);
		} else {
			employee = copyFromEmployeeData(employeeData);
			employee = employeeDao.save(employee);
		}
		employeeData = copyFromEmployee(employee);
		return employeeData;
	}

	public Employee findOrCreateEmployee(EmployeeData employeeData) {
		Employee employee = null;
		try {
			employee = findEmployById(employeeData.getId());
		} catch (Exception e) {
			log.debug(e.getMessage());
			log.info(e.getMessage());
		}
		return employee;
	}

	public Employee findEmployById(long employeeId) {
		Optional<Employee> results = employeeDao.findById(employeeId);
		Employee employee = results.orElse(null);
		if (employee == null) {
			throw new NoSuchElementException("No Employee existed with the Id : " + employeeId);
		} else {
			return employee;
		}
	}
	
	private Employee copyFromEmployeeData(EmployeeData data) {
		Employee employee = new Employee();
		if(data.getId() > 0) {
			employee.setId(data.getId());
		}
		
		if(data.getEmployeeEmail() != null) {
			employee.setEmployeeEmail(data.getEmployeeEmail());
		}

		if(data.getEmployeeFirstName() != null) {
			employee.setEmployeeFirstName(data.getEmployeeFirstName());
		}
		
		if(data.getEmployeeLastName() != null) {
			employee.setEmployeeLastName(data.getEmployeeLastName());
		}
		
		if(data.getEmployeeJobTitle() != null) {
			employee.setEmployeeJobTitle(data.getEmployeeJobTitle());
		}
		return employee;
	}
	
	private EmployeeData copyFromEmployee(Employee data) {
		EmployeeData employee = new EmployeeData(data);
		return employee;
	}
}
