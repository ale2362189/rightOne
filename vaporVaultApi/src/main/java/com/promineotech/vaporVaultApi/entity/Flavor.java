package com.promineotech.vaporVaultApi.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
public class Flavor {
	
	
	
	private Long id;
	private String name;
	
	@JsonIgnore
	private Set<Recipe> recipes;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "recipe_flavor",
//			joinColumns = @JoinColumn(name = "flavorId", referencedColumnName = "id"),
//			inverseJoinColumns = @JoinColumn(name = "recipeId", referencedColumnName = "id"))
	public Set<Recipe> getRecipe() {
		return recipes;
	}
	public void setRecipe(Set<Recipe> recipes) {
		this.recipes = recipes;
	}

	
	
}
