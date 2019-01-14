package com.example.demo.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.AppOutlet;
import com.example.demo.entity.AppUser;
 
@Repository
@Transactional
public class AppUserDAO {
 
    @Autowired
    private EntityManager entityManager;
 
    public AppUser findUserAccount(String userName) {
        try {
            String sql = "Select e from " + AppUser.class.getName() + " e " //
                    + " Where e.userName = :userName ";

            Query query = entityManager.createQuery(sql, AppUser.class);
            
            query.setParameter("userName", userName);
            
            return (AppUser) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public List<AppOutlet> findUserSelectedOutlets() {
        try {
            String sqlnative = "SELECT app_outlet.outlet_id, app_outlet.outlet_name from App_outlet inner join app_user_outlets on app_outlet.outlet_id = app_user_outlets.outlets_outlet_id and app_user_outlets.users_user_id = '3'";

            Query query = entityManager.createNativeQuery(sqlnative, AppOutlet.class);
            
            //query.setParameter("userName", userName);
            
            return (List<AppOutlet>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public int  SelectOutletsForUser() {
        try {
            String sqlnative = "SELECT app_outlet.outlet_id, app_outlet.outlet_name from App_outlet inner join app_user_outlets on app_outlet.outlet_id = app_user_outlets.outlets_outlet_id and app_user_outlets.users_user_id = '3'";

            Query query = entityManager.createNativeQuery(sqlnative, AppOutlet.class);
            
            //query.setParameter("userName", userName);
            
            return query.executeUpdate();
        } catch (NoResultException e) {
            return (Integer) null;
        }
    }
    
    public int  DeleteOutletsForUser() {
        try {
            String sqlnative = "Delete from APP_USER_OUTLETS where APP_USER_OUTLETS.Users_User_id='3'";

            Query query = entityManager.createNativeQuery(sqlnative, AppOutlet.class);
            
            //query.setParameter("userName", userName);
            
            return query.executeUpdate();
        } catch (NoResultException e) {
            return (Integer) null;
        }
    }
    
    
}

