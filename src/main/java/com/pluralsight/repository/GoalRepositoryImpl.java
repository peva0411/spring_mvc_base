package com.pluralsight.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;

@Repository("goalRepository")
public class GoalRepositoryImpl implements GoalRepository {

	@PersistenceContext
	private EntityManager em;
	
	public Goal save(Goal goal) {
		em.persist(goal);
		
		//em.flush(); //not sure why i don't need this now...
		
		return goal;
	}

	public List<Goal> loadAll() {
		
		
		TypedQuery<Goal> query = em.createNamedQuery(Goal.FIND_ALL_GOALS, Goal.class);
		
//		Query query = em.createQuery("Select g from Goal g");
		
		List goals = query.getResultList();
		
		return goals;
	}

	public List<GoalReport> findAllGoalReports() {
		
		TypedQuery<GoalReport> query = em.createNamedQuery(Goal.FIND_GOAL_REPORTS, GoalReport.class);
		
//		Query query = em.createQuery("Select new com.pluralsight.model.GoalReport(g.minutes, e.minutes, e.activity)" + 
//										"from Goal g, Exercise e where g.id = e.goal.id)");
		return query.getResultList();
	}

}
