package com.accenture.lkm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.entity.PizzaEntity;

@RepositoryDefinition(domainClass = PizzaEntity.class,idClass = Integer.class)
@Transactional(value = "txManager")
public interface PizzaDAO {

	@Query(name = "PizzaDAO.findPizzaDetails")
	List<PizzaEntity> findPizzaDetails();
	
}
