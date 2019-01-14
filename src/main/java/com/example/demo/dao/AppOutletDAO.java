package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.AppOutlet;

@Repository
@Transactional
public class AppOutletDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	public List<AppOutlet> getAllNewsOutlets(){
		try {
			String sql = "Select  e from " + AppOutlet.class.getName() + " e";
			
			String sql1 = "Select app_outlet.outlet_id, app_outlet.outlet_name from app_outlet";
			
			Query query = entityManager.createNativeQuery(sql1, AppOutlet.class);
			
			return query.getResultList();
		
		} catch (NoResultException e) {
			return null;
		}
	}	

}
