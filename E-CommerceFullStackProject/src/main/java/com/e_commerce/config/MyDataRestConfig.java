package com.e_commerce.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.e_commerce.entity.Country;
import com.e_commerce.entity.Product;
import com.e_commerce.entity.ProductCategory;
import com.e_commerce.entity.State;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
	
	@Autowired
	private EntityManager entity;

	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
			
		HttpMethod[] theUnsupportedTypes = {HttpMethod.DELETE,HttpMethod.PUT,HttpMethod.POST,HttpMethod.PATCH};
		
		//disable HTTP methods for Product: POST,PUT, PATCH and DELETE.
		config.getExposureConfiguration()
		      .forDomainType(Product.class)
		      .withItemExposure((metadata,httpMethods)->httpMethods.disable(theUnsupportedTypes))
		      .withCollectionExposure((metadata,httpMethods)->httpMethods.disable(theUnsupportedTypes));
		
		//disable HTTP methods for Product Category: POST,PUT, PATCH and DELETE.
		config.getExposureConfiguration()
	      .forDomainType(ProductCategory.class)
	      .withItemExposure((metadata,httpMethods)->httpMethods.disable(theUnsupportedTypes))
	      .withCollectionExposure((metadata,httpMethods)->httpMethods.disable(theUnsupportedTypes));
		
		config.getExposureConfiguration()
	      .forDomainType(Country.class)
	      .withItemExposure((metadata,httpMethods)->httpMethods.disable(theUnsupportedTypes))
	      .withCollectionExposure((metadata,httpMethods)->httpMethods.disable(theUnsupportedTypes));
		
		config.getExposureConfiguration()
	      .forDomainType(State.class)
	      .withItemExposure((metadata,httpMethods)->httpMethods.disable(theUnsupportedTypes))
	      .withCollectionExposure((metadata,httpMethods)->httpMethods.disable(theUnsupportedTypes));
		
		// call an internal helper method to expose the id's.
		exposeIds(config);
	}

	private void exposeIds(RepositoryRestConfiguration config) {

		Set<EntityType<?>> entities = entity.getMetamodel().getEntities();
		
		List<Class> entityClass=new ArrayList<>();
		
		for(EntityType type:entities) {
			entityClass.add(type.getJavaType());
		}
		
		Class[] domainTypes=entityClass.toArray(new Class[0]);
		config.exposeIdsFor(domainTypes);
	}
}
