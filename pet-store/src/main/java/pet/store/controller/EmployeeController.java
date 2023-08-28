package pet.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.EmployeeData;
import pet.store.service.EmployeeService;

@RestController
@RequestMapping("/employee") //http://localhost:8080/employee
@Slf4j
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(EmployeeController.class);
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeData> postPetStore(@RequestBody EmployeeData employeeData) {
		log.info("Processing POST Request.");
		employeeData = employeeService.saveEmployee(employeeData);
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeData);
	}
	
}
