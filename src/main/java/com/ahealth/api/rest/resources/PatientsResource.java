package com.ahealth.api.rest.resources;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ahealth.api.rest.dto.PatientDTO;
import com.ahealth.api.rest.entity.Patient;
import com.ahealth.api.rest.repository.PatientRespository;

/**
 * @author Ankush Gupta 
 * 
 * Email: no.1ankush@gmail.com
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */

@RestController
@RequestMapping(path = "/patients" )
public class PatientsResource {

	@Autowired
	PatientRespository repository;
	
	@Autowired
	ModelMapper mapper;
	
	@GetMapping
	public Resources<PatientDTO> getPatients() {
		List<Patient> patientList =  new ArrayList<>(repository.findAll());
		List<PatientDTO> patientDTOList = patientList
												.stream()
		          								.map(patient -> convertEnityToDto(patient))
		          								.collect(Collectors.toList());
		
		for(PatientDTO patientDTO: patientDTOList) {
			patientDTO.add(linkTo(methodOn(this.getClass()).getPatient(patientDTO.getUniqueId())).withSelfRel());
		}
		
		Resources<PatientDTO> resources = new Resources<PatientDTO>(patientDTOList, 
												linkTo(methodOn(this.getClass()).getPatients()).withSelfRel());
		return resources;
	}
	
	@GetMapping(path = "/{id}")
	public Resource<PatientDTO> getPatient(@PathVariable @NotNull String id) {
		Optional<Patient> patient = repository.findById(id);
		if(patient.isPresent())
		{
			PatientDTO patientDTO = convertEnityToDto(patient.get());
			Resource<PatientDTO> resource = new Resource<PatientDTO>(patientDTO);
			resource.add(linkTo(methodOn(this.getClass()).getPatient(id)).withSelfRel());
			resource.add(linkTo(methodOn(this.getClass()).getPatients()).withRel("all-patients"));
			return resource;
		}
		
		return null;
	}
	
	@PostMapping
	public ResponseEntity<Object> createPatient(@RequestBody @Valid PatientDTO patientDTO) {
		Patient patient = repository.save(convertDtoToEntity(patientDTO));
		
		URI location = ServletUriComponentsBuilder.
							fromCurrentRequest()
							.path("/{id}")
							.buildAndExpand(patient.getUniqueId())
							.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(path = "/{id}")
	public void updatePatient(@PathVariable @NotNull String id, @RequestBody @Valid PatientDTO patientDTO) {
		if(repository.findById(id).isPresent())
		{
			Patient patient = convertDtoToEntity(patientDTO);
			patient.setUniqueId(id);
			repository.save(patient);
		}
	}
	
	@DeleteMapping(path = "/{id}")
	public void deletePatient(@PathVariable String id) {
		repository.deleteById(id);
	}
	
	/**
	 * Converts entity to DTO
	 * 
	 * @param patient
	 * @return PatientDTO
	 */
	private PatientDTO convertEnityToDto(Patient patient) {
		return mapper.map(patient, PatientDTO.class);
	}
	
	/**
	 * Converts DTO to Entity
	 * 
	 * @param patientDTO
	 * @return Patient
	 */ 
	private Patient convertDtoToEntity(PatientDTO patientDTO) {
		return mapper.map(patientDTO, Patient.class);
	}
}
