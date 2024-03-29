package com.supinfo.supcrowdfunder.entity;

// Generated 8 f?vr. 2014 03:00:55 by Hibernate Tools 3.4.0.CR1
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

/**
 * Project generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "project")
public class Project implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Category category;
	private String name;
	private String description;
	private Date created;
	private Date completionDate;
	private Integer amount;
	private String imageSource;
	private Date endDate;
	@OneToMany(cascade = CascadeType.ALL)
	private Collection<Contribution> contributionList;

	public Project() {
	}

	public Project(User user, Category category, String name,
			String description, Integer amount, String imageSource, Date endDate) {
		this.user = user;
		this.category = category;
		this.name = name;
		this.description = description;
		this.amount = amount;
		this.imageSource = imageSource;
		this.endDate = endDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getImageSource() {
		return imageSource;
	}

	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Collection<Contribution> getContributionList() {
		return contributionList;
	}

	public void setContributionList(Collection<Contribution> contributionList) {
		this.contributionList = contributionList;
	}
}
