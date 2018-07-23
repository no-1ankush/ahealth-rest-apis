package com.ahealth.api.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ahealth.api.rest.entity.Resource;

/**
 * @author Ankush Gupta 
 * 
 * Email: no.1ankush@gmail.com
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */
public interface ResourceRespository extends MongoRepository<Resource, String> {

}
