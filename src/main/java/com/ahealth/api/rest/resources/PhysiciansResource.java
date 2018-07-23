package com.ahealth.api.rest.resources;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
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

import com.ahealth.api.rest.dto.PhysicianDTO;
import com.ahealth.api.rest.entity.Physician;
import com.ahealth.api.rest.repository.PhysicianRespository;

/**
 * @author Ankush Gupta 
 * 
 * Email: no.1ankush@gmail.com
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */

@RestController
@RequestMapping(path = "/physicians" )
public class PhysiciansResource {

	@Autowired
	PhysicianRespository repository;
	
	@Autowired
	ModelMapper mapper;
	
	@GetMapping
	public Resources<PhysicianDTO> getPhysicians() {
		List<Physician> physicianList =  repository.findAll();
		List<PhysicianDTO> physicianDTOList = physicianList.stream()
		          								.map(physician -> convertEnityToDto(physician))
		          								.collect(Collectors.toList());
		
		for(PhysicianDTO physicianDTO: physicianDTOList) {
			physicianDTO.add(linkTo(methodOn(this.getClass()).getPhysician(physicianDTO.getUniqueId())).withSelfRel());
		}
		
		Resources<PhysicianDTO> resources = new Resources<PhysicianDTO>(physicianDTOList, 
												linkTo(methodOn(this.getClass()).getPhysicians()).withSelfRel());
		return resources;
	}
	
	@GetMapping(path = "/{id}")
	public Resource<PhysicianDTO> getPhysician(@PathVariable @NotNull String id) {
		Optional<Physician> physician = repository.findById(id);
		if(physician.isPresent())
		{
			PhysicianDTO physicianDTO = convertEnityToDto(physician.get());
			Resource<PhysicianDTO> resource = new Resource<PhysicianDTO>(physicianDTO);
			resource.add(linkTo(methodOn(this.getClass()).getPhysician(id)).withSelfRel());
			resource.add(linkTo(methodOn(this.getClass()).getPhysicians()).withRel("all-physician"));
			return resource;
		}
		return null;
	}
	
	@PostMapping
	public ResponseEntity<Object> createPatient(@RequestBody @Valid PhysicianDTO physicianDTO) {
		Physician physician = repository.save(convertDtoToEntity(physicianDTO));
		
		URI location = ServletUriComponentsBuilder.
							fromCurrentRequest()
							.path("/{id}")
							.buildAndExpand(physician.getUniqueId())
							.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(path = "/{id}")
	public void updatePatient(@PathVariable @NotNull String id, @RequestBody @Valid PhysicianDTO physicianDTO) {
		if(repository.findById(id).isPresent())
		{
			Physician physician = convertDtoToEntity(physicianDTO);
			physician.setUniqueId(id);
			repository.save(physician);
		}
	}
	
	@DeleteMapping(path = "/{id}")
	public void deletePatient(@PathVariable @NotNull String id) {
		repository.deleteById(id);
	}
	/**
	 * Converts entity to DTO
	 * 
	 * @param physician
	 * @return PatientDTO
	 */
	private PhysicianDTO convertEnityToDto(Physician physician) {
		return mapper.map(physician, PhysicianDTO.class);
	}
	
	/**
	 * Converts DTO to Entity
	 * 
	 * @param physicianDTO
	 * @return Patient
	 */ 
	private Physician convertDtoToEntity(PhysicianDTO physicianDTO) {
		return mapper.map(physicianDTO, Physician.class);
	}
}
