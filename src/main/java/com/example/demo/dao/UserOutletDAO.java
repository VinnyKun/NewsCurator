package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.AppOutlet;
import com.example.demo.entity.AppUser;

//not in use
//@Repository
//@Transactional
//public class UserOutletDAO {
//	
//	//@Autowired
//    private EntityManager entityManager;
//	
//	//I want a list returned 
//	//I must search for the ID of the of user
//	//use the id to return the the Ids of the outlets
//	//then search the outlet table for the outlet names with the corresponding 
//    
//	public List<AppOutlet> getAllNewsOutletsForThisUser(){
//		try {
////			String sqlUserId = "Select e.id from " + AppUser.class.getName() + " e " //
////                    + " Where e.userName = :userName ";
////            Query q1 = entityManager.createQuery(sqlUserId, Long.class);
////            q1.setParameter("userName", userName);
////			Long userId = (Long) q1.getSingleResult();
//			//System.out.println(userId);
//			String sqlJoinTable = "select app_outlet.outlet_id, app_outlet.outlet_name from app_user inner join user_outlet on app_user.user_id = 1 inner join app_outlet on  user_outlet.outlet_id = app_outlet.outlet_id";  
//			Query query = entityManager.createNativeQuery(sqlJoinTable, AppOutlet.class);
//
//			return query.getResultList();
//			
//		} catch (NoResultException e) {
//			return null;
//		}
//	}	
//}
