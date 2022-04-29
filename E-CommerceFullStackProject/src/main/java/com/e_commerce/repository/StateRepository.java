package com.e_commerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.e_commerce.entity.State;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel ="states", path="states")
public interface StateRepository extends JpaRepository<State, Integer> {
	
	public List<State> findByCountryCode(@RequestParam("code") String code);

}
