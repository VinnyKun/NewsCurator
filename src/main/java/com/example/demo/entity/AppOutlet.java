package com.example.demo.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "App_Outlet", //
		uniqueConstraints = {//
				@UniqueConstraint(name= "APP_OUTLET_UK", columnNames = "Outlet_Name" ) })
public class AppOutlet {
	
	@Id
	@GeneratedValue
	@Column(name = "Outlet_Id", nullable = false)
	private Long outletId;

	@Override
	public String toString() {
		return "AppOutlet [outletId=" + outletId + ", outletName=" + outletName + "]";
	}

	@Column(name = "Outlet_Name", length = 30,  nullable = false)
	private String outletName;
	
	@ManyToMany(mappedBy = "outlets")
	private Set<AppUser> users = new HashSet<AppUser>();
	
	
	public Set<AppUser> getUsers() {
		return users;
	}

	public void setUsers(Set<AppUser> users) {
		this.users = users;
	}

	public Long getOutletId() {
		return outletId;
	}

	public void setOutletId(Long outletId) {
		this.outletId = outletId;
	}

	public String getOutletName() {
		return outletName;
	}

	public void setOutletName(String roleName) {
		this.outletName = roleName;
	}
	
	
	
}
