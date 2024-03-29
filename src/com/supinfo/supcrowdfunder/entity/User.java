package com.supinfo.supcrowdfunder.entity;

// Generated 8 f?vr. 2014 03:00:55 by Hibernate Tools 3.4.0.CR1

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "user")
public class User implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private boolean admin;

	@OneToMany(cascade = CascadeType.ALL)
	private Collection<Project> projectList;

	@OneToMany(cascade = CascadeType.ALL)
	private Collection<Contribution> contributionList;

	public User() {
	}

	public User(String firstName, String lastName, String email,
			String password, boolean admin) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.admin = admin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Collection<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(Collection<Project> projectList) {
		this.projectList = projectList;
	}

	public Collection<Contribution> getContributionList() {
		return contributionList;
	}

	public void setContributionList(Collection<Contribution> contributionList) {
		this.contributionList = contributionList;
	}
}
