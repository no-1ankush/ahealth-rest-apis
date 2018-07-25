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
}
