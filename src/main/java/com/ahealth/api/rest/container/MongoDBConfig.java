package com.ahealth.api.rest.container;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author Ankush Gupta 
 * 
 * Email: no.1ankush@gmail.com
 * GitHub: https://github.com/no-1ankush
 * LinkedIn: www.linkedin.com/in/no1ankush
 */
@EnableMongoRepositories(basePackages = "com.ahealth.api.rest.repository")
@Configuration
public class MongoDBConfig {

}
