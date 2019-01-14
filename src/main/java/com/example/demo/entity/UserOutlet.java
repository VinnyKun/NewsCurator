package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

//not in use
//@Entity
//@Table(name = "User_Outlet", //
//	uniqueConstraints = {//
//			@UniqueConstraint(name = "USER_OUTLET_UK", columnNames = {"User_Id", "Outlet_Id"})
//})
//public class UserOutlet {
//	
//    @Id
//    @GeneratedValue
//    @Column(name = "Id", nullable = false)
//    private Long id;
// 
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "User_Id", nullable = false)
//    private AppUser appUser;
// 
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "Outlet_Id", nullable = false)
//    private AppOutlet appOutlet;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public AppUser getAppUser() {
//		return appUser;
//	}
//
//	public void setAppUser(AppUser appUser) {
//		this.appUser = appUser;
//	}
//
//	public AppOutlet getAppOutlet() {
//		return appOutlet;
//	}
//
//	public void setAppOutlet(AppOutlet appOutlet) {
//		this.appOutlet = appOutlet;
//	}
    
    
//}
