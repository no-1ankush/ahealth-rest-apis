package com.ahealth.api.rest.resources;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ahealth.api.rest.dto.ResourceDTO;
import com.ahealth.api.rest.entity.Resource;
import com.ahealth.api.rest.repository.ResourceRespository;

/**
 * @author Ankush Gupta 
 * 
 * Email: no.1ankush@gmail.com
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */

@RestController
@RequestMapping(path = "/resources" )
public class RootResource {

	@Autowired
	ResourceRespository repository;
	
	@Autowired
	ModelMapper mapper;
	
	@GetMapping
	public Resources<ResourceDTO> getResources() {
		addResource();
		List<Resource> resourceList =  new ArrayList<>(repository.findAll());
		List<ResourceDTO> resourceDTOList = resourceList
												.stream()
		          								.map(resource -> convertEnityToDto(resource))
		          								.collect(Collectors.toList());
		
		for(ResourceDTO resourceDTO: resourceDTOList) {
			resourceDTO.add(linkTo(methodOn(this.getClass()).getResource(resourceDTO.getResourceId())).withSelfRel());
		}
		
		Resources<ResourceDTO> resources = new Resources<ResourceDTO>(resourceDTOList, 
												linkTo(methodOn(this.getClass()).getResources()).withSelfRel());
		return resources;
	}
	
	@GetMapping(path = "/{id}")
	public org.springframework.hateoas.Resource<ResourceDTO> getResource(@PathVariable @NotNull String id) {
		Optional<Resource> resource = repository.findById(id);
		if(resource.isPresent())
		{
			ResourceDTO resourceDTO = convertEnityToDto(resource.get());
			org.springframework.hateoas.Resource<ResourceDTO> outputResource 
												= new org.springframework.hateoas.Resource<ResourceDTO>(resourceDTO);
			outputResource.add(linkTo(methodOn(this.getClass()).getResource(id)).withSelfRel());
			outputResource.add(linkTo(methodOn(this.getClass()).getResources()).withRel("all-resources"));
			return outputResource;
		}
		
		return null;
	}
	
	/**
	 * Converts entity to DTO
	 * 
	 * @param resource
	 * @return ResourceDTO
	 */
	private ResourceDTO convertEnityToDto(Resource resource) {
		return mapper.map(resource, ResourceDTO.class);
	}
	
	private void addResource()
	{
		repository.deleteAll();
		Resource getPatients = new Resource("GET PATIENTS",
						"Retrives all Patients information.",
						"http://localhost:8999/patients",
						RequestMethod.GET.name());
		repository.save(getPatients);
		
		Resource getPhysicians = new Resource("GET PHYSICIANS",
						"Retrieves all Physician information.",
						"http://localhost:8999/physicians",
						RequestMethod.GET.name());
		
		repository.save(getPhysicians);
		
		Resource addPatient = new Resource("ADD PATIENT",
						"Add a new Patient.",
						"http://localhost:8999/patients",
						RequestMethod.POST.name());
		repository.save(addPatient);
		
		Resource addPhysician = new Resource("ADD PHYSICIAN",
						"Add a new Physician.",
						"http://localhost:8999/physicians",
						RequestMethod.POST.name());

		repository.save(addPhysician);
		
		Resource updatePatient = new Resource("UPDATE PATIENT",
						"Update the existing Patient Information.",
						"http://localhost:8999/patients",
						RequestMethod.PUT.name());
		repository.save(updatePatient);
		
		Resource updatePhysician = new Resource("UPDATE PHYSICIAN",
						"Update the existing Physician Information.",
						"http://localhost:8999/physicians",
						RequestMethod.PUT.name());
		
		repository.save(updatePhysician);
		
		Resource deletePatient = new Resource("DELETE PATIENT",
						"Deletes the Patient Record.",
						"http://localhost:8999/patients",
						RequestMethod.DELETE.name());
		repository.save(deletePatient);
		
		Resource deletePhysician = new Resource("DELETE PHYSICIAN",
						"Deletes the Physician Record.",
						"http://localhost:8999/physicians",
						RequestMethod.DELETE.name());
		
		repository.save(deletePhysician);
	}
}
