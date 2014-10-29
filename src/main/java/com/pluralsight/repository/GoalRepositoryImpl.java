package com.pluralsight.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.pluralsight.model.Goal;
import com.pluralsight.service.GoalService;

@Repository("goalRepository")
public class GoalRepositoryImpl implements GoalRepository {

	@PersistenceContext
	private EntityManager em;
	
	public Goal save(Goal goal) {
		em.persist(goal);
		
		//em.flush(); //not sure why i don't need this now...
		
		return goal;
	}

}
